import java.util.ArrayList;
import java.util.Collections;


public class BeginFight {

    private ArrayList<Person> alive = new ArrayList<>();
    private ArrayList<Person> dead = new ArrayList<>();
    private int day = 0;

    public BeginFight() {
    }

    public void addAlive(Person p) {
        this.alive.add(p);
    }



    public void start() {
        System.out.println("\n");
        System.out.println("Announcment: 'Welcome To Today's Match!'");
        System.out.println("\n");

        while (alive.size() > 1){
            int p1Pos = randPos(alive.size());
            int p2Pos;
            do {
                p2Pos = randPos(alive.size());
            } while(p1Pos == p2Pos);
            Person p1 = alive.get(p1Pos);
            Person p2 = alive.get(p2Pos);
            if(Math.random() < 0.5){
                processKill(p1, p2, p2Pos);
            } else {
                processKill(p2, p1, p1Pos);
            }
            System.out.println();
        }
        System.out.println("\n"+ alive.get(0).getName() + " from District " + alive.get(0).getDistrict().getNumber() + " Wins!!!");

        dead.add(alive.get(0));
        Collections.sort(dead);

        System.out.println("\nThe Top 3 Killers Were:");
        for(int i = 0; i < 3; i++) {
            System.out.println(dead.get(i).getName() + " With: " + dead.get(i).getKills());
        }
    }

    private void processKill(Person killer, Person killed, int killedPos) {
        this.day += 1;
        System.out.println("Day " + day);

        killer.addKill();
        System.out.println(killer.getName() + " kills " + killed.getName());
        System.out.print(killer.getFirstName() + " Now Has " + killer.getKills());
        if(killer.getKills() == 1) System.out.println(" Kill!");
        else System.out.println(" Kills!");
        alive.remove(killedPos);
        dead.add(killed);
    }


    private int randPos(int size){
        double n = Math.random() * size;
        int r = (int)Math.floor(n);
        return r;
    }
}

