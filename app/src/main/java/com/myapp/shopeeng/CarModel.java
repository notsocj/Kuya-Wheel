package com.myapp.shopeeng;

import android.os.Parcel;
import android.os.Parcelable;

public class CarModel implements Parcelable {
    private String name;
    private int imageResId;
    private int price;

    public CarModel(String name, int imageResId, int price) {
        this.name = name;
        this.imageResId = imageResId;
        this.price = price;
    }

    protected CarModel(Parcel in) {
        name = in.readString();
        imageResId = in.readInt();
        price = in.readInt();
    }

    public static final Creator<CarModel> CREATOR = new Creator<CarModel>() {
        @Override
        public CarModel createFromParcel(Parcel in) {
            return new CarModel(in);
        }

        @Override
        public CarModel[] newArray(int size) {
            return new CarModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResId);
        dest.writeInt(price);
    }
}