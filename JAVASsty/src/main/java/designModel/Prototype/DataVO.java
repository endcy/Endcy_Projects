package designModel.Prototype;

import java.io.*;
import java.util.List;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class DataVO implements Cloneable,Serializable {
    private String DataName;
    private List rowsData;

    public String getDataName() {
        return DataName;
    }

    public void setDataName(String dataName) {
        DataName = dataName;
    }

    public List getRowsData() {
        return rowsData;
    }

    public void setRowsData(List rowsData) {
        this.rowsData = rowsData;
    }

    @Override
    public DataVO clone() {
        DataVO dataVO = new DataVO();
        try {
            dataVO = (DataVO) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
//        List list = new ArrayList<>();
//        for (Object o : this.rowsData) {
//            list.add(o);
//        }
//        dataVO.setRowsData(list);
        return dataVO;
    }

    public DataVO cloneFinal() throws IOException, ClassNotFoundException {
        DataVO dataVO = new DataVO();
        ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
        ObjectOutputStream objOs = new ObjectOutputStream(byteOs);
        objOs.writeObject(this);
        ObjectInputStream objIs = new ObjectInputStream(new ByteArrayInputStream(byteOs.toByteArray()));
        dataVO = (DataVO) objIs.readObject();
        return dataVO;
    }
}
