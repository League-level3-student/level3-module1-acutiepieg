package _01_IntroToArrayLists;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class _02_GuestBook implements ActionListener {
	JButton addName;
	JButton viewName;
	JTextArea text;
	JFrame frame;

	ArrayList<String> names = new ArrayList<String>();
	String addedName;

	public _02_GuestBook() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.add(panel);
		addName = new JButton("Add Name");
		viewName = new JButton("View Names");
		panel.add(addName);
		panel.add(viewName);
		text = new JTextArea();
		panel.add(text);
		frame.pack();

		addName.addActionListener(this);
		viewName.addActionListener(this);
	}

	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".

	public static void main(String[] args) {
		_02_GuestBook object = new _02_GuestBook();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addName) {
			addedName = JOptionPane.showInputDialog("Add a name");
			names.add(addedName);
			text.setText("Added Guest: " + addedName);
			frame.pack();
		}

		else {
			String nameString = "";
			for (int i = 0; i < names.size(); i++) {
				String n = names.get(i);
				nameString = nameString  + "Guest #" + (i + 1) + ": " + n;
				if(i < names.size() - 1) {
					nameString = nameString + "\n";
				}
			}
			text.setText(nameString);
			frame.pack();
		}
	}

	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners

}
