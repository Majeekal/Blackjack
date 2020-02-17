package com.skilldistillery.blackjack.cards;

public class Card {

	// F i e l d s

	private Suit suit;
	private Rank rank;

	// M e t h o d s

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (rank != Rank.JACK && rank != Rank.QUEEN && rank != Rank.KING && rank != Rank.ACE) {
			builder.append(rank.getValue());
		} else {
			switch (rank) {
			case JACK:
				builder.append("Jack");
				break;
			case QUEEN:
				builder.append("Queen");
				break;
			case KING:
				builder.append("King");
				break;
			case ACE:
				builder.append("Ace");
				break;
			default:
				System.out.println("Something went heywire!");
			}
		}
		builder.append(" of ");
		builder.append(suit);
		return builder.toString();
	}

	public int getValue() {
		return rank.getValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

}
