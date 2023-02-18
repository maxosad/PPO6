package com.osadchiy.java;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String expr = in.nextLine();
        Tokenizer tokenizer = new Tokenizer();
        List<TokenInterface> tokens;
        List<TokenInterface> modifiedTokens;
        int result = 0;
        //input empty string to stop
        while (!expr.equals("")) {
            try {

                tokens = tokenizer.tokenize(expr);
                modifiedTokens = new ParserVisitor().parse(tokens);
                result = new EvalVisitor().evaluate(modifiedTokens);
                System.out.println(new PrintVisitor().print(tokens));
                System.out.println(new PrintVisitor().print(modifiedTokens));
                System.out.println("Answer = " + result);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            expr = in.nextLine();
        }
    }
}
