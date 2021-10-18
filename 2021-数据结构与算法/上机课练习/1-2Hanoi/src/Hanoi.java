import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the level of tower: ");
        int N = input.nextInt();
        hanoi(N, 'A', 'B', 'C');
    }

    private static void hanoi(int N, char ATower, char BTower, char CTower) {
        if (N == 1) {
            System.out.println(N +" "+ ATower + " --> " + CTower);//每次移动中，ATower为起始塔，CTower为目标塔
        } else {
            hanoi(N - 1, ATower, CTower, BTower);
            System.out.println(N +" "+ ATower + " --> " + CTower);
            hanoi(N - 1, BTower, ATower, CTower);
        }
    }
}
