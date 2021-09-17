import javax.swing.*;
import java.util.Scanner;
public class countries {
    public static void main(String[] args) {

    }
    public class Country {

        // instance variables
        private String name;
        private String capital;
        private double area;
        private double population;

        //to count the number of countries that have been created
        private int numCountriesCreated = 0;

        public Country(String name, String cap, double ar, double pop) {
            this.name = name; //here the use of "this" is necessary, to resolve the ambiguity
            //between the instance variable "name" and the input param with the same name
            capital = cap;
            area = ar;
            population = pop;
            numCountriesCreated++;
        }

        public Country(String China) {
            this(China, "Bijing", 1000, 10000);
        }
        public String getName() {
            return this.name;
        }
        public String getCapital() {
            return this.capital;
        }
        public double getArea() {
            return area;       // specifying "this" is optional
        }
        public double getPopulation() {
            return population;
        }
        public void setName(String newName) {
            this.name = newName;
        }

    }


}
