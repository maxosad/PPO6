package com.osadchiy.java;

import java.text.ParseException;

public interface TokenInterface {
    public String toString();
    public TokenType getTokenType();
    void accept(Visitor visitor) throws ParseException;
}
