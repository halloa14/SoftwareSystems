package ss.week4.tictactoe;

import java.util.Scanner;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] a) {
    	System.out.println("Voor 2 namen in, gescheiden door een comma.: ");
    	Scanner scanner = new Scanner(System.in);
    	String[] args = scanner.nextLine().split(",");
    	Player s1 = new HumanPlayer(args[0], Mark.XX);
    	Player s2 = new HumanPlayer(args[1], Mark.OO);
    	Game game = new Game(s1, s2);
    	game.start();
    	scanner.close();
    }
}