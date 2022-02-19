package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
          To solve this in the most optimized way is to sort the array using merge sort O(n log(n))
          and then to iterate the array with two pointers, one at the beginning and the second at the end
          and if the sum of those two numbers is smaller than the expected sum we move the first pointer
          to the next element and if it was bigger we move the second pointer into the previous element.
        */
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the expected sum");
        int expectedSum = sc.nextInt();

        System.out.println("Please enter length of String array");
        Integer length = sc.nextInt();

        Integer[] numbers = new Integer[length];
        System.out.println("Please enter array elements");
        for (int i = 0; i < length; i++) {
            Integer userInput = sc.nextInt();
            numbers[i] = userInput;
        }

        // Merge sort which costs (n log(n))
        Arrays.sort(numbers);

        boolean isFound = false;
        int smallNumberIndex = 0;
        int bigNumberIndex = numbers.length - 1;
        while (smallNumberIndex < bigNumberIndex) {
            int sum = numbers[smallNumberIndex] + numbers[bigNumberIndex];
            if (sum == expectedSum) {
                isFound = true;
                break;
            }
            if (sum > expectedSum)
                bigNumberIndex--;
            else
                smallNumberIndex++;
        }

        if (isFound)
            System.out.println(numbers[smallNumberIndex] + " + " + numbers[bigNumberIndex] + " = " + expectedSum);
        else
            System.out.println("there is no answer");
    }
}
