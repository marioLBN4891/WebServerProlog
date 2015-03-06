package prolog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SourceKB {

	public static String kb_path = "C:\\SVILUPPO\\gie_src\\gie_kb.pl";
	public static String storage_path = "C:\\SVILUPPO\\gie_src\\gie_storagekb.pl";
	
	public static boolean resetKB(String path) {
		
		try {
			File f = new File(path);
			f.delete();
			f.createNewFile();
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	public static boolean writeKB(String path, String fact) {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)))) {
		    out.println(fact);
		    out.close();
		    return true;
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean writeKB(String path, ArrayList<String> listaFact) {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)))) {
		    for(String fact : listaFact)
		    	out.println(fact);
		    out.close();
		    return true;
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static ArrayList<String> readNewFacts(String path) {
		ArrayList<String> listaFatti = new ArrayList<String>();
		String rigaFile;

		try {
			BufferedReader bufferFile = new BufferedReader( new FileReader(path));
			
			rigaFile=bufferFile.readLine();
			while (rigaFile != null) {
				if (rigaFile.contentEquals("%New facts")) {
					rigaFile=bufferFile.readLine();
					while (rigaFile != null) {
						listaFatti.add(rigaFile);
						rigaFile=bufferFile.readLine();
					}
				}
				else 
					rigaFile=bufferFile.readLine();
			}
			bufferFile.close();
			return listaFatti;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
