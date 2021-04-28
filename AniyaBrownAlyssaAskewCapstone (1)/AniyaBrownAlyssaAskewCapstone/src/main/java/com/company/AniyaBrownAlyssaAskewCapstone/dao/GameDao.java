package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    void updateGame(Game game);

    void deleteGame(int id);

    List<Game> getGamebyStudio (String studio);

    List<Game> getGamesbyTitle(String title);

    List<Game> getGamesbyESRB(String esrb);


}
