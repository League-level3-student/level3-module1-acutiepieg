package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HangMan {
	String numWords1;
	int numWords;

	Stack<String> words = new Stack<String>();
	JLabel label;

	public HangMan() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		label = new JLabel();
		frame.add(label);
	}

	public void startGame() {
		numWords1 = JOptionPane.showInputDialog("How many words would you like to play?");
		numWords = Integer.parseInt(numWords1);
		for(int i = 0; i < numWords; i ++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
	HangMan h = new HangMan();
	}
	

}
