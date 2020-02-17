package com.skilldistillery.blackjack.hand;

import com.skilldistillery.blackjack.cards.Card;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card Card : getCards()) {
			handValue += Card.getValue();
		}
		return handValue;
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
