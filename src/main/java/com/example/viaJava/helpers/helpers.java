package com.example.viaJava.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class helpers {

    public static String encryptPassword(String password) {
        try {
            MessageDigest message = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = message.digest(password.getBytes());
            StringBuilder stgbuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                stgbuilder.append(String.format("%02x", b));
            }
            return stgbuilder.toString();
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
            return null;
        }
    }
}
