package com.alex_ttt.remindme.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.alex_ttt.remindme.adapter.fragments.AbstractTabFragment;
import com.alex_ttt.remindme.adapter.fragments.BirthdaysFragment;
import com.alex_ttt.remindme.adapter.fragments.HistoryFragment;
import com.alex_ttt.remindme.adapter.fragments.IdeasFragment;
import com.alex_ttt.remindme.adapter.fragments.TodoFragment;
import com.alex_ttt.remindme.dto.RemindDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter{

    private Map<Integer, AbstractTabFragment> tabs = new HashMap<>();
    private Context context;
    private HistoryFragment historyFragment;

    private List<RemindDTO> data;

    public TabsFragmentAdapter(Context _context, FragmentManager fm) {
        super(fm);
        this.data = new ArrayList<>();
        this.context = _context;
        initTabsMap();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    private void initTabsMap() {
        historyFragment = HistoryFragment.getInstance(context, data);
        tabs.put(0, historyFragment);
        tabs.put(1, IdeasFragment.getInstance(context));
        tabs.put(2, TodoFragment.getInstance(context));
        tabs.put(3, BirthdaysFragment.getInstance(context));
    }

    public void setData(List<RemindDTO> data) {
        this.data = data;
        historyFragment.RefreshData(data);
    }
}
