package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UkrTranslate {
	private Map<String, String> UkrMap = new HashMap<>();
	private ArrayList<String> list = new ArrayList<>();

	public UkrTranslate() {
		super();
	}

	public void createDictionary(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				String[] date = text.split("[-]");
				String key = date[0];
				String value = date[1];
				UkrMap.put(key, value);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadFromFile(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				String[] date = text.split("[., ]");
				for (int i = 0; i < date.length; i++) {
					list.add(date[i]);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String translate() {
		StringBuilder sb = new StringBuilder();
		Iterator<String> ir = list.iterator();
		String value = null;
		for (; ir.hasNext();) {
			String key = ir.next();
			if (UkrMap.containsKey(key)) {
				value = UkrMap.get(key);
				if (value != null) {
					sb.append(value + " ");
				} else {
					sb.append(key + " ");
				}
			}
		}

		return sb.toString();
	}

	public void saveToFile(File file) {
		try (BufferedWriter f = new BufferedWriter(new FileWriter(file))) {
			f.write(this.translate());
			System.out.println();
		} catch (IOException e) {
			System.out.println();
		}
	}
}
