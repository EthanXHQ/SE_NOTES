import java.util.Scanner;

//由题，暂时仅考虑N为非负数的情况
public class CountNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = input.nextInt();
        int numberOfOne = 0;
        mod(N, numberOfOne);
    }
    private static void mod(int N, int count) {
        if (N % 2 == 1){
            count++;
        }
        if (N / 2 == 0){
            System.out.print("The number of 1‘s in the binary representation of N is " + count);
        }else {
            mod(N /2, count);
        }
    }
}
