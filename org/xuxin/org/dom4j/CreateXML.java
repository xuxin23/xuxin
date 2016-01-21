/**
 * 
 */
package xuxin.org.dom4j;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 利用dom4j创建xml文件
 * @version 1.0
 * @author xuxin 
 * @data 2012-12-7
 */
public class CreateXML {
    
    public static void main(String[] args) {
        CreateXML createXML = new CreateXML();
        createXML.createXMLFile("src/book.xml");
    }
    
    /**
     * 建立一个XML文档，文档名由输入属性决定
     * @param fileName 需建立的文件名
     * @return 返回操作结果，0表失败，1表成功
     */
    public int createXMLFile(String fileName) {
        int returnValue = 0;
        //建立document对象
        Document document = DocumentHelper.createDocument();
        //建立XML文档的根books
        Element booksElement = document.addElement("books");
        //加入一行注释
        booksElement.addComment("This is a test for dom4j,2012.12.07");
        //加入第一个book节点
        Element bookElement = booksElement.addElement("book");
        //加入show属性内容
        bookElement.addAttribute("show", "yes");
        //加入title节点
        Element titleElement = bookElement.addElement("titel");
        //为title设置内容
        titleElement.setText("Dom4j study...");
        
        //类似的完成两个book
        bookElement = booksElement.addElement("book");
        bookElement.addAttribute("show","yes");
        titleElement = bookElement.addElement("title");
        titleElement.setText("how do you feel...");
        bookElement = booksElement.addElement("book");
        bookElement.addAttribute("show", "no");
        titleElement = bookElement.addElement("title");
        titleElement.setText("yes,it's last one...");
        
        //加入owner节点
        Element ownerElement = booksElement.addElement("owner");
        ownerElement.setText("xuxin");
        
        try {
            //格式化输出
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            //将document中的内容写入文件中
            XMLWriter writer = new XMLWriter(new FileWriter(FileTool.createFile(fileName)),format);
            writer.write(document);
            writer.close();
            returnValue = 1;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
