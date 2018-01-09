package net.volgatech.javacore2017;

import java.io.*;
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new Error("Invalid argument count");
            }
            int passLength = Integer.parseInt(args[0]);
            String symbols = args[1];
            String password = "";
            Random random = new Random();

            for (int i = 0; i < passLength; ++i) {
                password += symbols.charAt(random.nextInt(symbols.length()));
            }
            System.out.println(password);
        }
        catch (Throwable err) {
            System.out.println(err);
            System.out.println("Use: PasswordGenerator <password length> <password symbols>");
            System.out.println("Example: PasswordGenerator 5 _874cvg");
        }
    }
}