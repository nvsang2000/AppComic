package com.sict.mobile.appcomic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chapter{

    @SerializedName("idchapter")
    @Expose
    private Integer idchapter;
    @SerializedName("tenchap")
    @Expose
    private String tenchap;
    @SerializedName("noidung")
    @Expose
    private String noidung;
    @SerializedName("idtruyen")
    @Expose
    private Integer idtruyen;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Chapter(Integer idchapter, String tenchap, String noidung, Integer idtruyen, String createdAt, String updatedAt) {
        this.idchapter = idchapter;
        this.tenchap = tenchap;
        this.noidung = noidung;
        this.idtruyen = idtruyen;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getIdchapter() {
        return idchapter;
    }

    public void setIdchapter(Integer idchapter) {
        this.idchapter = idchapter;
    }

    public String getTenchap() {
        return tenchap;
    }

    public void setTenchap(String tenchap) {
        this.tenchap = tenchap;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Integer getIdtruyen() {
        return idtruyen;
    }

    public void setIdtruyen(Integer idtruyen) {
        this.idtruyen = idtruyen;
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
        return "Chapter{" +
                "idchapter=" + idchapter +
                ", tenchap='" + tenchap + '\'' +
                ", noidung='" + noidung + '\'' +
                ", idtruyen=" + idtruyen +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
