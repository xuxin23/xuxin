package xuxin.org.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 利用dom4j修改xml文件内容
 * @version 1.0
 * @author xuxin 
 * @data 2012-12-7
 */
public class ModifyXML {
    
    public static void main(String[] args) {
        ModifyXML modifyXML = new ModifyXML();
        modifyXML.modifyXMLFile("src/book.xml", "src/book.xml");
    }
    
    /**
     * 修改XML文件中内容，并另存为一个新文件
     * 重点掌握dom4j中如何添加节点，修改节点，删除节点
     * @param fileName 修改对象文件
     * @param newFileName 修改后另存为该文件
     * @return 返回操作结果，0表失败，1表成功
     */
    public int modifyXMLFile(String fileName,String newFileName) {
        int returnValue = 0;
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new File(fileName));
            
             /* 修改内容1：如果book节点中show属性的内容为yes,则修改成no*/
             //先用xpath查找对象
            List list = document.selectNodes("/books/book/@show");
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Attribute attribute = (Attribute) iterator.next();
                if (attribute.getValue().equals("yes")) {
                    attribute.setValue("no");
                }
            }
            
            /*修改内容2：把owner项内容改为test modify...*/
            /*并在owner节点加入data节点，还为data节点添加一个属性type*/
            list = document.selectNodes("/books/owner");
            iterator = list.iterator();
            if (iterator.hasNext()) {
                Element ownerElement = (Element) iterator.next();
                ownerElement.setText("test modify...");
                Element dataElement = ownerElement.addElement("data");
                dataElement.setText("2012-12-07");
                dataElement.addAttribute("type", "Gregorian calendar");
            }
            
            /*修改内容3：若tile内容为yes,it's last one...，则删除该节点*/
            list = document.selectNodes("/books/book");
            iterator = list.iterator();
            while (iterator.hasNext()) {
                Element bookElement = (Element) iterator.next();
                Iterator iterator2 = bookElement.elementIterator("title");
                while (iterator2.hasNext()) {
                    Element titleElement = (Element) iterator2.next();
                    if (titleElement.getText().equals("yes,it's last one...")) {
                        bookElement.remove(titleElement);
                    }
                }
            }
            
            try {
                //格式化输出
                OutputFormat format = OutputFormat.createPrettyPrint();
                format.setEncoding("UTF-8");
                //将document中的内容写入文件中
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(FileTool.createFile(newFileName)),"UTF-8");
                XMLWriter writer = new XMLWriter(osw,format);
                writer.write(document);
                writer.close();
                returnValue = 1;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (DocumentException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
