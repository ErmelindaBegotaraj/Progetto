package com.lindatato.Progetto.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Classe che gestisce le richieste di filtri 
 *
 */

public class Filter {
	private static final List<String> operatori = Arrays.asList("&gt","$gte","&lt","&lte","&eq","&not","&in","&nin");
	
	/**
	 * Metodo che controlla se l'oggetto passato è un numero, una stringa o una lista e confronta tramite gli operatori logici e condizionali val e rif
	 * @param val valore da controllare del dataset
	 * @param op operatore preso in considerazione
	 * @param rif valore di riferimento passato durante la richiesta
	 * @return valore booleano
	 */
	public static boolean check(Object val, String op, Object rif) {
		
		// casting variabili
		Double rifN = ((Number)rif).doubleValue();
		Double valN = ((Number)val).doubleValue();
		String rifS = ((String)rif);
		String valS = ((String)val);
		List rifL = (List)rif;
		
		if(rif instanceof Number && val instanceof Number) {
			
			if(op.equals("&eq"))
					return valN == rifN;
				else if(op.equals("&not"))
							return valN != rifN;
						else if (op.equals("&gt"))
									return valN > rifN;
								else if (op.equals("&gte"))
											return valN >= rifN;
										else if (op.equals("&lt"))
													return valN < rifN;
												else if (op.equals("&lte"))
															return valN <= rifN;
														else {
															System.err.println("Operatore non valido.");
															return false;
														}	
		}
		
		else if(rif instanceof String && val instanceof String) {
			
			if(op.equals("&eq"))
					return val.equals(rif);
				else if(op.equals("&not"))
							return valS != rifS;
						else {
							System.err.println("Operatore non valido.");
							return false;
						}
		}
		
		else if(rif instanceof List && val instanceof String) {
			
			if(!rifL.isEmpty() && rifL.get(0) instanceof String) {
				List<String> stringList = new ArrayList<>();  // crea una nuova lista di stringhe
				for(Object str : rifL) {
					stringList.add((String)str);  // scorre un ciclo for per effettuare il casting su ogni elemento della lista
				}
				if(op.equals("&in"))
						return rifL.contains(rifS);
					else if(op.equals("&nin"))
								return rifL.contains(rifS);
							else {
								System.err.println("Operatore non valido.");
								return false;
							}
			}
			else {
				System.err.println("La lista potrebbe essere vuota o contenere elementi non validi.");
				return false;
			}
		}
		
		else if(rif instanceof List && val instanceof Number) {
			
			if(!rifL.isEmpty() && rifL.get(0) instanceof Number) {
				List<Number> numberList = new ArrayList<>();  // crea una nuova lista di numeri
				for(Object num : rifL) {
					numberList.add((Number)num);  // scorre un ciclo for per effettuare il casting su ogni elemento della lista
				}
				if(op.equals("&in"))
						return rifL.contains(rifN);
					else if(op.equals("&nin"))
							return !rifL.contains(rifN);
							else {
								System.err.println("Operatore non valido.");
								return false;
							}
			}
		}
		else return false;
	}
}
