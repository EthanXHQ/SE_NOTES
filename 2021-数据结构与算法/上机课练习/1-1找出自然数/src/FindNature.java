import java.util.Scanner;

public class FindNature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = input.nextInt();
        System.out.print("Enter r: ");
        int r = input.nextInt();
        if (r > N) {
            System.out.print("Error!");
        } else {
            int[] a = new int[r];
            function(N, r, a);
        }
    }

    private static void function(int N, int r, int[] a) {
        for (int i = N; i >= r; i--) {
            a[r - 1] = i;
            if (r > 1)
                function(i - 1, r - 1, a);
            else {
                for (int j = a.length - 1; j >= 0; j--)
                    System.out.print(a[j] + " ");
                System.out.println();
            }
        }
    }
}
