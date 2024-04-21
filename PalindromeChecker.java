import java.io.*;

public class PalindromeChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter a string: ");
        String input = reader.readLine();

       if (isPalindrome(input)) {
    System.out.println("The string \"" + input + "\" is a palindrome.");
} else {
    System.out.println("The string \"" + input + "\" is not a palindrome.");
}

        reader.close();
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
