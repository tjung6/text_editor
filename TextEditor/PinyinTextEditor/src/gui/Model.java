package gui;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Model {
	private HashMap<Integer, String> accents;
	private HashMap<String, Character> vowels; 
	
	public Model() {
		accents = new HashMap<Integer, String>(); 
		setupTones();
		setupVowels(); 
	}
	
	// When typing Pinyin, user will want a specific vowel to have
	// a specific tone 
	// 1 	First Tone
	// 2	Second Tone
	// 3 	Third Tone 
	// 4	Fourth Tone 
	// "u" is an exception where there is a fifth tone used under
	// special circumstances 
	public void setupTones() {
		accents.put('a' + '1', "\u0101"); 
		accents.put('a' + '2', "\u00E1"); 
		accents.put('a' + '3', "\u01CE"); 
		accents.put('a' + '4', "\u00E0"); 
		
		accents.put('e' + '1', "\u0113"); 
		accents.put('e' + '2', "\u00E9"); 
		accents.put('e' + '3', "\u011B"); 
		accents.put('e' + '4', "\u00E8");
		
		accents.put('i' + '1', "\u012B"); 
		accents.put('i' + '2', "\u00ED"); 
		accents.put('i' + '3', "\u01D0"); 
		accents.put('i' + '4', "\u00EC");
			
		accents.put('o' + '1', "\u014D"); 
		accents.put('o' + '2', "\u00F3"); 
		accents.put('o' + '3', "\u01D2"); 
		accents.put('o' + '4', "\u00F2");
			
		accents.put('u' + '1', "\u016B"); 
		accents.put('u' + '2', "\u00FA"); 
		accents.put('u' + '3', "\u01D4"); 
		accents.put('u' + '4', "\u00F9");
		accents.put('u' + '5', "\u01DA");
	}
		
	public void setupVowels() {
		vowels = new HashMap<String, Character>();
		vowels.put("\u0101", 'a'); 
		vowels.put("\u00E1", 'a'); 
		vowels.put("\u01CE", 'a'); 
		vowels.put("\u00E0", 'a'); 
		
		vowels.put("\u0113", 'e'); 
		vowels.put("\u00E9", 'e'); 
		vowels.put("\u011B", 'e'); 
		vowels.put("\u00E8", 'e');
			
		vowels.put("\u012B", 'i'); 
		vowels.put("\u00ED", 'i'); 
		vowels.put("\u01D0", 'i'); 
		vowels.put("\u00EC", 'i');
		
		vowels.put("\u014D", 'o'); 
		vowels.put("\u00F3", 'o'); 
		vowels.put("\u01D2", 'o'); 
		vowels.put("\u00F2", 'o');
		
		vowels.put("\u016B", 'u'); 
		vowels.put("\u00FA", 'u'); 
		vowels.put("\u01D4", 'u'); 
		vowels.put("\u00F9", 'u');
		vowels.put("\u01DA", 'u');
	}

	public Map<String, Character> getVowels() {
		return Collections.unmodifiableMap(vowels); 
	}

	public Map<Integer, String> getAccents() {
		return Collections.unmodifiableMap(accents); 
	}
}	
