public class Card implements Comparable{
	private String shape;
	private int value;

	public Card(String shape, int value) {
		super();
		this.shape = shape;
		this.value = value;
	}

	/**
	 * @return the shape
	 */
	public String getShape() {
		return shape;
	}

	/**
	 * @param shape
	 *            the shape to set
	 */
	public void setShape(String shape) {
		this.shape = shape;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	public String getDisplayValue() {
		String stringValue = null;
		switch (value) {
		case 1:
			stringValue = "ace";
			break;
		case 11:
			stringValue = "jack";
			break;
		case 12:
			stringValue = "queen";
			break;
		case 13:
			stringValue = "king";
			break;
		default:
			stringValue = String.valueOf(value);
			break;
		}
		return stringValue;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	public String getColor() {
		if (shape.equals("hearts") || shape.equals("diamonds")) {
			return "red";
		} else if (shape.equals("spades") || shape.equals("clubs")) {
			return "black";
		}

		else {
			return null;
		}
	}

	@Override
	public boolean equals(Object object) {
		Card card = (Card) object;
		if (card.shape.equals(shape) && card.value == value) {
			return true;
		}
		else {
			return false;
		}
		
	}
	@Override
	public int compareTo(Object arg0) {
		Card card = (Card)arg0;
		
		if(card.value > value) {
			return -1;
		}
		else if (card.value== value) {
			return card.shape.compareTo(shape);
		}
		else {
			return 1;
		}
		
	}
	
	public void displayCard() {
		System.out.printf("%s of %s", getDisplayValue(), getShape());
	}
	
	

}
