package cn.endcy.sortutils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2017/10/25.
 * Version      : 1.0
 * ***************************************************************************
 */
public class SortList {
    public void sortListMap(List<Map<String, Object>> resultList) {
        Collections.sort(resultList, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> t1, Map<String, Object> t2) {
                //某个可转为数字的对象作为排序对象，可定义其它对比方式例如汉字排序等等
                Integer num1 = (Integer) t1.get("ShouldSortStr");
                Integer num2 = (Integer) t2.get("ShouldSortStr");
                if (num1 > num2)
                    return 1;
                else
                    return -1;
            }
        });
    }
}
