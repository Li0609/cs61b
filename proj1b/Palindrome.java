import java.util.*;

import static org.junit.Assert.assertEquals;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        int i = word.length();
        Deque<Character> LinkedChar = new ArrayDeque<Character>();
        for (int j = 0; j < i; j++) {
            LinkedChar.addLast(word.charAt(j));
        }
        return LinkedChar;
    }
    private boolean helper(Deque<Character> dd){
        if(dd.size() == 0 || dd.size() == 1){
            return true;
        }else if(dd.removeFirst() != dd.removeLast()){
            return false;
        }else{
            return helper(dd);
        }

    }
    public boolean isPalindrome(String word){
        Deque<Character> dd = this.wordToDeque(word);
        return helper(dd);

    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        int j = word.length();
        if(j == 0 || j == 1){
            return true;
        }
        for(int i = 0; i<=j/2-1; i++){
            char x = word.charAt(i);
            char y = word.charAt(j-i-1);
            if(!cc.equalChars(x, y)){
                return false;
            }
        }
        return true;
    }
}
