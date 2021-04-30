package com.company.AniyaBrownAlyssaAskewCapstone.ServiceLayer;

import com.company.AniyaBrownAlyssaAskewCapstone.dao.TShirtDao;
import com.company.AniyaBrownAlyssaAskewCapstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShirtService {
    private final TShirtDao tShirtDao;

    @Autowired
    public TShirtService(TShirtDao tShirtDao) {
        this.tShirtDao = tShirtDao;
    }

    TShirt addTshirt(TShirt tShirt){return tShirtDao.addTshirt(tShirt);}

    TShirt getTshirt(int id){return tShirtDao.getTshirt(id);}

    List<TShirt> getAllTshirts(){return tShirtDao.getAllTshirts();}

    void deleteTshirt(int id){tShirtDao.deleteTshirt(id);}

    void updateTshirt(TShirt tShirt){tShirtDao.updateTshirt(tShirt);}

    List<TShirt> getbyColor(String color){return tShirtDao.getbyColor(color);};

    List<TShirt> getbySize(String size){return tShirtDao.getbySize(size);}
}
