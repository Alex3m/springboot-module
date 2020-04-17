package academy.everyonecodes.data;

public class Countdown {
    private String id;
    private int count;

    public Countdown(int count) {
        this.count = count;
    }

    public Countdown() {
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Countdown{" +
                "id='" + id + '\'' +
                ", count=" + count +
                '}';
    }
}
