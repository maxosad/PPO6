package com.osadchiy.test;
import com.osadchiy.java.*;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FullPipeline extends Assert {
    private int allPipe(String s) throws Exception {
        Tokenizer tokenizer = new Tokenizer();
        List<TokenInterface> tokens;
        List<TokenInterface> modifiedTokens;
        int result = 0;
        //input empty string to stop



        tokens = tokenizer.tokenize(s);
        modifiedTokens = new ParserVisitor().parse(tokens);
        result = new EvalVisitor().evaluate(modifiedTokens);

        return result;
    }


    @Test
    public void pureString2Int() {
        String[] strings = new String[] {
                "1",
                "1+2",
                "1-2",
                "1*2",
                "2/1",
                "2+2*2",
                "(2+2) * 2",
                "2+2*2 - 6 /3"
        };

        int[] ans = new int[] {
                1,
                3,
                -1,
                2,
                2,
                6,
                8,
                4};


        for (int i = 0; i < strings.length; i++) {
            try {
                assertEquals(allPipe(strings[i]), ans[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void exceptionTest() {
        String [] exceptionStrings = new String[] {
                "1 +",
                "(1+2))"
        };
        for (int i = 0; i < exceptionStrings.length; i++) {
            int finalI = i;
            assertThrows(ParseException.class,() -> allPipe(exceptionStrings[finalI]));
        }

    }

}
