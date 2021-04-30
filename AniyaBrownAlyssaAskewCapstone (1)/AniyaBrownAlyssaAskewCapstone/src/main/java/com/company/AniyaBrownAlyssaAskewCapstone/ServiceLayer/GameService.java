package com.company.AniyaBrownAlyssaAskewCapstone.ServiceLayer;

import com.company.AniyaBrownAlyssaAskewCapstone.dao.GameDao;
import com.company.AniyaBrownAlyssaAskewCapstone.dao.GameDaoImpl;
import com.company.AniyaBrownAlyssaAskewCapstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameDao gameDao;

    @Autowired
    public GameService(GameDaoImpl gameDao) {
        this.gameDao = gameDao;
    }

    public Game addGame(Game game){
        return gameDao.addGame(game);
    }

    public Game getGame(int id){
        return gameDao.getGame(id);
    }

    public List<Game> getAllGames(){
        return gameDao.getAllGames();
    }

    void updateGame(Game game){
        gameDao.updateGame(game);
    }

    void deleteGame(int id){
        gameDao.deleteGame(id);
    }

    public List<Game> getGamebyStudio (String studio){return gameDao.getGamebyStudio(studio);}

    public List<Game> getGamesbyTitle(String title){return gameDao.getGamesbyTitle(title);}

    public List<Game> getGamesbyESRB(String esrb){return gameDao.getGamesbyESRB(esrb);}
}