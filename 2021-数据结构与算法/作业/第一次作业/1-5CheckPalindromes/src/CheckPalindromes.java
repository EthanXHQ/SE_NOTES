import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckPalindromes {
    public static void main(String[] args) {
        System.out.println("Enter a sentence:");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        str = str.toLowerCase();
        List<String> a = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                a.add(Character.toString(str.charAt(i)));
            }
        }
        //System.out.println(a);
        for (String item : a) {
            System.out.print(item);
        }
        System.out.print(" is ");
        palindrome(a);
    }

    public static int palindrome(List<String> a) {
        if (a.size() == 0 || a.size() == 1) {
            System.out.println("a palindrome.");
        } else {
            if (!a.get(0).equals(a.get(a.size() - 1))) {
                System.out.println("not a palindrome.");
                return 0;
            }
            a.remove(0);
            a.remove(a.size() - 1);
            palindrome(a);
        }
        return 0;
    }
}
