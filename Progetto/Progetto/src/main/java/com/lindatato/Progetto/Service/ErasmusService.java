package com.lindatato.Progetto.Service;

import java.util.List;
import java.util.Vector;

import com.lindatato.Progetto.Utilities.*;
//import com.sun.java.util.jar.pack.Package.Class.Field;
import com.lindatato.Progetto.Model.*;

@org.springframework.stereotype.Service
public class ErasmusService {
	
	private ParsingCSV utilities;
	
	public ErasmusService() {
		DownloadDataset download = new DownloadDataset();
		ParsingCSV pars = new ParsingCSV();
		
		Object[] fields = Erasmus.class.getDeclaredFields();
	}
	
	public List metadata() {
		return utilities.getMetadata();
	}
	
	public List data() {
 		return utilities.getData();
	}

}
