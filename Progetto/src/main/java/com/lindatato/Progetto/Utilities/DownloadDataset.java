package com.lindatato.Progetto.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class DownloadDataset {

		String url = "http://data.europa.eu/euodp/data/api/3/action/package_show?id=erasmus-mobility-statistics-2011-12";
		String file= new String("student_1112.csv");
		public DownloadDataset() {
		try {
			
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream input = openConnection.getInputStream();
			
			 String data = "";
			 String line = "";
			 try {
			   InputStreamReader inputReader = new InputStreamReader( input );
			   BufferedReader br = new BufferedReader( inputReader );
			  
			   while ( ( line = br.readLine() ) != null ) {
				   data+= line;
				   System.out.println( line );
			   }
			 } finally {
			   input.close();
			 }
			JSONObject object = (JSONObject) JSONValue.parseWithException(data); 
			JSONObject objectI = (JSONObject) (object.get("result"));
			JSONArray objectArray = (JSONArray) (objectI.get("resources"));
			
			for(Object obj: objectArray){
			    if ( obj instanceof JSONObject ) {
			        JSONObject obj1 = (JSONObject)obj; 
			        String format = (String)obj1.get("format");
			        String urlD = (String)obj1.get("url");
			        System.out.println(format + " | " + urlD);
			        if(format.equals("csv")) {
			        	download(urlD, file);
			        }
			    }
			}			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println( "\nDownload completato." );
}
	
	public static void download(String url, String fileName) throws Exception {
	    try (InputStream in = URI.create(url).toURL().openStream()) {
	        Files.copy(in, Paths.get(fileName));
	    
	    }
	}
}
