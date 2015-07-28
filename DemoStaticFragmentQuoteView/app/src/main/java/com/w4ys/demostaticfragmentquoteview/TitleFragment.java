package com.w4ys.demostaticfragmentquoteview;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by hckhanh on 28/07/2015.
 */
public class TitleFragment extends ListFragment {

    OnTitleSelectedListener onItemClickListener = null;

    interface OnTitleSelectedListener {
        void onTitleSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onItemClickListener = (OnTitleSelectedListener) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] titles = getResources().getStringArray(R.array.titles);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, titles));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        onItemClickListener.onTitleSelected(position);

        l.setItemChecked(position, true);
    }
}
