//Krishna Sindhuri Vemuri G01024066 SWE_645_HW4
//This is the ZipRest class for ajax application for ZipCode
package SWE645_VEMURI_HW4;

import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/zips")
public class ZipRest {

	Map<String, String> zipstatecity;

	public ZipRest() {
		super();
		zipstatecity = new HashMap<String, String>();
		zipstatecity.put("22312", "VA,Alexandria,22312");
		zipstatecity.put("22030", "VA,Fairfax,22030");
		zipstatecity.put("22301", "MD,Tysons Corner,22301");
		zipstatecity.put("20148", "VA,Ashburn,20148");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{zip}")
	public String LookUp(@PathParam("zip") String zip) {

		String match = zipstatecity.get(zip);
		String[] value = match.split(",");
		String cityState = new String(value[1] + "," + value[0]);
		return cityState;

	}

}
