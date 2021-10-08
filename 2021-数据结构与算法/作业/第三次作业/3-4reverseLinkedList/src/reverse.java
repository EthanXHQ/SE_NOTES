import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        //初始化单链表
        System.out.println("Enter a sentence:");
        //Scanner input = new Scanner(System.in);
        //String str = input.nextLine();
        String str = "to be or not to be that's a question";  //测试用例
        String[] strList = str.split("\\s+");

        Node first = new Node();
        first.item = strList[0];
        Node last = new Node();
        first.next = last;
        for (int i = 1; i < strList.length; i++) {
            last.item = strList[i];
            Node oldLast = last;
            last = new Node();
            oldLast.next = last;
        }

        //头插法
        Node reFirst = new Node();
        Node reLast = new Node();
        reFirst.next = reLast;
        while (first.item != null) {
            reFirst.item = first.item;
            Node oldReFirst = reFirst;
            reFirst = new Node();
            reFirst.next = oldReFirst;
            first = first.next;
        }

        //打印
        System.out.println("The reversed sentence is:");
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
