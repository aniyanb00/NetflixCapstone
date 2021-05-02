package com.company.AniyaBrownAlyssaAskewCapstone.ServiceLayer;

import com.company.AniyaBrownAlyssaAskewCapstone.dao.GameDao;
import com.company.AniyaBrownAlyssaAskewCapstone.dao.GameDaoImpl;
import com.company.AniyaBrownAlyssaAskewCapstone.model.Game;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class GameServiceTest {

    GameService gameService;
    GameDao gameDao;

    @Before
    public void setUp() throws Exception{
        setUpGameDaoMock();

        gameService = new GameService(gameDao);
    }

    @Test
    public void saveFindGame(){
        Game game = new Game();

        game.setTitle("Black Ops");
        game.setEsrb_rating("Rated-R");
        game.setDescription("shooting game");
        game.setPrice(new BigDecimal("50.00"));
        game.setStudio("Activision");
        game.setQuantity(3);

        game = gameService.saveGame(game);

        Game fromGameService = gameService.getGame(game.getId());

        assertEquals(game,fromGameService);
    }

    @Test
    public void findAllGame(){
        List<Game> fromGameService = gameService.getAllGames();

        assertEquals(1,fromGameService.size());
    }

    @Test
    public void saveFindStudio(){
        Game game = new Game();
        game.setTitle("Black Ops");
        game.setEsrb_rating("Rated-R");
        game.setDescription("shooting game");
        game.setPrice(new BigDecimal("50.00"));
        game.setStudio("Activision");
        game.setQuantity(3);

        game = gameService.saveGame(game);

        List<Game> gList = gameService.getGamebyStudio(game.getStudio());

        assertEquals(1, gList.size());
    }

    @Test
    public void saveFindTitle(){
        Game game = new Game();
        game.setTitle("Black Ops");
        game.setEsrb_rating("Rated-R");
        game.setDescription("shooting game");
        game.setPrice(new BigDecimal("50.00"));
        game.setStudio("Activision");
        game.setQuantity(3);

        game = gameService.saveGame(game);

        List<Game> gList = gameService.getGamesbyTitle(game.getTitle());

        assertEquals(1, gList.size());
    }
    @Test
    public void saveFindESRB(){
        Game game = new Game();
        game.setTitle("Black Ops");
        game.setEsrb_rating("Rated-R");
        game.setDescription("shooting game");
        game.setPrice(new BigDecimal("50.00"));
        game.setStudio("Activision");
        game.setQuantity(3);

        game = gameService.saveGame(game);

        List<Game> gList = gameService.getGamesbyESRB(game.getEsrb_rating());

        assertEquals(1, gList.size());
    }

    //helper methods
    private void setUpGameDaoMock(){
        gameDao = mock(GameDaoImpl.class);

        Game game = new Game();
        game.setId(1);
        game.setTitle("Black Ops");
        game.setEsrb_rating("Rated-R");
        game.setDescription("shooting game");
        game.setPrice(new BigDecimal("50.00"));
        game.setStudio("Activision");
        game.setQuantity(3);

        Game game1 = new Game();
        game1.setTitle("Black Ops");
        game1.setEsrb_rating("Rated-R");
        game1.setDescription("shooting game");
        game1.setPrice(new BigDecimal("50.00"));
        game1.setStudio("Activision");
        game1.setQuantity(3);

        List<Game> gList = new ArrayList<>();
        gList.add(game);

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(gList).when(gameDao).getAllGames();
        doReturn(gList).when(gameDao).getGamebyStudio("Activision");
        doReturn(gList).when(gameDao).getGamesbyESRB("Rated-R");
        doReturn(gList).when(gameDao).getGamesbyTitle("Black Ops");
     }

}