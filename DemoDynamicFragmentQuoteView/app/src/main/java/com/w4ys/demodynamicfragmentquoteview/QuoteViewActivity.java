package com.w4ys.demodynamicfragmentquoteview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.w4ys.demodynamicfragmentquoteview.TitlesFragment.OnTitleClickListener;

public class QuoteViewActivity extends Activity implements OnTitleClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_view);

        if (findViewById(R.id.quoteViewContainer) != null) {

            if (savedInstanceState != null)
                return;

            // Add Titles fragment
            TitlesFragment titlesFragment = new TitlesFragment();

            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.quoteViewContainer, titlesFragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_title, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTitleSelected(int position) {
        QuotesFragment quotesFragment = (QuotesFragment) getFragmentManager()
                .findFragmentById(R.id.fragmentQuotes);

        if (quotesFragment == null) { // single fragment layout

            // You can not update the position after commit the fragment
            // So, you have to save the position to parameter and use it on onStart() method
            quotesFragment = new QuotesFragment();
            Bundle args = new Bundle();
            args.putInt(QuotesFragment.ARG_QUOTE_INDEX, position);
            quotesFragment.setArguments(args);

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.quoteViewContainer, quotesFragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            quotesFragment.updatePosition(position);
        }
    }
}
