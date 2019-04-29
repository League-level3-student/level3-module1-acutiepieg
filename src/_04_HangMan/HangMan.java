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
		for(int i = 0; i < numWords; i ++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
	}
	
	public void addWord() {
		hangManWord = words.pop();
		for(int i = 0; i < hangManWord.length(); i ++) {
			label.setText(label.getText() + " _");
		}
		label.setText(label.getText() + " Lives: ");
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(hangManWord.contains(e.getKeyChar()) == true) {
			
		}
		
		
		if(hangManWord.contains("_") == false) {
			addWord();
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
