
// ********RoostGPT********
/*
Test generated by RoostGPT for test java-unitdemo using AI Type  and AI Model

ROOST_METHOD_HASH=encrypt_2fa104da27
ROOST_METHOD_SIG_HASH=encrypt_3045562d7b

Based on the provided Vigenere class and its encrypt method, here are several test scenarios for the encrypt method:

```
Scenario 1: Encrypt a simple message with a single-letter key

Details:
  TestName: encryptSimpleMessageWithSingleLetterKey
  Description: Test the encryption of a basic message using a single-letter key.
Execution:
  Arrange: Create a Vigenere instance and prepare a simple message and key.
  Act: Call the encrypt method with the message and key.
  Assert: Compare the encrypted result with the expected output.
Validation:
  Verify that each letter in the message is shifted correctly according to the key. This test ensures the basic functionality of the Vigenere cipher for a simple case.

Scenario 2: Encrypt a message with a multi-letter key

Details:
  TestName: encryptMessageWithMultiLetterKey
  Description: Test the encryption of a message using a key with multiple letters.
Execution:
  Arrange: Create a Vigenere instance and prepare a message and a multi-letter key.
  Act: Call the encrypt method with the message and key.
  Assert: Compare the encrypted result with the expected output.
Validation:
  Confirm that the key is applied cyclically and each letter in the message is shifted correctly. This test verifies the proper handling of keys longer than one character.

Scenario 3: Encrypt a message with mixed case letters

Details:
  TestName: encryptMessageWithMixedCase
  Description: Test the encryption of a message containing both uppercase and lowercase letters.
Execution:
  Arrange: Create a Vigenere instance and prepare a mixed-case message and key.
  Act: Call the encrypt method with the message and key.
  Assert: Compare the encrypted result with the expected output.
Validation:
  Ensure that uppercase and lowercase letters are encrypted correctly while maintaining their original case. This test verifies the method's ability to handle different letter cases.

Scenario 4: Encrypt a message with non-alphabetic characters

Details:
  TestName: encryptMessageWithNonAlphabeticCharacters
  Description: Test the encryption of a message containing non-alphabetic characters.
Execution:
  Arrange: Create a Vigenere instance and prepare a message with letters, numbers, and symbols.
  Act: Call the encrypt method with the message and a key.
  Assert: Compare the encrypted result with the expected output.
Validation:
  Verify that non-alphabetic characters remain unchanged in the encrypted output while alphabetic characters are properly encrypted. This test ensures the method correctly handles mixed content.

Scenario 5: Encrypt an empty message

Details:
  TestName: encryptEmptyMessage
  Description: Test the encryption of an empty message.
Execution:
  Arrange: Create a Vigenere instance and prepare an empty message and a key.
  Act: Call the encrypt method with the empty message and key.
  Assert: Verify that the result is an empty string.
Validation:
  Confirm that the method handles empty input correctly without throwing exceptions. This test checks the edge case of an empty message.

Scenario 6: Encrypt a message with an empty key

Details:
  TestName: encryptMessageWithEmptyKey
  Description: Test the encryption of a message using an empty key.
Execution:
  Arrange: Create a Vigenere instance and prepare a message and an empty key.
  Act: Call the encrypt method with the message and empty key.
  Assert: Verify that the result matches the input message.
Validation:
  Ensure that the method handles an empty key gracefully, returning the original message unchanged. This test checks the edge case of an empty key.

Scenario 7: Encrypt a long message with a short key

Details:
  TestName: encryptLongMessageWithShortKey
  Description: Test the encryption of a message much longer than the key.
Execution:
  Arrange: Create a Vigenere instance and prepare a long message and a short key.
  Act: Call the encrypt method with the long message and short key.
  Assert: Compare the encrypted result with the expected output.
Validation:
  Confirm that the key is applied cyclically throughout the entire message, regardless of the length difference. This test verifies the method's ability to handle messages longer than the key.
```

These test scenarios cover various aspects of the encrypt method, including basic functionality, handling of different input types, edge cases, and potential error conditions. They aim to ensure the robustness and correctness of the Vigenere cipher implementation.
*/

// ********RoostGPT********

package com.thealgorithms.ciphers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class VigenereEncryptTest {

	private Vigenere vigenere;

	@BeforeEach
	void setUp() {
		vigenere = new Vigenere();
	}

	@ParameterizedTest
	@CsvSource({ "HELLO, A, HELLO", "HELLO WORLD, KEY, RIJVS UYVJN", "AbCdEf, XYZ, XyZaBc",
			"123 ABC !@#, KEY, 123 KCM !@#" })
	@Tag("valid")
	void testEncrypt(String message, String key, String expected) {
		assertEquals(expected, vigenere.encrypt(message, key));
	}

	@Test
	@Tag("valid")
	void testEncryptSimpleMessageWithSingleLetterKey() {
		assertEquals("IFMMP", vigenere.encrypt("HELLO", "A"));
	}

	@Test
	@Tag("valid")
	void testEncryptMessageWithMultiLetterKey() {
		assertEquals("RIJVS UYVJN", vigenere.encrypt("HELLO WORLD", "KEY"));
	}

	@Test
	@Tag("valid")
	void testEncryptMessageWithMixedCase() {
		assertEquals("XyZaBc", vigenere.encrypt("AbCdEf", "XYZ"));
	}

	@Test
	@Tag("valid")
	void testEncryptMessageWithNonAlphabeticCharacters() {
		assertEquals("123 KCM !@#", vigenere.encrypt("123 ABC !@#", "KEY"));
	}

	@Test
	@Tag("boundary")
	void testEncryptEmptyMessage() {
		assertEquals("", vigenere.encrypt("", "KEY"));
	}

	@Test
	@Tag("boundary")
	void testEncryptMessageWithEmptyKey() {
		assertEquals("HELLO", vigenere.encrypt("HELLO", ""));
	}

	@Test
	@Tag("valid")
	void testEncryptLongMessageWithShortKey() {
		String longMessage = "THISISAVERYLONGMESSAGETHATISLONGERTHANTHEKEYANDSHOULDBECYCLICALLYENCRYPTED";
		String shortKey = "SHORT";
		String expected = "LLABKUTNWJQDGFYZWKLSYWLZSLAKLLGVLZWCWQTFVKLZGMDVTWUQUDAUTDDQWFUJQHLWV";
		assertEquals(expected, vigenere.encrypt(longMessage, shortKey));
	}

	@Test
	@Tag("invalid")
	void testEncryptWithNullMessage() {
		assertThrows(NullPointerException.class, () -> vigenere.encrypt(null, "KEY"));
	}

	@Test
	@Tag("invalid")
	void testEncryptWithNullKey() {
		assertThrows(NullPointerException.class, () -> vigenere.encrypt("HELLO", null));
	}

}