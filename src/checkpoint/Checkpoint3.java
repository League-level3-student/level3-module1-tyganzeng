package checkpoint;

import java.util.HashMap;

public class Checkpoint3 {
	public static void main(String[] args) {
		HashMap<String, String> h = new HashMap<String, String>();
		h.put("Hello", "Olleh");
		h.put("My", "Ym");
		h.put("Name", "Eman");
		h.put("Is", "Si");
		h.put("Tygan", "Nagyt");
		for (String s : h.keySet()) {
			System.out.println("Key: " + s + " Value: " + h.get(s));
		}

	}
}
