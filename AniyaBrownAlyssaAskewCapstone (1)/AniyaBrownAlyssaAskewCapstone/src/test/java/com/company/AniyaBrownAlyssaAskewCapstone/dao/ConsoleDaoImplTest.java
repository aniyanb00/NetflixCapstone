package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ConsoleDaoImplTest {

    @Autowired
    public ConsoleDao consoleDao;

    @Before
    public void setUp()throws Exception{
        List<Console> allConsole = consoleDao.getAllConsoles();
        for (Console c: allConsole){
            consoleDao.deleteConsole(c.getId());
        }
    }

    @Test
    public void addGetDeleteConsole(){

        Console console = new Console();

        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500GB");
        console.setProcessor("AMD Zen 2");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);

        console = consoleDao.addConsole(console);

        console = new Console();
        console.setModel("Xbox One ");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("1000GB");
        console.setProcessor("1.75GHz AMD 8-core");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);

        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1,console);

        consoleDao.deleteConsole(console.getId());

        console1 = consoleDao.getConsole(console.getId());

        assertNull(console1);

    }

    @Test
    public void shouldGetAllConsoles(){
        Console console = new Console();

        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500GB");
        console.setProcessor("AMD Zen 2");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);

        console = consoleDao.addConsole(console);

        console = new Console();
        console.setModel("Xbox One ");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("1000GB");
        console.setProcessor("1.75GHz AMD 8-core");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);

        console = consoleDao.addConsole(console);

        List<Console> consoles = consoleDao.getAllConsoles();

        assertEquals(consoles.size(),2);

    }

    @Test
    public void shouldUpdateConsole(){
        Console console = new Console();

        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500GB");
        console.setProcessor("AMD Zen 2");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);

        console = consoleDao.addConsole(console);

        console.setQuantity(4);
        console.setPrice(new BigDecimal("800.00"));

        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1,console);

    }

    @Test
    public void shouldGetbyManufacturer(){
        Console console = new Console();

        console.setModel("Xbox One ");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("1000GB");
        console.setProcessor("1.75GHz AMD 8-core");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);

        console = consoleDao.addConsole(console);

        console = new Console();
        console.setModel("Xbox 360 ");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("500GB");
        console.setProcessor("1.00GHz AMD 4-core");
        console.setPrice(new BigDecimal("200.00"));
        console.setQuantity(1);

        console = consoleDao.addConsole(console);

        List<Console> consoles = consoleDao.getConsolebyManufacturer("Microsoft");

        assertEquals(consoles.size(), 2);

    }



}