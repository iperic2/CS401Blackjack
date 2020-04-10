	/*
		Card Object - makes card class objects, initialize a private integer, 
		cardValue, and a private string variable, suit, 
		and contains method for setting the values of the variables.
	*/

import java.lang.String;

public class Card {

	private int cardValue;
	private String suit;

	public Card(){
		cardValue = 0;
		suit = "";
	}

	public Card(int cv, String s){
		cardValue = cv;
		suit = s;
	}

	public void setCardValue(int c) {
		cardValue = c;
	}
	public void setSuit(String s) {
		Suit = s;
	}
		
	//add getters?

}

