package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.players.BlackjackDealer;
import com.skilldistillery.blackjack.players.BlackjackPlayer;
import com.skilldistillery.blackjack.players.Player;

public class BlackjackApp {
	Scanner consoleInput = new Scanner(System.in);
	private BlackjackDealer dealer = new BlackjackDealer();
	private Player player = new BlackjackPlayer();
	private Deck deck = dealer.getDeck();
	
	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.run();
	}
	
	public void run() {
		player.setName(getName());
		int option = menu();
	}
	
	public void game() {
		// Shuffle cards
		dealer.getDeck().shuffle();
		
		// Hand player cards
		player.setHand(dealer.initialDeal(player.getHand()));
		
		// Show cards
		player.printHand();
		dealer.printHand(true);
		
		// Is blackjack or bust
		if(dealer.getHand().isBlackjack()) {
			player.printHand();
			dealer.printHand(false);
			System.out.println("Dealer wins! Blackjack!!");
		} else if(player.getHand().isBlackjack()){
			player.printHand();
			dealer.printHand(false);
			System.out.println(player.getName() + " wins! Blackjack!!");
		} else if(player.getHand().isBust() || dealer.getHand().isBust()) {
			System.out.println("Logic error with double Aces. Stretch goal");
		} else {
			
			int choice;
			boolean isOver = false; 		
			while(!isOver) {
				System.out.println("What would you like to do?");
				System.out.println("1. Hit");
				System.out.println("2. Stay");
				
				consoleInput.nextLine();
				choice = consoleInput.nextInt();
				
				switch(choice) {
					case 1: player.hit(deck.dealCard()); player.printHand(); break;
					case 2: isOver = true; break;	
					default: return;
				}
				
				if(player.getHand().isBlackjack()) {
					player.printHand();
					dealer.printHand(false);
					System.out.println(player.getName() + " wins! Blackjack!!");
					isOver = true;
					return;
				} else if(player.getHand().isBust()) {
					player.printHand();
					dealer.printHand(false);
					System.out.println(player.getName() + " busts!");
					System.out.println("Dealer wins!");
					isOver = true;
					return;
				}
			}
			
			while (dealer.getHand().getHandValue() < 17) {
				if (dealer.getHand().getHandValue() < 17) {
					dealer.hit(deck.dealCard());
				}
			}
			
			dealer.printHand(false);
			
			if (player.getHand().getHandValue() == dealer.getHand().getHandValue()) {
				System.out.println("It's a push!");
			} else if (dealer.getHand().isBust()) {
				System.out.println("Dealer busted. You win!");
			} else if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
				System.out.println("Dealer wins!");
			} else {
				System.out.println("You win!!");
			}
		}
	}
	
	public int menu() {
		System.out.println("1. Join the table.\n" +
						   "2. View high scores.\n" +
						   "3. Learn to play.\n" +
						   "4. Leave the game.");
		
		int option = consoleInput.nextInt();
		
		switch(option) {
			case 1: game(); break;
			case 2: break;
			case 3: break;
			case 4: break;
			default: break;
		}
		
		return option;
	}
	
	public String getName() {
		System.out.println("Enter your name.");
		return consoleInput.next();
	}
}