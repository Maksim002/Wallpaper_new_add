package com.example.wallpaper.ui.adapter.recycler.other;

import android.view.View;

import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.ui.adapter.base.BaseRecyclerAdaptor;

import java.util.List;

public class OtherRecyclerAdapter extends BaseRecyclerAdaptor<OtherViewHolder, Model> {
    public OtherRecyclerAdapter(List<Model> list) {
        super(list);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_other;
    }

    @Override
    protected OtherViewHolder getViewHolder(View view) {
        return new OtherViewHolder(view);
    }
}
