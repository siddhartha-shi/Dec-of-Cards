import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dec {
	
	private static ArrayList<Card> deCards = Card.newDeck();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		deCards = Card.newDeck();
		
		System.out.println();
		printHand(deal(5));
		
		deCards = shuffle();
		
		System.out.println();
		printHand(deal(2));
		
		deCards = shuffle();
		
		System.out.println();
		printHand(deal(5));
		
		System.out.println();
		printHand(deal(1));
		printHand(deal(6));
	}
	
	public static ArrayList<Card> shuffle() {
		Random random = new Random();
		List<Card> shuffled = Card.newDeck();
		for (int i = shuffled.size() - 1; i >= 0; i--) {
		    int j = random.nextInt(i + 1);
		    
		    /* swap cards i,j */
		    Card card = shuffled.get(i);
		    shuffled.set(i, shuffled.get(j));
			shuffled.set(j, card);
		}
		return (ArrayList<Card>) shuffled;
	}
	
	private static ArrayList<Hand> deal(int hands) {
		ArrayList<Hand> handList = new ArrayList<Hand>();
		if (hands>=2 && hands<=5) {
			for (int i = 0; i < hands; i++) {
			Hand hand = singleHandDeal(deCards, 5);
			handList.add(hand);
		}
		} else {
			System.err.println("Please enter player between 2 to 5.");
		}
		return handList;
	}
	public static ArrayList<Hand> deal(ArrayList<Card> deCards, int hands) {
		ArrayList<Hand> handList = new ArrayList<Hand>();
		if (hands>=2 && hands<=5) {
			for (int i = 0; i < hands; i++) {
			Hand hand = singleHandDeal(deCards, 5);
			handList.add(hand);
		}
		} else {
			System.err.println("Please enter player between 2 to 5.");
		}
		return handList;
	}
	private static Hand singleHandDeal(List<Card> deck, int n) {
    	List<Card> deckTempCards = deck;
    	Hand singleHand = new Hand();
         int deckSize = deck.size();
         List<Card> handView = deckTempCards.subList(deckSize-n, deckSize);
//         ArrayList<Card> hand = new ArrayList<Card>(handView);
         singleHand.setHand(new ArrayList<Card>(handView));
         handView.clear();
         return singleHand;
     }
	
	private static void printHand(ArrayList<Hand> hands) {
		for (Hand hand : hands) {
			printCards(hand);
		}
	}
    private static void printCards(Hand cards) {
		for (Card card : cards.getHand()) {
			System.out.print(card.rank()+"("+card.suit()+")"+" ");
		}
		System.out.println();
	}
}