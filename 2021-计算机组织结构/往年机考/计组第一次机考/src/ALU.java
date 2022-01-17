import java.util.ArrayList;

public class ALU {


    /**
     * TODO 1.实现将整数转化为16位补码
     *
     * @param num 十进制整数（数值大小不会超过16位补码的可表示范围）。
     * @return 16位二进制补码
     */
    public String intToComplement(int num) {
        String BinStr = Integer.toBinaryString(num);
        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */
        while (BinStr.length() < 32) {
            if (num >= 0)
                BinStr = "0" + BinStr;
            else
                BinStr = "1" + BinStr;
        }
        return BinStr.substring(16, 32);
    }

    /**
     * TODO 2.实现1个全加器
     *
     * @param x: 1位的二进制数
     * @param y: 1位的二进制数
     * @param c: 进位输入，1位的二进制数
     * @return 2位的字符串，包括1位的进位输出和1位的加法运算结果
     */
    public String fullAdder(char x, char y, char c) {
        if (x == '0' && y == '0' && c == '0')
            return "00";
        if (x == '1' && y == '0' && c == '0')
            return "01";
        if (x == '0' && y == '1' && c == '0')
            return "01";
        if (x == '0' && y == '0' && c == '1')
            return "01";
        if (x == '1' && y == '1' && c == '0')
            return "10";
        if (x == '1' && y == '0' && c == '1')
            return "10";
        if (x == '0' && y == '1' && c == '1')
            return "10";
        if (x == '1' && y == '1' && c == '1')
            return "11";
        return null;
    }

    /**
     * TODO 3.实现4位的先行进位加法器
     *
     * @param operand1 4位补码
     * @param operand2 4位补码
     * @param c        进位输入，1位的二进制数
     * @return 5位的加法运算结果，包括1位的进位和4位的和
     */
    public String claAdder(String operand1, String operand2, char c) {
        String res = "";
        for (int i = 3; i >= 0; i--) {
            String temp = fullAdder(operand1.charAt(i), operand2.charAt(i), c);
            res = temp.charAt(1) + res;
            c = temp.charAt(0);
        }
        return c + res;
    }

    /**
     * TODO 4.实现16位的部分先行进位加法器（要求：基于上述方法claAdder）
     *
     * @param operand1 16位补码
     * @param operand2 16位补码
     * @param c        进位输入，1位的二进制数
     * @return 17位的加法运算结果，包括1位的进位和16位的和
     */
    public String pclaAdder(String operand1, String operand2, char c) {
        String res = "";
        for (int i = 12; i >= 0; i -= 4) {
            String temp = claAdder(operand1.substring(i, i + 4), operand2.substring(i, i + 4), c);
            res = temp.substring(1, 5) + res;
            c = temp.charAt(0);
        }
        return c + res;
    }

    /**
     * TODO 5.实现布斯乘法
     *
     * @param operand1 被乘数，十进制整数，不会超过16位补码的可表示范围
     * @param operand2 乘数，十进制整数，不会超过16位补码的可表示范围
     * @return ArrayList的长度为17，第1个元素为初始的product+Y（含Y0，共33位），第2-17个元素为计算过程中每次右移后的product+Y（共33位）
     */
    public ArrayList<String> multiplication(int operand1, int operand2) {
        ArrayList<String> output = new ArrayList<String>();
        String op1 = intToComplement(operand1);
        String negop1 = intToComplement(-1 * operand1);
        String op2 = intToComplement(operand2);
        String res = "0000000000000000" + op2 + "0";
        output.add(res);
        for (int i = 1; i < 17; i++) {
            if ((res.charAt(32) == '0' && res.charAt(31) == '0') || (res.charAt(32) == '1' && res.charAt(31) == '1')) {
                res = res.charAt(0) + res.substring(0, 32);
                output.add(res);
            }
            else if (res.charAt(32) == '1' && res.charAt(31) == '0') {
                res = pclaAdder(res.substring(0, 16), op1, '0').substring(1, 17) + res.substring(16, 32);
                res = res.charAt(0) + res;
                output.add(res);
            }
            else if (res.charAt(32) == '0' && res.charAt(31) == '1') {
                res = pclaAdder(res.substring(0, 16), negop1, '0').substring(1, 17) + res.substring(16, 32);
                res = res.charAt(0) + res;
                output.add(res);
            }

        }

        return output;
    }

}
