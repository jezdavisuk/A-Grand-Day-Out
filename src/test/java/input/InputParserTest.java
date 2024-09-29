package input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("When passed a single valid instruction of type String, returns array with single element of class Instruction matches user input.")
    void testParsesSingleValidInstruction() {

        //Arrange
        InputParser inputParser = new InputParser();

        ArrayList<Instruction> expectedLeft = new ArrayList<>(List.of(Instruction.L));
        ArrayList<Instruction> expectedRight = new ArrayList<>(List.of(Instruction.R));
        ArrayList<Instruction> expectedMove = new ArrayList<>(List.of(Instruction.M));

        //Act
        ArrayList<Instruction> actualLeft = inputParser.parseInstruction("L");
        ArrayList<Instruction> actualRight = inputParser.parseInstruction("R");
        ArrayList<Instruction> actualMove = inputParser.parseInstruction("M");

        // Assert
        assertAll(
                () -> assertEquals(expectedLeft, actualLeft),
                () -> assertEquals(expectedRight, actualRight),
                () -> assertEquals(expectedMove, actualMove)
        );
    }

}