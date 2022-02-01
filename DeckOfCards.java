

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import javafx.scene.image.Image;

public class DeckOfCards {
	private ArrayList<ThrityOneCard> deck;
	
	//one argument constructor that passes the deck
	public DeckOfCards(ArrayList<ThrityOneCard> deck) {
		this.deck = deck;
	}
	//zero argument constructor that builds the deck
	public DeckOfCards() {
		List<String> suits = ThrityOneCard.getValidSuits(); //creates list of valid suits using card class
												//static method
		List<String> faceNames = ThrityOneCard.getValidFaceNames();//creates list of valid faceNames using  
														// card class static method
		deck = new ArrayList<>(); 
		for(String suit:suits) { 
			for(String faceName:faceNames) { 
				deck.add(new ThrityOneCard(faceName, suit));//goes through entire face name list before it
			}										//switches suits
		}
	}
	
	public String toString() {
		System.out.println("The deck contains " + deck.size() + " cards"); //printing deck size
		return deck.toString();//printing the deck
	}
}
