/**
 * 
 */
package ProjectVehicle;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author shiri
 *
 */
class SeleniumCallWebPageTest {
	
	@Test
	  public void testStringConcat() {
		SeleniumCallWebPage tester = new SeleniumCallWebPage();
	    Assert.assertTrue("Test Passed", tester.DoMethod());
	  }

	@Test
	void test() {
		Assert.assertFalse(false);
	}

}
