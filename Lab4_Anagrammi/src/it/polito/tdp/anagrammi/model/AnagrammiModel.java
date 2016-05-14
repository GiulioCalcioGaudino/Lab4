package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.RicercaDAO;

public class AnagrammiModel {
	List <String> paroleTutte;
	char[] letterei;
	RicercaDAO r = new RicercaDAO();
	
	public List <String> doAnagramma (String s){
		letterei = s.toCharArray();
		paroleTutte = new ArrayList<String>();
		ricorsione(0,letterei,new ArrayList <Character>());
		return paroleTutte;
	}
	
	private void ricorsione (int step,char[] lettere,List<Character> result){
		if(step==lettere.length){
			StringBuilder sb = new StringBuilder();
			for (Character c: result){
				sb.append(c);}
			if(!paroleTutte.contains(sb.toString()))
			{paroleTutte.add(sb.toString());}
			return;
		}
		else{
			for(int i = 0; i<lettere.length; i++){
				if (listCounter(result,lettere[i])< arrayCounter(lettere,lettere[i])) {
				result.add(Character.valueOf(lettere[i]));
				ricorsione(step+1,lettere,result);
				result.remove(Character.valueOf(lettere[i]));
				}
			}
		}
		
		
	}
	
public int listCounter(List<Character> parola, char c) {
		
		int listCounter = 0;
		
		for (Character a: parola)
			if (a.charValue() == c)
				listCounter++;
		
		return listCounter;
	}

public int arrayCounter(char[] characters, char c) {
	
	int arrayCounter = 0;
	
	for (char a: characters) {
		if (a == c)
			arrayCounter++;
	}
	return arrayCounter;
}
public List<Parola> cerca (List<String> parole){
	return r.cerca(parole);
}
}
