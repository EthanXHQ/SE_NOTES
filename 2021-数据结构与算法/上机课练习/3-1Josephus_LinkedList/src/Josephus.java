import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of people: ");
        int N = input.nextInt();
        System.out.println("Enter the repeat number: ");
        int m = input.nextInt();
        Node first = new Node();
        first.item = 1;
        Node last = new Node();
        first.next = last;
        for(int i = 2; i < N; i++) {
            last.item = i;
            Node oldLast = last;
            last = new Node();
            oldLast.next = last;
        }
        last.item = N;
        last.next = first;

        Josephus(N, m, first, last);
    }
    private static void Josephus(int N, int m, Node first, Node last){
        if (N == 1) {
            System.out.println("The survivor is No." + first.item + " .");
        } else {
            for (int i = 1; i < m; i++) {
                first = first.next;
                last = last.next;
            }
            System.out.println("No." + first.item + " is killed.");
            last.next = first.next;
            first = last.next;
            Josephus(N - 1, m, first, last);
        }
    }
    private static class Node {
        int item;
        Node next;
    }
}
