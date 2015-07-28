package com.w4ys.demodynamicfragmentquoteview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hckhanh on 28/07/2015.
 */
public class QuotesFragment extends Fragment {

    public static final String ARG_QUOTE_INDEX = "quote_index";
    String[] quotes;
    private int mCurrentPos = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null)
            mCurrentPos = savedInstanceState.getInt(ARG_QUOTE_INDEX);

        quotes = getResources().getStringArray(R.array.quotes);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.quote_view, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // When this method is execute,
        // the layout has applied to the fragment and now it is available. :D
        Bundle args = getArguments();
        if (args != null) {
            updatePosition(args.getInt(ARG_QUOTE_INDEX));
        } else if (mCurrentPos != -1) {
            updatePosition(mCurrentPos);
        }
    }

    public void updatePosition(int position) {
        TextView quoteView = (TextView) getView();

        if (quoteView != null)
            quoteView.setText(quotes[position]);

        mCurrentPos = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(ARG_QUOTE_INDEX, mCurrentPos);
    }
}
