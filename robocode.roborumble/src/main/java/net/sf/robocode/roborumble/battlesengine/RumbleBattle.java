package net.sf.robocode.roborumble.battlesengine;

public class RumbleBattle {
	private final String[] bots;
	private final String runonly;

	public RumbleBattle(String[] bots, String runonly) {
		this.bots = bots;
		this.runonly = runonly;
	}

	public String[] getBots() {
		return bots;
	}

	public String getRunonly() {
		return runonly;
	}

	@Override
	public String toString() {
		StringBuilder battle = new StringBuilder(bots[0]);

		for (int i = 1; i < bots.length; i++) {
			battle.append(',').append(bots[i]);
		}
		battle.append(',').append(runonly);

		return battle.toString();
	}
}
