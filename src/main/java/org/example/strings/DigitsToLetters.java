package org.example.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitsToLetters {

    public static void main(String[] args) {
        DigitsToLetters obj = new DigitsToLetters();
        obj.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if(digits.length()==0 || digits == null) return result;

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtracking(0, digits, new StringBuilder(), result, digitToLetters);
        return result;
    }


    private void backtracking(Integer index, String digit, StringBuilder current, List<String> result, Map<Character, String> digitToLetters){
        if(index == digit.length()){
            result.add(current.toString());
            return;
        }

        String letters = digitToLetters.get(digit.charAt(index));

        for(char s : letters.toCharArray()) {
            current.append(s);
            backtracking(index+1, digit, current, result, digitToLetters);
            current.deleteCharAt(current.length()-1);
        }


    }
}
