package ss.week5;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NaiveStrategy implements Strategy {
	
	private String name = "Naive";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int determineMove(Board b, Mark m) {
		Set<Integer> emptyfields = new HashSet<Integer>();
		Random random = new Random();
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			if (b.isEmptyField(i)) {
				emptyfields.add(i);
			}
		}
		return (int) emptyfields.toArray()[random.nextInt(emptyfields.size())];
	}

}
