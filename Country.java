//package HungerGames.scr;
import java.util.Random;


public class Country {
	public boolean is_alive;
	public String name;
	public Team team; 
	
	public int strength;
	public int daysAlive;
	public int kill_counter;
	
	public Country(String name, int strength) {
		this.name = name;
		this.strength = strength;
		
		this.is_alive = true;
		this.daysAlive = 0;
		this.kill_counter = 0;
		
	}
	
	public void kill(Country p) {
		if(this.team == null || this.team != p.team) {
			System.out.println(this.name + " Killed: " + p.name);
			this.kill_counter++;
			p.is_alive = false;				
		}
	}
	public void join_team() {
		int rand_int = new Random().nextInt(Team.values().length);
		this.team = Team.values()[rand_int];
	}
	public void change_strength(int random_num) {
		String msg1 = " :General has been killed, -1 point of strength: ";
		String msg2 = " :Tanks with engine problems, -1 point of strength: ";
		String msg3 = " :+1 point of strength: ";
		String msg4 = " :Scientits developed a new weapon, +1 point of strength: ";
		switch (random_num) {
		case 0:
			System.out.println(this.name + msg1 + this.strength);
			this.strength--;
			break;
		case 1:
			System.out.println(this.name + msg2 + this.strength);
			this.strength--;
			break;
		case 2:
			System.out.println(this.name + msg3 + this.strength);
			this.strength++;
			break;
		case 3:
			System.out.println(this.name + msg4 + this.strength);
			this.strength++;
			break;
		}
		
	}
}