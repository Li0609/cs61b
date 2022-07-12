import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return x == y;
    }
    @Test
    public void TestOffByOne(){
        OffByOne aa = new OffByOne();
        assertFalse(aa.equalChars('a','b'));
        assertTrue((aa.equalChars('a','a')));

    }

    public static void main(String[] args) {
        char x = 'a';
        char y = 'A';
        OffByOne aa = new OffByOne();
        System.out.println(aa.equalChars(x,y));
    }
}
