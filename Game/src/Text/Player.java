package Text;

import java.util.ArrayList;
import java.util.TreeMap;

public class Player {

	protected int strength = 10;
	protected int intellect = 10;
	protected int charisma = 10;
	protected int constitution = 10;
	protected int dexterity = 10; //spelling might be off
	protected ArrayList<String> bag = new ArrayList<>();
	protected TreeMap<String, String> equipment = new TreeMap<>();
	protected float money;
	
	public int getStr() {
		return strength;
	}
	public void setStr(int num) {
		strength += num;
	}
	
	public int getInt() {
		return intellect;
	}
	public void setInt(int num) {
		intellect += num;
	}
	
	public int getCha() {
		return charisma;
	}
	public void setChar(int num) {
		charisma += num;
	}
	
	public int getCon() {
		return constitution;
	}
	public void setCon(int num) {
		constitution += num;
	}
	
	public int getDex() {
		return dexterity;
	}
	
	public void setDex(int num) {
		dexterity += num;
	}
	
	
}
