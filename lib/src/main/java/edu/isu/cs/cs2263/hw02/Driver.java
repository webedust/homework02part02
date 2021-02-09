package edu.isu.cs.cs2263.hw02;

import java.util.StringTokenizer;

public class Driver
{
    public static void main(String[] args)
    {
        String test = "This is a sample sentence to test the adapted String Tokenizer w. pushback.";
        StringTokenizerAdapted tokenizer = new StringTokenizerAdapted(test, " ", false);

        System.out.println(tokenizer.nextToken());
        tokenizer.pushback();
        System.out.println(tokenizer.nextToken());
        tokenizer.pushback();
        System.out.println(tokenizer.nextToken());
        System.out.println(tokenizer.nextToken());
        tokenizer.pushback();
        System.out.println(tokenizer.nextToken());
        tokenizer.pushback();
        System.out.println(tokenizer.nextToken());
    }
}
