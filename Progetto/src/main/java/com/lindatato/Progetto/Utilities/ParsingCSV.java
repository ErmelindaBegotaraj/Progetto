package Progetto.src.main.java.com.lindatato.Progetto.Utilities;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

import com.lindatato.Progetto.Model.Erasmus;

public class ParsingCSV {
	
	private List<Erasmus> lista = new ArrayList<>();
	private List<Map> metadata = new ArrayList<>();
	

	public ParsingCSV() {
			String csvFile= "student_1112.csv";
			String line = "";
		    String csvSplitBy = ";";
		    BufferedReader br= null;
		    boolean flag1= false, flag2= false;
		    int count= 0;
		    
		    try {
		    	
		    	br = new BufferedReader(new FileReader(csvFile));
		    	
		    	while (((line = br.readLine()) != null) && !flag2) {
		    		if (count==500) flag2= true;
		    		if (!flag1) {flag1=true; continue;}
		    		String[] valore = line.split(csvSplitBy);
	    			lista.add(new Erasmus (valore[0],valore[1],Integer.parseInt(valore[2]),valore[3],valore[4],Integer.parseInt(valore[5]),valore[6],Integer.parseInt(valore[7]),valore[8],valore[9],valore[10],
	    									valore[11],valore[12],valore[13],valore[14],Double.parseDouble(valore[15]),Double.parseDouble(valore[16]),valore[17],valore[18],valore[19],valore[20],
	    									Integer.parseInt(valore[21]),Integer.parseInt(valore[22]),Integer.parseInt(valore[23]),Double.parseDouble(valore[24]),valore[25],valore[26],valore[27],
	    									Double.parseDouble(valore[28]),Double.parseDouble(valore[29]),valore[30],valore[31])); }
		    	} catch (FileNotFoundException e) {
		    		e.printStackTrace();
		    	} catch (IOException e) {
		    		e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	           }
	        }
		    System.out.println("Parsing completato.");
	}
		
	public List getMetadata() {
		return metadata;
	}
	
	public Erasmus getHostIst(int id) {
		if(id < List.size()) return List.get(id);
		else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Host Country: '" + id + "' does not exist");
	}
	
	public Erasmus getHometIst(int id) {
		if(id < List.size()) return List.get(id);
		else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Home Country: '" + id + "' does not exist");
	}
		*/
	
	public List getAllData(){
		return lista;
	}
 
    
	public static void SerializzazioneDati(File file, List<Erasmus> dati) {
			   try {			   
				   ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				   output.writeObject(dati);
				   output.close();
			   } catch(IOException e) {
				   System.out.println("Error of I/O");
				   e.printStackTrace();
			   }
		}
		
}