package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.hand.Hand;

public abstract class Player {
	
	// F i e l d s 
	Hand hand;
	String name;
	// M e t h o d s 
	
	public void printHand() {
		System.out.println(getName() + "'s Hand\n-----------");
		System.out.println(getHand());
		System.out.println("Total: " + getHand().getHandValue() + "\n");
	}
	
	public void hit(Card card) {
		hand.addCard(card);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Hand getHand() {
		return hand;
	}
	public abstract void getHand(boolean hidden);
}
