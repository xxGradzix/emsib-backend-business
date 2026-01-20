package com.emsib.emsib_backend_business.security.securitymodule.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;


public final class PasswordHashUtil {

    private static final String ALGO = "PBKDF2WithHmacSHA256";

    private static final int ITERATIONS = 100_000;
    private static final int KEY_LENGTH = 256;

    private PasswordHashUtil() {}

    public static byte[] generateSalt(int sizeBytes) {
        SecureRandom rnd = new SecureRandom();
        byte[] salt = new byte[sizeBytes];
        rnd.nextBytes(salt);
        return salt;
    }

    public static byte[] hashPassword(char[] password, byte[] salt) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGO);
            byte[] hash = skf.generateSecret(spec).getEncoded();
            spec.clearPassword();
            return hash;
        } catch (Exception e) {
            throw new IllegalStateException("Failed to hash password", e);
        }
    }

    public static boolean verifyPassword(String rawPassword, byte[] salt, byte[] expectedHash) {
        byte[] computed = hashPassword(rawPassword.toCharArray(), salt);
        boolean equal = Arrays.equals(computed, expectedHash);

        Arrays.fill(computed, (byte) 0);
        return equal;
    }
}
