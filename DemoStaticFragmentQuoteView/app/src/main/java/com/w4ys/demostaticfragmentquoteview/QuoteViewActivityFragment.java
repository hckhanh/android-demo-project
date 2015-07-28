package com.w4ys.demostaticfragmentquoteview;

import android.app.Activity;
import android.os.Bundle;


/**
 * A placeholder fragment containing a simple view.
 */
public class QuoteViewActivityFragment extends Activity implements  TitleFragment.OnTitleSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_view);
    }

    @Override
    public void onTitleSelected(int position) {
        QuoteFragment quoteFragment = (QuoteFragment) getFragmentManager().findFragmentById(R.id.quoteFragment);
        if (quoteFragment != null) {
            quoteFragment.updateQuote(position);
        }
    }
}
