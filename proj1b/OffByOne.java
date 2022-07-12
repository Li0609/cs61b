import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return (x - y) ==1 || (y - x) ==1;
    }
}
