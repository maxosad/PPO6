package com.osadchiy.java;

import com.osadchiy.java.tokens.NumberToken;
import com.osadchiy.java.tokens.OperatorToken;
import com.osadchiy.java.tokens.ParenthesisToken;

import java.text.ParseException;
import java.util.List;

public class PrintVisitor implements Visitor{

    String result = "";

    @Override
    public void visit(NumberToken token) {
        result += token.toString() + " ";
    }

    @Override
    public void visit(ParenthesisToken token) throws ParseException {
        result += token.toString() + " ";
    }

    @Override
    public void visit(OperatorToken token) {
        result += token.toString() + " ";
    }

    public String print(List<TokenInterface> tokens) throws ParseException {

        for (TokenInterface token: tokens) {
            //отпарвляем токену visitor чтобы токен пришел и записался
            token.accept(this);
        }

        return result;
    }

}
