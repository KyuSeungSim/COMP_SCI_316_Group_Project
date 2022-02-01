import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ThrityOneController {

	ThrityOne game31 = new ThrityOne();
	
	private String playerDeck[] = {"-1", "-1", "-1"}; 
	private String dealerDeck[] = {"-1", "-1", "-1"}; 
	private String tableDeck[] = {"-1", "-1", "-1"}; 
	private String clickedDeck[] = {"-1", "-1", "-1"};

	@FXML
    private Button startButton;

    @FXML
    private Button reStartButton;

    @FXML
    private TextField moneyTextField;

    @FXML
    private TextField wagerTextField;

    @FXML
    private Button swapButton;

    @FXML
    private Button knockButton;

    @FXML
    private ImageView dealerCard1;

    @FXML
    private ImageView dealerCard2;

    @FXML
    private ImageView dealerCard3;

    @FXML
    private ImageView tableCard1;

    @FXML
    private RadioButton tableRadioButton1;

    @FXML
    private ToggleGroup tableCardRadioGroup;

    @FXML
    private ImageView tableCard2;

    @FXML
    private RadioButton tableRadioButton2;

    @FXML
    private ImageView tableCard3;

    @FXML
    private RadioButton tableRadioButton3;

    @FXML
    private ImageView playerCard1;

    @FXML
    private RadioButton playerRadioButton1;

    @FXML
    private ToggleGroup playerCardRadioGroup;

    @FXML
    private ImageView playerCard2;

    @FXML
    private RadioButton playerRadioButton2;

    @FXML
    private ImageView playerCard3;

    @FXML
    private RadioButton playerRadioButton3;

    @FXML
    private TextField dealerTextField;

    @FXML
    private TextField playerTextField;

    @FXML
    private TextField winnerTextField;

    @FXML
    private ImageView newDeck;
    
    private int temp = 0;

    @FXML
    void dealDeck(MouseEvent event) {
    			// clicked deck cards
    			game31.DealCard(clickedDeck, 0, 9);
    			game31.DealCard(clickedDeck, 1, 10);
    			game31.DealCard(clickedDeck, 2, 11);
    			
    			//setting tableDeck to the clicked cards
    			tableDeck[0] = clickedDeck[0];
    			tableDeck[1] = clickedDeck[1];
    			tableDeck[2] = clickedDeck[2];
    			
    	    	//setting the table cards to new cards
    			tableCard1.setImage(new Image("/cardimages/" + clickedDeck[0] + ".png"));
        		tableCard2.setImage(new Image("/cardimages/" + clickedDeck[1] + ".png"));
        		tableCard3.setImage(new Image("/cardimages/" + clickedDeck[2] + ".png"));
        		temp++;
        		
        		
        		newDeck.setVisible(true);
    		
    	
    }

    @FXML
    void startButtonPressed(ActionEvent event) {

    	// Deal player, table, and dealer
    	dealDeck();
		
    	// Bring Wager to input
    	game31.setWager(wagerTextField.getText());
    	
    	// Show Card Images
    	//game31.showDeck(playerDeck, tableDeck);
    	
    	String newDeckImage= "/cardimages/gray_back.png";
    	newDeck.setImage(new Image(newDeckImage));
    	
    	// Player Card Images
    	String playerCardImage1 = "/cardimages/" + playerDeck[0] + ".png";
    	String playerCardImage2 = "/cardimages/" + playerDeck[1] + ".png";
    	String playerCardImage3 = "/cardimages/" + playerDeck[2] + ".png";
    	playerCard1.setImage(new Image(playerCardImage1));
    	playerCard2.setImage(new Image(playerCardImage2));
    	playerCard3.setImage(new Image(playerCardImage3));
    	
    	// Table Card Images
    	String tableCardImage1 = "/cardimages/" + tableDeck[0]  + ".png";
    	String tableCardImage2 = "/cardimages/" + tableDeck[1] + ".png";
    	String talbeCardImage3 = "/cardimages/" + tableDeck[2] + ".png";
    	tableCard1.setImage(new Image(tableCardImage1));
    	tableCard2.setImage(new Image(tableCardImage2));
    	tableCard3.setImage(new Image(talbeCardImage3));

    	// Hide Dealer Card
    	String dealerCardImage1 = "/cardimages/gray_back.png";
    	String dealerCardImage2 = "/cardimages/gray_back.png";
    	String dealerCardImage3 = "/cardimages/gray_back.png";
    	dealerCard1.setImage(new Image(dealerCardImage1));
    	dealerCard2.setImage(new Image(dealerCardImage2));
    	dealerCard3.setImage(new Image(dealerCardImage3));
    	
    	// Make work another button work
    	startButton.setDisable(true);
    	wagerTextField.setDisable(true);
    	knockButton.setDisable(false);
    	swapButton.setDisable(false);
    }

    @FXML
    void restartButtonPressed(ActionEvent event) {
    	
    	// Restart The game - reset of money
    	moneyTextField.setText("500");
    	
    	startButton.setDisable(false);
    	reStartButton.setDisable(true);
    }

    //tableCard 1 = clickedDeck1
    @FXML
    void swapButtonPressed(ActionEvent event) {
    	
    	
    	// Check Table Radio Button Selected and Save image File in temp1
    	if(tableRadioButton1.isSelected() == true) {
    		if(playerRadioButton1.isSelected() == true) {
    			// Swap the values
        		game31.SwapButton(playerDeck, 0, tableDeck, 0);
        		// Update the Card Images
        		playerCard1.setImage(new Image("/cardimages/" + playerDeck[0] + ".png"));
        		tableCard1.setImage(new Image("/cardimages/" + tableDeck[0] + ".png"));
        		
    		} else if(playerRadioButton2.isSelected() == true) { 
    			// Swap the values
        		game31.SwapButton(playerDeck, 1, tableDeck, 0);
        		// Update the Card Images
        		playerCard2.setImage(new Image("/cardimages/" + playerDeck[1] + ".png"));
        		tableCard1.setImage(new Image("/cardimages/" + tableDeck[0] + ".png"));
        		
    		} else if(playerRadioButton3.isSelected() == true) {
    			// Swap the values
        		game31.SwapButton(playerDeck, 2, tableDeck, 0);
        		// Update the Card Images
        		playerCard3.setImage(new Image("/cardimages/" + playerDeck[2] + ".png"));
        		tableCard1.setImage(new Image("/cardimages/" + tableDeck[0] + ".png"));
    		}
    	}
		if(tableRadioButton2.isSelected() == true) {
    		if(playerRadioButton1.isSelected() == true) {
    			// Swap the values
        		game31.SwapButton(playerDeck, 0, tableDeck, 1);
        		// Update the Card Images
        		playerCard1.setImage(new Image("/cardimages/" + playerDeck[0] + ".png"));
        		tableCard2.setImage(new Image("/cardimages/" + tableDeck[1] + ".png"));
        		
    		} else if(playerRadioButton2.isSelected() == true) { 
    			// Swap the values
        		game31.SwapButton(playerDeck, 1, tableDeck, 1);
        		// Update the Card Images
        		playerCard2.setImage(new Image("/cardimages/" + playerDeck[1] + ".png"));
        		tableCard2.setImage(new Image("/cardimages/" + tableDeck[1] + ".png"));
        		
    		} else if(playerRadioButton3.isSelected() == true) {
    			// Swap the values
        		game31.SwapButton(playerDeck, 2, tableDeck, 1);
        		// Update the Card Images
        		playerCard3.setImage(new Image("/cardimages/" + playerDeck[2] + ".png"));
        		tableCard2.setImage(new Image("/cardimages/" + tableDeck[1] + ".png"));
    		}
		}
		if(tableRadioButton3.isSelected() == true) {  		
    		if(playerRadioButton1.isSelected() == true) {
    			// Swap the values
        		game31.SwapButton(playerDeck, 0, tableDeck, 2);
        		// Update the Card Images
        		playerCard1.setImage(new Image("/cardimages/" + playerDeck[0] + ".png"));
        		tableCard3.setImage(new Image("/cardimages/" + tableDeck[2] + ".png"));
    			
    		} else if(playerRadioButton2.isSelected() == true) { 
    			// Swap the values
        		game31.SwapButton(playerDeck, 1, tableDeck, 2);
        		// Update the Card Images
        		playerCard2.setImage(new Image("/cardimages/" + playerDeck[1] + ".png"));
        		tableCard3.setImage(new Image("/cardimages/" + tableDeck[2] + ".png"));
        		
    		} else if(playerRadioButton3.isSelected() == true) {
    			// Swap the values
        		game31.SwapButton(playerDeck, 2, tableDeck, 2);
        		// Update the Card Images
        		playerCard3.setImage(new Image("/cardimages/" + playerDeck[2] + ".png"));
        		tableCard3.setImage(new Image("/cardimages/" + tableDeck[2] + ".png"));
    		}
		}
    }
    
    @FXML
    void knockButtonPressed(ActionEvent event) {
    	
    	// Make disable to press knock and swap button. - Knock Button is finish the game.
    	knockButton.setDisable(true);
    	swapButton.setDisable(true);
    	
    	// If money is 0 then game over.
    	if(moneyTextField.getText().equals("0")) {
	  		
    		startButton.setDisable(true);
    		reStartButton.setDisable(false);
    		
    	} else {
    		// Show Dealer Card Image
    		dealerCard1.setVisible(true);
        	dealerCard2.setVisible(true);
        	dealerCard3.setVisible(true);
        	  		
        	String dealerCardImage1 = "/cardimages/" + dealerDeck[0] + ".png";
        	String dealerCardImage2 = "/cardimages/" + dealerDeck[1] + ".png";
        	String dealerCardImage3 = "/cardimages/" + dealerDeck[2] + ".png";
        	dealerCard1.setImage(new Image(dealerCardImage1));
        	dealerCard2.setImage(new Image(dealerCardImage2));
        	dealerCard3.setImage(new Image(dealerCardImage3));
    		
    		game31.KnockButton(playerDeck, dealerDeck);
    	
    		// Show the Score and Winner on the game
    		dealerTextField.setText(game31.getDealerScore());
    		playerTextField.setText(game31.getPlayerScore());
    		winnerTextField.setText(game31.getWinner());
    		
    		// Update Money
    		moneyTextField.setText(game31.getMoney());
    	
    		// Open the start and wager to play next game
	    	startButton.setDisable(false);
	    	wagerTextField.setDisable(false);
    	}
    }
    
    public void initialize() {
    	// Set Money Start Game
    	moneyTextField.setText(game31.getMoney());
    
    }
    
    public void dealDeck() {
		// Deal Player Deck
		game31.DealCard(playerDeck, 0, 0);
		game31.DealCard(playerDeck, 1, 1);
		game31.DealCard(playerDeck, 2, 2);

		// Deal Dealer Deck
		game31.DealCard(dealerDeck, 0, 3);
		game31.DealCard(dealerDeck, 1, 4);
		game31.DealCard(dealerDeck, 2, 5);

		// Deal Table Deck
		game31.DealCard(tableDeck, 0, 6);
		game31.DealCard(tableDeck, 1, 7);
		game31.DealCard(tableDeck, 2, 8);
    }
}
