package com.company.AniyaBrownAlyssaAskewCapstone.controller;

import com.company.AniyaBrownAlyssaAskewCapstone.ServiceLayer.ConsoleService;
import com.company.AniyaBrownAlyssaAskewCapstone.dao.ConsoleDao;
import com.company.AniyaBrownAlyssaAskewCapstone.model.Console;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ConsoleService consoleService;


    @Before
    public void setUp(){


    }
    @Before
    public void before() {
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
    @Test
    public void shouldReturnAllConsolesInCollection() throws Exception {
        String outputJson = mapper.writeValueAsString(consoleService);
        mockMvc.perform(
                get("/console"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void shouldReturnNewConsoleOnPostRequest() throws Exception {
        Console console = new Console();
        console.setManufacturer("Activision");
        console.setModel("500");
        console.setMemory_amount("300mb");
        console.setQuantity(1);
        console.setProcessor("processor1");
        console.setPrice(new BigDecimal("150"));
        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(
                post("/console")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)

        )
         .andDo(print())
         .andExpect(status().isCreated());
    }
    @Test
    public void shouldReturnConsolesById() throws Exception {


        Console console = new Console();

        console.setId(2);
        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500GB");
        console.setProcessor("AMD Zen 2");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);

        console = consoleService.saveConsole(console);

        String outputJson = mapper.writeValueAsString(console);

        mockMvc.perform(get("/console/2"))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void shouldUpdateReturn204StatusCode() throws Exception {
        Console console = new Console();
        console.setModel("Xbox One ");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("1000GB");
        console.setProcessor("1.75GHz AMD 8-core");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);
        console.setId(3);
        String inputJson = mapper.writeValueAsString(console);
        mockMvc.perform(
                put("/console")
                 .content(inputJson)
                 .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }


     @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(delete("/console/4"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturnByManufacturer() throws Exception {
        Console console = new Console();
        console.setModel("Xbox One ");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("1000GB");
        console.setProcessor("1.75GHz AMD 8-core");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);
        console.setId(3);

        String outputJson = mapper.writeValueAsString(console);
        mockMvc.perform(
                get("/console/manufacturer/Microsoft"))
                .andDo(print())
                .andExpect(status().isOk());


    }

}
