package com.example.wallpaper.ui.adapter.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpaper.ui.main.Listener;

public abstract class BaseViewHolder<V> extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public abstract void bind(V data);

    public abstract void unbind();
}
