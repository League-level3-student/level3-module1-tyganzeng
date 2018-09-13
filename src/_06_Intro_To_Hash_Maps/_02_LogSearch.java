package _06_Intro_To_Hash_Maps;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	HashMap<Integer, String> myLog = new HashMap<Integer, String>();
	JFrame window;
	JPanel panel;
	JButton button;
	JButton button2;
	JButton button3;
	JButton button4;
	public final static int width = 650;
	public final static int height = 900;

	public static void main(String[] args) {
		_02_LogSearch log = new _02_LogSearch();
		log.setup();
	}

	public void setup() {
		window = new JFrame();
		panel = new JPanel();
		button = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		window.setVisible(true);
		window.getContentPane().setPreferredSize(new Dimension(width, height));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.add(panel);
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		button.setText("Add Entry");
		button.addActionListener(this);
		button2.setText("Search by ID");
		button2.addActionListener(this);
		button3.setText("View List");
		button3.addActionListener(this);
		button4.setText("Delete user");
		button4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonClicked = (JButton) e.getSource();
		if (buttonClicked == button) {
			int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID"));
			String name = JOptionPane.showInputDialog("Enter a name");
			myLog.put(ID, name);
		} else if (buttonClicked == button2) {
			int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID"));
			for (Integer i : myLog.keySet()) {
				if (i == ID) {
					JOptionPane.showMessageDialog(null, "The name at this ID is " + myLog.get(i));
				} else {
					JOptionPane.showMessageDialog(null, "User does not exist");
				}
			}
		} else if (buttonClicked == button3) {
			String list = "";
			for (Integer i : myLog.keySet()) {
				list += "ID: " + i + "  Name: " + myLog.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		} else if (buttonClicked == button4) {
			int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID"));
			for (Integer i : myLog.keySet()) {
				if (i == ID) {
					myLog.remove(i);
					JOptionPane.showMessageDialog(null, "User removed");
				} else {
					JOptionPane.showMessageDialog(null, "User does not exist");
				}
			}
		}
	}
}
