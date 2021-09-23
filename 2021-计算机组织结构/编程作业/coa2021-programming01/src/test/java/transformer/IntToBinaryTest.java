package transformer;

import org.junit.Assert;
import org.junit.Test;

public class IntToBinaryTest {

	private Transformer transformer = new Transformer();

	@Test
	public void test1() {
		Assert.assertEquals("00000000000000000000000000000010",
				transformer.intToBinary("2"));
	}

}
