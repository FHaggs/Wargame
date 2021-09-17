import java.util.Random;
import java.util.ArrayList;

public class Game {
	
	
	
	public static void main(String[] args) {
		Random random = new Random(); 
		
		Country america = new Country("America", random.nextInt(10));
		Country germany = new Country("Germany", random.nextInt(10));
		Country brazil = new Country("Brazil", random.nextInt(10));
		Country russia = new Country("Russia", random.nextInt(10));
		Country canada = new Country("Canada", random.nextInt(10));
		Country england = new Country("England", random.nextInt(10));
		
		ArrayList<Country> all_countrys = new ArrayList<>(); // Create an ArrayList object
		// TODO: ArrayList<Country> all_dead_countrys = new ArrayList<>(); 
		
		all_countrys.add(america);
		all_countrys.add(germany);
		all_countrys.add(brazil);
		all_countrys.add(russia);
		all_countrys.add(canada);
		all_countrys.add(england);
		america.kill(germany);
		simulate_day(all_countrys);
		/**
		System.out.println(germany.is_alive);
		update_survivors(all_countrys);
		System.out.println(all_countrys.get(0));
		**/
	}
	static void update_survivors(ArrayList<Country> a) {
		for(int i=0;i < a.size();i++) {
			if(!a.get(i).is_alive) {
				System.out.println(a.get(i).name);
				a.remove(i);
			}
		}
	}
	static void simulate_day(ArrayList<Country> a) {
		// 3 random strength, 2 kills
		Random r = new Random();
		int bar = r.nextInt(4);
		a.get(5).change_strength(bar);
		
		//for(int i=0;i<3;)
	}
	

}
