package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/15 21:05
 * @version: 1.0
 */
public class I19lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int endIndex = s.length() - 1;
        while (s.charAt(endIndex) == ' '){
            endIndex--;
        }
        int wordLength = 0;
        while (endIndex >=0 && s.charAt(endIndex) !=' '){
            endIndex--;
            wordLength++;
        }
        return wordLength;
    }

    public static void main(String[] args) {
        new I19lengthOfLastWord().lengthOfLastWord("Hello World");
    }
}
