package com.example.wallpaper.ui.adapter.recycler.other;

import android.view.View;

import com.example.wallpaper.R;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.base.BaseRecyclerAdaptor;
import com.example.wallpaper.interfese.Listener;

import java.util.List;

public class OtherRecyclerAdapter extends BaseRecyclerAdaptor<OtherViewHolder, ModelGallery> {
    private Listener listener;

    public OtherRecyclerAdapter(List<ModelGallery> list, Listener listener) {
        super(list,listener);
        this.listener = listener;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_other;
    }

    @Override
    protected OtherViewHolder getViewHolder(View view) {
        return new OtherViewHolder(view,listener);
    }
}
