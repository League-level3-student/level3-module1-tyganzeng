package _04_HangMan;

import java.awt.Dimension;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan {
	JFrame window;
	JPanel panel;
	JLabel label;
	JLabel livesLabel;
	String word;
	String hidden;
	int lives;
	boolean gameOver;
	public final static int width = 650;
	public final static int height = 900;
	Stack<String> words;

	public static void main(String[] args) {
		new HangMan().setup();

	}

	public void setup() {
		window = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		livesLabel = new JLabel();
		words = new Stack<String>();
		window.setVisible(true);
		window.getContentPane().setPreferredSize(new Dimension(width, height));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.add(panel);
		panel.add(label);
		panel.add(livesLabel);
		hidden = "";
		lives = 5;
		livesLabel.setText("Lives: " + lives);
		gameOver = false;
		int num = Integer.parseInt(JOptionPane.showInputDialog("Enter a number between 1 and # of words"));
		for (int i = 0; i < num; i++) {
			String str = Utilities.readRandomLineFromFile("./src/_04_HangMan/dictionary.txt");
			while (words.contains(str)) {
				str = Utilities.readRandomLineFromFile("./src/_04_HangMan/dictionary.txt");
			}
			words.push(str);
		}
		for (int j = 0; j < num; j++) {
			word = words.pop();
			System.out.println(word);
			for (int i = 0; i < word.length(); i++) {
				hidden += "-";
			}
			label.setText(hidden);
			while (!hidden.equals(word) && !gameOver) {
				char c = JOptionPane.showInputDialog("Guess a character").charAt(0);
				boolean found = false;
				for (int i = 0; i < word.length(); i++) {
					if (c == word.charAt(i)) {
						found = true;
						hidden = hidden.substring(0, i) + c + hidden.substring(i + 1, hidden.length());
					}
				}
				if (!found) {
					lives--;
					livesLabel.setText("Lives: " + lives);
					if (lives == 0) {
						System.out.println("Game Over, word was " + word);
						gameOver = true;
						String yes = JOptionPane.showInputDialog("Would you like to continue? Type yes to continue");
						if (yes.equals("yes")) {
							gameOver = false;
							lives = 5;
							hidden = word;
						}
					}
				}
				label.setText(hidden);
			}
			if (hidden.equals(word)) {
				System.out.println("Correct!");
				hidden = "";
			} else {
				// JOptionPane.showOptionDialog(parentComponent, message, title, optionType,
				// messageType, icon, options, initialValue)
			}
		}
		System.out.println("Congratulations! You win!");

	}

}
