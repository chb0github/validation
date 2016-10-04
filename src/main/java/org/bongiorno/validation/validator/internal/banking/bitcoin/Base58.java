/**
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bongiorno.validation.validator.internal.banking.bitcoin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Helper for Bitcoin Base58 encoding.
 * 
 * <p>
 *     This class is a reduced fork of the Base58 class from
 *     <a href="https://code.google.com/p/bitcoinj/">bitcoinj</a>:
 * </p>
 * <ul>
 *   <li>Everything was removed besides {@link #decodeChecked(String)}.</li>
 *   <li>
 *   	 The serialization of address decoding was removed by using
 *       new {@link MessageDigest} objects instead of one synchronized singleton.
 *   </li>
 *   <li>
 *       The type of {@link #ALPHABET} changed to String. It's more convenient
 *       to have a String for the RegExp match in
 *       {@link BitcoinAddressValidatorForString#isValid(String, javax.validation.ConstraintValidatorContext)}.
 *   </li>
 * </ul>
 * 
 * @see <a href="https://code.google.com/p/bitcoinj/source/browse/core/src/main/java/com/google/bitcoin/core/Base58.java">bitcoinj:Base58</a>
 * @see <a href="https://github.com/bitcoinj/bitcoinj/pull/30">avoid synchronized blocks during address decoding</a>
 */
class Base58 {
	
    public static final String ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

    private static final int[] INDEXES = new int[128];
    static {
        for (int i = 0; i < INDEXES.length; i++) {
            INDEXES[i] = -1;
        }
        for (int i = 0; i < ALPHABET.length(); i++) {
            INDEXES[ALPHABET.charAt(i)] = i;
        }
    }
    
    static boolean isValidChecksum(String address) {
    	try {
    		decodeChecked(address);
    		return true;
    		
    	} catch (AddressFormatException e) {
    		return false;
    		
    	}
    }

    private static byte[] decode(String input) throws AddressFormatException {
        if (input.length() == 0) {
            return new byte[0];
        }
        byte[] input58 = new byte[input.length()];
        // Transform the String to a base58 byte sequence
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);

            int digit58 = -1;
            if (c >= 0 && c < 128) {
                digit58 = INDEXES[c];
            }
            if (digit58 < 0) {
                throw new AddressFormatException("Illegal character " + c + " at " + i);
            }

            input58[i] = (byte) digit58;
        }
        // Count leading zeroes
        int zeroCount = 0;
        while (zeroCount < input58.length && input58[zeroCount] == 0) {
            ++zeroCount;
        }
        // The encoding
        byte[] temp = new byte[input.length()];
        int j = temp.length;

        int startAt = zeroCount;
        while (startAt < input58.length) {
            byte mod = divmod256(input58, startAt);
            if (input58[startAt] == 0) {
                ++startAt;
            }

            temp[--j] = mod;
        }
        // Do no add extra leading zeroes, move j to first non null byte.
        while (j < temp.length && temp[j] == 0) {
            ++j;
        }

        return copyOfRange(temp, j - zeroCount, temp.length);
    }
    
    /**
     * Uses the checksum in the last 4 bytes of the decoded data to verify the rest are correct. The checksum is
     * removed from the returned data.
     *
     * @throws AddressFormatException if the input is not base 58 or the checksum does not validate.
     */
    private static byte[] decodeChecked(String input) throws AddressFormatException {
        byte tmp [] = decode(input);
        if (tmp.length < 4)
            throw new AddressFormatException("Input too short");
        byte[] bytes = copyOfRange(tmp, 0, tmp.length - 4);
        byte[] checksum = copyOfRange(tmp, tmp.length - 4, tmp.length);
        
        tmp = doubleDigest(bytes);
        byte[] hash = copyOfRange(tmp, 0, 4);
        if (!Arrays.equals(checksum, hash)) 
            throw new AddressFormatException("Checksum does not validate");
        
        return bytes;
    }
    
    //
    // number -> number / 256, returns number % 256
    //
    private static byte divmod256(byte[] number58, int startAt) {
        int remainder = 0;
        for (int i = startAt; i < number58.length; i++) {
            int digit58 = (int) number58[i] & 0xFF;
            int temp = remainder * 58 + digit58;

            number58[i] = (byte) (temp / 256);

            remainder = temp % 256;
        }

        return (byte) remainder;
    }

    private static byte[] copyOfRange(byte[] source, int from, int to) {
        byte[] range = new byte[to - from];
        System.arraycopy(source, from, range, 0, range.length);

        return range;
    }
    
    /**
     * See {@link Utils#doubleDigest(byte[], int, int)}.
     */
    private static byte[] doubleDigest(byte[] input) {
        return doubleDigest(input, 0, input.length);
    }

    /**
     * Calculates the SHA-256 hash of the given byte range, and then hashes the resulting hash again. This is
     * standard procedure in Bitcoin. The resulting hash is in big endian form.
     */
    private static byte[] doubleDigest(byte[] input, int offset, int length) {
    	try {
        	MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(input, offset, length);
            byte[] first = digest.digest();
            return digest.digest(first);
        	
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
            
        }
    }
}
