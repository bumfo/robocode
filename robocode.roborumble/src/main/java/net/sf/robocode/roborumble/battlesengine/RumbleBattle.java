package net.sf.robocode.roborumble.battlesengine;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RumbleBattle {
	private final String[] bots;
	private final String runonly;

	private final Set<String> prioritizedBots;

	public RumbleBattle(String[] bots, String runonly) {
		this(bots, runonly, false);
	}

	public RumbleBattle(String[] bots, String runonly, boolean prioritized) {
		this.bots = bots;
		this.runonly = runonly;

		if (prioritized) {
			prioritizedBots = new HashSet<String>(Arrays.asList(bots[0], bots[1]));
		} else {
			prioritizedBots = Collections.emptySet();
		}
	}

	public String[] getBots() {
		return bots;
	}

	public String getRunonly() {
		return runonly;
	}

	public boolean shouldDumpResult(String botName) {
		return prioritizedBots.isEmpty() || prioritizedBots.contains(botName);
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
