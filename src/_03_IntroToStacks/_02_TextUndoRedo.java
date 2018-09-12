package _03_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */

	JFrame window;
	JPanel panel;
	JLabel label;
	public final static int width = 650;
	public final static int height = 900;
	Stack<Character> deleted;
	String labelText;

	public static void main(String[] args) {
		new _02_TextUndoRedo().setup();
	}

	public void setup() {
		window = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		label.setText("yes");
		labelText = label.getText();
		deleted = new Stack<Character>();
		window.setVisible(true);
		window.getContentPane().setPreferredSize(new Dimension(width, height));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.add(panel);
		window.addKeyListener(this);
		panel.add(label);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		/*char c = e.getKeyChar();
		String s = label.getText() + c;
		label.setText(s);
		System.out.println(deleted.size());
		System.out.println(s);*/
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			/*String s = label.getText();
			System.out.println("label text is " + s + " length is " + s.length());
			deleted.push(s.charAt(s.length() - 1));
			System.out.println(s.charAt(s.length() - 1));
			String newString = s.substring(0, s.length() - 1);
			System.out.println("new label text is " + newString + " length is " + newString.length());
			label.setText(newString);*/
			deleted.push(labelText.charAt(labelText.length() - 1));
			labelText = labelText.substring(0,labelText.length() - 1); 		
			label.setText(labelText);		
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!deleted.empty()) {
				char c = deleted.pop();
				labelText += c;
				label.setText(labelText);
			}
		}  else { 
			char c = e.getKeyChar();
			labelText += c;
			label.setText(labelText);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
