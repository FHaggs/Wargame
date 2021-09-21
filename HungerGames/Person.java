public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;
    private District district;
    private int kills = 0;

    public Person(String firstName, String lastName, int age, District district) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.district = district;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }



    public District getDistrict() {
        return district;
    }




    public int getKills() {
        return kills;
    }

    public void addKill() {
        this.kills++;
    }

    //public void printInfo() {
      //  System.out.println("Player Name: " + getName());
       // System.out.println("Player Age: " + age);
       // System.out.println("Player District: " + district);
   // }

    public int compareTo(Person o) {
        return o.getKills() - this.kills;
    }
}