package com.w4ys.demostaticfragmentquoteview;

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
public class QuoteFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quotes, container, false);
    }

    public void updateQuote(int position) {
        TextView textView = (TextView) getActivity().findViewById(R.id.textViewQuote);
        String[] quotes = getResources().getStringArray(R.array.quotes);

        textView.setText(quotes[position]);
    }
}
