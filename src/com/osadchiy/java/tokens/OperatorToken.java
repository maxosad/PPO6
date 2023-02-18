package com.osadchiy.java.tokens;

import com.osadchiy.java.TokenInterface;
import com.osadchiy.java.TokenType;
import com.osadchiy.java.Visitor;

import java.text.ParseException;

import static com.osadchiy.java.TokenType.*;


public class OperatorToken implements TokenInterface {
    @Override
    public String toString() {
        return op.toString();
    }

    @Override
    public TokenType getTokenType() {
        return op;
    }

    @Override
    public void accept(Visitor visitor) throws ParseException {
        visitor.visit(this);
    }


    private TokenType op;

    public OperatorToken(char expr) {
        if (expr == '+') op = ADD;
        if (expr == '-') op = SUB;
        if (expr == '/') op = DIV;
        if (expr == '*') op = MUL;
    }
}
