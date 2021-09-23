package transformer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryToFloatTest {

	Transformer t = new Transformer();

	@Test
	public void test1() {
		String result = t.binaryToFloat("00000000010000000000000000000000");
		assertEquals(String.valueOf(Math.pow(2, -127)), result);
	}

	@Test
	public void test2() {
		String result = t.binaryToFloat("11000010001101110100000000000000");
		assertEquals(String.valueOf(-45.8125), result);
	}

	@Test
	public void test3() {
		String result = t.binaryToFloat("10010011101000100000000000000000");
		assertEquals(String.valueOf(-4.089454932665725E-27), result);
	}

	@Test
	public void test4() {
		String result = t.binaryToFloat("11111111100000000000000000000000");//
		assertEquals("-Inf", result);
	}

	@Test
	public void test5() {
		String result = t.binaryToFloat("01111111100000000000000000000000");//
		assertEquals("+Inf", result);
	}

	@Test
	public void test6() {
		String result = t.binaryToFloat("00110101110100010000000000000000");//
		assertEquals(String.valueOf(1.55717134475708E-6), result);
	}

	@Test
	public void test7() {
		String result = t.binaryToFloat("11001001110100010000000000000000");//
		assertEquals(String.valueOf(-1712128.0), result);
	}

	@Test
	public void test9() {
		String result = t.binaryToFloat("00000000011000000000000000000000");//
		assertEquals(String.valueOf(8.816207631167156E-39), result);
	}

	@Test
	public void test10() {
		String result = t.binaryToFloat("10110101110100010000000000000000");//
		assertEquals(String.valueOf(-1.55717134475708E-6), result);
	}

	@Test
	public void test11() {
		String result = t.binaryToFloat("01001001110100010000000000000000");//
		assertEquals(String.valueOf(1712128.0), result);
	}

	@Test
	public void test12() {
		String result = t.binaryToFloat("00000000000000000000000000000000");
		assertEquals(String.valueOf(0.0), result);
	}

	@Test
	public void test13() {
		String result = t.binaryToFloat("01000010011101011010111000010110");
		System.out.println(result);
	}
}
