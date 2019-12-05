import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class CardCollection {
	private Card[] cards = null;
	private int noOfCards;

	public CardCollection() {
		cards = new Card[52];
		noOfCards = 0;
	}

	public void add(Card card) {
		cards[noOfCards] = card;
		noOfCards++;
	}

	public Card pop() {
		if (noOfCards != 0) {
			return cards[--noOfCards];
		} else {
			return null;
		}
	}

	public void remove(Card card) {
		for (int i = 0; i < noOfCards; i++) {
			if (cards[i].equals(card)) {
				cards[i] = null;
				noOfCards--;
				break;
			}
		}
		sort();
	}

	public void sort() {
		Arrays.sort(cards, new Comparator<Card>() {
			@Override
			public int compare(Card arg0, Card arg1) {
				if (arg0 == null && arg1 == null) {
					return 0;
				}
				if (arg0 == null) {
					return 1;
				}
				if (arg1 == null) {
					return -1;
				}
				return arg0.compareTo(arg1);
			}
		});
		;
	}

	public void shuffle() {
		for (int i = 0; i < noOfCards; i++) {
			Random random = new Random();
			int randInt = random.nextInt(noOfCards);
			Card tempCard = cards[i];
			cards[i] = cards[randInt];
			cards[randInt] = tempCard;
		}
	}

	public boolean isEmpty() {
		if (noOfCards == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isLone() {
		if (noOfCards == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void displayCards() {
		System.out.printf("Current No. of Cards %d\n", noOfCards);
		System.out.printf("===\n");
		for (int i = 0; i < noOfCards; i++) {
			if (cards[i] == null) {
				System.out.println("null");
			} else {
				System.out.printf("%d. ",i);
				cards[i].displayCard();
				System.out.println();
			}
		}
		System.out.printf("===\n");
	}

	public Card[] findMatch() {
		for (int i = 0; i < noOfCards; i++) {
			for (int j = i + 1; j < noOfCards; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					if (cards[i].getColor().equals(cards[j].getColor())) {
						return new Card[] { cards[i], cards[j] };
					}
				}
			}
		}
		return null;
	}
}
