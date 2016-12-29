package com.alex_ttt.remindme.adapter.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alex_ttt.remindme.R;
import com.alex_ttt.remindme.adapter.RemindListAdapter;
import com.alex_ttt.remindme.dto.RemindDTO;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_history;
    private List<RemindDTO> data;
    private RemindListAdapter adapter;

    public static HistoryFragment getInstance(Context _context, List<RemindDTO> data){
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        fragment.setData(data);
        fragment.setContext(_context);
        fragment.setTitle(_context.getString(R.string.tab_item_history));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        //adapter = new RemindListAdapter(data);
        //rv.setAdapter(adapter);
        rv.setAdapter(new RemindListAdapter(createMockData()));

        return view;
    }

    private List<RemindDTO> createMockData() {
        List<RemindDTO> data = new ArrayList<>();
        data.add(new RemindDTO("Item 1"));
        data.add(new RemindDTO("Item 2"));
        data.add(new RemindDTO("Item 3"));
        data.add(new RemindDTO("Item 4"));
        data.add(new RemindDTO("Item 5"));
        data.add(new RemindDTO("Item 6"));

        return data;

    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<RemindDTO> data) {
        this.data = data;
    }

    public void RefreshData(List<RemindDTO> dataList){
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }

    public void refreshList(List<RemindDTO> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}
