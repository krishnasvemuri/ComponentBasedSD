//Krishna Sindhuri Vemuri -G01024066
//Java class for getSearchList complex type.
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSearchList", propOrder = {
    "arg0",
    "arg1",
    "arg2",
    "arg3"
})
public class GetSearchList {

    protected String arg0;
    protected String arg1;
    protected String arg2;
    protected String arg3;

  
    public String getArg0() {
        return arg0;
    }

   
    public void setArg0(String value) {
        this.arg0 = value;
    }

    
    public String getArg1() {
        return arg1;
    }

   
    public void setArg1(String value) {
        this.arg1 = value;
    }

    
    public String getArg2() {
        return arg2;
    }

    
    public void setArg2(String value) {
        this.arg2 = value;
    }

   
    public String getArg3() {
        return arg3;
    }

   
    public void setArg3(String value) {
        this.arg3 = value;
    }

}
