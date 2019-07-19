package com.lindatato.Progetto.Service;

import com.lindatato.Progetto.Model.Erasmus;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe utile per la gestione dei matadati quando vengono richiesti
 */

public class Metadata {
	
	
	private List<Map> metadata = new ArrayList<>();
	
	public Metadata() {
		
		Field[] fields = Erasmus.class.getDeclaredFields();//estrae gli attributi della classe Erasmus

        for (Field f : fields) {
            Map<String, String> map = new HashMap<>();
            //andiamo ad inserire le coppie chiave/valore
            map.put("alias", f.getName());
            map.put("sourceField", f.getName().toUpperCase());//nome del campo in csv
            map.put("type", f.getType().getSimpleName());
            metadata.add(map);
        	}

        }
        
	/**
	 * Metodo che ritorna la lista di mappe contenente i metadati
	 * 
	 * @return lista dei metadati
	 */
	
	public List<Map> getMetadata() {
		return metadata;
		}

	}
