package academy.everyonecodes.data;

public class Accumulation {
    private String id;
    private int times;

    public Accumulation(int times) {
        this.times = times;
    }

    public Accumulation() {
    }

    public String getId() {
        return id;
    }

     public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
