package edu.isu.cs.cs2263.hw02;

import java.util.StringTokenizer;

public class StringTokenizerWithPushback extends StringTokenizer implements PushbackTokenizer
{
    // Variables
    // Tracks how many times nextToken() was called for pushback to function.
    private int timesNextCalled = 0;
    // Constructor variables. Needed when creating new StringTokenizer on pushback
    private String str;
    private String delim;
    private boolean returnDelims;
    // Internal StringTokenizer for use with pushback.
    private StringTokenizer internal;


    public StringTokenizerWithPushback(String str, String delim, boolean returnDelims)
    {
        super(str, delim, returnDelims);
        this.str = str;
        this.delim = delim;
        this.returnDelims = returnDelims;
        internal = new StringTokenizer(str, delim, returnDelims);
    }

    @Override
    public String nextToken()
    {
        timesNextCalled++;
        return internal.nextToken();
    }

    @Override
    public boolean hasMoreTokens()
    {
        return internal.hasMoreTokens();
    }

    @Override
    public void pushback()
    {
        // Replace internal with new StringTokenizer
        internal = new StringTokenizerWithPushback(str, delim, returnDelims);

        // Decrease timesNextCalled to reflect pushback
        timesNextCalled -= 1;

        // Call nextToken on copy correct amt. of times
        for (int i = 0; i < timesNextCalled; i++)
            internal.nextToken();
    }
}
