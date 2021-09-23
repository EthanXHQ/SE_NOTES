package transformer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloatToBinaryTest {

    private Transformer t = new Transformer();

    @Test
    public void test1() {
        String result = t.floatToBinary(String.valueOf(Math.pow(2, -127)));
        assertEquals("00000000010000000000000000000000", result);
    }

    @Test
    public void test8() {
        String result = t.floatToBinary("" + Double.MAX_VALUE);
        assertEquals("+Inf", result);
    }

    @Test
    public void test2() {
        String result = t.floatToBinary(String.valueOf(-45.8125));
        assertEquals("11000010001101110100000000000000", result);
    }

    @Test
    public void test3() {
        String result = t.floatToBinary(String.valueOf(-4.089454932665725E-27));
        assertEquals("10010011101000100000000000000000", result);
    }

    @Test
    public void test4() {
        String result = t.floatToBinary("" + -Double.MAX_VALUE);
        assertEquals("-Inf", result);
    }

    @Test
    public void test5() {
        String result = t.floatToBinary(String.valueOf(1.55717134475708E-6));
        assertEquals("00110101110100010000000000000000", result);
    }

    @Test
    public void test6() {
        String result = t.floatToBinary(String.valueOf(-1.55717134475708E-6));
        assertEquals("10110101110100010000000000000000", result);
    }

    @Test
    public void test9() {
        String result = t.floatToBinary(String.valueOf(-1712128.0));
        assertEquals("11001001110100010000000000000000", result);
    }

    @Test
    public void test10() {
        String result = t.floatToBinary(String.valueOf(8.816207631167156E-39));
        assertEquals("00000000011000000000000000000000", result);
    }

    @Test
    public void test11() {
        String result = t.floatToBinary(String.valueOf(1712128.0));
        assertEquals("01001001110100010000000000000000", result);
    }

    @Test
    public void test12() {
        String result = t.floatToBinary(String.valueOf(61.419997));
        System.out.println(result);

        String result1 = t.floatToBinary(String.valueOf(61.419998));
        System.out.println(result1);

        String result2 = t.floatToBinary(String.valueOf(61.419999));
        System.out.println(result2);
    }

}
