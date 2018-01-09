package net.volgatech.javacore2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HashSumCreator {
    private static final int PRIME_NUMBER = 7;
    private static final int MAX_HASH_LENGTH = 8;
    private static final int BASE = 29;

    private ArrayList<String> hashSums = new ArrayList<String>();
    private ArrayList<String> filePaths = new ArrayList<String>();

    public ArrayList<String> getFilePaths() {
        return filePaths;
    }

    public ArrayList<String> getHashSums() {
        return hashSums;
    }

    public void walk(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("file or path " + path + " doesn\'t exist");
        }
        if (file.isDirectory()) {
            File[] includedPaths = file.listFiles();
            if (includedPaths != null) {
                for (int i = 0; i < includedPaths.length; ++i) {
                    walk(includedPaths[i].getPath());
                }
            }
        }
        else {
            String hashSum = getHashSum(file);
            if (hashSum.length() < MAX_HASH_LENGTH) {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < MAX_HASH_LENGTH - hashSum.length(); ++i) {
                    str.append("0");
                }
                str.append(hashSum);
                hashSum = str.toString();
            }
            hashSums.add(hashSum);
            filePaths.add(path);
        }
    }

    private String getHashSum(File file) {
        int result = BASE;
        try {
            FileReader fileReader = new FileReader(file.getAbsoluteFile());
            Scanner reader = new Scanner(fileReader);
            while (reader.hasNext()) {
                String line = reader.nextLine();
                byte[] bytes = line.getBytes();
                for (byte b : bytes) {
                    result *= PRIME_NUMBER;
                    result ^= b;
                }
            }
        }
        catch (IOException err) {
            result = 0;
        }

        return Integer.toHexString(result);
    }
}
