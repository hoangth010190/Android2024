package com.example.facebookfake.classes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Friend implements Parcelable {
    private String id;
    private String name;

    private String avatar;
    private String description;
    private String info;

    public Friend(String id, String name, String avatar, String description, String info) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.description = description;
        this.info = info;
    }

    protected Friend(Parcel in) {
        id = in.readString();
        name = in.readString();
        avatar = in.readString();
        description = in.readString();
        info = in.readString();
    }

    public static final Creator<Friend> CREATOR = new Creator<Friend>() {
        @Override
        public Friend createFromParcel(Parcel in) {
            return new Friend(in);
        }

        @Override
        public Friend[] newArray(int size) {
            return new Friend[size];
        }
    };

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(avatar);
        parcel.writeString(description);
        parcel.writeString(info);
    }
}
