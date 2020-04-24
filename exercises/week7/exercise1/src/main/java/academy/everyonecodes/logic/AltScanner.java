package academy.everyonecodes.logic;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class AltScanner {
    private Scanner scanner = new Scanner(System.in);

    public int nextInteger() {
        return scanner.nextInt();
    }

    public String nextString() {
        return scanner.nextLine();
    }
}
