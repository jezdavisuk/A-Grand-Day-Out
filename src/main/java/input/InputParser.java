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

    public void parseInstruction(String input) {

        List<String> inputList = new LinkedList<>(Arrays.asList(input.split("")));

        inputList.stream()
                .filter(InputParser::validateInstructions)
                .map(String::toUpperCase)
                .forEach(this::queueInstructions);
    }

    private static boolean validateInstructions(String input) {

        Predicate<String> isValid = string -> {
            Pattern pattern = Pattern.compile("[LRM]+", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(string);
            return matcher.matches();
        };

        return isValid.test(input);
    }

    private void queueInstructions(String input) {

        Consumer<String> queueInstruction = string -> validatedInstructions.add(Instruction.valueOf(string));

        queueInstruction.accept(input);
    }

}
