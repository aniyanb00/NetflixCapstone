package com.company.AniyaBrownAlyssaAskewCapstone.controller;



import com.company.AniyaBrownAlyssaAskewCapstone.ServiceLayer.GameService;

import com.company.AniyaBrownAlyssaAskewCapstone.model.Game;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {




        @Autowired
        private MockMvc mockMvc;


        @Autowired
        private ObjectMapper mapper = new ObjectMapper();

        @MockBean
        private GameService gameService;


        @Before
        public void setUp(){


        }
        @Before
        public void before() {
            mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        }
        @Test
        public void shouldReturnAllGamesInCollection() throws Exception {
            String outputJson = mapper.writeValueAsString(gameService);
            mockMvc.perform(
                    get("/game"))
                    .andDo(print())
                    .andExpect(status().isOk());

        }
        @Test
        public void shouldReturnNewGameOnPostRequest() throws Exception {
            Game game = new Game();
            game.setTitle("Black Ops");
            game.setEsrb_rating("Rated-R");
            game.setDescription("shooting game");
            game.setPrice(new BigDecimal("50.00"));
            game.setStudio("Activision");
            game.setQuantity(3);

            String inputJson = mapper.writeValueAsString(game);
            Game game2 = new Game();
            game2.setTitle("NBA 2k20");
            game2.setEsrb_rating("General Audience");
            game2.setDescription("Sports basketball game");
            game2.setPrice(new BigDecimal("79.00"));
            game2.setStudio("Visual Concepts");
            game2.setQuantity(5);
            String outputJson = mapper.writeValueAsString(game2);
            mockMvc.perform(
                    post("/game/")
                            .content(inputJson)
                            .contentType(MediaType.APPLICATION_JSON)

            )
                    .andDo(print())
                    .andExpect(status().isCreated());
        }
        @Test
        public void shouldReturnGamesById() throws Exception {
            Game game = new Game();
            game.setTitle("Call of Duty: Black Ops");
            game.setEsrb_rating("Rated-R");
            game.setDescription("shooting game");
            game.setPrice(new BigDecimal("50.00"));
            game.setStudio("Activision");
            game.setQuantity(3);
            game.setId(2);


            String outputJson = mapper.writeValueAsString(game);
            mockMvc.perform(
                    get("/games/2"))
                    .andDo(print())
                    .andExpect(status().isOk());
                    //.andExpect(content().json(outputJson));

        }
        @Test
        public void shouldUpdateAndReturn204StatusCode() throws Exception {
            Game game = new Game();
            game.setTitle("Black Ops");
            game.setEsrb_rating("Rated-R");
            game.setDescription("shooting game");
            game.setPrice(new BigDecimal("50.00"));
            game.setStudio("Activision");
            game.setQuantity(3);
            String inputJson = mapper.writeValueAsString(game);
            mockMvc.perform(
                    put("/game")
                            .content(inputJson)
                            .contentType(MediaType.APPLICATION_JSON)

            )
                    .andDo(print())
                    .andExpect(status().isOk());
        }


        @Test
        public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
            mockMvc.perform(delete("/game/4"))
                    .andDo(print())
                    .andExpect(status().isNoContent());
        }
    @Test
    public void shouldReturnByStudioAndReturn204StatusCode( ) throws Exception {
        Game game = new Game();
        game.setTitle("Call of Duty : WarZone");
        game.setEsrb_rating("General Audience");
        game.setDescription("shooting game");
        game.setPrice(new BigDecimal("10.00"));
        game.setStudio("Activision");
        game.setQuantity(3);
        String outputJson = mapper.writeValueAsString(game);
        mockMvc.perform(
                get("/game/studio/Activision"))
                .andDo(print())
                .andExpect(status().isOk());
               // .andExpect(content().json(outputJson));


    }
    @Test
    public void shouldReturnByESRBAndReturn204StatusCode() throws Exception{
        Game game = new Game();
        game.setTitle("Just Dance");
        game.setEsrb_rating("Everyone");
        game.setDescription("dancing game");
        game.setPrice(new BigDecimal("13.00"));
        game.setStudio("Activision");
        game.setQuantity(3);
        String outputJson = mapper.writeValueAsString(game);
        mockMvc.perform(
                get("/game/esrb/Everyone"))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().json(outputJson));

    }
    @Test
    public void shouldReturnByTitleAndReturn204StatusCode() throws Exception {
        Game game = new Game();
        game.setTitle("Animal Farm");
        game.setEsrb_rating("Everyone");
        game.setDescription("animal life game");
        game.setPrice(new BigDecimal("6.00"));
        game.setStudio("Nintendo");
        game.setQuantity(2);
        String outputJson = mapper.writeValueAsString(game);
        mockMvc.perform(
                get("/game/title/Animal Farm"))
                .andDo(print())
                .andExpect(status().isOk());
               // .andExpect(content().json(outputJson));

    }

    }



