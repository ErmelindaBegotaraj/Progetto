package main.javaoop.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import main.javaoop.model.Erasmus;

public class ParsingCSV {
	
	private List<Erasmus> lista = new ArrayList<>();
		public ParsingCSV() {
			String csvFile= "C:\\Users\\corra\\Desktop\\CORRADO RAIOLA\\UNIVERSITÀ\\II ANNO\\PROGRAMMAZIONE A OGGETTI\\PROGETTO\\student_1112.csv";
			String line = "";
		    String csvSplitBy = ",";
		    BufferedReader br= null;
		    
		    try {
		 
		    	br = new BufferedReader(new FileReader(csvFile)); 
		    	while ((line = br.readLine()) != null) {
		    		String[] valore = line.split(csvSplitBy);
	    			lista.add(new Erasmus (valore[0],valore[1],valore[2],valore[3],valore[4],valore[5],valore[6],valore[7],valore[8],valore[9],valore[10],
	    								valore[11],valore[12],valore[13],valore[14],valore[15],valore[16],valore[17],valore[18],valore[19],valore[20],
	    								Integer.parseInt(valore[21]),Integer.parseInt(valore[22]),Integer.parseInt(valore[23]),Integer.parseInt(valore[24]),Integer.parseInt(valore[25]),Integer.parseInt(valore[26]),Integer.parseInt(valore[27]),Integer.parseInt(valore[28]),Double.parseDouble(valore[29]),Double.parseDouble(valore[30]),Double.parseDouble(valore[31])));
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
	        }
		public List<Erasmus> getList(){
			return lista;
		}
		
	}