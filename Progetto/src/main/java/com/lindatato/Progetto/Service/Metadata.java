package com.lindatato.Progetto.Service;

import com.lindatato.Progetto.Model.Erasmus;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metadata {
	
	
	private List<Map> metadata = new ArrayList<>();
	
	public Metadata() {
		
		Field[] fields = Erasmus.class.getDeclaredFields();//estrae gli attributi della classe Erasmus

        for (Field f : fields) {
            Map<String, String> map = new HashMap<>();
            //andiamo ad inserire le coppie chiave/valore
            map.put("alias", f.getName());
            map.put("sourceField", f.getName().toUpperCase());//nome del campo in csv
            //touppercase serve per convertire il nome in maiuscolo
            map.put("type", f.getType().getSimpleName());
            metadata.add(map);
            
        	}

        }
        
	public List<Map> getMetadata() {
		return metadata;
		}

	}
