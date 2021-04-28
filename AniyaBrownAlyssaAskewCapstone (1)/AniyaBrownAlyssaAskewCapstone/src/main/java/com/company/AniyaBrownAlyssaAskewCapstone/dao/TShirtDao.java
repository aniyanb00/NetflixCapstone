package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.TShirt;

import java.util.List;

public interface TShirtDao {
    TShirt addTshirt(TShirt tShirt);

    TShirt getTshirt(int id);

    List<TShirt> getAllTshirts();

    void deleteTshirt(int id);

    void updateTshirt(TShirt tShirt);

    List<TShirt> getbyColor(String color);

    List<TShirt> getbySize(String size);
}
