import java.awt.*;
import java.awt.color.ColorSpace;
//import java.awt.color.ColorSpace;
import java.util.Random;

import javax.imageio.ImageIO;

import java.util.ArrayList;

//import java.nio.file.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
//import java.awt.image.ColorConvertOp;
//import java.io.*;
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game {
	
	static int day=1;
	static ArrayList<Country> dead_countries = new ArrayList<>();
	
	public static void main(String[] args)  throws IOException{
		Random random = new Random(); 
		
		
		Country america = new Country("America", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/flags/america.jpg");
		Country germany = new Country("Germany", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/flags/germany.png");
		Country brazil = new Country("Brazil", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/flags/brasil.png");
		Country russia = new Country("Russia", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/flags/russia.png");
		Country canada = new Country("Canada", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/flags/canada.png");
		Country england = new Country("England", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/flags/england.png");
		Country china = new Country("china", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/flags/china.png");
		Country ukraine = new Country("ukraine", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/flags/ukraine.jpg");
		Country argentina = new Country("argentina", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/flags/argentina.jpg");
		Country india = new Country("india", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/flags/india.png");
		Country chile = new Country("chile", random.nextInt(10), "/home/pedro/eclipse-workspace/HungerGames/flags/chile.jpg");
		
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
		
			try {
				save_image(all_countries, dead_countries);			
			}catch(Exception e) {
				System.out.println(e);
			}
			
			System.out.println("Day: "+ day + " Alive: " + all_countries.size());			
			all_countries = simulate_day(all_countries);
			day++;
			System.out.println("\n");
		
		}
		//save_image(all_countries.get(0),day, true);
		System.out.println("Winner: " + all_countries.get(0).name + " Kills:" + all_countries.get(0).kill_counter);
	}

	
	static ArrayList<Country> update_survivors(ArrayList<Country> a) {
		for(int i=0;i < a.size();i++) {
			if(!a.get(i).is_alive) {
				dead_countries.add(a.get(i)); // add dead country to the dead list
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
		for(int i=0;i<2;i++) {
			int rand_country = r.nextInt(a.size());
			Country c = a.get(rand_country);
			int rand_int = new Random().nextInt(Team.values().length);
			Team rand_team = Team.values()[rand_int];
			if(c.team != rand_team) {				
				c.join_team(rand_team);
				System.out.println(c.name+ " Joined " + c.team);
			}
		}
		for(int j=0;j<2;j++) {
			int rand_country1 = r.nextInt(a.size());
			int rand_country2 = r.nextInt(a.size());
			if(a.get(rand_country1).strength > a.get(rand_country2).strength) { // if country_a.strength > country_b.strength
				a.get(rand_country1).kill(a.get(rand_country2)); //country_a. kills country_b
				a = update_survivors(a);
			} else {
				a.get(rand_country2).kill(a.get(rand_country1)); // country_b. kills country_a
				a = update_survivors(a);
			}
		}

		
		//a = update_survivors(a);
		return a;
		
	}
	static void save_image(ArrayList<Country> a, ArrayList<Country> d) throws IOException {
		BufferedImage newimg = new BufferedImage(1100,1100,BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics =newimg.createGraphics();
		int x = 0;
		int y = 0;
		int row_counter = 1;
		int col_counter = 0;
		for(int i=0;i<a.size();i++) {
			
			Image image = javax.imageio.ImageIO.read(new File(a.get(i).image_path));
			image = image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
			
			//System.out.println(x+160*row_counter);
			//System.out.println(y+col_counter);
			graphics.drawImage(image,x+160*row_counter,y+col_counter,null);
			
			if(row_counter >= 3) {
				//System.out.println("GKGGHGHKJGHKJ");
				row_counter = 0;
				col_counter = col_counter + 100;
			}
			row_counter++;
		}
		
		for(int i=0;i<d.size();i++) {			
			try {

			    File file = new File(d.get(i).image_path);
			    Image image = ImageIO.read(file);
			    image =  image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		        BufferedImage buf_image = toBufferedImage(image);
		        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);  
		        ColorConvertOp op = new ColorConvertOp(cs, null);
		        BufferedImage image1 = op.filter(buf_image, null);


		        //image = buf_image;
				graphics.drawImage(image1,x+160*row_counter,y+col_counter,null);
				if(row_counter >= 3) {
					//System.out.println("GKGGHGHKJGHKJ");
					row_counter = 0;
					col_counter = col_counter + 100;
				}
				row_counter++;
				
				//ImageIO.write(result, "png", output);
				
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ImageIO.write(newimg,"png",new File("day_"+String.valueOf(day)+".png"));

	}
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
	
}
