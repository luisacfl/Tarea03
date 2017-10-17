package com.example.luisacfl.tareatabs.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by luisacfl on 16/10/17.
 */

public class City implements Parcelable {
    private int idCity;
    private String name;

    public City(){

    }

    public City(int idCity, String name) {
        this.idCity = idCity;
        this.name = name;
    }

    protected City(Parcel in) {
        idCity = in.readInt();
        name = in.readString();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idCity);
        parcel.writeString(name);
    }
}
