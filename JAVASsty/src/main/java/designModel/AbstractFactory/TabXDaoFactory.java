package designModel.AbstractFactory;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class TabXDaoFactory implements DBDaoFactory{
    @Override
    public DBTableDao getMySqlDao() {
        return new MySqlDBTabX();
    }

    @Override
    public DBTableDao getOracleDao() {
        return new OracleDBTabX();
    }
}
