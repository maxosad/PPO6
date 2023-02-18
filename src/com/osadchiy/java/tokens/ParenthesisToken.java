package com.osadchiy.java.tokens;

import com.osadchiy.java.TokenInterface;
import com.osadchiy.java.TokenType;
import com.osadchiy.java.Visitor;

import java.text.ParseException;

import static com.osadchiy.java.TokenType.*;


public class ParenthesisToken implements TokenInterface {

    private TokenType p;
    public ParenthesisToken(char exp) {
        switch (exp) {
            case '(':
                p = LEFT;
                break;
            case ')':
                p = RIGHT;
                break;
        }
    }
    @Override
    public String toString() {
       return p.toString();
    }

    @Override
    public TokenType getTokenType() {
        return p;
    }

    public void accept(Visitor visitor) throws ParseException {
        visitor.visit(this);
    }


}
