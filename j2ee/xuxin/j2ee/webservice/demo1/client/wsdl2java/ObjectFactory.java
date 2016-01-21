
package xuxin.j2ee.webservice.demo1.client.wsdl2java;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xuxin.j2ee.webservice.demo1.client.wsdl2java package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SelectMaxAgeStudentResponse_QNAME = new QName("http://server.demo1.webservice.j2ee.xuxin/", "selectMaxAgeStudentResponse");
    private final static QName _Student_QNAME = new QName("http://server.demo1.webservice.j2ee.xuxin/", "Student");
    private final static QName _SelectMaxAgeStudent_QNAME = new QName("http://server.demo1.webservice.j2ee.xuxin/", "selectMaxAgeStudent");
    private final static QName _SelectMaxLongNameStudent_QNAME = new QName("http://server.demo1.webservice.j2ee.xuxin/", "selectMaxLongNameStudent");
    private final static QName _SelectMaxLongNameStudentResponse_QNAME = new QName("http://server.demo1.webservice.j2ee.xuxin/", "selectMaxLongNameStudentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xuxin.j2ee.webservice.demo1.client.wsdl2java
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link SelectMaxAgeStudent }
     * 
     */
    public SelectMaxAgeStudent createSelectMaxAgeStudent() {
        return new SelectMaxAgeStudent();
    }

    /**
     * Create an instance of {@link SelectMaxLongNameStudent }
     * 
     */
    public SelectMaxLongNameStudent createSelectMaxLongNameStudent() {
        return new SelectMaxLongNameStudent();
    }

    /**
     * Create an instance of {@link SelectMaxLongNameStudentResponse }
     * 
     */
    public SelectMaxLongNameStudentResponse createSelectMaxLongNameStudentResponse() {
        return new SelectMaxLongNameStudentResponse();
    }

    /**
     * Create an instance of {@link SelectMaxAgeStudentResponse }
     * 
     */
    public SelectMaxAgeStudentResponse createSelectMaxAgeStudentResponse() {
        return new SelectMaxAgeStudentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectMaxAgeStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.demo1.webservice.j2ee.xuxin/", name = "selectMaxAgeStudentResponse")
    public JAXBElement<SelectMaxAgeStudentResponse> createSelectMaxAgeStudentResponse(SelectMaxAgeStudentResponse value) {
        return new JAXBElement<SelectMaxAgeStudentResponse>(_SelectMaxAgeStudentResponse_QNAME, SelectMaxAgeStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Student }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.demo1.webservice.j2ee.xuxin/", name = "Student")
    public JAXBElement<Student> createStudent(Student value) {
        return new JAXBElement<Student>(_Student_QNAME, Student.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectMaxAgeStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.demo1.webservice.j2ee.xuxin/", name = "selectMaxAgeStudent")
    public JAXBElement<SelectMaxAgeStudent> createSelectMaxAgeStudent(SelectMaxAgeStudent value) {
        return new JAXBElement<SelectMaxAgeStudent>(_SelectMaxAgeStudent_QNAME, SelectMaxAgeStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectMaxLongNameStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.demo1.webservice.j2ee.xuxin/", name = "selectMaxLongNameStudent")
    public JAXBElement<SelectMaxLongNameStudent> createSelectMaxLongNameStudent(SelectMaxLongNameStudent value) {
        return new JAXBElement<SelectMaxLongNameStudent>(_SelectMaxLongNameStudent_QNAME, SelectMaxLongNameStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectMaxLongNameStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.demo1.webservice.j2ee.xuxin/", name = "selectMaxLongNameStudentResponse")
    public JAXBElement<SelectMaxLongNameStudentResponse> createSelectMaxLongNameStudentResponse(SelectMaxLongNameStudentResponse value) {
        return new JAXBElement<SelectMaxLongNameStudentResponse>(_SelectMaxLongNameStudentResponse_QNAME, SelectMaxLongNameStudentResponse.class, null, value);
    }

}
