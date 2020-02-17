package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.hand.Hand;

public abstract class Player {
	
	// F i e l d s 
	Hand hand;
	String name;
	// M e t h o d s 
	
	public void hit(Card card) {
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
		return this.hand;
	}
	public abstract void getHand(boolean hidden);

	
	
	

}
