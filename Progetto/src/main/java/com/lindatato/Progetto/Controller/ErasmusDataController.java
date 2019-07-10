package com.lindatato.Progetto..Controller;


import com.lindatato.Progetto.Model.Erasmus;
import com.lindatato.Progetto.Utilities.DownloadDataset;
import com.lindatato.Progetto.Utilities.ParsingCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller Spring che gestisce le richieste dell'utente (client)
 */
@RestController
public class ErasmusDataController {

    //creo una variabile della classe Service
    private ErasmusService utilities;

    /**
     * Costruttore che con l'annotazione @Autowired viene lanciato automaticamente all'avvio da Spring e esegue il collegamento al Service
     *
     * @param service riferimento all'istanza del service inizializzata da Spring
     */
    @Autowired //stiamo dichiarando che il controllore dipende da service, ovvero stiamo iniettando una dipendenza
    public ErasmusDataController(ErasmusService utilities) {
        this.utilities = utilities;
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
        return utilities.getAllData();
    }

  
    /**
     * Metodo che gestisce la richiesta GET alla rotta "/metadata", restituisce i metadata
     *
     * @return lista dei metadata
     */
    @GetMapping("/metadata")
    public List getMetadata() {
        return utilities.getMetadata();
    }
    
    /** 
     * Metodo che gestisce la richiesta GET alla rotta "/HostIst" , restituisce i nomi dei paesi ospitanti
     * 
     * @return lista dei paesi ospitanti
     */
    @GetMapping("/HostIst")
    public List getHostIst() {
    	return utilities.getHostIst();
    }
    
    /** 
     * Metodo che gestisce la richiesta GET alla rotta "/HomeIst" , restituisce i nomi dei paesi d'origine
     * 
     * @return lista dei paesi d'origine
     */
    @GetMapping("/HostIst")
    public List getHostIst() {
    	return utilities.getHostIst();
    }


}