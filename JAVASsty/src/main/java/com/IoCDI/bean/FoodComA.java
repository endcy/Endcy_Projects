package com.IoCDI.bean;

import com.IoCDI.implement.IFoodCompany;

/**
 * Created by cxx on 2016/9/1.
 */
public class FoodComA implements IFoodCompany {
    private Food food;

    @Override
    public Food getFood() {
        System.out.println("来源 CompanyA");
        return food;
    }

    public void setFood(Food food) {
        food = this.food;
    }
}
