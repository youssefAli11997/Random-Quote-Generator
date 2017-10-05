package com.csed.youssefali.randomquote;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by youssefali on 04/10/17.
 */

public class MainMechanism {

    public class Quote{

        private String text;
        private String author;

        public Quote(String text, String author){
            this.text = text;
            this.author = author;
        }

        public String getAuthor() {
            return author;
        }

        public String getText() {
            return text;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public ArrayList<Quote> quotes;
    public Random randIndex;
    public int currRandIndex;
    public InputStream quotesFile;

    public MainMechanism(InputStream file){
        this.quotesFile = file;
        quotes = new ArrayList<>();
        readQuotesFile();
        //quotes.add(new Quote("I love you the more in that I believe you had liked me for my own sake and for nothing else."
        //        ,"John Keats"));
        randIndex = new Random();
        currRandIndex = -1;
    }

    public Quote getRandomQuote(){
        int index = randIndex.nextInt(quotes.size());
        while(index == currRandIndex){
            index = randIndex.nextInt(quotes.size());
        }
        Quote newQuote = quotes.get(index);
        currRandIndex = index;
        return newQuote;
    }

    public void readQuotesFile(){
        Scanner in;
        try {
            in = new Scanner(quotesFile);
            while(in.hasNextLine()){
                quotes.add(new Quote(in.nextLine(),in.nextLine()));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(quotes);
    }

}
