package com.csed.youssefali.randomquote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainMechanism mainMecha;
    MainMechanism.Quote quote;
    TextView quoteText;
    TextView quoteAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainMecha = new MainMechanism(getResources().openRawResource(R.raw.quotes));
        quoteText = (TextView) findViewById(R.id.text);
        quoteAuthor = (TextView) findViewById(R.id.author);

        quote = mainMecha.getRandomQuote();
        quoteText.setText(quote.getText());
        quoteAuthor.setText(quote.getAuthor());
    }

    public void getNewQuote(View view) {
        quote = mainMecha.getRandomQuote();
        quoteText.setText(quote.getText());
        quoteAuthor.setText(quote.getAuthor());
    }
}
