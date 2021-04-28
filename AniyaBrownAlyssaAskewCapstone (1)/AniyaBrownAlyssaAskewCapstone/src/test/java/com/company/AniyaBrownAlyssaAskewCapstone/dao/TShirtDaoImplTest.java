package com.company.AniyaBrownAlyssaAskewCapstone.dao;

import com.company.AniyaBrownAlyssaAskewCapstone.model.Game;
import com.company.AniyaBrownAlyssaAskewCapstone.model.TShirt;
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


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoImplTest {

    @Autowired
    public TShirtDao shirtDao;

    @Before
    public void setUp()throws Exception{

        List<TShirt> allShirts = shirtDao.getAllTshirts();
        for(TShirt t: allShirts){
            shirtDao.deleteTshirt(t.getId());
        }
    }

    @Test
    public void addGetDeleteShirt(){

        TShirt shirt = new TShirt();
        shirt.setSize("X-Large");
        shirt.setColor("purple");
        shirt.setDescription("Summer short sleeve shirt with flower print");
        shirt.setPrice(new BigDecimal("10.00"));
        shirt.setQuantity(2);

        shirt = shirtDao.addTshirt(shirt);

        TShirt shirt1 = shirtDao.getTshirt(shirt.getId());

        assertEquals(shirt1,shirt);

        shirtDao.deleteTshirt(shirt.getId());

        shirt1 = shirtDao.getTshirt(shirt.getId());

        assertNull(shirt1);

    }

    @Test
    public void shouldGetAllShirts(){
        TShirt shirt = new TShirt();
        shirt.setSize("Large");
        shirt.setColor("white");
        shirt.setDescription("Plain ");
        shirt.setPrice(new BigDecimal("5.00"));
        shirt.setQuantity(5);

        shirt= shirtDao.addTshirt(shirt);

        shirt = new TShirt();
        shirt.setSize("small");
        shirt.setColor("black");
        shirt.setDescription("Marvel avengers long sleeve shirt ");
        shirt.setPrice(new BigDecimal("25.00"));
        shirt.setQuantity(2);

        shirt = shirtDao.addTshirt(shirt);

        shirt = new TShirt();
        shirt.setSize("X-Large");
        shirt.setColor("purple");
        shirt.setDescription("Summer short sleeve shirt with flower print");
        shirt.setPrice(new BigDecimal("10.00"));
        shirt.setQuantity(2);

        shirt = shirtDao.addTshirt(shirt);

        List<TShirt> tShirts = shirtDao.getAllTshirts();

        assertEquals(tShirts.size(),3);
    }

    @Test
    public void shouldUpdateTShirt(){
        TShirt shirt = new TShirt();
        shirt.setSize("small");
        shirt.setColor("black");
        shirt.setDescription("Marvel avengers long sleeve shirt ");
        shirt.setPrice(new BigDecimal("25.00"));
        shirt.setQuantity(2);

        shirt = shirtDao.addTshirt(shirt);

        shirt.setQuantity(3);
        shirt.setColor("yellow");

        shirtDao.updateTshirt(shirt);

        TShirt shirt1 = shirtDao.getTshirt(shirt.getId());

        assertEquals(shirt1,shirt);

    }

    @Test
    public void shouldGetShirtbyColor(){
        TShirt shirt = new TShirt();
        shirt.setSize("Large");
        shirt.setColor("black");
        shirt.setDescription("Plain ");
        shirt.setPrice(new BigDecimal("5.00"));
        shirt.setQuantity(5);

        shirt= shirtDao.addTshirt(shirt);

        shirt = new TShirt();
        shirt.setSize("small");
        shirt.setColor("black");
        shirt.setDescription("Marvel avengers long sleeve shirt ");
        shirt.setPrice(new BigDecimal("25.00"));
        shirt.setQuantity(2);

        shirt = shirtDao.addTshirt(shirt);

        shirt = new TShirt();
        shirt.setSize("X-Large");
        shirt.setColor("purple");
        shirt.setDescription("Summer short sleeve shirt with flower print");
        shirt.setPrice(new BigDecimal("10.00"));
        shirt.setQuantity(2);

        shirt = shirtDao.addTshirt(shirt);

        List<TShirt> tShirts = shirtDao.getbyColor("black");

        assertEquals(tShirts.size(),2);
    }

    @Test
    public void shouldGetShirtbySize(){
        TShirt shirt = new TShirt();
        shirt.setSize("Large");
        shirt.setColor("black");
        shirt.setDescription("Plain ");
        shirt.setPrice(new BigDecimal("5.00"));
        shirt.setQuantity(5);

        shirt= shirtDao.addTshirt(shirt);

        shirt = new TShirt();
        shirt.setSize("Large");
        shirt.setColor("black");
        shirt.setDescription("Marvel avengers long sleeve shirt ");
        shirt.setPrice(new BigDecimal("25.00"));
        shirt.setQuantity(2);

        shirt = shirtDao.addTshirt(shirt);

        shirt = new TShirt();
        shirt.setSize("Large");
        shirt.setColor("purple");
        shirt.setDescription("Summer short sleeve shirt with flower print");
        shirt.setPrice(new BigDecimal("10.00"));
        shirt.setQuantity(2);

        shirt = shirtDao.addTshirt(shirt);

        List<TShirt> tShirts = shirtDao.getbySize("Large");

        assertEquals(tShirts.size(),3);
    }

}