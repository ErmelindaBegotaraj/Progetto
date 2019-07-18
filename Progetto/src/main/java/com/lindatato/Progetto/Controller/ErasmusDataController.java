package com.lindatato.Progetto.Controller;

import com.lindatato.Progetto.Model.Erasmus;
import com.lindatato.Progetto.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Controller Spring che gestisce le richieste dell'utente (client)
 */
@RestController
public class ErasmusDataController {

    //creo una variabile della classe Service
	@Autowired  //il controllore dipende da service, stiamo dunque iniettando una dipendenza
    private ErasmusService service;

    /**
     * Costruttore che con l'annotazione @Autowired viene lanciato automaticamente all'avvio da Spring e esegue il collegamento al Service
     *
     * @param service riferimento all'istanza del service inizializzata da Spring
     */
    public ErasmusDataController(ErasmusService service) {
        this.service = service;
    }

    //metodi per la comunicazione con il client che gestiscono le richieste GET e POST

    /**
     * Metodo che gestisce la richiesta GET alla rotta "/data", restituisce l'intero dataset
     *
     * @return lista di tutti gli oggetti del dataset
     */
    //esempio: localhost:8080/data
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
    public List<Map> getStats(@RequestParam(value = "field", defaultValue = "") String fieldName) {
    	Field[] fields = Erasmus.class.getDeclaredFields();
    	List<Map> list = new ArrayList<>();
    	if(fieldName.equals("")) {  // se non viene specificato il campo calcola le statistiche di ogni attributo
    		for(int i=0; i < fields.length; i++) {
    			list.add(service.getStats(fields[i].getName()));		
    		}
    		return list;
    	}
    	else {  // altrimenti calcola le statistiche del solo campo specificato
    		list.add(service.getStats(fieldName));
    		return list;
    	}
	}
    
    /**
     * Metodo che gestisce la richiesta POST alla rotta "/filter" e che restituisce i dati filtrati 
     * 
     * @param req oggetto di tipo Filter al quale vengono passati i valori del body tramite una chiamata POST
     * @return lista dei dati opportunamente filtrati
     */
    @PostMapping("/data")
    public List getFilterData(@RequestBody Filter req) {
    	return service.getFilterData(req.getFieldName(), req.getOp(), req.getRif());
    }
    
    /**
     * Metodo che restituisce la richiesta POST alla rotta "/stats" e che restituisce le statistiche dei dati filtrati se non si specifica
     * il nome del campo, oppure, se lo si specifica, restituisce le statistiche dei dati filtrati solo del campo desiderato
     * 
     * @param fieldName nome del campo del quale si vogliono calcolare le statistiche
     * @param req oggetto di tipo Filter al quale vengono passati i valori del body tramite una chiamata POST
     * @return lista delle statistiche dei dati filtrati
     */
    @PostMapping("/stats")
    public List<Map> getFilterStats(@RequestParam(value = "field", defaultValue = "") String fieldName, @RequestBody Filter req) {
    	List<Map> listaStats = new ArrayList<>();
    	List listaFiltrata = service.getFilterData(req.getFieldName(), req.getOp(), req.getRif());
    	Field[] fields = Erasmus.class.getDeclaredFields();
    	// se non specifico il nome del campo, mi restituisce le statistiche di tutti gli attributi Erasmus dei dati filtrati secondo i parametri passati nel body
    	if(fieldName.equals("")) {
    		for(int i=0; i < fields.length; i++) {
    			listaStats.add(service.getStats(fields[i].getName(), listaFiltrata));		
    		}
    		return listaStats;
    	}
    	else {  // altrimenti restituisce solo quelli del parametro specificato
    		listaStats.add(service.getStats(fieldName, listaFiltrata));
    	}
		return listaStats;
    }
}