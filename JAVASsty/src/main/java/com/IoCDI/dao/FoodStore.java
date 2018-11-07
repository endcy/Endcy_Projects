package com.IoCDI.dao;

import com.IoCDI.bean.Food;
import com.IoCDI.bean.FoodComA;
import com.IoCDI.bean.FoodComB;
import com.IoCDI.implement.IFoodCompany;

/**
 * Created by cxx on 2016/9/1.
 */
public class FoodStore {
    private IFoodCompany ifoodcom;

    //等待注入
    public void setIfoodcom(IFoodCompany ifc) {
        this.ifoodcom = ifc;
    }
    //注入后调用（即注入后已经可获取到生产对象）
    public IFoodCompany getFoodCom() {
        return ifoodcom;
    }
    //注入后获取了对象，可执行目的操作
    public void getFood() {
        getFoodCom().getFood();
    }

    public static void main(String[] args) {
        FoodStore boss = new FoodStore();
        boss.setIfoodcom(new FoodComB());
        boss.getFood();
    }
}
