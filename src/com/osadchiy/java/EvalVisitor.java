package com.osadchiy.java;

import com.osadchiy.java.tokens.NumberToken;
import com.osadchiy.java.tokens.OperatorToken;
import com.osadchiy.java.tokens.ParenthesisToken;

import java.text.ParseException;
import java.util.List;
import java.util.Stack;

import static com.osadchiy.java.TokenType.*;

public class EvalVisitor implements Visitor{
    private Stack<Integer> stack = new Stack<>();

    @Override
    public void visit(NumberToken token) {
        stack.add(token.getValue());
    }

    @Override
    public void visit(ParenthesisToken token) throws ParseException {}

    @Override
    public void visit(OperatorToken token) throws ParseException {
        try {
            int operand2 = stack.pop();
            int operand1 = stack.pop();
            if (token.getTokenType() == ADD) stack.add(operand1 + operand2);
            if (token.getTokenType() == SUB) stack.add(operand1 - operand2);
            if (token.getTokenType() == MUL) stack.add(operand1 * operand2);
            if (token.getTokenType() == DIV) stack.add(operand1 / operand2);
        } catch (Exception e) {
            throw new ParseException("Incorrect OPZ", 2);
        }
    }

    public int evaluate(List<TokenInterface> tokens) throws ParseException {
        for (TokenInterface token: tokens) {
            token.accept(this);
        }
        return stack.pop();
    }

}
