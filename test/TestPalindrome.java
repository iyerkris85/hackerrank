import org.junit.Assert;
import org.junit.Test;

/**
 * Created by krishnandevarajan on 2/28/17.
 */


public class TestPalindrome extends Palindrome{

    @Test
    public void testPalindrome(){

       String testinput1 = "foof";     // Even characters palindrome
       String testinput2 = "foiof";    // Odd character palindrome
       String testinput3 = "abcdef";   // Even Not a palindrome
       String testinput4 = "abcdefg";  // Odd Not a palindrome
       String testinput5 = "fooF";     // Case Sensitive Not a palindrome

       Assert.assertTrue(isPalindrome(testinput1));
       Assert.assertTrue(isPalindrome(testinput2));
       Assert.assertFalse(isPalindrome(testinput3));
       Assert.assertFalse(isPalindrome(testinput4));
       Assert.assertFalse(isPalindrome(testinput5));
    }

}
