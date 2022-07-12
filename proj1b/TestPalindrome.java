import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage",actual );
    }
    @Test
    public void testisPalindrme() {
        boolean d = palindrome.isPalindrome("abcddcba");
        assertTrue(palindrome.isPalindrome("abccba"));
        assertTrue(d);
        assertFalse(palindrome.isPalindrome("abcddcb"));
        assertTrue(palindrome.isPalindrome(""));
    }
    @Test
    public void testisPalindreme() {
        OffByOne aa = new OffByOne();
        assertTrue(palindrome.isPalindrome("abccba",aa));
        assertFalse(palindrome.isPalindrome("abcddcb",aa));
        assertTrue(palindrome.isPalindrome("",aa));
    }
}
