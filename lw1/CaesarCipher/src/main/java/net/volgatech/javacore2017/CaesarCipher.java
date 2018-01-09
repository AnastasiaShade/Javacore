package net.volgatech.javacore2017;

//import java.io.*;

public class CaesarCipher {

    public static String decryptMessage(int key, String message) {
        String newMessage = "";
        char minValue = 'a', maxValue = 'z';
        char minValueUpperCase = 'A', maxValueUpperCase = 'Z';
        int step = key % ((int)maxValue - (int)minValue + 1);
        for (int i = 0; i < message.length(); ++i) {
            if (!Character.isAlphabetic((int)message.charAt(i))) {
                throw new Error("Invalid symbol in input message");
            }
            if (Character.isUpperCase((int)message.charAt(i))) {
                newMessage += ((int)message.charAt(i) > (int)maxValueUpperCase - step)
                        ? Character.toString((char)(((int)minValueUpperCase - 1) + (step - ((int)maxValueUpperCase - (int)message.charAt(i)))))
                        : Character.toString((char)((int)message.charAt(i) + step));
            }
            else {
                newMessage += ((int)message.charAt(i) > (int)maxValue - step)
                        ? Character.toString((char)(((int)minValue - 1) + (step - ((int)maxValue - (int)message.charAt(i)))))
                        : Character.toString((char)((int)message.charAt(i) + step));
            }
        }
        return newMessage;
    }

    public static String encryptMessage(int key, String message) {
        String newMessage = "";
        char minValue = 'a', maxValue = 'z';
        char minValueUpperCase = 'A', maxValueUpperCase = 'Z';
        int step = key % ((int)maxValue - (int)minValue + 1);
        for (int i = 0; i < message.length(); ++i) {
            if (!Character.isAlphabetic((int)message.charAt(i))) {
                throw new Error("Invalid symbol in input message");
            }
            if (Character.isUpperCase((int)message.charAt(i))) {
                newMessage += ((int)message.charAt(i) < (int)minValueUpperCase + step)
                        ? Character.toString((char)(((int)maxValueUpperCase - 1) + (step - ((int)minValueUpperCase - (int)message.charAt(i)))))
                        : Character.toString((char)((int)message.charAt(i) - step));
            }
            else {
                newMessage += ((int)message.charAt(i) < (int)minValue + step)
                        ? Character.toString((char)(((int)maxValue - 1) + (step - ((int)minValue - (int)message.charAt(i)))))
                        : Character.toString((char)((int)message.charAt(i) - step));
            }

        }
        return newMessage;
    }

    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new Error("Invalid argument count");
            }
            if (args[0].equals("-e")) {
                System.out.println(encryptMessage(Integer.parseInt(args[1]), args[2]));
            }
            else if(args[0].equals("-d")) {
                System.out.println(decryptMessage(Integer.parseInt(args[1]), args[2]));
            }
            else {
                throw new Error("Invalid operation mode");
            }
        }
        catch (Throwable err) {
            System.out.println(err);
            System.out.println("Use: CaesarCipher <operation mode (-e for encryption or -d for decryption)> <key> <string>");
            System.out.println("Example: CaesarCipher -e 1 abcd");
        }
    }
}