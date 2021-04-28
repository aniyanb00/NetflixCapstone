package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoImpl implements ConsoleDao {

    //prepared statements
    private static final String INSERT_CONSOLE_SQL =
            "insert into console (model,manufacturer,memory_amount,processor,price,quantity) values(?,?,?,?,?,?)";

    private static final String SELECT_CONSOLE_SQL=
            "select * from console where console_id = ?";

    private static final String SELECT_ALL_CONSOLE_SQL =
            "select * from console ";

    private static final String UPDATE_CONSOLE_SQL =
            "update console set  model =?, manufacturer = ?, memory_amount = ? , processor = ?, price = ? , quantity = ?";

    private static final String DELETE_CONSOLE_SQL =
            "delete from console where console_id = ?";

    private static final String SELECT_CONSOLE_BY_MANUFACTURER =
            "select * from console where manufacturer = ?";


    private JdbcTemplate jdbcTemplate;

    //constructor
    @Autowired
    public ConsoleDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    //methods
    @Transactional
    @Override
    public Console addConsole(Console console) {
        jdbcTemplate.update(INSERT_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemory_amount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        console.setId(id);

        return console;
    }

    @Override
    public Console getConsole(int id){
        try{
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowtoTShirt, id);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Console> getAllConsoles(){
        return jdbcTemplate.query(SELECT_ALL_CONSOLE_SQL, this::mapRowtoTShirt);
    }

    @Override
    public void updateConsole(Console console){
        jdbcTemplate.update(UPDATE_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemory_amount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity()
                );
    }

    @Override
    public void deleteConsole(int id){
        jdbcTemplate.update(DELETE_CONSOLE_SQL,id);
    }

    @Override
    public List<Console> getConsolebyManufacturer(String manufacturer){
        return jdbcTemplate.query(SELECT_CONSOLE_BY_MANUFACTURER, this::mapRowtoTShirt, manufacturer);
    }

    private Console mapRowtoTShirt(ResultSet rs, int rowNum)throws SQLException {
        Console console = new Console();

        console.setId(rs.getInt("console_id"));
        console.setModel(rs.getString("model"));
        console.setManufacturer(rs.getString("manufacturer"));
        console.setMemory_amount(rs.getString("memory_amount"));
        console.setProcessor(rs.getString("processor"));
        console.setPrice(rs.getBigDecimal("price"));
        console.setQuantity(rs.getInt("quantity"));

        return console;
    }

}
