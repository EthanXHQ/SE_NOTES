import java.util.ArrayList;

public class ALU {


    /**
     * TODO 1.实现将整数转化为16位补码
     *
     * @param num 十进制整数（数值大小不会超过16位补码的可表示范围）。
     * @return 16位二进制补码
     */
    public String intToComplement(int num) {
        return null;
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
        return null;
    }

    /**
     * TODO 3.实现4位的先行进位加法器
     *
     * @param operand1 4位补码
     * @param operand2 4位补码
     * @param c 进位输入，1位的二进制数
     * @return 5位的加法运算结果，包括1位的进位和4位的和
     */
    public String claAdder(String operand1, String operand2, char c) {
        return null;
    }

    /**
     * TODO 4.实现16位的部分先行进位加法器（要求：基于上述方法claAdder）
     *
     * @param operand1 16位补码
     * @param operand2 16位补码
     * @param c 进位输入，1位的二进制数
     * @return 17位的加法运算结果，包括1位的进位和16位的和
     */
    public String pclaAdder(String operand1, String operand2, char c) {
        return null;
    }

    /**
     * TODO 5.实现布斯乘法
     *
     * @param operand1 被乘数，十进制整数，不会超过16位补码的可表示范围
     * @param operand2 乘数，十进制整数，不会超过16位补码的可表示范围
     * @return ArrayList的长度为17，第1个元素为初始的product+Y（含Y0，共33位），第2-17个元素为计算过程中每次右移后的product+Y（共33位）
     */
    public ArrayList<String> multiplication(int operand1, int operand2) {
        return null;
    }

}
