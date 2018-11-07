package designModel.AbstractFactory;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public abstract class OracleDBTable implements DBTableDao {
    public abstract String saveInfo(String info);
}
