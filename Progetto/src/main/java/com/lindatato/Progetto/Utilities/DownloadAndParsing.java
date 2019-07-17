package com.lindatato.Progetto.Utilities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.lindatato.Progetto.Model.Erasmus;

public class DownloadAndParsing {
	
	private String url = "http://data.europa.eu/euodp/data/api/3/action/package_show?id=erasmus-mobility-statistics-2011-12";
	private Vector<Erasmus> erasmusList;
	private int limit;
	
	private String link = "";
	
	public DownloadAndParsing() {
		this.erasmusList = new Vector<Erasmus>();
		this.limit = 500;
	}
	
	public DownloadAndParsing(int limit) {
		this.erasmusList = new Vector<Erasmus>();
		this.limit = limit;
	}
	
	public String download() {
		try {
			URLConnection openConnection = new URL(url).openConnection();  //crea una connesione tra applicazioe e url
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream input = openConnection.getInputStream();  //crea il flusso di input
			
			 String data = "";
			 String line = "";
			 try {
			   InputStreamReader inputReader = new InputStreamReader(input);  //legge i byte e li decodifica in caratteri
			   BufferedReader br = new BufferedReader(inputReader);  //legge un file di testo
			   
			   while ((line = br.readLine())!=null) {
				   data += line;
				   //System.out.println(line);
			   }
			 } finally {
			   input.close();
			 }
			 
			 JSONObject object = (JSONObject) JSONValue.parseWithException(data); 
			 JSONObject objectI = (JSONObject) (object.get("result"));
			 JSONArray objectArray = (JSONArray) (objectI.get("resources"));
					 
			 for(Object obj : objectArray) {
				 if (obj instanceof JSONObject) {
					 JSONObject obj1 = (JSONObject)obj;
					if(((String)obj1.get("format")).toLowerCase().contains("csv") && ((String)obj1.get("url")).contains("student"))
						 link = (String)obj1.get("url");
				 }
			 }			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println( "\nDownload completato." );
		return link;
	}
	
	public Vector<Erasmus> parsing(String link) {
		String line = "";
	    String csvSplitBy = ";";
	    BufferedReader br= null;
	    boolean flag1= false, flag2= false;
	    int count = 1;
	    
	    try {
	    	URL urlCSV = new URL(link);
	    	br = new BufferedReader(new InputStreamReader(urlCSV.openStream()));
	    	
	    	while (((line = br.readLine()) != null) && !flag2) {
	    		if (count==this.limit) flag2= true;
	    		if (!flag1) {flag1=true; continue;}
	    		String[] valore = line.split(csvSplitBy);
	    		erasmusList.add(new Erasmus (valore[0],valore[1],Integer.parseInt(valore[2]),valore[3],valore[4],Integer.parseInt(valore[5]),valore[6],Integer.parseInt(valore[7]),valore[8],valore[9],valore[10],
    									valore[11],valore[12],valore[13],valore[14],Double.parseDouble(valore[15]),Double.parseDouble(valore[16]),valore[17],valore[18],valore[19],valore[20],
    									Integer.parseInt(valore[21]),Integer.parseInt(valore[22]),Integer.parseInt(valore[23]),Double.parseDouble(valore[24]),valore[25],valore[26],valore[27],
    									Double.parseDouble(valore[28]),Double.parseDouble(valore[29]),valore[30],valore[31]));
	    		count++;
	    	}
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
	    System.out.println("Parsing completato.\n");
	    
	    /*for(Erasmus e : erasmusList)
    	System.out.println(e);*/
	    return erasmusList;
	}
	
	public Vector<Erasmus> getData(){
		return erasmusList;
	}
}