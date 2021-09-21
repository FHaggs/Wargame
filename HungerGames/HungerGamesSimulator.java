import java.util.ArrayList;

public class HungerGamesSimulator {
    static ArrayList<District> districts = new ArrayList<>();


    public static void main(String[] args) {
        District d1 = new District("District", 1);
        District d2 = new District("District", 2);
        District d3 = new District("District", 3);
        District d4 = new District("District", 4);
        District d5 = new District("District", 5);
        District d6 = new District("District", 6);
        District d7 = new District("District", 7);
        District d8 = new District("District", 8);
        District d9 = new District("District", 9);
        District d10 = new District("District", 10);
        District d11 = new District("District", 11);
        District d12 = new District("District", 12);
        districts.add(d1);
        districts.add(d2);
        districts.add(d3);
        districts.add(d4);
        districts.add(d5);
        districts.add(d6);
        districts.add(d7);
        districts.add(d8);
        districts.add(d9);
        districts.add(d10);
        districts.add(d11);
        districts.add(d12);

        d1.setPlayer(new Person("Monet", "Roblu", 29, d1));
        d1.setPlayer(new Person("Klaudia", "Kavoch", 34, d1));
        d2.setPlayer(new Person("Lara", "Nosr", 24, d2));
        d2.setPlayer(new Person("Margo", "Ad", 18, d2));
        d3.setPlayer(new Person("Mitch", "McGregor", 19, d3));
        d3.setPlayer(new Person("Porshe", "Koshovich", 22, d3));
        d4.setPlayer(new Person("Rita", "Cole", 23, d4));
        d4.setPlayer(new Person("Kal", "Mot", 31, d4));
        d5.setPlayer(new Person("Riccardo", "Shileni", 40, d5));
        d5.setPlayer(new Person("Richy", "Ochoa", 23, d5));
        d6.setPlayer(new Person("David", "Koth", 22, d6));
        d6.setPlayer(new Person("Michal", "Jones", 21, d6));
        d7.setPlayer(new Person("Kate", "Williams", 18, d7));
        d7.setPlayer(new Person("Vlad", "Jones", 18, d7));
        d8.setPlayer(new Person("Vladimir", "Miller", 19, d8));
        d8.setPlayer(new Person("Pedro", "Davis", 21, d8));
        d9.setPlayer(new Person("Polina", "Hero", 20, d9));
        d9.setPlayer(new Person("Paul", "Mtdoc", 23, d9));
        d10.setPlayer(new Person("James", "Aufdi", 31, d10));
        d10.setPlayer(new Person("Robert", "Gorsh", 26, d10));
        d11.setPlayer(new Person("Mark", "Davis", 18, d11));
        d11.setPlayer(new Person("Audin", "Wang", 19, d11));
        d12.setPlayer(new Person("Habib", "King", 24, d12));
        d12.setPlayer(new Person("Alex", "Shau", 17, d12));

        BeginFight fight = new BeginFight();

        for(District d : districts){
            fight.addAlive(d.getPlayer());

        }

        fight.start();
    }
}    