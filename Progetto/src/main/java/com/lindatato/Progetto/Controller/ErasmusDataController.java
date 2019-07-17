package com.lindatato.Progetto.Controller;

import com.lindatato.Progetto.Model.Erasmus;
import com.lindatato.Progetto.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controller Spring che gestisce le richieste dell'utente (client)
 */
@RestController
public class ErasmusDataController {

    //creo una variabile della classe Service
	@Autowired
    private ErasmusService service;

    /**
     * Costruttore che con l'annotazione @Autowired viene lanciato automaticamente all'avvio da Spring e esegue il collegamento al Service
     *
     * @param service riferimento all'istanza del service inizializzata da Spring
     */
    //@Autowired //stiamo dichiarando che il controllore dipende da service, ovvero stiamo iniettando una dipendenza
    public ErasmusDataController(ErasmusService service) {
        this.service = service;
    }

    //metodi per la comunicazione con il client che gestiscono le richieste GET e POST

    /**
     * Metodo che gestisce la richiesta GET alla rotta "/data", restituisce l'intero dataset
     *
     * @return lista di tutti gli oggetti del dataset
     */
    //la rotta � la parte dell'url dopo dominio:porta es.: localhost:8080/data
    @GetMapping("/data")
    public List getAllData() {
        return service.getData();
    }

    /**
     * Metodo che gestisce la richiesta GET alla rotta "/metadata", restituisce i metadata
     *
     * @return lista dei metadata
     */
    @GetMapping("/metadata")
    public List<Map> getMetadata() {
        return service.getMetadata();
    }
    
    /**
     * Metodo che gestisce la richiesta GET alla rotta "/stats" e che restituisce le statistiche
     * 
     * @param fieldName nome del campo del quale si vogliono calcolare le statistiche
     * @return lista delle statistiche
     */

    @GetMapping("/stats")
    public List getStats(@RequestParam(value = "field", defaultValue = "") String fieldName) {
    	Field[] fields = Erasmus.class.getDeclaredFields();
    	List<Map> list = new ArrayList<>();
    	if(fieldName.equals("")) {
    		for(int i=0; i < fields.length; i++) {
    			list.add(service.getStats(fields[i].getName()));		
    		}
    		return list;
    	}
    	else {
    		list.add(service.getStats(fieldName));
    		return list;
    	}
	}
    
}