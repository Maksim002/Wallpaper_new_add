package com.example.wallpaper.ui.main;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpaper.R;
import com.example.wallpaper.model.Model;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.recycler.year.NewYearRecyclerAdapter;
import com.example.wallpaper.ui.util.ResourceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NewYearFragment extends Fragment implements Listener {
    private RecyclerView recyclerView;
    private NewYearRecyclerAdapter adapter;
    private String SAMPLES = "year.json";

    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_new_year,container,false);

        recyclerView = view.findViewById(R.id.recyclerYear);
        recyclerView.setAdapter(adapter = new NewYearRecyclerAdapter(getQuestions(),this));
        adapter.updeteList(getQuestions());
        return view;
    }
    private List<ModelGallery> getQuestions() {
        String json = ResourceManager.readFromAssets(getContext(), SAMPLES);
        Type type = new TypeToken<List<ModelGallery>>() {
        }.getType();
        return new Gson().fromJson(json, type);
    }

    @Override
    public void onClick(int adapterPosition, ModelGallery data) {
        setProgressDialog();
        new OtherFragment.DownloadImageTask(requireContext())
                .execute(data.getUrl());
    }

    class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        Context context;

        public DownloadImageTask(Context context) {
            this.context = context;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            final WallpaperManager wpManager = WallpaperManager.getInstance(context);
            // Set the wallpaper
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                // Create the pitch black bitmap
                // On Android N and above use the new API to set both the general system wallpaper and
                // the lock-screen-specific wallpaper
                try {
                    wpManager.setBitmap(result, null, true, WallpaperManager.FLAG_SYSTEM | WallpaperManager.FLAG_LOCK);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    wpManager.setBitmap(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void setProgressDialog() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMax(100);
        progressDialog.setMessage("Its loading....");
        progressDialog.setTitle("Setting wallpaper");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progressDialog.getProgress() <= progressDialog
                            .getMax()) {
                        Thread.sleep(200);
                        handle.sendMessage(handle.obtainMessage());
                        if (progressDialog.getProgress() == progressDialog
                                .getMax()) {
                            progressDialog.dismiss();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @SuppressLint("HandlerLeak")
    Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDialog.incrementProgressBy(1);
        }
    };
}
