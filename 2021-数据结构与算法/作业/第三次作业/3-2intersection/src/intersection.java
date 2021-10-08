import java.util.Scanner;

public class intersection {
    public static void main(String[] args) {
        //初始化单链表
        System.out.println("Enter list L1:");
        Scanner input = new Scanner(System.in);
        String numStr1 = input.nextLine();
        //String numStr1 = "1 2 3";  //测试用例
        String[] L1Str = numStr1.split("\\s+");
        System.out.println("Enter list L2:");
        String numStr2 = input.nextLine();
        //String numStr2 = "2 5 6";  //测试用例
        String[] L2Str = numStr2.split("\\s+");

        Node L1first = new Node();
        L1first.item = L1Str[0];
        Node L1last = new Node();
        L1first.next = L1last;
        for (int i = 1; i < L1Str.length; i++) {
            L1last.item = L1Str[i];
            Node oldLast = L1last;
            L1last = new Node();
            oldLast.next = L1last;
        }

        Node L2first = new Node();
        L2first.item = L2Str[0];
        Node L2last = new Node();
        L2first.next = L2last;
        for (int i = 1; i < L2Str.length; i++) {
            L2last.item = L2Str[i];
            Node oldLast = L2last;
            L2last = new Node();
            oldLast.next = L2last;
        }

        //比较
        Node reFirst = new Node();
        Node reLast = new Node();
        reFirst.next = reLast;
        while (L1first.item != null && L2first.item != null) {
            if (L1first.item.equals(L2first.item)) {
                reLast.item = L1first.item;
                Node oldReLast = reLast;
                reLast = new Node();
                oldReLast.next = reLast;
                L1first = L1first.next;
                L2first = L2first.next;
            } else if (Integer.parseInt(L1first.item) < Integer.parseInt(L2first.item))
                L1first = L1first.next;
            else if (Integer.parseInt(L1first.item) > Integer.parseInt(L2first.item))
                L2first = L2first.next;
        }

        //打印
        System.out.println("The intersection is:");
        Node firstPrint = reFirst.next;
        while (firstPrint.item != null) {
            System.out.print(firstPrint.item + " ");
            firstPrint = firstPrint.next;
        }
    }

    private static class Node {
        String item;
        Node next;
    }
}
