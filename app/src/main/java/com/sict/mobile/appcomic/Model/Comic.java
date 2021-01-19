package com.sict.mobile.appcomic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Comic implements Serializable{
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tentruyen")
    @Expose
    private String tentruyen;
    @SerializedName("hinh")
    @Expose
    private String hinh;
    @SerializedName("chitiet")
    @Expose
    private String chitiet;
    @SerializedName("trangthai")
    @Expose
    private String trangthai;
    @SerializedName("idchitiet")
    @Expose
    private Integer idchitiet;
    @SerializedName("idtheloai")
    @Expose
    private Integer idtheloai;
    @SerializedName("iddanhmuc")
    @Expose
    private Integer iddanhmuc;
    @SerializedName("view")
    @Expose
    private Integer view;
    @SerializedName("sl")
    @Expose
    private Integer sl;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Comic(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public Comic(Integer id, String tentruyen, String hinh, String chitiet, String trangthai, Integer idchitiet, Integer idtheloai, Integer iddanhmuc, Integer view, Integer sl, String createdAt, String updatedAt) {
        this.id = id;
        this.tentruyen = tentruyen;
        this.hinh = hinh;
        this.chitiet = chitiet;
        this.trangthai = trangthai;
        this.idchitiet = idchitiet;
        this.idtheloai = idtheloai;
        this.iddanhmuc = iddanhmuc;
        this.view = view;
        this.sl = sl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Comic() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTentruyen() {
        return tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public Integer getIdchitiet() {
        return idchitiet;
    }

    public void setIdchitiet(Integer idchitiet) {
        this.idchitiet = idchitiet;
    }

    public Integer getIdtheloai() {
        return idtheloai;
    }

    public void setIdtheloai(Integer idtheloai) {
        this.idtheloai = idtheloai;
    }

    public Integer getIddanhmuc() {
        return iddanhmuc;
    }

    public void setIddanhmuc(Integer iddanhmuc) {
        this.iddanhmuc = iddanhmuc;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
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
        return "Comic{" +
                "id=" + id +
                ", tentruyen='" + tentruyen + '\'' +
                ", hinh='" + hinh + '\'' +
                ", chitiet='" + chitiet + '\'' +
                ", trangthai='" + trangthai + '\'' +
                ", idchitiet=" + idchitiet +
                ", idtheloai=" + idtheloai +
                ", iddanhmuc=" + iddanhmuc +
                ", view=" + view +
                ", sl=" + sl +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
