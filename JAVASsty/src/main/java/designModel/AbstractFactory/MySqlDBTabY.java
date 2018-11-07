package designModel.AbstractFactory;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class MySqlDBTabY extends MySqlDBTable {
    @Override
    public String saveInfo(String info) {
        return "MySqlDBTabY Deal ……" + info;
    }
}
