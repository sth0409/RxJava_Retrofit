package com.example.sth0409.rxjava_retrofit;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sth0409 on 2016/5/22.
 */
public class Cartoon_entity implements Parcelable {
    public String id;
    public String link;
    public String[] thumbnailList;
    public String time;
    public String title;


    public Cartoon_entity() {
    }

    public Cartoon_entity(String id, String link, String[] thumbnailList, String time, String title) {
        this.id = id;
        this.link = link;
        this.thumbnailList = thumbnailList;
        this.time = time;
        this.title = title;
    }

    protected Cartoon_entity(Parcel in) {
        id = in.readString();
        link = in.readString();
        thumbnailList = in.createStringArray();
        time = in.readString();
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(link);
        dest.writeStringArray(thumbnailList);
        dest.writeString(time);
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cartoon_entity> CREATOR = new Creator<Cartoon_entity>() {
        @Override
        public Cartoon_entity createFromParcel(Parcel in) {
            return new Cartoon_entity(in);
        }

        @Override
        public Cartoon_entity[] newArray(int size) {
            return new Cartoon_entity[size];
        }
    };
}
