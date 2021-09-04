import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursionForArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = input.nextInt();
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            a.add(input.nextInt());
        }
        FindMax(a.get(0), a);
        System.out.print("The average of the array is " + FindAverage(a.get(0), a));
    }
    private static void FindMax(int max, List<Integer> a){
        if (a.size() == 1){
            if (a.get(0) > max){
                max = a.get(0);
            }
            System.out.println("The maximum of the array is " + max);
        } else {
            int temp = a.get(0);
            a.remove(0);
            if (a.get(0) > max){
                max = a.get(0);
            }
            FindMax(max, a);
            a.add(0, temp);
        }
    }
    private static double FindAverage(int firstNum, List<Integer> a){
        if (a.size() == 1){
            return a.get(0) * 1.0;
        } else {
            int temp = a.get(0);
            a.remove(0);
            double preAve = FindAverage(a.get(0), a);
            a.add(0, temp);
            return (firstNum + ((a.size()-1) * preAve)) / (a.size());
        }
    }
}
