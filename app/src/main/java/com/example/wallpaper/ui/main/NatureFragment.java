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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpaper.R;
import com.example.wallpaper.interfese.Listener;
import com.example.wallpaper.interfese.ListenerFerbase;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.recycler.nature.NatureRecyclerAdapter;
import com.example.wallpaper.ui.main.password.ActivityPassword;
import com.example.wallpaper.ui.util.ResourceManager;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NatureFragment extends Fragment implements Listener, ListenerFerbase {
    private RecyclerView recyclerView;
    private NatureRecyclerAdapter adapter;
    private String SAMPLES = "nature.json";
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private List<String> res;

    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nature, container, false);

        database = FirebaseDatabase.getInstance();




        recyclerView = view.findViewById(R.id.recyclerNature);
        recyclerView.setAdapter(adapter = new NatureRecyclerAdapter(getQuestions(), this, this));
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
    public void onClick(int adapterPosition, final ModelGallery data) {
        setProgressDialog();
        new DownloadImageTask(requireContext()).execute(data.getUrl());

    }

    @Override
    public void ClicFaer(final ModelGallery modelGallery) {


        reference = database.getReference().child("galley").child(ActivityPassword.userId);
        reference.push().setValue(modelGallery.getUrl());

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
                    wpManager.setBitmap(result, null, true, WallpaperManager.FLAG_LOCK | WallpaperManager.FLAG_SYSTEM);
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
                        Thread.sleep(100);
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
