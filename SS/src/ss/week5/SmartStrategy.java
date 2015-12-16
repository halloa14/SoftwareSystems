package ss.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SmartStrategy implements Strategy {
	
	private String name = "Smart";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int determineMove(Board b, Mark m) {
		List<Integer> emptyfields = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			if (b.isEmptyField(i)) {
				emptyfields.add(i);
			}
		}
		if (emptyfields.contains(4)) {
			return 4;
		}
		for (Integer emptyfield : emptyfields) {
			Board deepcopy = b.deepCopy();
			deepcopy.setField(emptyfield, m);
			if (deepcopy.isWinner(m)) {
				return emptyfield;
			}
		}
		for (Integer emptyfield : emptyfields) {
			Board deepcopy = b.deepCopy();
			deepcopy.setField(emptyfield, m.other());
			if (deepcopy.isWinner(m.other())) {
				return emptyfield;
			}
		}
		return (int) emptyfields.toArray()[random.nextInt(emptyfields.size())];
		

	}
	


}
