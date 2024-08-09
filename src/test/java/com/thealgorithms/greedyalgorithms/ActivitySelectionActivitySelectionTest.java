// ********RoostGPT********
/*
Test generated by RoostGPT for test java-algos using AI Type Claude AI and AI Model claude-3-5-sonnet-20240620
ROOST_METHOD_HASH=activitySelection_77631a6e2d
ROOST_METHOD_SIG_HASH=activitySelection_bf79d28a9f
================================VULNERABILITIES================================
Vulnerability: cwe-190: integer overflow or wraparound
Issue: The code uses int for array indices and lengths, which could lead to integer overflow if very large input arrays are provided. This could result in unexpected behavior or crashes.
Solution: Use long instead of int for array indices and lengths, or implement input validation to ensure array sizes are within safe limits.
Vulnerability: cwe-400: uncontrolled resource consumption
Issue: The method doesn't limit the size of input arrays, potentially leading to excessive memory consumption or processing time with large inputs.
Solution: Implement input validation to limit the maximum size of input arrays, or use a more memory-efficient algorithm for large inputs.
Vulnerability: cwe-476: null pointer dereference
Issue: The method doesn't check if input arrays are null before accessing them, which could lead to NullPointerException.
Solution: Add null checks for input arrays at the beginning of the method and throw an appropriate exception if they are null.
Vulnerability: cwe-597: use of wrong operator in string comparison
Issue: While not directly present in this code, developers using this method might mistakenly use '==' instead of '.equals()' when comparing activity indices, leading to unexpected behavior.
Solution: Add a comment or documentation emphasizing the use of '.equals()' for comparing Integer objects when working with the returned ArrayList.
================================================================================
Based on the provided method and imports, here are several test scenarios for the `activitySelection` method:
```
Scenario 1: Basic Activity Selection
Details:
  TestName: basicActivitySelection
  Description: Test the basic functionality of activity selection with a simple set of non-overlapping activities.
Execution:
  Arrange: Create arrays for start times and end times with non-overlapping activities.
  Act: Call activitySelection with the arranged start and end times.
  Assert: Verify that the returned ArrayList contains the expected activity indices in the correct order.
Validation:
  This test ensures that the method correctly selects all activities when they don't overlap. It validates the core functionality of the activity selection algorithm.
Scenario 2: Overlapping Activities
Details:
  TestName: overlappingActivities
  Description: Test the method's ability to select the maximum number of non-overlapping activities from a set of overlapping activities.
Execution:
  Arrange: Create arrays for start times and end times with some overlapping activities.
  Act: Call activitySelection with the arranged start and end times.
  Assert: Verify that the returned ArrayList contains the indices of the maximum set of non-overlapping activities.
Validation:
  This test checks if the method correctly handles overlapping activities and selects the optimal set of non-overlapping activities. It validates the core logic of the greedy algorithm used in activity selection.
Scenario 3: Empty Input Arrays
Details:
  TestName: emptyInputArrays
  Description: Test the method's behavior when given empty input arrays.
Execution:
  Arrange: Create empty arrays for start times and end times.
  Act: Call activitySelection with the empty arrays.
  Assert: Verify that the method returns an empty ArrayList.
Validation:
  This test ensures that the method handles edge cases correctly, specifically when no activities are provided. It's important to validate that the method doesn't throw exceptions and returns an expected result for edge cases.
Scenario 4: Single Activity
Details:
  TestName: singleActivity
  Description: Test the method's behavior when given a single activity.
Execution:
  Arrange: Create arrays for start times and end times with only one activity.
  Act: Call activitySelection with the single-activity arrays.
  Assert: Verify that the returned ArrayList contains only one element with the index 0.
Validation:
  This test checks if the method correctly handles the case of a single activity, ensuring it's selected and returned properly. It's a boundary case that needs to be validated.
Scenario 5: Activities with Same End Time
Details:
  TestName: activitiesWithSameEndTime
  Description: Test the method's behavior when multiple activities have the same end time.
Execution:
  Arrange: Create arrays for start times and end times where multiple activities end at the same time.
  Act: Call activitySelection with the arranged start and end times.
  Assert: Verify that the returned ArrayList contains the correct selection of activities, prioritizing those with earlier start times when end times are the same.
Validation:
  This test ensures that the method correctly handles activities with identical end times, which tests the stability of the sorting algorithm and the selection process.
Scenario 6: Activities with Same Start Time
Details:
  TestName: activitiesWithSameStartTime
  Description: Test the method's behavior when multiple activities have the same start time.
Execution:
  Arrange: Create arrays for start times and end times where multiple activities start at the same time.
  Act: Call activitySelection with the arranged start and end times.
  Assert: Verify that the returned ArrayList contains the correct selection of activities, prioritizing those with earlier end times.
Validation:
  This test checks if the method correctly handles activities with identical start times, ensuring that the selection is based on end times in such cases.
Scenario 7: Large Number of Activities
Details:
  TestName: largeNumberOfActivities
  Description: Test the method's performance and correctness with a large number of activities.
Execution:
  Arrange: Create large arrays for start times and end times with many activities.
  Act: Call activitySelection with the large arrays.
  Assert: Verify that the returned ArrayList contains a correct selection of non-overlapping activities and that the execution time is within acceptable limits.
Validation:
  This test ensures that the method scales well with a large number of activities and maintains correctness. It helps validate the efficiency of the algorithm implementation.
```
These test scenarios cover various aspects of the `activitySelection` method, including basic functionality, edge cases, and potential performance considerations. They aim to validate the correctness and robustness of the implementation across different input scenarios.
*/
// ********RoostGPT********
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Comparator;
import org.junit.jupiter.api.*;

@Tag("com.thealgorithms.sorts")
@Tag("com.thealgorithms.sorts.sort")
@Tag("com.thealgorithms.misc")
@Tag("com.thealgorithms.misc.add")
@Tag("com.thealgorithms.misc.add")
@Tag("com.thealgorithms.greedyalgorithms")
@Tag("com.thealgorithms.greedyalgorithms.activitySelection")
class ActivitySelectionActivitySelectionTest {

	@Test
	void basicActivitySelection() {
		int[] startTimes = { 1, 3, 0, 5, 8, 5 };
		int[] endTimes = { 2, 4, 6, 7, 9, 9 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 3, 4));

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isEqualTo(expected);
	}

	@Test
	void overlappingActivities() {
		int[] startTimes = { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
		int[] endTimes = { 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 3, 7, 10));

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isEqualTo(expected);
	}

	@Test
	void emptyInputArrays() {
		int[] startTimes = {};
		int[] endTimes = {};
		ArrayList<Integer> expected = new ArrayList<>();

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isEmpty();
	}

	@Test
	void singleActivity() {
		int[] startTimes = { 1 };
		int[] endTimes = { 2 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isEqualTo(expected);
	}

	@Test
	void activitiesWithSameEndTime() {
		int[] startTimes = { 1, 3, 2, 5 };
		int[] endTimes = { 4, 4, 4, 6 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 3));

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isEqualTo(expected);
	}

	@Test
	void activitiesWithSameStartTime() {
		int[] startTimes = { 1, 1, 1, 4 };
		int[] endTimes = { 2, 3, 4, 5 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 3));

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isEqualTo(expected);
	}

	@Test
	void largeNumberOfActivities() {
		int[] startTimes = new int[1000];
		int[] endTimes = new int[1000];
		for (int i = 0; i < 1000; i++) {
			startTimes[i] = i;
			endTimes[i] = i + 1;
		}
		ArrayList<Integer> expected = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			expected.add(i);
		}

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@MethodSource("provideTestCases")
	void parameterizedActivitySelectionTest(int[] startTimes, int[] endTimes, ArrayList<Integer> expected) {
		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
		assertThat(result).isEqualTo(expected);
	}

	private static Stream<Arguments> provideTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 1, 3, 0, 5, 8, 5 }, new int[] { 2, 4, 6, 7, 9, 9 },
						new ArrayList<>(Arrays.asList(0, 1, 3, 4))),
				Arguments.of(new int[] { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 },
						new int[] { 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16 },
						new ArrayList<>(Arrays.asList(0, 3, 7, 10))),
				Arguments.of(new int[] {}, new int[] {}, new ArrayList<>()),
				Arguments.of(new int[] { 1 }, new int[] { 2 }, new ArrayList<>(Arrays.asList(0))),
				Arguments.of(new int[] { 1, 3, 2, 5 }, new int[] { 4, 4, 4, 6 }, new ArrayList<>(Arrays.asList(0, 3))),
				Arguments.of(new int[] { 1, 1, 1, 4 }, new int[] { 2, 3, 4, 5 }, new ArrayList<>(Arrays.asList(0, 3))));
	}

}