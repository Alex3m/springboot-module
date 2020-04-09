package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.data.Summary;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Summary> summaries = new ArrayList<>();

    public void addSummary(Summary summary) {
        summaries.add(summary);
    }

    public List<Summary> getSummaries() {
        return summaries;
    }
}
