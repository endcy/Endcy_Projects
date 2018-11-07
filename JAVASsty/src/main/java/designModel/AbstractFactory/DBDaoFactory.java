package designModel.AbstractFactory;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public interface DBDaoFactory {
    DBTableDao getMySqlDao();
    DBTableDao getOracleDao();
}
