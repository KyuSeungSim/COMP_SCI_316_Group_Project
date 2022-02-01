import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String deck[] = {"C&7", "C&A", "D&10"};

		String[] arrOfStr1 = deck[0].split("&",2);
		String[] arrOfStr2 = deck[1].split("&",2);
		String[] arrOfStr3 = deck[2].split("&",2);
		
		String suit;
		String rank;
		
		suit = deck[0];
		rank = deck[1];
		
		System.out.println(arrOfStr1[0]);
		System.out.println(arrOfStr1[1]);
	}

}
