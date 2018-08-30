package _03_IntroToStacks;

import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		Stack<Double> doubles = new Stack<Double>();
		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int i = 0; i < 100; i++) {
			doubles.push(Math.random() * 100);
		}
		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		double d1 = Double.parseDouble(JOptionPane.showInputDialog("Enter a number between 0 and 100, inclusive"));
		double d2 = Double
				.parseDouble(JOptionPane.showInputDialog("Enter another number between 0 and 100, inclusive"));
		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.
		System.out.println("NUM 1:" + d1);
		System.out.println("NUM 2:" + d1);

		System.out.println("Popping elements off stack...");
		System.out.println("Elements between " + d1 + " and " + d2);
		for (int i = 0; i < doubles.size(); i++) {
			double d = doubles.pop();
			if (d > d1 && d < d2) {
				System.out.println(d);
			}
		}
		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}
}
