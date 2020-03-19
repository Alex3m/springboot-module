package academy.everyonecodes.app;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CreditCards {
    private final Set<Issuer> issuers;
    private final Luhn luhn;

    public CreditCards(Set<Issuer> issuers, Luhn luhn) {
        this.issuers = issuers;
        this.luhn = luhn;
    }

    public String inspect(String creditCardNumber) {
        if (luhn.isValid(creditCardNumber)) {
            return issuers.stream()
                    .filter(issuer -> issuer.issues(creditCardNumber))
                    .map(Issuer::getName)
                    .findFirst()
                    .orElse("Not Supported");
        }
        return "Invalid";
    }
}
