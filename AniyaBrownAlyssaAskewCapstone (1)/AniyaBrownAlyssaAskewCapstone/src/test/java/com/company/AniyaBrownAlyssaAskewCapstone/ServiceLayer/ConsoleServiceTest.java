package com.company.AniyaBrownAlyssaAskewCapstone.ServiceLayer;

import com.company.AniyaBrownAlyssaAskewCapstone.dao.ConsoleDao;
import com.company.AniyaBrownAlyssaAskewCapstone.dao.ConsoleDaoImpl;
import com.company.AniyaBrownAlyssaAskewCapstone.model.Console;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ConsoleServiceTest {

    ConsoleService consoleService;
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception{

        setUpConsoleDaoMock();

        consoleService = new ConsoleService(consoleDao);
    }
    @Test
    public void saveFindConsole(){
        Console console = new Console();
        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500GB");
        console.setProcessor("AMD Zen 2");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);

        console = consoleService.saveConsole(console);

        Console fromConsoleService = consoleService.getConsole(console.getId());

        assertEquals(console,fromConsoleService);

    }
    @Test
    public void findallConsole(){
        List<Console> fromConsoleService = consoleService.getAllConsoles();

        assertEquals(1,fromConsoleService.size());
    }

    @Test
    public void saveFindManufacturer(){
        Console console = new Console();
        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500GB");
        console.setProcessor("AMD Zen 2");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);

        console = consoleService.saveConsole(console);


        List<Console> cList = consoleService.getConsolebyManufacturer(console.getManufacturer());

        assertEquals(1,cList.size());
    }

    //helper methods
    private void setUpConsoleDaoMock(){

        consoleDao = mock(ConsoleDaoImpl.class);

        Console console =new Console();
        console.setId(1);
        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500GB");
        console.setProcessor("AMD Zen 2");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(1);


        Console console1 = new Console();
        console1.setModel("Playstation 5");
        console1.setManufacturer("Sony");
        console1.setMemory_amount("500GB");
        console1.setProcessor("AMD Zen 2");
        console1.setPrice(new BigDecimal("300.00"));
        console1.setQuantity(1);

        List<Console> cList = new ArrayList<>();
        cList.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(cList).when(consoleDao).getAllConsoles();
        doReturn(cList).when(consoleDao).getConsolebyManufacturer("Sony");
    }

}