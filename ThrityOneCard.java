import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;

public class ThrityOneCard {
	private String faceName;
	private String suit;
	private int faceValue;
	private Image cardImage;
	
	//Constructor that builds the card
	public ThrityOneCard(String faceName, String suit) {	
		this.faceName = faceName;
		this.suit = suit;
	}
     //list of suits
	 public static List<String> getValidSuits()
	    {
	        return Arrays.asList("C","S","D","H");
	    }
	 //list of face cards
	public static List<String> getValidFaceNames()
    {
        return Arrays.asList("2","3","4","5","6","7","8","9","10","J",
                            "Q","K","A");
    }
	public String toString() {
		return suit + "&" + faceName;
	}
	public int getFaceValue() {
		return faceValue; 
	}
	public Image getCardImage() {
		return cardImage;
	}
	public void setCardImage(Image cardImage) {
		this.cardImage = cardImage;
	}
	public String getFaceName() {
		return faceName;
	}
	public String getSuit() {
		return suit;
	}
}
