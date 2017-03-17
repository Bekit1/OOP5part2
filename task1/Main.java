package task1;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UkrTranslate ut = new UkrTranslate();
		File one = new File("dictionary.txt");
		File two = new File("English.in.txt");
		File three = new File("Ukrainian.out.txt");
		ut.createDictionary(one);
		ut.loadFromFile(two);
		System.out.println(ut.translate());
		ut.saveToFile(three);
	}

}
