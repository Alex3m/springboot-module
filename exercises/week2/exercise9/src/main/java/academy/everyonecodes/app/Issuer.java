package academy.everyonecodes.app;

import java.util.Set;

public class Issuer {
    private String name;
    private Set<String> startsWith;
    private Set<Integer> lengths;

    public Issuer() {
    }

    public Issuer(String name, Set<String> startsWith, Set<Integer> lengths) {
        this.name = name;
        this.startsWith = startsWith;
        this.lengths = lengths;
    }

    void setName(String name) {
        this.name = name;
    }

    void setStartsWith(Set<String> startsWith) {
        this.startsWith = startsWith;
    }

    void setLengths(Set<Integer> lengths) {
        this.lengths = lengths;
    }

    public String getName() {
        return name;
    }


    public boolean issues(String creditCardNumber) {
        if (lengths.contains(creditCardNumber.length())) {
            return startsWith.stream()
                    .anyMatch(startDigits-> creditCardNumber.startsWith(startDigits));
        }
        return false;
    }
}
