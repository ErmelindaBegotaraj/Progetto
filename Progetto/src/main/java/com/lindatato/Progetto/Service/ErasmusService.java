package com.lindatato.Progetto.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import org.springframework.stereotype.Service;

import com.lindatato.Progetto.Utilities.*;
import com.lindatato.Progetto.Model.*;


/**
 * 
 * Classe che gestisce le operazioni di download e carica del dataset e che mette in comunicazione tutte le le classi con il controlle
 * attraverso metodi opportunamente costruiti
 *
 */

@Service
public class ErasmusService {
	
	private String url = "http://data.europa.eu/euodp/data/api/3/action/package_show?id=erasmus-mobility-statistics-2011-12";
	private DownloadAndParsing utilities;
	private Metadata serviceMeta;
	private Stats serviceStats;
	private Filter serviceFilter;
	private List<Erasmus> lista;
	
	/**
	 * Costruttore che effettua al primo avvio dell'applicazione il download e il parsing dei dati che restituiscono i valori del file csv
	 * 
	 */
	public ErasmusService() {
		
		this.utilities = new DownloadAndParsing();
		this.serviceMeta = new Metadata();
		this.serviceStats = new Stats();
		this.serviceFilter = new Filter();
		
		String link="";
		
		link = utilities.download(url);
		lista = utilities.parsing(link);
	}
	
	/**
	 * Metodo che restituisce i metadati del file CSV
	 * @return la lista contenente i metadati
	 */
	public List<Map> getMetadata() {
		return serviceMeta.getMetadata();
	}
	
	/**
	 * Metodo che restituisce i dati del file csv
	 * @return lista dei dati csv
	 */
	public List<Erasmus> getData() {
 		return this.lista;
	}
	
	/**
	 * Metodo che restituisce le statistiche di un dato attributo
	 * @param nomeCampo contiene il valore dell'attributo del quale si vogliono calcolare le statistiche
	 * @return map delle statistiche desiderate
	 */
	public Map<String, Object> getStats(String nomeCampo) {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> mapError = new HashMap<>();
		mapError.put("Errore", "Campo inesistente");
		Field[] fields = Erasmus.class.getDeclaredFields();
		for (Field f : fields) {
			if(nomeCampo.equals(f.getName()))
				map = serviceStats.getStats(nomeCampo, fieldValues(nomeCampo, getData()));
		}
		if(map.isEmpty()) return mapError;
		else return map;
	}
	
	/**
	 * Metodo che restituisce le statistiche di un dato campo di una lista passatagli come parametro (si utilizza per filtrare le statistiche)
	 * @param nomeCampo contiene il valore del campo del quale si vogliono calcolare le statistiche
	 * @param lista contiene la lista dalla quale estrarre poi le statistiche di quel campo
	 * @return map delle statistiche desiderate (quelle filtrate)
	 */
	public Map<String, Object> getStats(String nomeCampo, List lista) {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> mapError = new HashMap<>();
		mapError.put("Errore", "Campo inesistente");
		Field[] fields = Erasmus.class.getDeclaredFields();
		for (Field f : fields) {
			if(nomeCampo.equals(f.getName()))
				map = serviceStats.getStats(nomeCampo, fieldValues(nomeCampo, lista));
		}
		if(map.isEmpty()) return mapError;
		else return map;
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
				// scorre il vettore di campi e controlla se il nome del campo corrispondente è uguale a quello passatogli come parametro 
				for(int i=0; i < fields.length; i++) {
					if(fieldName.equals(fields[i].getName())) {
						Method m = e.getClass().getMethod("get"+fields[i].getName());
						Object val = m.invoke(e);
						values.add(val); // se il controllo restituisce vero, aggiunge alla lista il valore dell'ogetto della lista passatagli come parametro ottenuto con il metodo getMethod
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
	 * @param rif valore di riferimento
	 * @return lista filtrata
	 */
	public List<Erasmus> getFilterData(String fieldName, String op, Object rif) {
		return this.serviceFilter.select(getData(), fieldName, op, rif);
	}
}
