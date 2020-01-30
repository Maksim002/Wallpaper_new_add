package com.example.wallpaper.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelGallery implements Parcelable {

    private int id;
    private String url;
    private Boolean kyi;

    public ModelGallery(String url) {
        this.url = url;
    }

    protected ModelGallery(Parcel in) {
        id = in.readInt();
        url = in.readString();
        byte tmpKyi = in.readByte();
        kyi = tmpKyi == 0 ? null : tmpKyi == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(url);
        dest.writeByte((byte) (kyi == null ? 0 : kyi ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
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

    public Boolean getKyi() {
        return kyi;
    }

    public void setKyi(Boolean kyi) {
        this.kyi = kyi;
    }

    public ModelGallery(int id, String url) {
        this.id = id;
        this.url = url;
    }
}
