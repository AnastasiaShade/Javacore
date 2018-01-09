package net.volgatech.javacore2017;

import java.io.*;
import java.util.*;

public class TopWords {
    public static ArrayList<HashMap<String, Integer>> countWords(String inputFileName) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(inputFileName));
        HashMap<String, Integer> words = new HashMap<>();
        ArrayList<HashMap<String, Integer>> sortedWords = new ArrayList<>();
        sortedWords.add(new HashMap<String, Integer>());

        while (scanner.hasNext()) {
            String word = scanner.next();
            if (!words.containsKey(word)) {
                words.put(word, 1);
                HashMap<String, Integer> tmp = sortedWords.get(0);
                tmp.put(word, 1);
                sortedWords.set(0, tmp);
            }
            else {
                int objectValue = words.get(word);
                HashMap<String, Integer> tmp = sortedWords.get(objectValue - 1);
                tmp.remove(word);
                sortedWords.set(objectValue - 1, tmp);
                words.put(word, ++objectValue);
                if (objectValue >= sortedWords.size()) {
                    sortedWords.add(new HashMap<String, Integer>());
                }
                HashMap<String, Integer> tmp1 = sortedWords.get(objectValue - 1);
                tmp1.put(word, objectValue);
                sortedWords.set(objectValue - 1, tmp1);
            }
        }
        return sortedWords;
    }

    public static void printResult(ArrayList<HashMap<String, Integer>> sortedWords, int wordsInTop) {
        for (int index = sortedWords.size() - 1; index >= 0; --index) {
            Set<HashMap.Entry<String, Integer>> set = sortedWords.get(index).entrySet();
            for (HashMap.Entry<String, Integer> element : set) {
                if (wordsInTop > 0) {
                    System.out.println(element.getKey() + ": " + element.getValue());
                    --wordsInTop;
                }
                else {
                    break;
                }
            }
            if (wordsInTop == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new IndexOutOfBoundsException("Invalid argument count");
            }

            ArrayList<HashMap<String, Integer>> sortedWords = countWords(args[0]);
            printResult(sortedWords, Integer.parseInt(args[1]));

        }
        catch (Exception err) {
            System.err.println(err);
            System.err.println("Use: TopWords <file path> <words top>");
            System.err.println("Example: TopWords input.txt 5");
        }
    }
}
