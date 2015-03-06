package prolog;

import java.util.ArrayList;
import java.util.Hashtable;

import jpl.Atom;
import jpl.Query;
import jpl.Term;

@SuppressWarnings("unused")
public class Prolog {

	private static String gie_path = "C:/SVILUPPO/gie_src/gie_start.pl";
	private static String fallito = "FALLITO.";
	private static String terminato = "TERMINATO.";
	private static String sim_avviata = "%Simulazione Avviata";
	private static String sim_terminata = "%Simulazione Terminata";
	
	
	public static boolean startGie() {
		System.out.print("Start Gie: AVVIATO. ");
		
		if (!(SourceKB.resetKB(SourceKB.kb_path) && SourceKB.resetKB(SourceKB.storage_path))) {
			System.out.println(fallito);
			return false;
		}
		
		if (!SourceKB.writeKB(SourceKB.storage_path, sim_avviata)) {
			System.out.println(fallito);
			return false;
		}
		
		Query q1 = new Query("reconsult", new Term[] {new Atom(gie_path)});
		boolean stato = q1.hasSolution();
		System.out.println((stato ? terminato : fallito));
		return stato;
	}
	
	public static boolean stopGie() {
		
		return SourceKB.writeKB(SourceKB.storage_path, sim_terminata);
	}
	
	private static boolean _1_loadKB() {
		return eseguiQuery("1 Load Knowledge Base: AVVIATO. ", "uno");
	}
	
	private static boolean _2_startEngine() {
		return eseguiQuery("2 Start engine and infer:  AVVIATO. ", "due");
	}
	
	private static boolean _3_viewFacts() {
		return eseguiQuery("3 View facts: AVVIATO. ", "tre");
	}

	private static boolean _4_viewUsedFacts() {
		return eseguiQuery("4 View used facts: AVVIATO. ", "quattro");
	}

	private static boolean _5_viewRules() {
		return eseguiQuery("5 View rules: AVVIATO. ", "cinque");
	}

	private static boolean _6_viewUsedRules() {
		return eseguiQuery("6 View used rules: AVVIATO. ", "sei");
	}

	private static boolean _7_viewindexedRules() {
		return eseguiQuery("7 View indexed rules: AVVIATO. ", "sette");
	}

	private static boolean _8_initializeEnviroment() {
		return eseguiQuery("8 Initialize enviroment: AVVIATO. ", "otto");
		}

	private static boolean _9_saveNewFactsToKB() {
		return eseguiQuery("9: Save new facts to KB. AVVIATO. ", "nove");
	}

	private static boolean assertFact(String fattoAttuale) {
		System.out.print("- Assert fact: AVVIATO. ");
		
		ArrayList<String> listaFatti = new ArrayList<String>();
		listaFatti = SourceKB.readNewFacts(SourceKB.kb_path);
		listaFatti.add(fattoAttuale);
		SourceKB.resetKB(SourceKB.kb_path);
		SourceKB.writeKB(SourceKB.storage_path, fattoAttuale);
		
		boolean stato = SourceKB.writeKB(SourceKB.kb_path, listaFatti);
		System.out.println((stato ? terminato : fallito));
		return stato;
	}
	
	private static ArrayList<String> readNewFacts() {
		ArrayList<String> listaNewFacts = SourceKB.readNewFacts(SourceKB.kb_path);
		SourceKB.writeKB(SourceKB.storage_path, listaNewFacts);
		return listaNewFacts;
	}

	public static ArrayList<String> runEngine(String fatto) {
		try {
			Prolog.assertFact(fatto);
			Prolog._1_loadKB();
			Prolog._2_startEngine();
			Prolog._9_saveNewFactsToKB();
			return Prolog.readNewFacts();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	private static ArrayList<Object> queryPrologV3(String fatto) {
		
		System.out.println("\"queryPrologV3()\" avviato.");
		Query q1 = new Query(fatto+"(X)" );
		@SuppressWarnings("rawtypes")
		Hashtable solution;
		ArrayList<Object> soluzioni = new ArrayList<Object>();
		
		while (q1.hasMoreSolutions()) {
		    solution = q1.nextSolution();
		    System.out.println( "X = " + solution.get("X"));
		    soluzioni.add(solution.get("X"));
		}
		System.out.println( "queryPrologV3 terminato con successo!"); 
		return soluzioni;
	}
	
	private static boolean eseguiQuery(String comando, String query) {
		System.out.print(comando);
		Query q1 = new Query(query);
		boolean stato = q1.hasSolution();
		System.out.println((stato ? terminato : fallito));
		return stato;
	}
}
