package academy.everyonecodes.logic.choices;

public abstract class Choice {
    private final int choiceNumber;

    protected Choice(int choiceNumber) {
        this.choiceNumber = choiceNumber;
    }

    public int getChoiceNumber() {
        return choiceNumber;
    }

    public abstract void performTheChoice();
}
