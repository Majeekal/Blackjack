package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.hand.Hand;

public class BlackjackDealer extends BlackjackPlayer {

	private Deck deck;

	public BlackjackDealer() {
		super();
		deck = new Deck();
	}

	public Hand initialDeal(Hand playerHand) {
		playerHand.addCard(deck.dealCard());
		hand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());
		hand.addCard(deck.dealCard());
		return playerHand;
	}

	

	public Deck getDeck() {
		return deck;
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
	
	public void printHand(boolean hidden) {
		int value;
		
		if(hidden) {
			value = getHand().getHandValue() - hand.getCards().get(0).getValue();
		} else {
			value = getHand().getHandValue();
		}
		
		System.out.println("Dealer Hand\n-----------");
		getHand(hidden);
		System.out.println("Total: " + value + "\n");
	}
}
