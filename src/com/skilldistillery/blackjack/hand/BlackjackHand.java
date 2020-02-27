package com.skilldistillery.blackjack.hand;


public class BlackjackHand extends Hand {

	public BlackjackHand() {
		super();
	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		} else {
			return false;

		}
	}
}
