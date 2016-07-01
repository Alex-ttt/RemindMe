package com.alex_ttt.remindme.adapter.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alex_ttt.remindme.R;

public class IdeasFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_example;

    public static IdeasFragment getInstance(Context _context){
        Bundle args = new Bundle();
        IdeasFragment fragment = new IdeasFragment();
        fragment.setArguments(args);
        fragment.setContext(_context);
        fragment.setTitle(_context.getString(R.string.tab_item_ideas));
        
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
