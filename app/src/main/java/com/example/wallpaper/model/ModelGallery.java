package com.example.wallpaper.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelGallery implements Parcelable {

    private int id;
    private String url;

    public ModelGallery(int id, String url) {
        this.id = id;
        this.url = url;
    }

    protected ModelGallery(Parcel in) {
        id = in.readInt();
        url = in.readString();
    }

    public static final Creator<ModelGallery> CREATOR = new Creator<ModelGallery>() {
        @Override
        public ModelGallery createFromParcel(Parcel in) {
            return new ModelGallery(in);
        }

        @Override
        public ModelGallery[] newArray(int size) {
            return new ModelGallery[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(url);
    }
}
