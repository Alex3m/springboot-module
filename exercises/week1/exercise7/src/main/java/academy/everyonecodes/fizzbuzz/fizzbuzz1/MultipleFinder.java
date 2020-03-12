package academy.everyonecodes.fizzbuzz.fizzbuzz1;

public class MultipleFinder {
    private int multiple;
    private String wordForMultiple;

    public MultipleFinder(int multiple, String wordForMultiple) {
        this.multiple = multiple;
        this.wordForMultiple = wordForMultiple;
    }

    public boolean isMultiple(int number) {
        return number % multiple == 0;
    }


    public String getWordForMultiple() {
        return wordForMultiple;
    }
}
