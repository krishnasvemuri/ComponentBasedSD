//Krishna Sindhuri Vemuri G01024066 SWE_645_HW2
//This is the WinningResultBean data model.
package SWE645_VEMURI_HW2;

import javax.faces.bean.ManagedBean;

@ManagedBean(name= "winningresultBean")
public class WinningResultBean {

	 private double Mean;
	  private double Standard_Deviation;
	   
	  public double getMean() {
	    return (Mean);
	  }

	  public double getStandardDeviation() {
 	    return (Standard_Deviation);
	  }
	  public void setMean(double mean) {
	   this.Mean = mean;
	  }

	  public void setStandardDeviation(double Standard_Deviation) {
	   this.Standard_Deviation = Standard_Deviation; 
     }
}