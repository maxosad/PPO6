package com.osadchiy.java.tokens;

import com.osadchiy.java.TokenInterface;
import com.osadchiy.java.TokenType;
import com.osadchiy.java.Visitor;

import java.text.ParseException;

public class NumberToken implements TokenInterface {
    private Integer x;

    public NumberToken(Integer x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "NUMBER(" + x.toString() + ")";
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.NUM;
    }


    public void accept(Visitor visitor) throws ParseException {
        visitor.visit(this);
    }

    public Integer getValue() {
        return x;
    }

}
