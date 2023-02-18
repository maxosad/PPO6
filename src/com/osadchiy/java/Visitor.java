package com.osadchiy.java;

import com.osadchiy.java.tokens.NumberToken;
import com.osadchiy.java.tokens.OperatorToken;
import com.osadchiy.java.tokens.ParenthesisToken;

import java.text.ParseException;

public interface Visitor {
    void visit(NumberToken token);
    void visit(ParenthesisToken token) throws ParseException;
    void visit(OperatorToken token) throws ParseException;
}
