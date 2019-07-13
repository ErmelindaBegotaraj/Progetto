package com.lindatato.Progetto.Service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.lindatato.Progetto.Utilities.*;
//import com.sun.java.util.jar.pack.Package.Class.Field;
import com.lindatato.Progetto.Model.*;

@org.springframework.stereotype.Service
public class ErasmusService {
	
	private DownloadAndParsing utilities;
	private Metadata service;
	
	public ErasmusService() {
		
		String serialFile= "dataset1.ser";
		
		if(Files.exists(Paths.get(serialFile))) {
			SerialUpload(serialFile);
		} 
		else {
			DownloadAndParsing download = new DownloadAndParsing();
			SerialSaving(serialFile);
		}
	}
	
	public List<Map> getMetadata() {
		return service.getMetadata();
	}
	
	public List getData() {
 		return utilities.getData();
	}
	
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
