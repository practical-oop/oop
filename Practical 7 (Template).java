import java.util.*;

public class Main {

    // Method to count elements satisfying a property (e.g., even numbers, palindromes)
    public static int countEvenNumbers(List<Integer> numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 == 0) count++;
        }
        return count;
    }

    public static int countOddNumbers(List<Integer> numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 != 0) count++;
        }
        return count;
    }

    public static int countPrimeNumbers(List<Integer> numbers) {
        int count = 0;
        for (int num : numbers) {
            if (isPrime(num) == true){ 
                count++;
            }
        }
        return count;
    }

    public static int countPalindromes(List<String> words) {
        int count = 0;
        for (String word : words) {
            if (isPalindrome(word)) count++;
        }
        return count;
    }

    // Helper method to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Helper method to check if a word is a palindrome
    private static boolean isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word);
        return word.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        // Example collections
        List<Integer> numbers = Arrays.asList(10, 15, 21, 22, 23, 34, 37, 42);
        List<String> words = Arrays.asList("level", "world", "radar", "java");

        // Count and display the results
        System.out.println("Even numbers count: " + countEvenNumbers(numbers));
        System.out.println("Odd numbers count: " + countOddNumbers(numbers));
        System.out.println("Prime numbers count: " + countPrimeNumbers(numbers));
        System.out.println("Palindromes count: " + countPalindromes(words));
    }
}