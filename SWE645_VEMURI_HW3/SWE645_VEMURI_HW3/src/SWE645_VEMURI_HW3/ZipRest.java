//Krishna Sindhuri Vemuri G01024066 SWE_645_HW3
//This is the Restful Services implementation for the ZipCode ajax implementation.
package SWE645_VEMURI_HW3;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
@Path("ziprest")
@ApplicationPath("webresources")
public class ZipRest extends Application{
	
	StudentService studentService = new StudentService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)	
	@Path("{zip}")
	public String populateCS(@PathParam("zip") String zip) {
		String city = null, state=null;
		if (zip.length() == 5) {				
			for (Map.Entry<String, String> entry : getMap().entrySet()) {
				if (entry.getKey().equals(zip)) {
					String[] city_state = entry.getValue().split("-");
					city = city_state[0];
					state = city_state[1];			
				}
			}
		}
		return city+"-"+state;
	}
	public Map<String, String> getMap() 
	{
		Map<String, String> zip_city_state = new HashMap<String, String>();
		zip_city_state.put("22312", "Alexandria-VA");
		zip_city_state.put("22030", "Fairfax-VA");
		zip_city_state.put("22301", "TysonsCorner-MD");
		zip_city_state.put("20148", "Ashburn-VA");

		return zip_city_state;
	}

}

