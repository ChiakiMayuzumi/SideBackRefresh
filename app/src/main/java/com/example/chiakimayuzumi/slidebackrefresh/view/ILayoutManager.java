package com.example.chiakimayuzumi.slidebackrefresh.view;

import android.support.v7.widget.RecyclerView;

import com.example.chiakimayuzumi.slidebackrefresh.BaseListAdapter;


/**
 * Created by Stay on 5/3/16.
 * Powered by www.stay4it.com
 */
public interface ILayoutManager {
    RecyclerView.LayoutManager getLayoutManager();
    int findLastVisiblePosition();
    void setUpAdapter(BaseListAdapter adapter);
}
