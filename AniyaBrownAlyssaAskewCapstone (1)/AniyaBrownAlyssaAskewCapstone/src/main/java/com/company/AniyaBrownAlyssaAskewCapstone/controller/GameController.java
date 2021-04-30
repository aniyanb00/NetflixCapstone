package com.company.AniyaBrownAlyssaAskewCapstone.controller;

import com.company.AniyaBrownAlyssaAskewCapstone.ServiceLayer.GameService;
import com.company.AniyaBrownAlyssaAskewCapstone.dao.GameDao;
import com.company.AniyaBrownAlyssaAskewCapstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {


    @Autowired
    private GameService gameService;


    //create game ->post
    @RequestMapping(value = "/game", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game) {

        return gameService.addGame(game);
    }
    //Read (get  game)

    @RequestMapping(value="/game/{id}", method = RequestMethod.GET)
    @ResponseStatus(value =HttpStatus.OK)
    public Game getGame(@PathVariable int id){
        return gameService.getGame(id);
    }
    //get all game
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames(){
        List<Game> allGame = gameService.getAllGames( );
        if(allGame == null){
            throw new IllegalArgumentException("no game found");
        }
        return allGame;

    }
    //update game
    @RequestMapping(value = "/game", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateGame(@RequestBody Game game){
         gameService.updateGame(game);

    }
//delete a game
@RequestMapping(value = "/game/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
      gameService.deleteGame(id);
}
//get by studio
@RequestMapping(value="/game", method = RequestMethod.GET)
@ResponseStatus(value =HttpStatus.OK)
public List<Game> getGameByStudio(@RequestParam String studio){
    return gameService.getGamebyStudio(studio);
}
//get by ESRB
@RequestMapping(value="/game", method = RequestMethod.GET)
@ResponseStatus(value =HttpStatus.OK)
public List<Game> getGameByESRB(@RequestParam String esrb){
   return gameService.getGamesbyESRB(esrb);
}

//get by Title
@RequestMapping(value="/game", method = RequestMethod.GET)
@ResponseStatus(value =HttpStatus.OK)
public List<Game> getGameByTitle(@RequestParam String title){
    return gameService.getGamesbyTitle(title);
}
}
