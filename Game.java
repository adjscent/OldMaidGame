public class Game {
	static void createDeck(CardCollection deck) {
		int shapecounter = 0;
		int cardValue = 1;
		for (int i = 0; i < 52; i++) {
			switch (shapecounter) {
			case 0:
				deck.add(new Card("diamonds", cardValue));
				shapecounter++;
				break;
			case 1:
				deck.add(new Card("clubs", cardValue));
				shapecounter++;
				break;
			case 2:
				deck.add(new Card("hearts", cardValue));
				shapecounter++;
				break;
			case 3:
				deck.add(new Card("spades", cardValue));
				shapecounter=0;
				cardValue++;
				break;
			}
		}
	}
	
	static void distributeDeck(Player[] players, CardCollection deck) {
		int counter = 0;
		while (!deck.isEmpty()) {
			players[counter].hand.add(deck.pop());
			if(counter < players.length -1) {
				counter++;
			}
			else {
				counter = 0;
			}
		}
	};
	
	public static void main(String[] args) {
		CardCollection deck = new CardCollection();
		
		createDeck(deck);
		
		deck.remove(new Card("diamonds", 12));
		
		//Shuffle the deck 100 times
		for (int i=0; i<100;i++) {
			deck.shuffle();
		}
		
		deck.displayCards();
		
		int noOfPlayers = 2;
		Player[] players = new Player[noOfPlayers];
		for (int i = 0; i< players.length;i ++) {
			players[i] = new Player("",i);
		}
		
		distributeDeck(players, deck);
		
		for (int i = 0; i< players.length;i ++) {
			System.out.printf("Player %d hand\n",i);
			players[i].hand.displayCards();
			System.out.printf("Player %d floor\n",i);
			players[i].floor.displayCards();
		}
		
		for (int i = 0; i< players.length;i ++) {
			players[i].matchPairs();
		}
		
		for (int i = 0; i< players.length;i ++) {
			System.out.printf("Player %d hand\n",i);
			players[i].hand.displayCards();
			System.out.printf("Player %d floor\n",i);
			players[i].floor.displayCards();
		}

	}
	
	
}
