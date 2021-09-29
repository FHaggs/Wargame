

public class Country {
	public boolean is_alive;
	public String name;
	public Team team; 
	public String image_path;
	
	public int strength;
	public int daysAlive;
	public int kill_counter;
	
	public Country(String name, int strength, String image_path) {
		this.name = name;
		this.strength = strength;
		
		this.is_alive = true;
		this.daysAlive = 0;
		this.kill_counter = 0;
		this.image_path = image_path;
		
	}
	
	public void kill(Country p) {
		if(this.team == null || this.team != p.team && this.name != p.name) {
			System.out.println(this.name + " Killed: " + p.name);
			this.kill_counter++;
			p.is_alive = false;				
		}
	}
	public void join_team(Team rand_team) {
			this.team = rand_team;
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