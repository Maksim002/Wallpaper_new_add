package com.example.wallpaper.ui.main;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpaper.R;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.recycler.winter.WinterRecyclerAdapter;
import com.example.wallpaper.ui.util.ResourceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class WinterFragment extends Fragment implements Listener {
    private RecyclerView recyclerView;
    private WinterRecyclerAdapter adapter;
    private String SAMPLES = "winter.json";
    private ImageView imageView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_winter, container, false);

        recyclerView = view.findViewById(R.id.recyclerWinter);
        recyclerView.setAdapter(adapter = new WinterRecyclerAdapter(getQuestions(), this));
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
    public void onClick(int adapterPosition, ModelGallery data) throws IOException {

        new DownloadImageTask(requireContext())
                .execute(data.getUrl());

        }
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
                    Toast.makeText(context, "set", Toast.LENGTH_SHORT).show();
                    wpManager.setBitmap(result, null, true, WallpaperManager.FLAG_LOCK | WallpaperManager.FLAG_SYSTEM);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
                try {
                    wpManager.setBitmap(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

