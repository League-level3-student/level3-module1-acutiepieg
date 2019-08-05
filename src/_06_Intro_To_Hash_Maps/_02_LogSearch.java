package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 **/
	
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	JButton add;
	JButton search;
	JButton view;
	ArrayList<Integer> listOfID;
	
	public _02_LogSearch() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.add(panel);
		add = new JButton("Add Entry");
		search = new JButton("Search by ID");
		view = new JButton("View List");
		
		
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		
		panel.add(add);
		panel.add(search);
		panel.add(view);
		frame.pack();
	}
	
	public static void main(String[] args) {
		_02_LogSearch l = new _02_LogSearch();
	}
	
	public void addEntry() {
		String num = JOptionPane.showInputDialog("Enter your ID");
		String name = JOptionPane.showInputDialog("Enter your name");
		int id = Integer.parseInt(num);
		map.put(id, name);
		listOfID = (ArrayList<Integer>) map.keySet();
	}
	
	public void searchByID() {
		String num = JOptionPane.showInputDialog("Enter your ID");
		int id = Integer.parseInt(num);
		if(map.get(id) == (null)) {
			JOptionPane.showMessageDialog(null, "Your entry does not exist");
		}
		else{
			JOptionPane.showMessageDialog(null, "Name: " + map.get(id));
		}
	}
	
	public void viewList() {
		String list = null;
		for(int i = 0; i < map.size(); i ++) {
			list = list + "/n" + "ID: " + listOfID.get(i) + "  Name: " + map.get(listOfID.get(i)) ;
		}
		JOptionPane.showMessageDialog(null, list);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add ) {
			addEntry();
		}
		
		else if(e.getSource() == search) {
			searchByID();
		}
		
		else if(e.getSource()== view) {
			viewList();
		}
	}
	
	
}
