package com.virOperation.awt;

import java.awt.*;

public class MoveMouse {
    private static Robot myRobot = null;

    public static void move() {
        if (myRobot == null)
            try {
                myRobot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();

            }
        PointerInfo pinfo = MouseInfo.getPointerInfo();
        Point p = pinfo.getLocation();
        int mx = (int) p.getX();
        int my = (int) p.getY();
        myRobot.mouseMove(mx + 100, my);
        //坐标复原
        myRobot.mouseMove(mx, my);
    }

}