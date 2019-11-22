package com.example.wallpaper.ui.adapter.recycler.winter;

import android.view.View;

import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.ui.adapter.base.BaseRecyclerAdaptor;

import java.util.List;

public class WinterRecyclerAdapter extends BaseRecyclerAdaptor<WinterViewHolder, Model> {
    public WinterRecyclerAdapter(List<Model> list) {
        super(list);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_winter;
    }

    @Override
    protected WinterViewHolder getViewHolder(View view) {
        return new WinterViewHolder(view);
    }
}
