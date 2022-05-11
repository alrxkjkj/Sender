package utils.xml;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlReaders {
    private static XmlReaders xml = new XmlReaders();

    /**
     * getXml:(读取xml文件。获取document树). <br/>
     * @author syzhao
     * @param xmlPath xml数字
     * @return Document
     * @since JDK 1.6
     */
    private static Document getXml(String xmlPath)
    {
        Document document = null;
        SAXReader reader = new SAXReader();

        try
        {
            document = reader.read(xml.getClass().getClassLoader().getResourceAsStream(xmlPath));
        }
        catch (DocumentException e)
        {
            //getClass().getClassLoader().getResourceAsStream(xmlPath)
            //System.out.println(xml.getClass().getClassLoader().getResourceAsStream(xmlPath));
            System.out.println(new File(xml.getClass().getResource("").getPath()));
            System.out.println("获取xml " + xmlPath + " 文件失败！");
            e.printStackTrace();
        }
        return document;
    }

    /**
     * getSql:(获取xml中的sql语句). <br/>
     * @author syzhao
     * @param xmlPath xml路径
     * @param xpathExpression 元素路径
     * @return key：sql
     * @since JDK 1.6
     */
    public static HashMap<String, String> getSql(String xmlPath, String xpathExpression)
    {
        HashMap<String, String> map = new HashMap<String, String>();
        List<Object> list = getXml(xmlPath).selectNodes(xpathExpression);
        if (list != null && !list.isEmpty())
        {

            for (Object object : list)
            {
                Element element = (Element)object;
                String sql = element.getTextTrim();
                String key = element.attributeValue("id").trim();
                map.put(key, sql);
            }
        }
        return map;
    }
    public static void main(String[] args)
    {

        /*HashMap<String, String> map = XmlReaders.getSql("sql.xml", "sqls/sql");
        System.out.println("map size :" + map.size());
        for (String key : map.keySet())
        {
            System.out.println("id:" + key);
            System.out.println("value:" + map.get(key));
            System.out.println("-------------------------分割线----------------------");
        }*/
        HashMap<String, String> map = XmlReaders.getSql("sql.xml", "sqls/sql");
        /*for (String key : map.keySet())
        {
            String s = map.get("LOGIN_INQUIRE");
            System.out.println(s);
        }*/
        System.out.println(map.get("LOGIN_INQUIRE"));
    }
}
