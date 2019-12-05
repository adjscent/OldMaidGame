public class Player {
	private String playerName;
	private int playerNo;
	public CardCollection hand;
	public CardCollection floor;

	public Player(String playerName, int playerNo) {
		super();
		this.playerName = playerName;
		this.playerNo = playerNo;
		hand = new CardCollection();
		floor = new CardCollection();
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return the playerNo
	 */
	public int getPlayerNo() {
		return playerNo;
	}

	/**
	 * @param playerNo the playerNo to set
	 */
	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public void matchPairs() {
		Card[] pairs = null;
		while ((pairs = hand.findMatch()) != null) {
			
			System.out.printf("Pair found: ");
			pairs[0].displayCard();
			System.out.printf(", ");
			pairs[1].displayCard();
			System.out.println();
			
			floor.add(pairs[0]);
			floor.add(pairs[1]);
			hand.remove(pairs[0]);
			hand.remove(pairs[1]);
		}
	}
}
