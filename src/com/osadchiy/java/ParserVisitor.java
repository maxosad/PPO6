package com.osadchiy.java;

import com.osadchiy.java.tokens.NumberToken;
import com.osadchiy.java.tokens.OperatorToken;
import com.osadchiy.java.tokens.ParenthesisToken;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.osadchiy.java.TokenType.*;



public class ParserVisitor implements Visitor {
    List<TokenInterface> result = new ArrayList<>();
    Stack<TokenInterface> stack = new Stack<>();

    @Override
    public void visit(NumberToken token) {
        result.add(token);
    }

    @Override
    public void visit(ParenthesisToken token) throws ParseException {
        if (token.getTokenType() == LEFT) {
            stack.add(token);
        } else {
            while (!stack.isEmpty() && stack.peek().getTokenType() != LEFT) {
                result.add(stack.pop());
            }
            if (stack.isEmpty()) {
                throw new ParseException("LEFT Parenthesis expected", 1);
            }
            stack.pop();
        }
    }


    private boolean isOperator(TokenType type) {
        return (type == ADD || type == SUB || type == MUL || type == DIV);
    }


    @Override
    public void visit(OperatorToken token) {
        while (!stack.isEmpty() && (token.getTokenType() == ADD || token.getTokenType() == SUB) && (isOperator(stack.peek().getTokenType()))) {
            result.add(stack.pop());
        }
        stack.add(token);
    }

    public List<TokenInterface> parse(List<TokenInterface> tokens) throws ParseException {

        for (TokenInterface token: tokens) {
            token.accept(this);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }


}
