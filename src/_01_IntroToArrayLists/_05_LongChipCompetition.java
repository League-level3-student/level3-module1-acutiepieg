package _01_IntroToArrayLists;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class _05_LongChipCompetition {
	/**
	 * The Beatles are eating lunch and playing a game to see who has the longest
	 * chip. (In England, french fries are called "chips".) * Find the Beatle with
	 * the longest chip. You may not edit the Chip or Beatle classes. Make sure to
	 * initialize The Beatles before you start your search. *
	 **/
	private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();
	static _05_LongChipCompetition lcc;
	static Chip longestChipGeorge = new Chip(0.0);
	static Chip longestChipJohn = new Chip(0.0);
	static Chip longestChipPaul = new Chip(0.0);
	static Chip longestChipRingo = new Chip(0.0);

	public static void main(String[] args) {
		lcc = new _05_LongChipCompetition();
		lcc.initializeBeatles();
		checkForLongestChip();

	}

	public static void checkForLongestChip() {
		for (int i = 0; i < lcc.theBeatles.get(0).getChips().size(); i++) {
			if (lcc.theBeatles.get(0).getChips().get(i).getLength() > longestChipGeorge.getLength()) {
				longestChipGeorge = lcc.theBeatles.get(0).getChips().get(i);
			} 
		}
		for (int i = 0; i < lcc.theBeatles.get(1).getChips().size(); i++) {
			if (lcc.theBeatles.get(1).getChips().get(i).getLength() > longestChipJohn.getLength()) {
				longestChipJohn = lcc.theBeatles.get(1).getChips().get(i);
			} 
		}
		for (int i = 0; i < lcc.theBeatles.get(2).getChips().size(); i++) {
			if (lcc.theBeatles.get(2).getChips().get(i).getLength() > longestChipPaul.getLength()) {
				longestChipPaul = lcc.theBeatles.get(2).getChips().get(i);
			} 
		}
		for (int i = 0; i < lcc.theBeatles.get(3).getChips().size(); i++) {
			if (lcc.theBeatles.get(3).getChips().get(i).getLength() > longestChipRingo.getLength()) {
				longestChipRingo = lcc.theBeatles.get(3).getChips().get(i);
			} 
		}
		Chip owner;
		if(longestChipGeorge.getLength() > longestChipJohn.getLength()) {
			owner = longestChipGeorge;
			}
		else {
			owner = longestChipJohn;
		}
		if(owner.getLength() > longestChipPaul.getLength()) {
		}
		else {
			owner = longestChipPaul;
		}
		if(owner.getLength() > longestChipRingo.getLength()) {
			
		}
		else {
			owner = longestChipRingo;
		}
	
		if(owner == longestChipGeorge) {
			System.out.println(lcc.theBeatles.get(0).getName());	
		}
		if(owner == longestChipJohn) {
			System.out.println(lcc.theBeatles.get(1).getName());	
		}
		if(owner == longestChipPaul) {
			System.out.println(lcc.theBeatles.get(2).getName());	
		}
		if(owner == longestChipRingo) {
			System.out.println(lcc.theBeatles.get(3).getName());	
		}
		
	}
	
	private void initializeBeatles() {
		Beatle george = new Beatle("George");
		Beatle john = new Beatle("John");
		Beatle paul = new Beatle("Paul");
		Beatle ringo = new Beatle("Ringo");
		theBeatles.add(george);
		theBeatles.add(john);
		theBeatles.add(paul);
		theBeatles.add(ringo);
	}

	public ArrayList<Beatle> getTheBand() {
		return theBeatles;
	}
}

class Beatle {
	private String name;
	private ArrayList<Chip> chips = new ArrayList<Chip>();

	public Beatle(String name) {
		this.name = name;
		initializePlateOfChips();
	}

	private void initializePlateOfChips() {
		int numberOfChips = new Random().nextInt(100);
		for (int i = 0; i < numberOfChips; i++) {
			chips.add(new Chip(new Random().nextDouble() * 10));
		}
	}

	public ArrayList<Chip> getChips() {
		return this.chips;
	}

	public String getName() {
		return this.name;
	}
}

class Chip {
	private double length;

	public double getLength() {
		return length;
	}

	Chip(double d) {
		this.length = d;
	}
}
