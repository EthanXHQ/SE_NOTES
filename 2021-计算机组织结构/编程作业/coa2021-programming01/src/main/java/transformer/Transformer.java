package transformer;

public class Transformer {
    /**
     * Integer to binaryString
     *
     * @param numStr to be converted
     * @return result
     */
    public String intToBinary(String numStr) {
        //TODO:
        StringBuilder binStr = new StringBuilder(Integer.toBinaryString(Integer.parseInt(numStr)));
        while (binStr.length() < 32) {
            binStr.insert(0, "0");
        }
        return binStr.toString();
    }

    /**
     * BinaryString to Integer
     *
     * @param binStr : Binary string in 2's complement
     * @return :result
     */
    public String binaryToInt(String binStr) {
        //TODO:
        int flag = 1;
        if (binStr.charAt(0) == '1') {
            flag = -1;
            String newBinStr = "";
            for (int i = 0; i < binStr.length(); i++) {
                if (binStr.substring(i, i + 1).equals("1"))
                    newBinStr += "0";
                else
                    newBinStr += "1";
            }
            binStr = newBinStr;
        }
        if (flag == -1)
            return String.valueOf((Integer.parseInt(binStr, 2) + 1) * flag);
        return String.valueOf(Integer.parseInt(binStr, 2) * flag);
    }

    /**
     * The decimal number to its NBCD code
     */
    public String decimalToNBCD(String decimalStr) {
        //TODO:
        String NBCDStr = "";
        if (Integer.parseInt(decimalStr) < 0) {
            NBCDStr += "1101";
            decimalStr = decimalStr.substring(1, decimalStr.length());
        } else
            NBCDStr += "1100";
        while (decimalStr.length() < 7)
            decimalStr = "0" + decimalStr;
        while (decimalStr.length() > 0) {
            int num = Integer.parseInt(decimalStr.substring(0, 1));
            StringBuilder binStr = new StringBuilder(Integer.toBinaryString(num));
            while (binStr.length() < 4)
                binStr.insert(0, "0");
            NBCDStr += binStr;
            decimalStr = decimalStr.substring(1, decimalStr.length());
        }

        return NBCDStr;
    }

    /**
     * NBCD code to its decimal number
     */
    public String NBCDToDecimal(String NBCDStr) {
        //TODO:
        int flag = 1;
        int dec = 0;
        String signStr = NBCDStr.substring(0, 4);
        if (signStr.equals("1101"))
            flag = -1;
        NBCDStr = NBCDStr.substring(4, NBCDStr.length());
        while (NBCDStr.length() > 0) {
            dec *= 10;
            String binStr = NBCDStr.substring(0, 4);
            dec += Integer.parseInt(binStr, 2);
            NBCDStr = NBCDStr.substring(4, NBCDStr.length());
        }
        return String.valueOf(dec * flag);
    }

    /**
     * Float true value to binaryString
     *
     * @param floatStr : The string of the float true value
     */
    public String floatToBinary(String floatStr) {
        //TODO:
        //正负无穷
        if (floatStr.equals("" + Double.MAX_VALUE))
            return "+Inf";
        if (floatStr.equals("" + -Double.MAX_VALUE))
            return "-Inf";
        Double f = Double.parseDouble(floatStr);
        String binStr = "";
        if (f < 0) {
            binStr += "1";
            f *= -1;
        } else
            binStr += "0";
        //表示0.0
        if (f == 0.0)
            return binStr + "00000000000000000000000";
        if (f < Math.pow(2, -126)) {    //指数为-126
            binStr += "00000000";
            f *= Math.pow(2, 126);
            String fraction = "";
            int count = 0;
            while (count < 23 && f != 0) {
                f *= 2;
                if (f >= 1) {
                    fraction += "1";
                    f -= 1;
                } else
                    fraction += "0";
                count++;
            }
            for (int i = fraction.length(); i < 23; i++)
                fraction += "0";
            binStr += fraction;
        } else {                        //指数为0~255
            int exp = 127;
            //Double f1 = f;
            while (f > 2) {
                f /= 2;
                exp++;
            }
            while (f < 1) {
                f *= 2;
                exp--;
            }
            String expStr = Integer.toBinaryString(exp);
            for (int i = expStr.length(); i < 8; i++)
                expStr = "0" + expStr;
            binStr += expStr;
            f -= 1;
            String fraction = "";
            int count = 0;
            while (count < 23 && f != 0) {
                f *= 2;
                if (f >= 1) {
                    fraction += "1";
                    f -= 1;
                } else
                    fraction += "0";
                count++;
            }
            for (int i = fraction.length(); i < 23; i++)
                fraction += "0";
            binStr += fraction;
        }
        return binStr;
    }

    /**
     * Binary code to its float true value
     */
    public String binaryToFloat(String binStr) {
        //TODO:
        float flag = 1;
        float num = 0;
        int exp;
        if (binStr.substring(0, 1).equals("1")) {
            flag = -1;
            binStr = binStr.substring(1, binStr.length());
        } else
            binStr = binStr.substring(1, binStr.length());
        String expStr = binStr.substring(0, 8);     //表示0
        if (binStr.equals("0000000000000000000000000000000"))
            return "0.0";
        if (expStr.equals("00000000")) {    //指数为-126
            exp = -126;
            binStr = binStr.substring(8, binStr.length());
            for (int i = 1; i <= binStr.length(); i++) {
                num += (Integer.parseInt(binStr.substring(i - 1, i)) * Math.pow(2, -i));
            }
            return String.valueOf(num * Math.pow(2, exp) * flag);
        }
        if (expStr.equals("11111111")) {    //正负无穷
            if (flag == 1)
                return "+Inf";
            else
                return "-Inf";
        } else {                            //指数为0~255
            exp = Integer.parseInt(binStr.substring(0, 8), 2) - 127;
            binStr = binStr.substring(8, binStr.length());
            for (int i = 1; i <= binStr.length(); i++) {
                num += (Integer.parseInt(binStr.substring(i - 1, i)) * Math.pow(2, -i));
            }
            num += 1;
        }
        return String.valueOf(num * Math.pow(2, exp) * flag);
    }


}
