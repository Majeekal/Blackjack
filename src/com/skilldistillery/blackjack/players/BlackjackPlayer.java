package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.hand.BlackjackHand;
import com.skilldistillery.blackjack.hand.Hand;

public class BlackjackPlayer extends Player {
	
	// F i e l d s
	
	String name;
	
	public BlackjackPlayer() {
		hand = new BlackjackHand();
	}

	@Override
	public void hit(Card card) {
		hand.addCard(card);
	}

	public Hand getHand() {
		return hand;
	}

	
	public void getHand(boolean hidden) {
		
		// TODO Auto-generated method stub
	}

	
	
}
