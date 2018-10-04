package checkpoint;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Checkpoint2 {
	public static void main(String[] args) {
		Stack<Integer> ints = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			int rand = new Random().nextInt(50);
			ints.add(rand);
		}
		int sum = 0;
		for (int i = 0; i < ints.size(); i++) {
			sum += ints.pop();
		}
		JOptionPane.showMessageDialog(null, "The sum is " + sum);
	}
}
