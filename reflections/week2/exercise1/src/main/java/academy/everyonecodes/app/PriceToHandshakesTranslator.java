package academy.everyonecodes.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PriceToHandshakesTranslator {
    private final HandshakeNumberToMoveTranslator translator;
    private int minPrice;
    private int maxPrice;

    public PriceToHandshakesTranslator(
            @Value("${secretagent.minPrice}") int minPrice,
            @Value("${secretagent.maxPrice}") int maxPrice,
            HandshakeNumberToMoveTranslator translator) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.translator = translator;
    }

    public List<String> translate(int number) {
        List<String> moves = new ArrayList<>();
        if (isInPriceRange(number)) {
            String[] numberAsStrings = String.valueOf(number).split("");
            for (String digitAsString : numberAsStrings) {
                int digit = Integer.parseInt(digitAsString);
                String currentMove = translator.translate(digit);
                moves.add(currentMove);
            }
        }
        moves.removeAll(Arrays.asList(""));
        return moves;
    }

    private boolean isInPriceRange(int number) {
        return minPrice <= number && number <= maxPrice;
    }
}
