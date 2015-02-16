package prolog;

import java.util.ArrayList;
import java.util.Hashtable;

import jpl.Atom;
import jpl.Compound;
import jpl.Query;
import jpl.Term;
import jpl.Variable;

@SuppressWarnings("deprecation")
public class PrologSmartHome {

	public static boolean consultProlog() {
		
		System.out.println("\"consultProlog()\" avviato.");

		Query q1 = new Query("consult", new Term[] {new Atom("C:/SVILUPPO/regoleCasa.txt")});
		
		boolean stato = q1.query();
		System.out.println( "consultProlog " + (stato ? "terminato con successo!" : "fallito")); 
		
		return stato;
	}
	
	public static boolean assertProlog(String azione, String tempo, String oggetto) {
		
		System.out.println("\"assertProlog()\" avviato.");
		
		Query q1 = new Query("assert", new Term[] {new Compound(oggetto+azione, new Term[] {new Atom(tempo)})});
		
		boolean stato = q1.query();
		System.out.println( "assertProlog " + (stato ? "terminato con successo!" : "fallito")); 
		
		return stato;
	}
	
	public static boolean assertPrologV2(String fatto) {
		
		System.out.println("\"assertPrologV2()\" avviato.");
		
		Query q1 = new Query("assert("+fatto+")");
		
		boolean stato = q1.query();
		System.out.println( "assertPrologV2 " + (stato ? "terminato con successo!" : "fallito")); 
		
		return stato;
	}
	public static boolean queryProlog(String azione, String tempo, String oggetto) {
		
		System.out.println("\"queryProlog()\" avviato.");
		
		Query q1 = new Query(oggetto+azione, new Term[] {new Atom(tempo)});
		
		boolean stato = q1.query();
		System.out.println( "queryProlog " + (stato ? "terminato con successo!" : "fallito"));
		
		return stato;
		
	}
	
	public static boolean queryPrologV2(String fatto) {
		
		System.out.println("\"queryPrologV2()\" avviato.");
		
		Query q1 = new Query(fatto);
		
		boolean stato = q1.query();
		System.out.println( "queryPrologV2 " + (stato ? "terminato con successo!" : "fallito")); 
		
		return stato;
	}
	
	public static ArrayList<Object> queryPrologV3(String fatto) {
		
		System.out.println("\"queryPrologV3()\" avviato.");
		
		Variable X = new Variable("X");
		
		Query q1 = new Query(fatto+"(X)" );
		
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
}
