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
	private List<Erasmus> lista;
	
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
		
		link = utilities.download();
		lista = utilities.parsing(link);
	}
	
	/**
	 * Metodo che restituisce i metadati del file CSV
	 * @return la lista contenente i metadati
	 */
	public List<Map> getMetadata() {
		return serviceMeta.getMetadata();
	}
	
	public List<Erasmus> getData() {
 		return this.lista;
	}
	
	public Map<String, Object> getStats(String nomeCampo) {
		return serviceStats.getStats(nomeCampo, fieldValues(nomeCampo, getData()));
	}
	
	public Map<String, Object> getStats(String nomeCampo, List lista) {
		return serviceStats.getStats(nomeCampo, fieldValues(nomeCampo, lista));
	}
	
	/**
	 * Metodo che estrae i valori di un determinato campo, passato tramite fieldName
	 * @param fieldName nome del campo del file CSV
	 * @param list lista che si ottiene dopo aver effettuato il parsing, vettore di oggetti "Erasmus"
	 * @return la lista che contiene i valori di un determinato campo
	 */
	public List fieldValues(String fieldName, List list) {
		List<Object> values = new ArrayList<>();
		try {
			Field[] fields = Erasmus.class.getDeclaredFields();
			for(Object e : list) {
				for(int i=0; i < fields.length; i++) {
					if(fieldName.equals(fields[i].getName())) { 
						//	values.add(e.getClass().getMethod(fields[i].getName()));
						Method m = e.getClass().getMethod("get"+fields[i].getName());
						Object val = m.invoke(e);
						values.add(val);
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
	public List<Erasmus> getFilterData(String fieldName, String op, Object rif) {
		return this.serviceFilter.select(getData(), fieldName, op, rif);
	}
	
	public Map<String, Object> getFilterStats(String fieldName, String op, Object val) {
		return (Map<String, Object>) this.serviceFilter.select((List) getStats(fieldName), fieldName, op, val);
	}
}
