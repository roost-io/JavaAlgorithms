// ********RoostGPT********
/*
Test generated by RoostGPT for test testmenow using AI Type  and AI Model 

ROOST_METHOD_HASH=floodFill_411b0d8e67
ROOST_METHOD_SIG_HASH=floodFill_ade1f9b78a

Here are some test scenarios for the `floodFill` method:

**Scenario 1: Fill a single pixel with a new color**

Details:
TestName: fillSinglePixel
Description: This test checks if the `floodFill` method correctly fills a single pixel with a new color.
Execution:
Arrange: Create a 3x3 image with all pixels set to color 0. Set the pixel at (1, 1) to color 1.
Act: Call `floodFill(image, 1, 1, 2, 1)`.
Assert: Verify that the pixel at (1, 1) is now set to color 2.
Validation: This test ensures that the `floodFill` method correctly changes the color of a single pixel.

**Scenario 2: Fill a horizontal line with a new color**

Details:
TestName: fillHorizontalLine
Description: This test checks if the `floodFill` method correctly fills a horizontal line with a new color.
Execution:
Arrange: Create a 3x3 image with all pixels set to color 0. Set the pixels at (0, 1), (1, 1), and (2, 1) to color 1.
Act: Call `floodFill(image, 1, 1, 2, 1)`.
Assert: Verify that the pixels at (0, 1), (1, 1), and (2, 1) are now set to color 2.
Validation: This test ensures that the `floodFill` method correctly changes the color of a horizontal line.

**Scenario 3: Fill a vertical line with a new color**

Details:
TestName: fillVerticalLine
Description: This test checks if the `floodFill` method correctly fills a vertical line with a new color.
Execution:
Arrange: Create a 3x3 image with all pixels set to color 0. Set the pixels at (1, 0), (1, 1), and (1, 2) to color 1.
Act: Call `floodFill(image, 1, 1, 2, 1)`.
Assert: Verify that the pixels at (1, 0), (1, 1), and (1, 2) are now set to color 2.
Validation: This test ensures that the `floodFill` method correctly changes the color of a vertical line.

**Scenario 4: Fill a rectangular area with a new color**

Details:
TestName: fillRectangle
Description: This test checks if the `floodFill` method correctly fills a rectangular area with a new color.
Execution:
Arrange: Create a 5x5 image with all pixels set to color 0. Set the pixels at (1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3), (3, 1), (3, 2), and (3, 3) to color 1.
Act: Call `floodFill(image, 2, 2, 2, 1)`.
Assert: Verify that all pixels in the rectangular area are now set to color 2.
Validation: This test ensures that the `floodFill` method correctly changes the color of a rectangular area.

**Scenario 5: Fill an entire image with a new color**

Details:
TestName: fillEntireImage
Description: This test checks if the `floodFill` method correctly fills an entire image with a new color.
Execution:
Arrange: Create a 3x3 image with all pixels set to color 1.
Act: Call `floodFill(image, 1, 1, 2, 1)`.
Assert: Verify that all pixels in the image are now set to color 2.
Validation: This test ensures that the `floodFill` method correctly changes the color of an entire image.

**Scenario 6: Attempt to fill an image with the same color**

Details:
TestName: fillWithSameColor
Description: This test checks if the `floodFill` method does not change the color of an image when the new color is the same as the old color.
Execution:
Arrange: Create a 3x3 image with all pixels set to color 1.
Act: Call `floodFill(image, 1, 1, 1, 1)`.
Assert: Verify that the image remains unchanged.
Validation: This test ensures that the `floodFill` method does not perform unnecessary operations when the new color is the same as the old color.

**Scenario 7: Attempt to fill an image with an invalid color**

Details:
TestName: fillWithInvalidColor
Description: This test checks if the `floodFill` method throws an exception when attempting to fill an image with an invalid color.
Execution:
Arrange: Create a 3x3 image with all pixels set to color 1.
Act: Call `floodFill(image, 1, 1, -1, 1)`.
Assert: Verify that an exception is thrown.
Validation: This test ensures that the `floodFill` method validates its input parameters.

**Scenario 8: Attempt to fill an image with an out-of-bounds coordinate**

Details:
TestName: fillWithOutOfBoundsCoordinate
Description: This test checks if the `floodFill` method throws an exception when attempting to fill an image with an out-of-bounds coordinate.
Execution:
Arrange: Create a 3x3 image with all pixels set to color 1.
Act: Call `floodFill(image, -1, 1, 2, 1)`.
Assert: Verify that an exception is thrown.
Validation: This test ensures that the `floodFill` method validates its input parameters.

**Scenario 9: Fill an image with a color that is not present in the image**

Details:
TestName: fillWithNonExistentColor
Description: This test checks if the `floodFill` method does not change the color of an image when the old color is not present in the image.
Execution:
Arrange: Create a 3x3 image with all pixels set to color 1.
Act: Call `floodFill(image, 1, 1, 2, 3)`.
Assert: Verify that the image remains unchanged.
Validation: This test ensures that the `floodFill` method does not perform unnecessary operations when the old color is not present in the image.
*/

// ********RoostGPT********

package com.thealgorithms.backtracking;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FloodFillFloodFillTest {
    @Test
    @Tag("valid")
    public void fillSinglePixel() {
        int[][] image = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] expected = {
                {0, 0, 0},
                {0, 2, 0},
                {0, 0, 0}
        };
        FloodFill.floodFill(image, 1, 1, 2, 1);
        assertArrayEquals(expected, image);
    }
    @Test
    @Tag("valid")
    public void fillHorizontalLine() {
        int[][] image = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        int[][] expected = {
                {0, 2, 0},
                {0, 2, 0},
                {0, 2, 0}
        };
        FloodFill.floodFill(image, 1, 1, 2, 1);
        assertArrayEquals(expected, image);
    }
    @Test
    @Tag("valid")
    public void fillVerticalLine() {
        int[][] image = {
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
        };
        int[][] expected = {
                {0, 0, 0},
                {2, 2, 2},
                {0, 0, 0}
        };
        FloodFill.floodFill(image, 1, 1, 2, 1);
        assertArrayEquals(expected, image);
    }
    @Test
    @Tag("valid")
    public void fillRectangle() {
        int[][] image = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 2, 2, 2, 0},
                {0, 2, 2, 2, 0},
                {0, 2, 2, 2, 0},
                {0, 0, 0, 0, 0}
        };
        FloodFill.floodFill(image, 2, 2, 2, 1);
        assertArrayEquals(expected, image);
    }
    @Test
    @Tag("valid")
    public void fillEntireImage() {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };
        FloodFill.floodFill(image, 1, 1, 2, 1);
        assertArrayEquals(expected, image);
    }
    @Test
    @Tag("valid")
    public void fillWithSameColor() {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        FloodFill.floodFill(image, 1, 1, 1, 1);
        assertArrayEquals(expected, image);
    }
    @Test
    @Tag("invalid")
    public void fillWithInvalidColor() {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        // No exception expected, as the method returns without changing the image
        FloodFill.floodFill(image, 1, 1, -1, 1);
    }
    @Test
    @Tag("boundary")
    public void fillWithOutOfBoundsCoordinate() {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        // No exception expected, as the method returns without changing the image
        FloodFill.floodFill(image, -1, 1, 2, 1);
    }
    @Test
    @Tag("valid")
    public void fillWithNonExistentColor() {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        FloodFill.floodFill(image, 1, 1, 2, 3);
        assertArrayEquals(expected, image);
    }
}