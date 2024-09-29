package input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("When passed a single valid instruction of type String, returns array with single element of class Instruction matches user input.")
    void testParsesSingleValidInstruction() {

        //Arrange
        InputParser inputParser = new InputParser();

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

}