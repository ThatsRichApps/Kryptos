package com.thatsrichapps.kryptos;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class KeyedVigenere {
	
	private char[] alphabetKey;
	private Map<Character, Map<Character, Character>> encoder;
	private Map<Character, Map<Character, Character>> decoder;
	private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private char[] keyedAlphabet;
	
	public KeyedVigenere(char[] alphabetKey) {
		super();
		
		this.alphabetKey = alphabetKey;
		
		// create an alphabet so that alphabetKey is at the beginning
		//System.out.println ("chars in a = " + ALPHABET.length);

		keyedAlphabet = new char[26];
		int index = 0;
		for (char letter : alphabetKey) {
			keyedAlphabet[index] = letter;
			index++;
		}
		
		// add the rest of the alphabet in order
		for (char letter : ALPHABET) {
			//System.out.println(letter);
			if (!contains(letter, alphabetKey)) {
				keyedAlphabet[index] = letter;
				index++;
			}
		}
		
		System.out.println("ka = " + new String(keyedAlphabet));
		
		encoder = new TreeMap <Character, Map<Character, Character>>();
		decoder = new TreeMap <Character, Map<Character, Character>>();
		
		char[] line = keyedAlphabet.clone();
		
		for (char keyLetter : keyedAlphabet) {
			
			Map<Character, Character> encode = new HashMap<Character, Character>();
			Map<Character, Character> decode = new HashMap<Character, Character>();
			
			int i = 0;
			for (char plaintext : keyedAlphabet) {
				char ciphertext = line[i];
				//System.out.println("key : pt : ct = " + keyLetter + " : "  + plaintext + " : " + ciphertext);
				encode.put(plaintext,ciphertext);
				decode.put(ciphertext,plaintext);
				i++;
			}
			encoder.put(keyLetter, encode);
			decoder.put(keyLetter, decode);
			shift(line);
		}
		
		// how do we know it worked?
		//char ciphertext = encoder.get('L').get('E');
		//System.out.println("With L key, E is coded as : " + ciphertext);
			
	}

	public char[] getAlphabetKey() {
		return alphabetKey;
	}

	public static boolean contains(char c, char[] array) {
	    for (char x : array) {
	        if (x == c) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static void shift(char[] cs){
		  for(int i = 0; i < cs.length - 1; i++){
		    swap(cs,i,i+1);
		  }
	}
	
	 // Swapping with no extra storage.
	public static void swap(char[] s, int pos1, int pos2){
	  s[pos1] = (char) (s[pos1] ^ s[pos2]);
	  s[pos2] = (char) (s[pos1] ^ s[pos2]);
	  s[pos1] = (char) (s[pos1] ^ s[pos2]);
	}
	
	
	public char[] decode(char[] keyword, char[] ciphertext) {
	
		char[] plaintext = new char[ciphertext.length]; 
		int index = 0;
		for (char cipherletter : ciphertext) {
			int keyposition = index % keyword.length;
			//System.out.println("decoding " + cipherletter + " with alphabet " + keyword[keyposition]);
			plaintext[index] = decoder.get(keyword[keyposition]).get(cipherletter);
			index++;
		}
		
		return plaintext;
	}

	public char[] encode(char[] keyword, char[] plaintext) {
		
		char[] ciphertext = new char[plaintext.length]; 
		int index = 0;
		for (char letter : plaintext) {
			int keyposition = index % keyword.length;
			ciphertext[index] = encoder.get(keyword[keyposition]).get(letter);
			index++;
		}
		
		return ciphertext;
	}

	
	
	
}
