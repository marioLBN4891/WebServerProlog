package restfull;



import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;
import org.omg.CORBA.SystemException;

@Path("prolog")
public class Rest {

	@Context
	private UriInfo context;

	@POST
	@Path("avvio1")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String avvio1()  {
		
		JSONObject json = new JSONObject();
		
		try {
			Test.main();
			json.put("esito", "OKavvio1prolog");
			return json.toString();
			
		} catch (SystemException e) {
			json.put("esito", "errore");
			return json.toString();
		}
		
	}
	
	@POST
	@Path("avvio2")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String avvio2()  {
		
		JSONObject json = new JSONObject();
		
		try {
			json.put("esito", "OKavvio2");
			return json.toString();
			
		} catch (SystemException e) {
			json.put("esito", "errore");
			return json.toString();
		}
		
	}
	
	@POST
	@Path("avvio3")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String avvio3()  {
		
		JSONObject json = new JSONObject();
		
		try {
			Test.main2();
			json.put("esito", "OKavvio3prolog");
			return json.toString();
			
		} catch (SystemException e) {
			json.put("esito", "errore");
			return json.toString();
		}
		
	}
}