package designModel.Prototype;

import java.io.IOException;
import java.util.Arrays;

/**
 * ***************************************************************************
 * Description  : 原型模型 Prototype模式是一种对象创建型模式，它采取复制原型对象的方法来创建对象的实例。使用
 * Prototype模式创建的实例，具有与原型一样的数据。
 * Author       : cxx
 * Creation date: 2018/4/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class PrototypeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataVO dataVO = new DataVO();
        dataVO.setDataName("this is A");
        dataVO.setRowsData(Arrays.asList(new String[]{"abc","cde","fgh"}));
        DataVO dataVOx = dataVO.clone();
        DataVO dataVOy = dataVO.cloneFinal();
        System.out.println(dataVO);
        System.out.println(dataVOx);
        System.out.println(dataVOy);
        System.out.println(dataVO.getRowsData());
        System.out.println("change rowsData last:xxx");
        dataVO.setRowsData(Arrays.asList(new String[]{"abc","cde","xxx"}));
        System.out.println(dataVO.getRowsData());
        System.out.println(dataVOx.getRowsData());
        System.out.println(dataVOy.getRowsData());
    }
}
