package com.example.chiakimayuzumi.slidebackrefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


import com.example.chiakimayuzumi.slidebackrefresh.view.DividerItemDecoration;
import com.example.chiakimayuzumi.slidebackrefresh.view.ILayoutManager;
import com.example.chiakimayuzumi.slidebackrefresh.view.MyLinearLayoutManager;
import com.example.chiakimayuzumi.slidebackrefresh.view.PullRecycler;

import java.util.ArrayList;


/**
 * Created by Stay on 25/2/16.
 * Powered by www.stay4it.com
 */
public abstract class BaseListActivity<T> extends SideBackRefreshActivity implements PullRecycler.OnRecyclerRefreshListener {
    protected BaseListAdapter adapter;
    protected ArrayList<T> mDataList;
    protected PullRecycler recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpContentView();
        setUpView();
        setUpData();
    }

    protected abstract void setUpContentView();

    protected abstract void setUpView() ;


    protected  void setUpData(){
        setUpAdapter();
        recycler.setOnRefreshListener(this);
        recycler.setLayoutManager(getLayoutManager());
        recycler.addItemDecoration(getItemDecoration());
        recycler.setAdapter(adapter);
    }

    protected void setUpAdapter() {
        adapter = new ListAdapter();
    }

    protected ILayoutManager getLayoutManager() {
        return new MyLinearLayoutManager(getApplicationContext());
    }

    protected RecyclerView.ItemDecoration getItemDecoration() {
        return new DividerItemDecoration(getApplicationContext(), R.drawable.list_divider);
    }

    public class ListAdapter extends BaseListAdapter {

        @Override
        protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
            return getNormalViewHolder(parent, viewType);
        }

        @Override
        protected int getDataCount() {
            return mDataList != null ? mDataList.size() : 0;
        }

        @Override
        protected int getDataViewType(int position) {
            return getItemType(position);
        }

        @Override
        public boolean isSectionHeader(int position) {
            return BaseListActivity.this.isSectionHeader(position);
        }
    }



    protected boolean isSectionHeader(int position) {
        return false;
    }
    protected int getItemType(int position) {
        return 0;
    }
    protected abstract BaseViewHolder getNormalViewHolder(ViewGroup parent, int viewType);

}