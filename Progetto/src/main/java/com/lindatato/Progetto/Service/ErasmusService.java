package com.lindatato.Progetto.Service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.springframework.stereotype.Service;

import com.lindatato.Progetto.Utilities.*;
//import com.sun.java.util.jar.pack.Package.Class.Field;
import com.lindatato.Progetto.Model.*;


/**
 * 
 * Classe che gestisce le operazioni di download e carica del dataset
 *
 */

@Service
public class ErasmusService {
	
	private DownloadAndParsing utilities;
	private Metadata serviceMeta;
	private Stats serviceStats;
	private Filter serviceFilter;
	private Vector<Erasmus> lista;
	
	/**
	 * Costruttore che carica il dataset facendo il parsing
	 * oppure, se il file è già stato creato, ricarica il parsing precedente
	 */
	public ErasmusService() {
		
		this.utilities = new DownloadAndParsing();
		this.serviceMeta = new Metadata();
		this.serviceStats = new Stats();
		this.serviceFilter = new Filter();
		
		String serialFile= "prova4.txt";
		String link="";
		
		if(Files.exists(Paths.get(serialFile))) {
			//SerialUpload(serialFile);
			link = utilities.download();
			lista = utilities.parsing(link);
		} 
		else {
			//DownloadAndParsing download = new DownloadAndParsing();
			link = utilities.download();
			lista = utilities.parsing(link);
			//SerialSaving(serialFile);
		}
	}
	/**
	 * Metodo che restituisce i metadati del file CSV
	 * @return la lista contenente i metadati
	 */
	public List<Map> getMetadata() {
		return serviceMeta.getMetadata();
	}
	
	public Vector<Erasmus> getData() {
 		return this.lista;
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
						//	values.add(e.getClass().getMethod(fields[i].getName()));
						Method m = e.getClass().getMethod(fields[i].getName());
						values.add(m.invoke(e));
					}
				}
			}
		} catch(NoSuchMethodException ex) {
			ex.printStackTrace();
		} catch(SecurityException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		return values;
	}
	
	/**
	 * Metodo che filtra i dati del csv
	 * 
	 * @param fieldName contiene il nome del campo richiesto
	 * @param op contiene l'operatore che si vuole utilizzare
	 * @param val valore di riferimento
	 * @return lista filtrata
	 */
	public Collection getFilterData(String fieldName, String op, Object val) {
		return serviceFilter.select(getData(), fieldName, op, val);
	}
	
	public Map<String, Object> getFilterStats(String fieldName, String op, Object val) {
		return (Map<String, Object>) serviceFilter.select((Collection) getStats(fieldName), fieldName, op, val);
	}
	
	/**
	 * Metodo che esegue il salvataggio della lista di oggetti dopo aver effettuato il parsing
	 * @param file nome del file cache da creare
	 */
	public void SerialSaving(String file) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			out.writeObject(this.utilities.getData());
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
		//Vector<Erasmus> lista = utilities.getData();
		/*try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			lista = (Vector<Erasmus>) in.readObject();
			in.close();
		} catch(ClassNotFoundException e) {
			System.out.println("Manca oggetto nel file");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("Errore di I/O");
			e.printStackTrace();
		}*/

	}
}
