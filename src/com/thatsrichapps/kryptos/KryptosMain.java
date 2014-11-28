package com.thatsrichapps.kryptos;

public class KryptosMain {
	
	// define some constants
	
	public static final char[] K1 = "EMUFPHZLRFAXYUSDJKZLDKRNSHGNFIVJYQTQUXQBQVYUVLLTREVJYQTMKYRDMFD".toCharArray();
	public static final char[] K2 = ("VFPJUDEEHZWETZYVGWHKKQETGFQJNCEGGWHKKDQMCPFQZDQMMIAGPFXHQRLGTIM"
			+ "VMZJANQLVKQEDAGDVFRPJUNGEUNAQZGZLECGYUXUEE"
			+ "NJTBJLBQCRTBJDFHRRYIZETKZEMVDUFKSJHKFWHKUW"
			+ "QLSZFTIHHDDDUVHDWKBFUFPWNTDFIYCUQZEREEVLDK"
			+ "FEZMOQQJLTTUGSYQPFEUNLAVIDXFLGGTEZFKZBSFDQ"
			+ "VGOGIPUFXHHDRKFFHQNTGPUAECNUVPDJMQCLQUMUNE"
			+ "DFQELZZVRRGKFFVOEEXBDMVPNFQ").toCharArray();
	public static final char[] K3 = ("").toCharArray();
	public static final char[] K4 = ("OBKRUOXOGHULBSOLIFBBWFLRVQQPRNGKSSOTW"
			+ "TQSJQSSEKZZWATJKLUDIAWINFBNYP"
			+ "VTTMZFPKWGDKZXTJCDIGKUHUAUEKCAR").toCharArray();
	
	public static void main(String[] args) {
	
		char[] alphabetKey = ("KRYPTOS").toCharArray();
		
		KeyedVigenere keyedVigenere = new KeyedVigenere(alphabetKey);
		
		//char[] plaintextK1 = keyedVigenere.decode("PALIMPSEST".toCharArray(), K1);
		//System.out.println(plaintextK1);

		//char[] ciphertextK1 = keyedVigenere.encode("PALIMPSEST".toCharArray(), plaintextK1);
		//System.out.println(ciphertextK1);

		
		//char[] plaintextK2 = keyedVigenere.decode("ABSCISSA".toCharArray(), K2);
		//System.out.println(plaintextK2);
		System.out.println(K4);
		
		char[] shifter = K4.clone();
		
		char[] password = "CBAQK".toCharArray();
		for (int i = 0; i < K4.length; i++) {
			char[] plaintext = keyedVigenere.decode(password, shifter);
			KeyedVigenere.shift(shifter);
			System.out.println(plaintext);
			if (i > password.length) break;
		}
		
	}

}
