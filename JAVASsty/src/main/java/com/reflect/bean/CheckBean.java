package com.reflect.bean;

import org.junit.Test;

/**
 * Created by cxx on 2016/8/31.
 */
public class CheckBean extends CheckBaseBean{
    private String index_x;    //坐标x
    private String index_y;    //坐标y
    private String color;    //颜色，所属方向
    private String exist;  //状态是否可用
    private String gostep; //状态是否可移动

    public String getIndex_x() {
        return index_x;
    }

    public void setIndex_x(String index_x) {
        this.index_x = index_x;
    }

    public String getIndex_y() {
        return index_y;
    }

    public void setIndex_y(String index_y) {
        this.index_y = index_y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getExist() {
        return exist;
    }

    public void setExist(String exist) {
        this.exist = exist;
    }

    public String getGostep() {
        return gostep;
    }

    public void setGostep(String gostep) {
        this.gostep = gostep;
    }

    @Test
    public void testToBean() {
        String test="index_x=1|index_y=2|color=black|exist=0|gostep=0";
        CheckBean cb=new CheckBean();
        try {
            cb.toBean(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
