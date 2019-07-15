package com.lindatato.Progetto.Service;

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
	 * Metodo che controlla sd l'oggetto passato è un numero o una stringa e applica i filtri
	 * @param val valore da controllare del dataset
	 * @param op operatore preso in considerazione
	 * @param rif valore di riferimento passato durante la richiesta
	 * @return valore booleano
	 */
	public static boolean check(Object val, String op, Object rif) {
		Double rifC = ((Number)rif).doubleValue();
		Double valC = ((Number)val).doubleValue();
		String rifS = ((String)rif);
		String valS = ((String)val);
		
		if(rif instanceof Number && val instanceof Number) {
			
			if(op.equals("&eq"))
				return val.equals(rif);
			else if (op.equals("&gt"))
				return valC > rifC;
				else if (op.equals("&gte"))
					return valC >= rifC;
					else if (op.equals("&lt"))
						return valC < rifC;
						else if (op.equals("&lte"))
							return valC <= rifC;
								else 
									System.err.println("Operatore non valido");	
		}
		else if(rif instanceof String && val instanceof String) {
			
			if(op.equals("&eq"))
				return val.equals(rif);
					else if(op.equals("&not"))
						return valS != rifS;
							else
								System.err.println("Operatore non valido");
		}
		
		else if(rif instanceof List && val instanceof Number) {
			
			if(List) {
				if(op.equals("&in"))
					return rif.
			}
			else if(val instanceof String) {
				if (op.equals("&in"))
					return rifS.contains(valS);
				else if(op.equals("&nin"))
					return !rifS.contains(valS);
			}
		}
	}

}
