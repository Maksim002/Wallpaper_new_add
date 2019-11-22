package com.example.wallpaper.ui.adapter.recycler.nature;

import android.view.View;

import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.ui.adapter.base.BaseRecyclerAdaptor;

import java.util.List;

public class NatureRecyclerAdapter extends BaseRecyclerAdaptor<NatureViewHolder, Model> {
    public NatureRecyclerAdapter(List<Model> list) {
        super(list);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_nature;
    }

    @Override
    protected NatureViewHolder getViewHolder(View view) {
        return new NatureViewHolder(view);
    }
}
