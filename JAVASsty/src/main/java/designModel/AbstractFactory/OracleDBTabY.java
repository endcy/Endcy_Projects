package designModel.AbstractFactory;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class OracleDBTabY extends OracleDBTable {
    @Override
    public String saveInfo(String info) {
        return "OracleDBTabY Deal ……" + info;
    }
}
