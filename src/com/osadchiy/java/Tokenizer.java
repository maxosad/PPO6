package com.osadchiy.java;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.osadchiy.java.tokens.*;

import static java.lang.Character.isDigit;

public class Tokenizer {


    private boolean isParenthesis(char x) {
        return x == '(' || x == ')';
    }

    private boolean isSpace(char x) {
        return x == ' ';
    }

    private boolean isOperator(char x) {
        return x == '+' || x == '-' || x == '/' || x == '*';
    }


    public List<TokenInterface> tokenize(String expr) throws ParseException {
        ArrayList<TokenInterface> tokens = new ArrayList<>();
        int len = expr.length();
        for (int i = 0; i < len; i++) {
            char curr = expr.charAt(i);
            if (isSpace(curr)) continue;
            if (isParenthesis(curr)) {
                tokens.add(new ParenthesisToken(curr));
                continue;
            }
            if (isOperator(curr)) {

                tokens.add(new OperatorToken(curr));
                continue;
            }
            if (isDigit(curr)) {
                int pos;
                for (pos = i + 1; pos < len; pos++) {
                    if(isDigit(expr.charAt(pos))) {
                        continue;
                    } else
                        break;
                }

                tokens.add(new NumberToken(Integer.parseInt(expr.substring(i, pos))));
                i = pos - 1;
               continue;
            }
            throw new ParseException("unnown symbol in " + i, 1);
        }
        return tokens;
    }



}
