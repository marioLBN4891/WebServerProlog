package restfull;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import prolog.Prolog;

@Path("she")
public class Rest {

	@Context
	private UriInfo context;

	@POST
	@Path("start")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String start()  {
		
		JSONObject json = new JSONObject();
		
		try {
			json.put("esito", Prolog.startGie());
			return json.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("esito", "errore");
			return json.toString();
		}
		
	}
	
	
	@POST
	@Path("request")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String request(@FormParam("fatto") String fatto) {
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		
		if (fatto == null) {
			json.put("esito", "errore");
			json.put("descrizione", "FATTO non definito");
		}
		
		try {
			json.put("esito", true);
			ArrayList<String> listaNewFacts = Prolog.runEngine(fatto);
			if (listaNewFacts != null && !listaNewFacts.isEmpty()) {
				for (String newFact : listaNewFacts) {
					JSONObject newJson = new JSONObject();
					newJson.put("fatto", newFact);
					array.put(newJson);
				}
			}
			json.put("listaFatti", array);
			return json.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("esito", "errore");
			return json.toString();
		}
		
	}
	
}