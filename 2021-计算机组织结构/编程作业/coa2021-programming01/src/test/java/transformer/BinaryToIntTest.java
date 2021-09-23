package transformer;

import org.junit.Assert;
import org.junit.Test;

public class BinaryToIntTest {

    private Transformer transformer = new Transformer();

    @Test
    public void test1() {
        Assert.assertEquals("2",
                transformer.binaryToInt("00000000000000000000000000000010"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("0",
                transformer.binaryToInt("00000000000000000000000000000000"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("10",
                transformer.binaryToInt("00000000000000000000000000001010"));
    }

}
