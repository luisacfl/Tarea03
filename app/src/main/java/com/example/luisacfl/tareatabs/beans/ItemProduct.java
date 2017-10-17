package com.example.luisacfl.tareatabs.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by luisacfl on 24/09/17.
 */
public class ItemProduct implements Parcelable {

    private int code;
    private int image;
    private String title;
    private String location;
    private String phone;
    private String description;
    private Category category;
    private Store store;

    public ItemProduct(){

    }

    public ItemProduct(int code, int image, String title, String description, Category category, Store store) {
        this.code = code;
        this.image = image;
        this.title = title;
        this.description = description;
        this.category = category;
        this.store = store;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static final Creator<ItemProduct> CREATOR = new Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel in) {
            return new ItemProduct(in);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "ItemProduct{" +
                "image=" + image +
                ", title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public ItemProduct(Parcel in) {
        code = in.readInt();
        image = in.readInt();
        title = in.readString();
        description = in.readString();
        store = in.readParcelable(Store.class.getClassLoader());
        category = in.readParcelable(Category.class.getClassLoader());
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeInt(image);
        dest.writeParcelable(store, flags);
        dest.writeParcelable(category, flags);
    }
}