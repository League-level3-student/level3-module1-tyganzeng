package checkpoint;

import java.util.ArrayList;
import java.util.Random;

public class Checkpoint1 {
	public static void main(String[] args) {
		ArrayList<Cow> cows = new ArrayList<Cow>();
		int num = new Random().nextInt(50);
		for (int i = 0; i < num; i++) {
			cows.add(new Cow());
		}
		for (Cow c : cows) {
			c.feed();
		}
	}
}

class Cow {
	public void feed() {
	}
}
