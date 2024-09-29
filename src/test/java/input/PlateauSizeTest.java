package input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlateauSizeTest {

    @Test
    @DisplayName("Instance variables dimX and dimY take assigned parameters to the PlateauSize constructor when those parameters are of size no less than 20 and no greater than 100.")
    void testInstantiatePlateauSizeCorrectDimensionsValidParams() {

        //Arrange
        PlateauSize plateauSize1;
        PlateauSize plateauSize2;
        PlateauSize plateauSize3;

        int[][] expectedDims = { {30, 80}, {60, 20}, {100, 50} };

        //Act
        plateauSize1 = new PlateauSize(expectedDims[0][0], expectedDims[0][1]);
        plateauSize2 = new PlateauSize(expectedDims[1][0], expectedDims[1][1]);
        plateauSize3 = new PlateauSize(expectedDims[2][0], expectedDims[2][1]);

        int[] actualDimsPlat1 = { plateauSize1.getxDim(), plateauSize1.getyDim()};
        int[] actualDimsPlat2 = { plateauSize2.getxDim(), plateauSize2.getyDim()};
        int[] actualDimsPlat3 = { plateauSize3.getxDim(), plateauSize3.getyDim()};

        int[][] actualDims = { actualDimsPlat1, actualDimsPlat2, actualDimsPlat3 };

        // Assert
        assertArrayEquals(expectedDims, actualDims);
    }

}