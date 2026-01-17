package org.example.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthisis {

    public static void main(String args[]){
        GenerateParenthisis obj = new GenerateParenthisis();
        obj.generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        recur(0,0,"",result, n);
        return result;

    }

    private void recur(int left, int right, String cur, List<String> result, int n){

        if(cur.length()==n*2){
            result.add(cur);
            return;
        }

        if(left<n){
            recur(left+1, right, cur+'(', result, n);

        }
        if(right<left)
            recur(left, right+1, cur+')', result, n);
    }
}
