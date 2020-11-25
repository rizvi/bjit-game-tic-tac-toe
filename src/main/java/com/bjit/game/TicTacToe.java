package com.bjit.game;

import com.bjit.game.GFG;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Human: "+GFG.player);
		System.out.println("PC: "+GFG.opponent);
		
		char board[][] = {
				{'_', '_', '_'},
				{'_', '_', '_'},
				{'_', '_', '_'}
		};
		
		// Shows empty board
		GFG gfg = new GFG();
		for (char[] a : board) {
			for (char i : a) {
				System.out.print(i + "\t");
			}
			System.out.println("\n");
		}
		
		
		
		int k = 0;
		int status = 0;
		for (int j = 0; j < 5; j++) {
			GFG.Move bestMove = new GFG.Move();
			System.out.println("Your Turn: ");
			System.out.println("Choose Row:");
			bestMove.row = input.nextInt();
			System.out.println("Choose Column:");
			bestMove.col = input.nextInt();
//			com.bjit.game.GFG.Move bestMove = gfg.findBestMove(board);
			
			System.out.printf("The Optimal Move is :\n");
			System.out.printf("ROW: %d COL: %d\n\n",
					bestMove.row, bestMove.col);
			
			board[bestMove.row][bestMove.col] = GFG.player;
			// now let's print a two dimensional array in Java
			for (char[] a : board) {
				for (char i : a) {
					System.out.print(i + "\t");
				}
				System.out.println("\n");
			}
			// Check the status
			status = GFG.evaluate(board);
			System.out.println("status is: "+status);
			if(status == 10) {
				System.out.println("Human wins");
				break;
			}
			k++;
			System.out.println("K: " + k);
			System.out.println("PC Turn: ");
			
			if (k != 9) {
				GFG.Move bestMove1 = gfg.findBestMove(board);
				board[bestMove1.row][bestMove1.col] = GFG.opponent;
				// now let's print a two dimensional array in Java
				System.out.println("======================");
				for (char[] a : board) {
					for (char i : a) {
						System.out.print(i + "\t");
					}
					System.out.println("\n");
				}
				System.out.println("======================");
				for (char[] a : board) {
					for (char i : a) {
						System.out.print(i + "\t");
					}
					System.out.println("\n");
				}
				k++;
				System.out.println("K: " + k);
			}
			status = GFG.evaluate(board);
			System.out.println("status2 is: "+status);
			if(status == -10) {
				System.out.println("PC wins");
				break;
			}
		}
		
		if(status == 0) {
			System.out.println("Game Draw!!!");
		}
	}
	
}
