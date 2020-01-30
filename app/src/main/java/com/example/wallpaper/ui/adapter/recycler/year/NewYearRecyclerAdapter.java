package com.example.wallpaper.ui.adapter.recycler.year;

import android.view.View;

import com.example.wallpaper.R;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.base.BaseRecyclerAdaptor;
import com.example.wallpaper.interfese.Listener;

import java.util.List;

public class NewYearRecyclerAdapter extends BaseRecyclerAdaptor<NewYearViewHolder, ModelGallery> {
    private Listener listener;

    public NewYearRecyclerAdapter(List<ModelGallery> list, Listener listener) {
        super(list,listener);
        this.listener = listener;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_new_uear;
    }

    @Override
    protected NewYearViewHolder getViewHolder(View view) {
        return new NewYearViewHolder(view,listener);
    }
}
