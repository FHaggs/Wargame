import java.util.Random;

import javax.imageio.ImageIO;

import java.util.ArrayList;

import java.nio.file.*;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;

public class Game {
	
	static int day=1;
	
	public static void main(String[] args) throws IOException {
		Random random = new Random(); 
		
		
		Country america = new Country("America", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/scr/flags/brasil.png");
		Country germany = new Country("Germany", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/scr/flags/germany.png");
		Country brazil = new Country("Brazil", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/scr/flags/brasil.png");
		Country russia = new Country("Russia", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/scr/flags/russia.png");
		Country canada = new Country("Canada", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/scr/flags/canada.png");
		Country england = new Country("England", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/scr/flags/england.png");
		Country china = new Country("china", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/scr/flags/china.png");
		Country ukraine = new Country("ukraine", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/scr/flags/ukraine.jpg");
		Country argentina = new Country("argentina", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/scr/flags/argentina.jpg");
		Country india = new Country("india", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/scr/flags/india.png");
		Country chile = new Country("chile", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/scr/flags/chile.jpg");
		
		ArrayList<Country> all_countries = new ArrayList<>(); // Create an ArrayList object
		 
		
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
		all_countries.add(chile);
		
		while(all_countries.size()>1) {
			//for(i=0;i<)
			System.out.println("Day: "+ day + " Alive: " + all_countries.size());			
			all_countries = simulate_day(all_countries);
			day++;
			System.out.println("\n");
		
		}
		//save_image(all_countries.get(0),day, true);
		System.out.println("Winner: " + all_countries.get(0).name + " Kills:" + all_countries.get(0).kill_counter);
		save_image(all_countries.get(0), day, true);
		//all_countries = update_survivors(all_countries);

		/**
		update_survivors(all_countries);
		System.out.println(all_countries.get(0));
		**/
	}

	
	static ArrayList<Country> update_survivors(ArrayList<Country> a) {
		for(int i=0;i < a.size();i++) {
			if(!a.get(i).is_alive) {
				//System.out.println(a.get(i).name);
				try {					
					//save_image(a.get(i), day, false);
				}catch(Exception e){
					System.out.println("EEEEEEE");
				}
				a.remove(i);
				//Save Image to dead list
			}else {
				try {					
					//save_image(a.get(i), day, true);
				}catch(Exception e){
					System.out.println("EEEEEEE");
				}
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
		for(int i=0;i<2;i++) {
			int rand_country = r.nextInt(a.size());
			Country c = a.get(rand_country);
			c.join_team();
			System.out.println(c.name+ " Joined " + c.team);
		}
		for(int j=0;j<2;j++) {
			int rand_country1 = r.nextInt(a.size());
			int rand_country2 = r.nextInt(a.size());
			if(a.get(rand_country1).strength > a.get(rand_country2).strength) { // if country_a.strength > country_b.strength
				a.get(rand_country1).kill(a.get(rand_country2)); //country_a. kills country_b
				//a = update_survivors(a);
			} else {
				a.get(rand_country2).kill(a.get(rand_country1)); // country_b. kills country_a
				//a = update_survivors(a);
			}
		}

		a = update_survivors(a);
		return a;
		
	}
	static void save_image(Country c, int day, boolean alive) throws IOException {
		String path = c.image_path;
		String final_path;
		if(alive) {
			final_path = "images_" + String.valueOf(day) + "_alive";			
		}else {
			final_path = "images_" + String.valueOf(day) + "_dead";
		}
		Image image = javax.imageio.ImageIO.read(new File("germany.png"));
		// resize it
		image = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		// create a new image to render to
		BufferedImage newimg = new BufferedImage(200,100,BufferedImage.TYPE_INT_ARGB);
		// get graphics to draw..
		Graphics2D graphics =newimg.createGraphics();
		//draw the other image on it
		graphics.drawImage(image,0,0,null);
		graphics.drawImage(image,100,0,null);
		graphics.fillOval(20,20,40,40); //making it a bit ugly ;)
		//export the new image
		ImageIO.write(newimg,"png",new File("output.png"));

	}
	

}
