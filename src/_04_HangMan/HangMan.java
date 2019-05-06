package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HangMan implements KeyListener {
	String numWords1;
	int numWords;
	String hangManWord;
	String wordShown = " ";
	int lives = 10;

	Stack<String> words = new Stack<String>();
	JLabel label;
	JFrame frame;

	public static void main(String[] args) {
		HangMan h = new HangMan();
	}

	public HangMan() {
		startGame();
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		label = new JLabel();
		frame.add(label);
		label.setText("");
		frame.addKeyListener(this);
		addWord();
	}

	public void startGame() {
		numWords1 = JOptionPane.showInputDialog("How many words would you like to play?");
		numWords = Integer.parseInt(numWords1);
		for (int i = 0; i < numWords; i++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
	}

	public void addWord() {
		hangManWord = words.peek();
		System.out.println(hangManWord);
		wordShown = "";
		for (int i = 0; i < hangManWord.length(); i++) {
			wordShown = wordShown + "_";
		}
		label.setText(wordShown + " Lives: " + lives);
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char character = e.getKeyChar();
		for (int i = 0; i < hangManWord.length(); i++) {
			if (hangManWord.charAt(i) == character) {
				wordShown = wordShown.substring(0, i) + character + wordShown.substring(i + 1, wordShown.length());
				label.setText(wordShown + " Lives: " + lives);
			} else {
				lives = lives - 1;
			}
		}

		if (wordShown.contains("_") == false) {
			words.pop();
			if (words.size() == 0) {
				JOptionPane.showMessageDialog(null, "You have no more words left");
			}
			if (lives == 0) {
				JOptionPane.showMessageDialog(null, "You have no lives left");
			} else {
				label.setText("");
				lives = 10;
				addWord();
			}
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
