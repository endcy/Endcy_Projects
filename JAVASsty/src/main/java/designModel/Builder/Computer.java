package designModel.Builder;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/5/30.
 * Version      : 1.0
 * ***************************************************************************
 */
public class Computer {
    private String oem;
    private String mouse;
    private String screen;
    private int id;

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "oem='" + oem + '\'' +
                ", mouse='" + mouse + '\'' +
                ", screen='" + screen + '\'' +
                ", id=" + id +
                '}';
    }
}
