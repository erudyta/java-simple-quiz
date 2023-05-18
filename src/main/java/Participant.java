public class Participant {
    private String name;
    private Score score;

    private Participant(ParticipantBuilder participantBuilder){
        this.name = participantBuilder.name;
        this.score = participantBuilder.score;
    }

    public String getName(){
        return name;
    }

    public Score getScore(){
        return score;
    }

    public static class ParticipantBuilder{
        private String name;
        private Score score;

        public ParticipantBuilder setName(String name){
            this.name = name;
            return this;
        }

        public  ParticipantBuilder setScore(Score score){
            this.score = score;
            return this;
        }

        public Participant build(){
            return new Participant(this);
        }

    }

}
