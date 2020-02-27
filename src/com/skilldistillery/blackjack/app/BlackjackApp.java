package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.players.BlackjackDealer;
import com.skilldistillery.blackjack.players.BlackjackPlayer;
import com.skilldistillery.blackjack.players.Player;

public class BlackjackApp {

	static Scanner kb = new Scanner(System.in);
	private BlackjackDealer dealer = new BlackjackDealer();
	private Player player = new BlackjackPlayer();
	private Deck deck = dealer.getDeck();
	private boolean hidden = true;

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.run();
	}

	public void run() {
		// Print and execute opening menu
		printMenu();

	}

	public void printMenu() {
		System.out.println("Welcome to the House of Cards");
		System.out.println("Menu Options (1-4)");
		System.out.println("1. Join the table.");
		System.out.println("2. Leave the Game.");
		System.out.println("3. Learn to play.");
		System.out.println("4. View High Scores.");
		int menuOption = kb.nextInt();
		switch (menuOption) {
		case 1:
			beginGame();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}

	}

	public void beginGame() {

		// set player name
		System.out.println("Enter your name:");
		String name = kb.next();
		player.setName(name);
		System.out.println("Welcome to Blackjack " + player.getName());

		// Dealer shuffles cards
		System.out.println("The dealer will now shuffle the deck...");
		dealer.getDeck().shuffle();

		// each players first two cards are initialized
		player.setHand(dealer.initialDeal(player.getHand()));

		System.out.println("The dealer deals out the cards...\n");
		printdealerHand(hidden);
		hidden = false;
		printPlayerHand();

		if (dealer.getHand().isBlackjack()) {
			System.out.println("Dealer wins! Blackjack!!");

		} else if (player.getHand().isBlackjack()) {
			System.out.println(player.getName() + " wins! Blackjack!!");
		} else if (player.getHand().isBust() || dealer.getHand().isBust()) {
			System.out.println("Logic error with double Aces. Stretch goal");
		} else {

			int choice = 0;
			while (choice != 2) {
				System.out.println("What would you like to do?");
				System.out.println("1. Hit");
				System.out.println("2. Stay");
				kb.nextLine();

				choice = kb.nextInt();
				switch (choice) {
				case 1:
					choice = playerTurn();
					player.hit(deck.dealCard());
					printPlayerHand();
					if (player.getHand().isBlackjack()) {
						choice = 2;
					}
					if (player.getHand().isBust()) {
						printdealerHand(hidden);
						System.out.println(player.getName() + " busts!");
						System.out.println("Dealer wins!");
						choice = 2;
					}
					break;
				case 2:
					break;
				default:
					System.out.println("Invalid input");

				}

			}
			if (player.getHand().isBust()) {

			} else {

				while (dealer.getHand().getHandValue() < 17) {
					if (dealer.getHand().getHandValue() < 17) {
						dealer.hit(deck.dealCard());
					}

				}
				printdealerHand(hidden);
				if (player.getHand().getHandValue() == dealer.getHand().getHandValue()) {
					System.out.println("It's a push!");
				}
				else if (dealer.getHand().isBust()) {
					System.out.println("Dealer busted. You win!");
				} else if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {

					System.out.println("Dealer wins!");
				} else {

					System.out.println("You win!!");
				}
			}
		}

	}
	private int playerTurn() {
		// TODO Auto-generated method stub
		return 0;
	}


	private void printPlayerHand() {
		System.out.println(player.getName() + "'s Hand\n-----------");
		System.out.println(player.getHand());
		System.out.println("Total: " + player.getHand().getHandValue() + "\n");

	}

	private void printdealerHand(boolean hidden) {
		System.out.println("Dealer Hand\n-----------");
		dealer.getHand(hidden);
		String print = hidden ? "" : "Total: " + dealer.getHand().getHandValue() + "\n";
		System.out.println(print);

	}

}
