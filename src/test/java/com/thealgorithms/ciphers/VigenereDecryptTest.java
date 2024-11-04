
// ********RoostGPT********
/*
Test generated by RoostGPT for test java-unitdemo using AI Type  and AI Model

ROOST_METHOD_HASH=decrypt_f14a13669e
ROOST_METHOD_SIG_HASH=decrypt_a801252d25

Based on the provided Vigenere class and its decrypt method, here are several test scenarios for the decrypt method:

```
Scenario 1: Decrypt a Simple Uppercase Message

Details:
  TestName: decryptSimpleUppercaseMessage
  Description: Test decryption of a simple uppercase message with a single-letter key.
Execution:
  Arrange: Create a Vigenere instance, set an encrypted message "KHOOR" and key "A".
  Act: Call the decrypt method with the encrypted message and key.
  Assert: Check if the decrypted message equals "HELLO".
Validation:
  This test verifies the basic functionality of the decrypt method for uppercase letters. It ensures that the method correctly shifts each letter back according to the Vigenere cipher algorithm with a simple key.

Scenario 2: Decrypt a Mixed Case Message

Details:
  TestName: decryptMixedCaseMessage
  Description: Test decryption of a message containing both uppercase and lowercase letters with a multi-letter key.
Execution:
  Arrange: Create a Vigenere instance, set an encrypted message "Khoor Zruog" and key "KEY".
  Act: Call the decrypt method with the encrypted message and key.
  Assert: Check if the decrypted message equals "Hello World".
Validation:
  This test ensures that the decrypt method correctly handles both uppercase and lowercase letters, maintaining their case in the output. It also verifies that the key is applied cyclically.

Scenario 3: Decrypt a Message with Non-Alphabetic Characters

Details:
  TestName: decryptMessageWithNonAlphabeticChars
  Description: Test decryption of a message containing non-alphabetic characters.
Execution:
  Arrange: Create a Vigenere instance, set an encrypted message "Khoor, Zruog! 123" and key "KEY".
  Act: Call the decrypt method with the encrypted message and key.
  Assert: Check if the decrypted message equals "Hello, World! 123".
Validation:
  This test verifies that the decrypt method correctly handles non-alphabetic characters by leaving them unchanged in the output.

Scenario 4: Decrypt with an Empty Key

Details:
  TestName: decryptWithEmptyKey
  Description: Test decryption behavior when an empty key is provided.
Execution:
  Arrange: Create a Vigenere instance, set an encrypted message "KHOOR" and an empty key "".
  Act: Call the decrypt method with the encrypted message and empty key.
  Assert: Check if the decrypted message equals the input message "KHOOR".
Validation:
  This test ensures that the decrypt method handles the edge case of an empty key gracefully, effectively not modifying the input message.

Scenario 5: Decrypt an Empty Message

Details:
  TestName: decryptEmptyMessage
  Description: Test decryption of an empty message.
Execution:
  Arrange: Create a Vigenere instance, set an empty encrypted message "" and a key "KEY".
  Act: Call the decrypt method with the empty message and key.
  Assert: Check if the decrypted message is an empty string.
Validation:
  This test verifies that the decrypt method correctly handles an empty input message, returning an empty string without throwing exceptions.

Scenario 6: Decrypt with a Key Longer than the Message

Details:
  TestName: decryptWithLongKey
  Description: Test decryption when the key is longer than the encrypted message.
Execution:
  Arrange: Create a Vigenere instance, set an encrypted message "ABC" and a key "LONGKEY".
  Act: Call the decrypt method with the encrypted message and long key.
  Assert: Check if the decrypted message is correctly decrypted using only the first three characters of the key.
Validation:
  This test ensures that the decrypt method correctly applies the key cyclically, using only the necessary portion of the key for decryption.

Scenario 7: Decrypt a Message with Repeating Key

Details:
  TestName: decryptWithRepeatingKey
  Description: Test decryption of a longer message where the key repeats multiple times.
Execution:
  Arrange: Create a Vigenere instance, set an encrypted message "Khoor Khoor Khoor" and key "KEY".
  Act: Call the decrypt method with the encrypted message and key.
  Assert: Check if the decrypted message equals "Hello Hello Hello".
Validation:
  This test verifies that the decrypt method correctly applies the key cyclically for longer messages, ensuring consistent decryption across repeated patterns.
```

These test scenarios cover various aspects of the decrypt method, including different input types, edge cases, and key behaviors. They aim to thoroughly validate the method's functionality and robustness.
*/

// ********RoostGPT********

package com.thealgorithms.ciphers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class VigenereDecryptTest {

	private Vigenere vigenere;

	@BeforeEach
	void setUp() {
		vigenere = new Vigenere();
	}

	@Test
	@Tag("valid")
	void decryptSimpleUppercaseMessage() {
		String encrypted = "KHOOR";
		String key = "A";
		String expected = "HELLO";
		assertEquals(expected, vigenere.decrypt(encrypted, key));
	}

	@Test
	@Tag("valid")
	void decryptMixedCaseMessage() {
		String encrypted = "Khoor Zruog";
		String key = "KEY";
		String expected = "Hello World";
		assertEquals(expected, vigenere.decrypt(encrypted, key));
	}

	@Test
	@Tag("valid")
	void decryptMessageWithNonAlphabeticChars() {
		String encrypted = "Khoor, Zruog! 123";
		String key = "KEY";
		String expected = "Hello, World! 123";
		assertEquals(expected, vigenere.decrypt(encrypted, key));
	}

	@Test
	@Tag("boundary")
	void decryptWithEmptyKey() {
		String encrypted = "KHOOR";
		String key = "";
		assertEquals(encrypted, vigenere.decrypt(encrypted, key));
	}

	@Test
	@Tag("boundary")
	void decryptEmptyMessage() {
		String encrypted = "";
		String key = "KEY";
		assertEquals("", vigenere.decrypt(encrypted, key));
	}

	@Test
	@Tag("valid")
	void decryptWithLongKey() {
		String encrypted = "ABC";
		String key = "LONGKEY";
		String expected = "LNM";
		assertEquals(expected, vigenere.decrypt(encrypted, key));
	}

	@Test
	@Tag("valid")
	void decryptWithRepeatingKey() {
		String encrypted = "Khoor Khoor Khoor";
		String key = "KEY";
		String expected = "Hello Hello Hello";
		assertEquals(expected, vigenere.decrypt(encrypted, key));
	}

	@Test
	@Tag("valid")
	void decryptLongMessage() {
		String encrypted = "Zlzv kg xsi Zmkvrici Gmtlvv";
		String key = "SECRET";
		String expected = "This is the Vigenere Cipher";
		assertEquals(expected, vigenere.decrypt(encrypted, key));
	}

	@Test
	@Tag("boundary")
	void decryptSingleCharacterMessage() {
		String encrypted = "B";
		String key = "KEY";
		String expected = "H";
		assertEquals(expected, vigenere.decrypt(encrypted, key));
	}

	@Test
	@Tag("invalid")
	void decryptWithNullMessage() {
		String key = "KEY";
		assertThrows(NullPointerException.class, () -> vigenere.decrypt(null, key));
	}

	@Test
	@Tag("invalid")
	void decryptWithNullKey() {
		String encrypted = "HELLO";
		assertThrows(NullPointerException.class, () -> vigenere.decrypt(encrypted, null));
	}

}