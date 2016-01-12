package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class VoteTUIView implements Observer, VoteView {
	
	VoteMachine votemachine;
	
	public VoteTUIView(VoteMachine votemachine) {
		this.votemachine = votemachine;
	}
	

	
	public void start() {
		Scanner scanner = new Scanner(System.in);
		int doorgaan = 1;
		while (doorgaan == 1) {
			String scan = scanner.next();
			if (scan.equals("EXIT")) {
				doorgaan = 0;
				scanner.close();
			} else if (scan.equals("VOTE")) {
				votemachine.vote(scanner.next());
			} else if (scan.startsWith("ADD")) {
				scanner.next();
				votemachine.addParty(scanner.next());
			} else if (scan.equals("VOTES")) {
				votemachine.getVotes();
			} else if (scan.equals("PARTIES")) {
				votemachine.getParties();
			} else if (scan.equals("HELP")) {
				System.out.println("Jou dikke mama");
			}
		}
	}
	
	public void showVotes(Map<String, Integer> votes) {
		
		for (String party : votes.keySet()) {
			System.out.println(party + "   " + votes.get(party));
		}

	}
	
	public void showParties(List<String> parties) {
		for (String party : parties) {
			System.out.println(party);
		}
	}
	
	public void showError(String e) {
		System.out.println(e);
	}



	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("party")) {
			votemachine.getParties();
		} else if (arg.equals("vote")) {
			votemachine.getVotes();
		}
		
		
	}

}
