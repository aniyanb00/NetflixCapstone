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

    public TShirt saveTshirt(TShirt tShirt){return tShirtDao.addTshirt(tShirt);}

    public TShirt getTshirt(int id){return tShirtDao.getTshirt(id);}

    public List<TShirt> getAllTshirts(){return tShirtDao.getAllTshirts();}

    public void deleteTshirt(int id){tShirtDao.deleteTshirt(id);}

    public void updateTshirt(TShirt tShirt){tShirtDao.updateTshirt(tShirt);}

    public List<TShirt> getbyColor(String color){return tShirtDao.getbyColor(color);}

    public List<TShirt> getbySize(String size){return tShirtDao.getbySize(size);}
}
