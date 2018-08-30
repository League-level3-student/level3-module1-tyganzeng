package _01_IntroToArrayLists;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame window = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JButton button2 = new JButton();
	ArrayList<String> names = new ArrayList<String>();
	public final static int width = 650;
	public final static int height = 900;

	public static void main(String[] args) {
		_02_GuestBook book = new _02_GuestBook();
		book.makeGuestBook();

	}

	public void makeGuestBook() {
		window.setVisible(true);
		window.getContentPane().setPreferredSize(new Dimension(width, height));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.add(panel);
		panel.add(button);
		panel.add(button2);
		button.setText("Add Name");
		button.addActionListener(this);
		button2.setText("View Names");
		button2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		JButton buttonClicked = (JButton) e.getSource();
		if (buttonClicked == button) {
			String s = JOptionPane.showInputDialog("Enter a name");
			names.add(s);
			System.out.println("button 1 clicked");
		} else {
			System.out.println("button 2 clicked");
			String list = "";
			for (int i = 0; i < names.size(); i++) {
				list += "Guest #" + i + 1 + ": " + names.get(i);
				list += "\n";

			}
			JOptionPane.showMessageDialog(null, list);
		}
		// 18. else tell them to try again
	}
}
