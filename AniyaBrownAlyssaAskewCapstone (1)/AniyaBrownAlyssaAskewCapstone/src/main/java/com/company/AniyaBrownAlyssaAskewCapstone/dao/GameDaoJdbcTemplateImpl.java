package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl implements GameDao{

    //prepared statements
    private static final String INSERT_GAME_SQL =
            "insert into game (title,esrb_rating, description,price, studio, quantity) values(?,?,?,?,?,?)";

    private static final String SELECT_GAME_SQL=
            "select * from game where game_id = ?";

    private static final String SELECT_ALL_GAME_SQL =
            "select * from game ";

    private static final String UPDATE_GAME_SQL =
            "update game set title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? where game_id = ?";

    private static final String DELETE_GAME_SQL =
            "delete from game where game_id = ?";

    private static final String SELECT_GAME_BY_STUDIO =
            "select * from game where studio = ?";

    private static final String SELECT_GAME_BY_ESRB =
            "select * from game where esrb_rating = ?";

    private static final String SELECT_GAME_BY_TITLE =
            "select * from game where title = ?";


    private JdbcTemplate jdbcTemplate;


    //constructor
    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    //methods
    @Override
    @Transactional
    public Game addGame(Game game){
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getTitle(),
                game.getEsrb_rating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        game.setId(id);

        return game;
    }

    @Override
    public Game getGame(int id){
        try{
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL,this::mapRowtoGame,id );
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Game> getAllGames(){
        return jdbcTemplate.query(SELECT_ALL_GAME_SQL,this::mapRowtoGame);
    }

    @Override
    public void updateGame(Game game){
        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrb_rating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getId()
        );

    }

    @Override
    public void deleteGame(int id){
        jdbcTemplate.update(DELETE_GAME_SQL, id);

    }

    @Override
    public List<Game> getGamebyStudio (String studio){
        return jdbcTemplate.query(SELECT_GAME_BY_STUDIO, this::mapRowtoGame, studio);
    }

    @Override
    public List<Game> getGamesbyTitle(String title){
        return jdbcTemplate.query(SELECT_GAME_BY_TITLE, this::mapRowtoGame, title);
    }

    @Override
    public List<Game> getGamesbyESRB(String esrb){
        return jdbcTemplate.query(SELECT_GAME_BY_ESRB, this::mapRowtoGame, esrb);
    }

    private Game mapRowtoGame(ResultSet rs, int rowNum)throws SQLException{
        Game game = new Game();

        game.setId(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setEsrb_rating(rs.getString("esrb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));

        return game;
    }
}
