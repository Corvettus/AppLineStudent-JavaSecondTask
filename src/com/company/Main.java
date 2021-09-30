package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> wordsMap = getWordsMap();

        for (String word : wordsMap.keySet()) {
            System.out.print(word + " ");
        }
        System.out.println("\n\n");

        System.out.println("word : count");
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("\n");

        Integer maxWordCount = maxWordCount(wordsMap);
        System.out.println("Maximum count of one word is " + maxWordCount +
                ".\nThere are often words:");
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue().equals(maxWordCount)) {
                System.out.println(entry.getKey());
            }
        }
    }

    private static Map<String, Integer> getWordsMap() {
        Map<String, Integer> wordsMap = new TreeMap<>();
        try {
            File inputFile = new File("resources/inputFile.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
                }
            }
            reader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return wordsMap;
    }

    private static Integer maxWordCount(Map<String, Integer> wordsMap) {
        Integer maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
            }
        }
        return maxCount;
    }
}
