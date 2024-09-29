package input;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private final Queue<Instruction> validatedInstructions = new LinkedList<>();

    public Queue<Instruction> getValidatedInstructions() {
        return validatedInstructions;
    }

    private static boolean validateInstructions(String input) {

        Predicate<String> isValid = string -> {
            Pattern pattern = Pattern.compile("[LRM]+", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(string);
            return matcher.matches();
        };

        return isValid.test(input);
    }

}
