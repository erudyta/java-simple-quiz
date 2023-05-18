public class Participant {
    private String name;
    private int score=0;

    public Participant(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void dodajPunkt(){
        score++;
    }


}
