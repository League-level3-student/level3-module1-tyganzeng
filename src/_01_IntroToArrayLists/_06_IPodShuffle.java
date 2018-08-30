package _01_IntroToArrayLists;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener {
	JFrame window;
	Panel panel;
	JButton button;
	ArrayList<Song> songs;
	public final static int width = 650;
	public final static int height = 900;

	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		// Song s = new Song("demo.mp3");
		// s.play();
		window = new JFrame();
		panel = new Panel();
		button = new JButton();
		songs = new ArrayList<Song>();
		songs.add(new Song("demo.mp3"));

		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */

	}

	public static void main(String[] args) {
		new _06_IPodShuffle().setup();
	}

	public void setup() {
		window.setVisible(true);
		window.getContentPane().setPreferredSize(new Dimension(width, height));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.add(panel);
		panel.add(button);
		button.addActionListener(this);
		button.setText("Surprise Me!");

	}

	public void actionPerformed(ActionEvent e) {

		JButton buttonClicked = (JButton) e.getSource();
		if (buttonClicked == button) {
			for (Song s : songs) {
				s.stop();
			}
			songs.get(new Random().nextInt(songs.size())).play();

		}

	}
}