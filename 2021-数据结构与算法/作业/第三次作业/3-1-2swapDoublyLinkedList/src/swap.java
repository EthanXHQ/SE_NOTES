import java.util.Scanner;

public class swap {
    public static void main(String[] args) {
//初始化单链表
        System.out.println("Enter a sentence:");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        //String str = "to be or not to be that's a question";  //测试用例
        String[] strList = str.split("\\s+");

        Node first = new Node();
        first.item = strList[0];
        Node last = new Node();
        first.next = last;
        last.before = first;
        for (int i = 1; i < strList.length; i++) {
            last.item = strList[i];
            Node oldLast = last;
            last = new Node();
            oldLast.next = last;
            last.before = oldLast;
        }

        //选择要交换单词
        System.out.println("Enter two adjacent elements' index numbers:");

        String numStr = input.nextLine();
        String[] numStrList = numStr.split(" ");
        int firstNum = Integer.parseInt(numStrList[0]);
        int secondNum = Integer.parseInt(numStrList[1]);

        Node beforeFirstSwap = first;
        for (int i = 0; i < firstNum - 1; i++) {
            beforeFirstSwap = beforeFirstSwap.next;
        }

        //交换
        Node firstSwap = beforeFirstSwap.next;
        beforeFirstSwap.next = firstSwap.next;
        firstSwap.next = firstSwap.next.next;
        beforeFirstSwap.next.next = beforeFirstSwap.next.before;
        //保证before的正确性
        beforeFirstSwap.next.before = beforeFirstSwap;
        firstSwap.before = beforeFirstSwap.next;
        firstSwap.next.before = firstSwap;

        //打印
        System.out.println("The adjuasted sentence is:");
        Node firstPrint = first;
        while (firstPrint.item != null) {
            System.out.print(firstPrint.item + " ");
            firstPrint = firstPrint.next;
        }
    }

    private static class Node {
        String item;
        Node next;
        Node before;
    }
}
