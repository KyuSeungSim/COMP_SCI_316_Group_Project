/*
 * Group Project - Game 31 Fianl Presentation
 * Group 8 
 * Members: Alexzandrea Olson, Kyu Seung Sim
 * 
 * Dec, 7 2020
 * 
 */

import java.util.*;

public class ThrityOne {
	
	private ArrayList<ThrityOneCard> deck;

	String[] suitList = {"C","S","H","D"}; // Club, Spade, Heart, Diamond
	String[] numberList = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"}; // 13 numbers

	final int MAX_SCORE = 31;              // 31 Game max score
	final int MAX_CARD = 3;				   // Player can't get over 3 cards
	final int DEFAULT_WAGER  = 10;         // Each game Wager amount.
	final int DEFAULT_WALLET = 500;        // This is default money when first time play game. It can change to life system.
	
	private int player_wallet = DEFAULT_WALLET;
	private int player_wager = DEFAULT_WAGER;
	
	private int dealerScore;
	private int playerScore;
	private String winner;
	
	public ThrityOne() {
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
	
	public ThrityOne(ArrayList<ThrityOneCard> deck) {
		this.deck = deck;
	}
	
	public String getMoney() { return String.valueOf(player_wallet); }
	
	public String getDealerScore() { return String.valueOf(dealerScore); }
	
	public String getPlayerScore() { return String.valueOf(playerScore); }
	
	public String getWinner() { return winner; }	
	
	public void setWager(String input) {
		player_wager = Integer.parseInt(input);
	}
	
	public void UpdateWallet(int update_amount) {

		if(player_wallet <= 0) {
			System.out.println("Out of Money! Game Over!");
		} else {
			player_wallet += update_amount;
		}
	}
	
	public void Deck() {
		deck = new ArrayList<ThrityOneCard>();
        for(int i = 0; i < suitList.length; i++) {
            for(int j = 0; j < numberList.length; j++) {
                deck.add(new ThrityOneCard(numberList[j], suitList[i]));
            }
        }
	}
		
	public void Suffle() {
		Collections.shuffle(deck);
    }             

	public void DealCard(String playDeck[], int deckIndex, int cardIndex) {
		
		Suffle();
		
		playDeck[deckIndex] = String.valueOf(deck.get(cardIndex));
	}
	
	public void SwapButton(String playerCard[], int playerCardNumber, String tableCard[], int tableCardNumber) {
		
		String swapNumber1;
		String swapNumber2;
		
		swapNumber1 = tableCard[tableCardNumber];
		swapNumber2 = playerCard[playerCardNumber];

		tableCard[tableCardNumber] = swapNumber2;
		playerCard[playerCardNumber] = swapNumber1;
		
	}
	
	public void KnockButton(String inputDeck1[], String inputDeck2[]) {
		
		int playerScore = 0;
		int dealerScore = 0;
		
		playerScore = newScore(inputDeck1);
		dealerScore = newScore(inputDeck2);

		Winner(dealerScore, playerScore);
	}
	
	public void Winner(int dealer_score, int player_score) {

		if(player_score > dealer_score) {
			UpdateWallet(player_wager);	
			winner = "Player";
		} else if(player_score == dealer_score) {
			winner = "Draw";
		} else if(player_score < dealer_score) {
			UpdateWallet(-player_wager);	
			winner = "Dealer";
		}
		
		playerScore = player_score;
		dealerScore = dealer_score;
	}
	
	public int newScore(String playDeck[]) {
		
		int totalScore = 0;
		int cardScore = 0;
		
		// Card Image Dvide by & position.
		String[] deck1 = playDeck[0].split("&",2);
		String[] deck2 = playDeck[1].split("&",2);
		String[] deck3 = playDeck[2].split("&",2);
		
		String suit1, suit2, suit3;
		String[] rank = { "", "", ""};

		// Save Suit position
		suit1 = deck1[0];
		suit2 = deck2[0];
		suit3 = deck3[0];
		// Save face number
		rank[0] = deck1[1];
		rank[1] = deck2[1];
		rank[2] = deck3[1];
			
		if( (suit1.equals(suit2)) && (suit2.equals(suit3)) && (suit1.equals(suit3)) ) {
			for(int i = 0; i < playDeck.length; i++) {
				if(rank[i].equals("J")  || rank[i].equals("Q") || rank[i].equals("K") ) {
					cardScore = 10;
				} else if(rank[i].equals("A") ) {
					cardScore = 11;
				} else {
					cardScore = Integer.parseInt(rank[i]);
				}
				totalScore = totalScore + cardScore;
			}
		} else if (suit1.equals(suit2)) {
			for(int i = 0; i < 2; i++) {
				if(rank[i].equals("J")  || rank[i].equals("Q") || rank[i].equals("K") ) {
					cardScore = 10;
				} else if(rank[i].equals("A") ) {
					cardScore = 11;
				} else {
					cardScore = Integer.parseInt(rank[i]);
				}
				totalScore = totalScore + cardScore;
			}
		} else if (suit2.equals(suit3)) {
			for(int i = 1; i < playDeck.length; i++) {
				if(rank[i].equals("J")  || rank[i].equals("Q") || rank[i].equals("K") ) {
					cardScore = 10;
				} else if(rank[i].equals("A") ) {
					cardScore = 11;
				} else {
					cardScore = Integer.parseInt(rank[i]);
				}
				totalScore = totalScore + cardScore;
			}
		} else if (suit1.equals(suit3)) {
			for(int i = 0; i < playDeck.length; i = i + 2) {
				if(rank[i].equals("J")  || rank[i].equals("Q") || rank[i].equals("K") ) {
					cardScore = 10;
				} else if(rank[i].equals("A") ) {
					cardScore = 11;
				} else {
					cardScore = Integer.parseInt(rank[i]);
				}
				totalScore = totalScore + cardScore;
			}

		}
		System.out.println(totalScore);
		return totalScore;
	}
}