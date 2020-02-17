package com.skilldistillery.blackjack.cards;

import java.util.*;

public class Deck {

	// F i e l d s

	private List<Card> cards;

	// M e t h o d s

	public Deck() {
		cards = createDeck();
	}

	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	@Override
	public String toString() {
		return "" + cards;
	}
	
	
}
