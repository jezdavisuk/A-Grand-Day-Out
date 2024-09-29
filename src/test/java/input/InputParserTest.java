package input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    private static InputParser inputParser;
    private static int count = 0;

    @Test
    @DisplayName("When passed a single valid instruction of type String, returns Instruction to match user input.")
    void testParsesSingleValidInstruction() {

        //Arrange
        inputParser = new InputParser();

        Instruction expectedLeft = Instruction.L;
        Instruction expectedRight = Instruction.R;
        Instruction expectedMove = Instruction.M;

        //Act
        inputParser.parseInstruction("L");
        inputParser.parseInstruction("R");
        inputParser.parseInstruction("M");

        Instruction actualLeft = inputParser.getValidatedInstructions().poll();
        Instruction actualRight = inputParser.getValidatedInstructions().poll();
        Instruction actualMove = inputParser.getValidatedInstructions().poll();

        // Assert
        assertAll(
                () -> assertEquals(expectedLeft, actualLeft),
                () -> assertEquals(expectedRight, actualRight),
                () -> assertEquals(expectedMove, actualMove)
        );
    }

    @Test
    @DisplayName("When passed multiple consecutive valid instructions of type String, returns matching elements of class Instruction.")
    void testParsesMultipleValidInstructions() {

        //Arrange
        inputParser = new InputParser();

        List<Instruction> expectedFirstLog = List.of(Instruction.L,Instruction.R,Instruction.M);
        List<Instruction> expectedSecondLog = List.of(Instruction.M,Instruction.L,Instruction.L,Instruction.R);
        List<Instruction> expectedThirdLog = List.of(Instruction.R,Instruction.R,Instruction.M,Instruction.L,Instruction.L,Instruction.L,Instruction.M);

        List<Instruction> actualFirstLog = new ArrayList<>();
        List<Instruction> actualSecondLog = new ArrayList<>();
        List<Instruction> actualThirdLog = new ArrayList<>();

        //Act
        inputParser.parseInstruction("LRM");
        while (count < 3) actualFirstLog.add(getInstruction());
        inputParser.parseInstruction("MLLR");
        while (count < 7) actualSecondLog.add(getInstruction());
        inputParser.parseInstruction("RRMLLLM");
        while (count < 14) actualThirdLog.add(getInstruction());

        // Assert
        assertAll(
                () -> assertEquals(expectedFirstLog, actualFirstLog),
                () -> assertEquals(expectedSecondLog, actualSecondLog),
                () -> assertEquals(expectedThirdLog, actualThirdLog)
        );
    }

    private static Instruction getInstruction() {
        count++;
        return inputParser.getValidatedInstructions().poll();
    }

}