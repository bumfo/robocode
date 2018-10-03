/**
 * Copyright (c) 2001-2018 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 */
package net.sf.robocode.roborumble.battlesengine;


import java.io.*;
import java.util.ArrayList;

/**
 * The BattlesFile maintains Battles to run by BattlesRunner
 */
public final class BattlesFile {
	private final String filename;
	private PrintStream outtxt;

	public BattlesFile(String filename) {
		this.filename = filename;
	}

	public boolean readRobots(ArrayList<String> robots) {
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(filename);
			br = new BufferedReader(fr);

			String record;
			while ((record = br.readLine()) != null) {
				robots.add(record);
			}
		} catch (IOException e) {
			System.out.println("Battles input file not found ... Aborting");
			System.out.println(e);
			return true;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ignore) {}
			}
		}
		return false;
	}

	public boolean openWrite() {
		try {
			outtxt = new PrintStream(new BufferedOutputStream(new FileOutputStream(filename)), false);
		} catch (IOException e) {
			System.out.println("Not able to open battles file " + filename + " ... Aborting");
			System.out.println(e);
			return false;
		}
		return true;
	}

	public void closeWrite() {
		outtxt.close();
	}

	public void writeBattle(String[] bots, String runonly) {
		StringBuilder battle = new StringBuilder(bots[0]);

		for (int i = 1; i < bots.length; i++) {
			battle.append(',').append(bots[i]);
		}
		battle.append(',').append(runonly);

		outtxt.println(battle);
	}
}
