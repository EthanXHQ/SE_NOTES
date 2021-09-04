import java.util.Scanner;

public class LengthOfLinkedList {
    public static void main(String[] args) {
        System.out.println("Enter a sentence:");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        //String str = "to be or not to be that's a question";  //测试用例
        String[] strList = str.split("\\s+");   //  \\s ==\s 表示转义字符 ,\s表示匹配任意空格（包括空格，制表符，换页符）\\s+中的'+'表示多次匹配

        //构造链表
        Node first = new Node();
        first.item = strList[0];
        Node last = new Node();
        first.next = last;
        for (int i = 1; i < strList.length; i++) {
            last.item = strList[i];
            Node oldlast = last;
            last = new Node();
            oldlast.next = last;
        }

        int count = 0;  //计数
        Count(first, count);
    }

    private static void Count(Node node, int count) {
        if (node.next.item == null) {   //若只有node.next，结果会多1，因为oldlast后仍有Node：last，所以oldlast.next不为null，last.item和last.next才均为null
            count++;
            System.out.println("The number of words in the sentence above is " + count + ".");
        } else {
            node = node.next;
            count++;
            Count(node, count);
        }
    }

    private static class Node {
        String item;
        Node next;
    }
}
