package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoImplTest {

    @Autowired
    public GameDao gameDao;

    @Before
    public void setUp()throws Exception{
        List<Game> allGames = gameDao.getAllGames();
        for (Game g: allGames){
            gameDao.deleteGame(g.getId());
        }
    }

    @Test
    public void addGetDeleteGame(){
        Game game = new Game();
        game.setTitle("Black Ops");
        game.setEsrb_rating("Rated-R");
        game.setDescription("shooting game");
        game.setPrice(new BigDecimal("50.00"));
        game.setStudio("Activision");
        game.setQuantity(3);

        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getId());

        assertEquals(game1,game);

        gameDao.deleteGame(game.getId());

        game1 = gameDao.getGame(game.getId());

        assertNull(game1);


    }

    @Test
    public void shouldgetAllGames(){
        Game game = new Game();
        game.setTitle("Black Ops");
        game.setEsrb_rating("Rated-R");
        game.setDescription("shooting game");
        game.setPrice(new BigDecimal("50.00"));
        game.setStudio("Activision");
        game.setQuantity(3);

        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("NBA 2k20");
        game.setEsrb_rating("General Audience");
        game.setDescription("Sports basketball game");
        game.setPrice(new BigDecimal("79.00"));
        game.setStudio("Visual Concepts");
        game.setQuantity(5);

        game = gameDao.addGame(game);

        List<Game> games = gameDao.getAllGames();

        assertEquals(games.size(),2);

    }

   @Test
    public void shouldUpdateGames(){
       Game game = new Game();
       game.setTitle("Black Ops");
       game.setEsrb_rating("Rated-R");
       game.setDescription("shooting game");
       game.setPrice(new BigDecimal("50.00"));
       game.setStudio("Activision");
       game.setQuantity(3);

       game = gameDao.addGame(game);

       game.setPrice(new BigDecimal("80.00"));
       game.setQuantity(5);

       gameDao.updateGame(game);

       Game game1 = gameDao.getGame(game.getId());

       assertEquals(game1,game);

   }

   @Test
    public void shouldGetGamesbyStudio(){

       Game game = new Game();
       game.setTitle("Black Ops");
       game.setEsrb_rating("Rated-R");
       game.setDescription("shooting game");
       game.setPrice(new BigDecimal("50.00"));
       game.setStudio("Activision");
       game.setQuantity(3);

       game = gameDao.addGame(game);

       game = new Game();
       game.setTitle("Call of Duty : WarZone");
       game.setEsrb_rating("Rated-R");
       game.setDescription("shooting game");
       game.setPrice(new BigDecimal("10.00"));
       game.setStudio("Activision");
       game.setQuantity(3);

       game = gameDao.addGame(game);

       List<Game> games = gameDao.getGamebyStudio("Activision");

       assertEquals(games.size(),2);

   }

   @Test
    public void shouldGetGamesbyESRB(){
       Game game = new Game();
       game.setTitle("Black Ops");
       game.setEsrb_rating("Rated-R");
       game.setDescription("shooting game");
       game.setPrice(new BigDecimal("50.00"));
       game.setStudio("Activision");
       game.setQuantity(3);

       game = gameDao.addGame(game);

       game = new Game();
       game.setTitle("Call of Duty : WarZone");
       game.setEsrb_rating("General Audience");
       game.setDescription("shooting game");
       game.setPrice(new BigDecimal("10.00"));
       game.setStudio("Activision");
       game.setQuantity(3);

       game = gameDao.addGame(game);

       List<Game> games = gameDao.getGamesbyESRB("Rated-R");

       assertEquals(games.size(),1);
   }

   @Test
    public void shouldGetGamesbyTitle(){
       Game game = new Game();
       game.setTitle("Call of Duty: Black Ops");
       game.setEsrb_rating("Rated-R");
       game.setDescription("shooting game");
       game.setPrice(new BigDecimal("50.00"));
       game.setStudio("Activision");
       game.setQuantity(3);

       game = gameDao.addGame(game);

       game = new Game();
       game.setTitle("Call of Duty : WarZone");
       game.setEsrb_rating("General Audience");
       game.setDescription("shooting game");
       game.setPrice(new BigDecimal("10.00"));
       game.setStudio("Activision");
       game.setQuantity(3);

       game = gameDao.addGame(game);

       List<Game> games = gameDao.getGamesbyTitle("Call of Duty: Black Ops");

       assertEquals(games.size(),1);

   }


}