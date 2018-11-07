package cn.endcy.fileutils;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by cxx on 2017/7/10.
 */
public class ReadXML {

    /**
     * 解析返回的报文为 key-map形式
     *
     * @param recXml
     * @return
     * @throws Exception
     */
    public static Map<String, Object> parserXml(String recXml) throws Exception {
        Map<String, Object> elemMap = new HashMap<String, Object>();
        Document document = null;
        document = DocumentHelper.parseText(recXml);
        Element root = document.getRootElement();
        List<Element> elements = root.elements();
        Element recordEle = elements.get(1);
        elements = recordEle.elements();
        recordEle = elements.get(0);
        elements = recordEle.elements();
        //判断是否有下一个节点
        if (elements.size() <= 1) {
            return elemMap;
        }
        recordEle = elements.get(1);
        elements = recordEle.elements();
        for (int i = 0; i < elements.size(); i++) {
            //子节点的操作
            Element it = (Element) elements.get(i);
            Iterator iters = it.elementIterator();
            while (iters.hasNext()) {
                Element itemEles = (Element) iters.next();
                elemMap.put(itemEles.getName(), itemEles.getTextTrim());
            }
            elemMap.put(it.getName(), it.getTextTrim());
        }
        return elemMap;
    }

}
