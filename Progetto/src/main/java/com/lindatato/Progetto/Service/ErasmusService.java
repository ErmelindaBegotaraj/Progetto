package com.lindatato.Progetto.Service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.lindatato.Progetto.Utilities.*;
//import com.sun.java.util.jar.pack.Package.Class.Field;
import com.lindatato.Progetto.Model.*;

@org.springframework.stereotype.Service

/**
 * 
 * Classe che gestisce le operazioni di download e carica del dataset
 *
 */
public class ErasmusService {
	
	private DownloadAndParsing utilities;
	private Metadata serviceMeta;
	private Stats serviceStats;
	
	/**
	 * Costruttore che carica il dataset facendo il parsing
	 * oppure, se il file è già stato creato, ricarica il parsing precedente
	 */
	public ErasmusService() {
		
		String serialFile= "serial1.ser";
		
		if(Files.exists(Paths.get(serialFile))) {
			SerialUpload(serialFile);
		} 
		else {
			DownloadAndParsing download = new DownloadAndParsing();
			SerialSaving(serialFile);
		}
	}
	/**
	 * Classe che restituisce i metadati del file CSV
	 * @return la lista contenente i metadati
	 */
	public List<Map> getMetadata() {
		return serviceMeta.getMetadata();
	}
	
	public Vector<Erasmus> getData() {
 		return utilities.getData();
	}
	
	public Map<String, Object> getStats(String nomeCampo) {
		return serviceStats.getStats(nomeCampo, fieldValues(nomeCampo, getData()));
	}
	
	/**
	 * Metodo che estrae i valori di un determinato campo, passato tramite fieldName
	 * @param fieldName nome del campo del file CSV
	 * @param list lista che si ottiene dopo aver effettuato il parsing, vettore di oggetti "Erasmus"
	 * @return la lista che contiene i valori di un determinato campo
	 */
	public List fieldValues(String fieldName, Vector<Erasmus> list) {
		List<Object> values = new ArrayList<>();
		try {
			Field[] fields = Erasmus.class.getDeclaredFields();
			for(Erasmus e : list) {
				for(int i=0; i < fields.length; i++) {
					if(fieldName.equals(fields[i].getName())) {
							values.add(e.getClass().getMethod(fields[i].getName()));
					}
				}
			}
		} catch(NoSuchMethodException ex) {
			ex.printStackTrace();
		} catch(SecurityException ex) {
			ex.printStackTrace();
		}
		return values;
	}
	
	/**
	 * Metodo che esegue il salvataggio della lista di oggetti dopo aver effettuato il parsing
	 * @param file nome del file cache da creare
	 */
	public void SerialSaving(String file) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			out.writeObject(utilities.getList());
			out.close();
		} catch(IOException e) {
			System.out.println("Errore di I/O");
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo che esegue il caricamento della lista di oggetti su quali è stato 
	 * effettuato precedentemente il parsing
	 * @param file nome del file da leggere
	 */
	
	public void SerialUpload(String file) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			Vector<Erasmus> lista = null;
			lista = (Vector<Erasmus>) in.readObject();
			in.close();
		} catch(ClassNotFoundException e) {
			System.out.println("Manca ogetto nel file");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("Errore di I/O");
			e.printStackTrace();
		}
	}

}
