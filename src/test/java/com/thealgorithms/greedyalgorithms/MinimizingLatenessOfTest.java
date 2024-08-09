// ********RoostGPT********
/*
Test generated by RoostGPT for test java-algos using AI Type Claude AI and AI Model claude-3-5-sonnet-20240620
ROOST_METHOD_HASH=of_eb8138c6bc
ROOST_METHOD_SIG_HASH=of_7a04d5363c
================================VULNERABILITIES================================
Vulnerability: cwe-502: deserialization of untrusted data
Issue: The 'of' method creates a Job object from input parameters without validation, potentially allowing untrusted data to be deserialized if used with external input.
Solution: Implement input validation for all parameters before object creation. Use a builder pattern or factory method with proper checks.
Vulnerability: cwe-134: uncontrolled format string
Issue: The jobName parameter could contain format specifiers that might be interpreted if used in string formatting operations elsewhere in the code.
Solution: Sanitize the jobName input to remove or escape any potential format specifiers before using it in string operations.
Vulnerability: cwe-20: improper input validation
Issue: The method lacks input validation for processingTime and deadline, which could lead to logical errors or unexpected behavior if invalid values are provided.
Solution: Add input validation to ensure processingTime and deadline are positive integers and within acceptable ranges before object creation.
================================================================================
Based on the provided method and class information, here are several JUnit test scenarios for the `of` method:
```
Scenario 1: Create a Job with Valid Parameters
Details:
  TestName: createJobWithValidParameters
  Description: Test the creation of a Job object with valid input parameters.
Execution:
  Arrange: Prepare valid input parameters for jobName, processingTime, and deadline.
  Act: Call the of method with these parameters.
  Assert: Verify that a non-null Job object is returned and its properties match the input.
Validation:
  This test ensures that the of method correctly creates a Job object when given valid inputs. It's crucial for verifying the basic functionality of the Job creation process.
Scenario 2: Create a Job with Minimum Valid Values
Details:
  TestName: createJobWithMinimumValidValues
  Description: Test the creation of a Job object with the minimum acceptable values for processingTime and deadline.
Execution:
  Arrange: Set up a jobName, and use 1 for both processingTime and deadline (assuming these are the minimum valid values).
  Act: Invoke the of method with these parameters.
  Assert: Check that a Job object is created with the specified minimum values.
Validation:
  This test verifies that the of method can handle edge cases with minimum valid inputs, ensuring robustness in Job creation.
Scenario 3: Attempt to Create a Job with Null JobName
Details:
  TestName: createJobWithNullJobName
  Description: Test the behavior of the of method when passed a null jobName.
Execution:
  Arrange: Prepare null for jobName, and valid values for processingTime and deadline.
  Act: Call the of method with these parameters.
  Assert: Expect an IllegalArgumentException or similar exception to be thrown.
Validation:
  This test ensures that the method properly handles invalid input for jobName, maintaining data integrity and preventing null values in critical fields.
Scenario 4: Create a Job with Maximum Integer Values
Details:
  TestName: createJobWithMaxIntegerValues
  Description: Test the creation of a Job with maximum possible integer values for processingTime and deadline.
Execution:
  Arrange: Set up a valid jobName and use Integer.MAX_VALUE for both processingTime and deadline.
  Act: Call the of method with these parameters.
  Assert: Verify that a Job object is created with the maximum values set correctly.
Validation:
  This test checks the method's ability to handle extreme values, ensuring it doesn't break under high-stress scenarios.
Scenario 5: Attempt to Create a Job with Negative ProcessingTime
Details:
  TestName: createJobWithNegativeProcessingTime
  Description: Test the of method's response to a negative value for processingTime.
Execution:
  Arrange: Prepare a valid jobName, a negative value for processingTime, and a valid deadline.
  Act: Invoke the of method with these parameters.
  Assert: Expect an IllegalArgumentException or similar exception to be thrown.
Validation:
  This test ensures that the method properly validates the processingTime parameter, rejecting invalid negative values.
Scenario 6: Attempt to Create a Job with Negative Deadline
Details:
  TestName: createJobWithNegativeDeadline
  Description: Test the of method's behavior when given a negative value for the deadline.
Execution:
  Arrange: Set up a valid jobName, a valid processingTime, and a negative value for deadline.
  Act: Call the of method with these parameters.
  Assert: Expect an IllegalArgumentException or similar exception to be thrown.
Validation:
  This test verifies that the method correctly handles invalid input for the deadline parameter, maintaining the integrity of the Job object.
Scenario 7: Create a Job with Deadline Less Than ProcessingTime
Details:
  TestName: createJobWithDeadlineLessThanProcessingTime
  Description: Test the creation of a Job where the deadline is earlier than the processing time.
Execution:
  Arrange: Prepare a valid jobName, set processingTime to a value greater than the deadline.
  Act: Invoke the of method with these parameters.
  Assert: Verify that a Job object is created and check if the lateness field is properly calculated.
Validation:
  This test ensures that the method can handle scenarios where jobs are inherently late, and verifies the correct calculation of the lateness field.
```
These scenarios cover various aspects of the `of` method, including normal operation, edge cases, and error handling. They aim to thoroughly test the method's functionality and robustness.
*/
// ********RoostGPT********
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.*;

@Tag("com.thealgorithms.greedyalgorithms")
@Tag("com.thealgorithms.greedyalgorithms.of")
class MinimizingLatenessOfTest {

	@Test
	void createJobWithValidParameters() {
		Job job = Job.of("TestJob", 10, 20);
		assertNotNull(job);
		assertEquals("TestJob", job.jobName);
		assertEquals(10, job.processingTime);
		assertEquals(20, job.deadline);
	}

	@Test
	void createJobWithMinimumValidValues() {
		Job job = Job.of("MinJob", 1, 1);
		assertNotNull(job);
		assertEquals("MinJob", job.jobName);
		assertEquals(1, job.processingTime);
		assertEquals(1, job.deadline);
	}

	@Test
	void createJobWithNullJobName() {
		assertThrows(IllegalArgumentException.class, () -> Job.of(null, 10, 20));
	}

	@Test
	void createJobWithMaxIntegerValues() {
		Job job = Job.of("MaxJob", Integer.MAX_VALUE, Integer.MAX_VALUE);
		assertNotNull(job);
		assertEquals("MaxJob", job.jobName);
		assertEquals(Integer.MAX_VALUE, job.processingTime);
		assertEquals(Integer.MAX_VALUE, job.deadline);
	}

	@Test
	void createJobWithNegativeProcessingTime() {
		assertThrows(IllegalArgumentException.class, () -> Job.of("NegativeProcessing", -1, 20));
	}

	@Test
	void createJobWithNegativeDeadline() {
		assertThrows(IllegalArgumentException.class, () -> Job.of("NegativeDeadline", 10, -1));
	}

	@Test
	void createJobWithDeadlineLessThanProcessingTime() {
		Job job = Job.of("LateJob", 20, 10);
		assertNotNull(job);
		assertEquals("LateJob", job.jobName);
		assertEquals(20, job.processingTime);
		assertEquals(10, job.deadline);
		assertTrue(job.lateness > 0);
	}

	@ParameterizedTest
	@CsvSource({ "Job1, 5, 10", "Job2, 15, 20", "Job3, 30, 30" })
	void createJobWithVariousParameters(String jobName, int processingTime, int deadline) {
		Job job = Job.of(jobName, processingTime, deadline);
		assertNotNull(job);
		assertEquals(jobName, job.jobName);
		assertEquals(processingTime, job.processingTime);
		assertEquals(deadline, job.deadline);
	}

}