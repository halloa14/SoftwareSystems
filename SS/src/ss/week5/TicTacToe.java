package ss.week5;

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
    	System.out.println("Voer 2 namen in, gescheiden "
    					+ "door een comma of een naam comma -N voor een computerspeler: ");
    	Scanner scanner = new Scanner(System.in);
    	String[] args = scanner.nextLine().split(",");
    	Player[] players = new Player[2];
    	Mark[] marks = new Mark[] {Mark.OO, Mark.XX};
    	for (int i = 0; i < args.length; i++) {
    		players[i] = stringToPlayer(args[i], marks[i]);
    	}
    	scanner.close();
    	Game game = new Game(players[0], players[1]);
    	game.start();
    }
    
    private static Player stringToPlayer(String s, Mark m) {
    	Player player;
    	if (s.equals("-S")) {
			player = new ComputerPlayer(m);
		} else if (s.equals("-N")) {
			player = new ComputerPlayer(m);
		} else {
			player = new HumanPlayer(s, m);
		}
    	return player;
    }
}