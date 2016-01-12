package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PartyList extends Observable {
	
	private List<String> partys = new ArrayList<String>();
	
	public List<String> getParties() {
		return partys;
	}
	
	public void addParty(String party) {
		partys.add(party);
		setChanged();
		notifyObservers("party");
	}
	
	public boolean hasParty(String party) {
		return partys.contains(party);
	}

}
