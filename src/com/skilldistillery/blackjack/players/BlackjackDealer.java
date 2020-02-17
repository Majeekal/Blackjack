package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.hand.BlackjackHand;
import com.skilldistillery.blackjack.hand.Hand;

public class BlackjackDealer extends BlackjackPlayer {

	private Deck deck;

	public BlackjackDealer() {
		deck = new Deck();
		hand = new BlackjackHand();
	}

	public Hand initialDeal(Hand playerHand) {
		playerHand.addCard(deck.dealCard());
		hand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());
		hand.addCard(deck.dealCard());
		return playerHand;
	}

	@Override
	public void hit(Card card) {
		hand.addCard(card);
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	public Hand getHand() {
		return hand;
	}

	public void getHand(boolean hidden) {
		if (hidden) {
			StringBuilder sb = new StringBuilder();
			sb.append("[Hidden, ");
			sb.append(hand.getCards().get(1) + "]");
			System.out.println(sb.toString());
		} else {
			System.out.println(hand);
		}
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

}
