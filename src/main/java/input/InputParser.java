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



}
