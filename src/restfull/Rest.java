package restfull;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;

import prolog.PrologSmartHome;


@Path("smarthome")
public class Rest {

	@Context
	private UriInfo context;

	@POST
	@Path("consultProlog")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String consultProlog()  {
		
		JSONObject json = new JSONObject();
		
		try {
			json.put("esito", PrologSmartHome.consultProlog());
			return json.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("esito", "errore");
			return json.toString();
		}
		
	}
	
	@POST
	@Path("assertProlog")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String assertProlog( @FormParam("azione") String azione,
								@FormParam("tempo") String tempo,
								@FormParam("oggetto") String oggetto) {
		
		JSONObject json = new JSONObject();
		
		if (azione == null) {
			json.put("esito", "errore");
			json.put("descrizione", "AZIONE non definita");
			return json.toString();
		}
		
		if (tempo == null) {
			json.put("esito", "errore");
			json.put("descrizione", "TEMPO non definito");
			return json.toString();
		}
		
		if (oggetto == null) {
			json.put("esito", "errore");
			json.put("descrizione", "OGGETTO non definito");
			return json.toString();
		}
		
		
		try {
			json.put("esito", PrologSmartHome.assertProlog(azione, tempo, oggetto));
			return json.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("esito", "errore");
			return json.toString();
		}
		
	}
	
	@POST
	@Path("assertPrologV2")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String assertProlog( @FormParam("fatto") String fatto) {
		
		JSONObject json = new JSONObject();
		
		if (fatto == null) {
			json.put("esito", "errore");
			json.put("descrizione", "FATTO non definito");
			return json.toString();
		}
		
		try {
			json.put("esito", PrologSmartHome.assertPrologV2(fatto));
			return json.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("esito", "errore");
			return json.toString();
		}
		
	}
	
	@POST
	@Path("queryProlog")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String queryProlog(  @FormParam("azione") String azione,
								@FormParam("tempo") String tempo,
								@FormParam("oggetto") String oggetto) {
		
		JSONObject json = new JSONObject();
		
		if (azione == null) {
			json.put("esito", "errore");
			json.put("descrizione", "AZIONE non definita");
			return json.toString();
		}
		
		if (tempo == null) {
			json.put("esito", "errore");
			json.put("descrizione", "TEMPO non definito");
			return json.toString();
		}
		
		if (oggetto == null) {
			json.put("esito", "errore");
			json.put("descrizione", "OGGETTO non definito");
			return json.toString();
		}
		
		
		try {
			json.put("esito", PrologSmartHome.queryProlog(azione, tempo, oggetto));
			return json.toString();
		
		} catch (Exception e) {
			e.printStackTrace();
			json.put("esito", "errore");
			return json.toString();
		}
		
	}
	
	@POST
	@Path("queryPrologV2")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String queryPrologV2( @FormParam("fatto") String fatto) {
		
		JSONObject json = new JSONObject();
		
		if (fatto == null) {
			json.put("esito", "errore");
			json.put("descrizione", "FATTO non definito");
			return json.toString();
		}
		
		try {
			json.put("esito", PrologSmartHome.queryPrologV2(fatto));
			return json.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("esito", "errore");
			return json.toString();
		}
		
	}
	
	@POST
	@Path("queryPrologV3")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String queryPrologV3( @FormParam("fatto") String fatto) {
		
		JSONObject json = new JSONObject();
		
		if (fatto == null) {
			json.put("esito", "errore");
			json.put("descrizione", "FATTO non definito");
			return json.toString();
		}
		
		try {
			json.put("esito", PrologSmartHome.queryPrologV3(fatto));
			return json.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("esito", "errore");
			return json.toString();
		}
		
	}
	
	
}