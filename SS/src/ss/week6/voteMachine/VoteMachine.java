package ss.week6.voteMachine;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {
	
	PartyList partylist;
	VoteList votelist;
	VoteView votetuiview;
	
	public VoteMachine() {
		partylist = new PartyList();
    	votelist = new VoteList();
    	votetuiview = new VoteGUIView(this);
    	partylist.addObserver(votetuiview);
    	votelist.addObserver(votetuiview);
    	
	}
	
	public void addParty(String party) {
		partylist.addParty(party);
	}
	
	public void vote(String party) {
		votelist.addVote(party);
	}
	
	public void getParties() {
		votetuiview.showParties(partylist.getParties());
	}
	
	public void getVotes() {
		votetuiview.showVotes(votelist.getVotes());
	}
	
	public void start() {
		votetuiview.start();
	}
	
    public static void main(String[] args) {
        
    	VoteMachine votemachine = new VoteMachine();
    	votemachine.start();
    }

}
