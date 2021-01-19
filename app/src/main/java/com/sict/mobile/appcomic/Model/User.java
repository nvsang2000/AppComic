package com.sict.mobile.appcomic.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User{
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("gioitinh")
    @Expose
    private int gioitinh;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("sdt")
    @Expose
    private int sdt;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("sl")
    @Expose
    private int sl;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public User() {
    }

    public User(int id, String name, int gioitinh, String date, int sdt, String email, int sl, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.gioitinh = gioitinh;
        this.date = date;
        this.sdt = sdt;
        this.email = email;
        this.sl = sl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gioitinh=" + gioitinh +
                ", date='" + date + '\'' +
                ", sdt=" + sdt +
                ", email='" + email + '\'' +
                ", sl=" + sl +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
