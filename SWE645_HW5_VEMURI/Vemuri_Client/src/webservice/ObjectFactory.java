//Krishna Sindhuri Vemuri -G01024066
//This is the Java Object factory class
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private final static QName _GetSearchListResponse_QNAME = new QName("http://webservice/", "getSearchListResponse");
    private final static QName _GetSearchList_QNAME = new QName("http://webservice/", "getSearchList");

    public ObjectFactory() {
    }
    public GetSearchListResponse createGetSearchListResponse() {
        return new GetSearchListResponse();
    }

    public GetSearchList createGetSearchList() {
        return new GetSearchList();
    }

    public StudentModel createStudentModel() {
        return new StudentModel();
    }

    @XmlElementDecl(namespace = "http://webservice/", name = "getSearchListResponse")
    public JAXBElement<GetSearchListResponse> createGetSearchListResponse(GetSearchListResponse value) {
        return new JAXBElement<GetSearchListResponse>(_GetSearchListResponse_QNAME, GetSearchListResponse.class, null, value);
    }
    @XmlElementDecl(namespace = "http://webservice/", name = "getSearchList")
    public JAXBElement<GetSearchList> createGetSearchList(GetSearchList value) {
        return new JAXBElement<GetSearchList>(_GetSearchList_QNAME, GetSearchList.class, null, value);
    }

}
