package com.sargen_d;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Open and read file
        Scanner scanner = new Scanner(new File("input.txt"));
        String fileContent = scanner.useDelimiter("\\A").next();
        scanner.close();

        // Break string into List
        int[] intArray = Arrays.stream(fileContent.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        // Restore state
        intArray[1] = 12;
        intArray[2] = 2;

        // Process to get a working computer
        int current = 0;
        boolean done = false;
        int tmp, finalPosition;
        while (!done) {
                switch (intArray[current]) {
                    case 1:
                        tmp = intArray[intArray[current + 1]] + intArray[intArray[current + 2]];
                        finalPosition = intArray[current + 3];
                        intArray[finalPosition] = tmp;
                        current += 4;
                        break;
                    case 2:
                        tmp = intArray[intArray[current + 1]] * intArray[intArray[current + 2]];
                        finalPosition = intArray[current + 3];
                        intArray[finalPosition] = tmp;
                        current += 4;
                        break;
                    case 99:
                        done = true;
                        break;
                }
        }

        // Find value

        System.out.println("Final 0 value: " + intArray[0]);
    }
}
