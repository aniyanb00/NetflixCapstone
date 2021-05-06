package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao {

    //prepared SQL statements
    private static final String INSERT_SHIRT_SQL =
            "insert into t_shirt (size,color,description,price,quantity) values (?,?,?,?,?)";

    private static final String SELECT_SHIRT_SQL=
            "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_SHIRTS_SQL =
            "select * from t_shirt ";

    private static final String UPDATE_SHIRT_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ? ";

    private static final String DELETE_SHIRT_SQL =
            "delete from t_shirt where t_shirt_id = ?";

    private static final String SELECT_SHIRT_BY_COLOR =
            "select * from t_shirt where color = ?";

    private static final String SELECT_SHIRT_BY_SIZE =
            "select * from t_shirt where size = ?";



    private JdbcTemplate jdbcTemplate;

    //constructor
    @Autowired
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    @Transactional
    public TShirt addTshirt(TShirt tShirt){

        jdbcTemplate.update(INSERT_SHIRT_SQL,
               tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        tShirt.setId(id);

        return tShirt;
    }

    @Override
    public TShirt getTshirt(int id){
        try {
            return jdbcTemplate.queryForObject(SELECT_SHIRT_SQL, this::mapRowtoTShirt, id);
        }
        catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<TShirt> getAllTshirts(){
        return jdbcTemplate.query(SELECT_ALL_SHIRTS_SQL, this::mapRowtoTShirt);
    }

    @Override
    public void deleteTshirt(int id){
      jdbcTemplate.update(DELETE_SHIRT_SQL,id);
    }

    @Override
    public void updateTshirt(TShirt tShirt){
        jdbcTemplate.update(UPDATE_SHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity(),
                tShirt.getId()
        );
    }

    @Override
    public List<TShirt> getbyColor(String color){
        return jdbcTemplate.query(SELECT_SHIRT_BY_COLOR,this::mapRowtoTShirt,color);
    }

    @Override
    public List<TShirt> getbySize(String size){
        return jdbcTemplate.query(SELECT_SHIRT_BY_SIZE, this::mapRowtoTShirt,size);
    }

    private TShirt mapRowtoTShirt(ResultSet rs, int rowNum)throws SQLException {
        TShirt shirt = new TShirt();

        shirt.setId(rs.getInt("t_shirt_id"));
        shirt.setSize(rs.getString("size"));
        shirt.setColor(rs.getString("color"));
        shirt.setDescription(rs.getString("description"));
        shirt.setPrice(rs.getBigDecimal("price"));
        shirt.setQuantity(rs.getInt("quantity"));

        return shirt;
    }
}
