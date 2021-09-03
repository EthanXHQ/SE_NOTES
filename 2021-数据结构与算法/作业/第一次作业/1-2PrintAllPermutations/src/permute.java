import java.util.Scanner;

public class permute {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.next();
        char[] charStr = str.toCharArray();
        permuteFunc(charStr, 0, charStr.length-1);
    }

    private static void permuteFunc( char [] str, int low, int high ){
        if (low == high) {
            for (int i = 0; i <= high; i++){
                System.out.print(str[i]);
            }
            System.out.println();
        } else {
            for (int j = low; j <= high; j++){
                swap(str, low, j);
                permuteFunc(str, low+1, high);
                swap(str, low, j);
            }
        }
    }

    private static char[] swap(char[] str, int a, int b){
        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;
        return str;
    }
}
