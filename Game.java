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
		Country china = new Country("china", random.nextInt(10));
		Country ukraine = new Country("ukraine", random.nextInt(10));
		Country argentina = new Country("argentina", random.nextInt(10));
		Country india = new Country("india", random.nextInt(10));
		
		ArrayList<Country> all_countries = new ArrayList<>(); // Create an ArrayList object
		ArrayList<Country> all_dead_countries = new ArrayList<>(); 
		
		all_countries.add(america);
		all_countries.add(germany);
		all_countries.add(brazil);
		all_countries.add(russia);
		all_countries.add(canada);
		all_countries.add(england);
		all_countries.add(china);
		all_countries.add(ukraine);
		all_countries.add(argentina);
		all_countries.add(india);
		
		//all_dead_coutries = update_dead();
		all_countries = simulate_day(all_countries);
		//all_countries = update_survivors(all_countries);
		for(int i=0;i<all_countries.size();i++) {
			System.out.println(all_countries.get(i).name);
		}
		/**
		System.out.println(germany.is_alive);
		update_survivors(all_countries);
		System.out.println(all_countries.get(0));
		**/
	}
	static ArrayList<Country> update_dead(ArrayList<Country> alive_list, ArrayList<Country> dead_list){//not working, dumb design
		for(int i=0;i < alive_list.size();i++) {
			if(!alive_list.get(i).is_alive) {
				dead_list.add(alive_list.get(i));
			}
		}
		return dead_list;
	}
	
	static ArrayList<Country> update_survivors(ArrayList<Country> a) {
		for(int i=0;i < a.size();i++) {
			if(!a.get(i).is_alive) {
				//System.out.println(a.get(i).name);
				a.remove(i);
			}
		}
		return a;
	}
	static ArrayList<Country> simulate_day(ArrayList<Country> a) {
		// 3 random strength, 2 kills
		Random r = new Random();
		// 3 random changes to strength
		for(int i=0;i<3;i++) {
			int rand_country = r.nextInt(a.size());
			int rand_msg = r.nextInt(4);
			//System.out.println(rand_country +"  " +rand_msg);
			a.get(rand_country).change_strength(rand_msg);
		}
		for(int j=0;j<2;j++) {
			int rand_country1 = r.nextInt(a.size());
			int rand_country2 = r.nextInt(a.size());
			if(a.get(rand_country1).strength > a.get(rand_country2).strength) { // if country_a.strength > country_b.strength
				a.get(rand_country1).kill(a.get(rand_country2)); //country_a. kills country_b
			} else {
				a.get(rand_country2).kill(a.get(rand_country1)); // country_b. kills country_a
			}
		}
		a = update_survivors(a);
		return a;
		
	}
	

}
