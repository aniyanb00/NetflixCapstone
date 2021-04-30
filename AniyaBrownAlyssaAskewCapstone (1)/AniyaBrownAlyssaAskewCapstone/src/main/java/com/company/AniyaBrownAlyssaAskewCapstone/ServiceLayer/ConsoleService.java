package com.company.AniyaBrownAlyssaAskewCapstone.ServiceLayer;

import com.company.AniyaBrownAlyssaAskewCapstone.dao.ConsoleDao;
import com.company.AniyaBrownAlyssaAskewCapstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleService {

    private final ConsoleDao consoleDao;

    @Autowired
    public ConsoleService(ConsoleDao consoleDao) {
        this.consoleDao = consoleDao;
    }

    public Console addConsole(Console console){return consoleDao.addConsole(console);}

    public Console getConsole(int id){return consoleDao.getConsole(id);}

    public List<Console> getAllConsoles(){return consoleDao.getAllConsoles();}

    void updateConsole(Console console){ consoleDao.updateConsole(console);}

    void deleteConsole(int id){consoleDao.deleteConsole(id);}

    public List<Console> getConsolebyManufacturer(String manufacturer){return consoleDao.getConsolebyManufacturer(manufacturer);}
}
