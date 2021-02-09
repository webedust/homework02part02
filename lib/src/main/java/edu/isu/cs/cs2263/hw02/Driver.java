package edu.isu.cs.cs2263.hw02;

public class Driver
{
    public static void main(String[] args)
    {
        String test = "This is a sample sentence to test the adapted String Tokenizer with pushback.";
        StringTokenizerWithPushback tokenizer = new StringTokenizerWithPushback(test, " ", false);

        // Pushback testing
        String nextFormat = "Next token: ";
        String pbFormat = "Pushback called.";
        System.out.println("Testing Pushback function on the following string:\n" + test);

        System.out.println("Next token: " + tokenizer.nextToken());

        tokenizer.pushback();
        System.out.println(pbFormat);

        System.out.println(nextFormat + tokenizer.nextToken());
        System.out.println(nextFormat + tokenizer.nextToken());

        tokenizer.pushback();
        System.out.println(pbFormat);

        System.out.println(nextFormat + tokenizer.nextToken());
        System.out.println(nextFormat + tokenizer.nextToken());

        tokenizer.pushback();
        System.out.println(pbFormat);
        tokenizer.pushback();
        System.out.println(pbFormat);
        tokenizer.pushback();
        System.out.println(pbFormat);

        while (tokenizer.hasMoreTokens())
            System.out.println(nextFormat + tokenizer.nextToken());

        System.out.println("\n\nPushback function test complete.");
    }
}
