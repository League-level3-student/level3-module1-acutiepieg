package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel label = new JLabel();

	Stack<Character> deletedChars = new Stack<Character>();
	String wordTyped = "";

	public static void main(String[] args) {
		_02_TextUndoRedo x = new _02_TextUndoRedo();
	}

	/*
	 * Create a JFrame with a JPanel and a JLabel. Every time a key is pressed, add
	 * that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	public _02_TextUndoRedo() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		getClass();
		label.setText(" ");
		frame.pack();
	}

	public void addChar() {
		label.setText(wordTyped);
		frame.pack();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
			if(wordTyped.length() != 0) {
			deletedChars.push(wordTyped.charAt(wordTyped.length() - 1));
			System.out.println(deletedChars);
			wordTyped = wordTyped.substring(0, wordTyped.length() - 1);
			addChar();
			}
		} else if (e.getKeyChar() == '\\') {
			if(deletedChars.size() != 0) {
			Character x = deletedChars.pop();
			System.out.println(x);
			wordTyped = wordTyped + x;
			addChar();
			}
		} else {
			wordTyped = wordTyped + e.getKeyChar();
			addChar();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
