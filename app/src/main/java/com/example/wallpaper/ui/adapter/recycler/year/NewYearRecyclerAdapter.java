package com.example.wallpaper.ui.adapter.recycler.year;

import android.view.View;

import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.ui.adapter.base.BaseRecyclerAdaptor;
import com.example.wallpaper.ui.main.Listener;

import java.util.List;

public class NewYearRecyclerAdapter extends BaseRecyclerAdaptor<NewYearViewHolder, Model> {
    public NewYearRecyclerAdapter(List<Model> list, Listener listener) {
        super(list,listener);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_new_uear;
    }

    @Override
    protected NewYearViewHolder getViewHolder(View view) {
        return new NewYearViewHolder(view);
    }
}
