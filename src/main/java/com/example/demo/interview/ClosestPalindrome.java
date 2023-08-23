package com.example.demo.interview;

public class ClosestPalindrome {
    public static void main(String[] args) {
        ClosestPalindrome solution = new ClosestPalindrome();
        String n = "12345";
        System.out.println(solution.nearestPalindromic(n)); // Output: "12321"
    }

    public String nearestPalindromic(String n) {
        long number = Long.parseLong(n); // Convert the given string n to a long integer
        long larger = findLargerPalindrome(number + 1); // Find the larger palindrome
        long smaller = findSmallerPalindrome(number - 1); // Find the smaller palindrome

        // Compare the absolute differences between the original number and the found palindromes
        long diff1 = Math.abs(larger - number);
        long diff2 = Math.abs(smaller - number);

        // If both differences are equal, return the smaller palindrome (as mentioned in the problem statement)
        if (diff1 == diff2) {
            return String.valueOf(smaller);
        }

        // Return the palindrome with the smaller absolute difference
        return diff1 < diff2 ? String.valueOf(larger) : String.valueOf(smaller);
    }

    private long findLargerPalindrome(long number) {
        String numStr = String.valueOf(number);
        int n = numStr.length();

        // Generate the first half of the palindrome based on the first half of the original number
        String firstHalf = numStr.substring(0, (n + 1) / 2);
        long larger = Long.parseLong(new StringBuilder(firstHalf).reverse().toString());

        // If the larger palindrome is equal to or smaller than the original number, adjust the first half and generate the full palindrome
        if (larger <= number) {
            int carry = 1;
            char[] firstHalfArr = firstHalf.toCharArray();
            int i = (n - 1) / 2;

            // Add carry to the digits until no carry is left
            while (i >= 0 && carry > 0) {
                int digit = firstHalfArr[i] - '0';
                digit += carry;
                carry = digit / 10;
                firstHalfArr[i] = (char) (digit % 10 + '0');
                i--;
            }

            // If there's still a carry, it means we need one more digit in the palindrome
            if (carry > 0) {
                return Long.parseLong('1' + new String(firstHalfArr) + '1');
            }

            // Otherwise, generate the full palindrome using the adjusted first half
            for (int j = 0; j < (n + 1) / 2; j++) {
                firstHalfArr[n - j - 1] = firstHalfArr[j];
            }
            larger = Long.parseLong(new String(firstHalfArr));
        }

        return larger;
    }

    private long findSmallerPalindrome(long number) {
        if (number <= 0) {
            return 0;
        }

        String numStr = String.valueOf(number);
        int n = numStr.length();

        // Generate the first half of the palindrome based on the first half of the original number
        String firstHalf = numStr.substring(0, n / 2);
        long smaller = Long.parseLong(new StringBuilder(firstHalf).reverse().toString());

        // If the smaller palindrome is equal to or larger than the original number, adjust the first half and generate the full palindrome
        if (smaller >= number) {
            int carry = -1;
            char[] firstHalfArr = firstHalf.toCharArray();
            int i = (n - 1) / 2;

            // Subtract carry from the digits until no carry is left
            while (i >= 0 && carry < 0) {
                int digit = firstHalfArr[i] - '0';
                digit += carry;
                carry = 0;
                if (digit < 0) {
                    digit += 10;
                    carry = -1;
                }
                firstHalfArr[i] = (char) (digit + '0');
                i--;
            }

            // If the first half becomes empty (all zeros), it means we need one less digit in the palindrome
            if (firstHalfArr[0] == '0') {
                return Long.parseLong(new String(firstHalfArr));
            }

            // Otherwise, generate the full palindrome using the adjusted first half
            for (int j = 0; j < n / 2; j++) {
                firstHalfArr[n - j - 1] = firstHalfArr[j];
            }
            smaller = Long.parseLong(new String(firstHalfArr));
        }

        return smaller;
    }
}

