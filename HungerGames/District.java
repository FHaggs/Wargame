public class District {
    private String name;
    private int number;
    private Person player;


    public District(String name, int number) {
        this.name = name;
        this.number = number;
    }



    public int getNumber() {
        return number;
    }

    public Person getPlayer() {
        return player;
    }

    public void setPlayer(Person player) {
        this.player = player;
    }


}
