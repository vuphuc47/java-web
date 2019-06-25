package com.edge47.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "chitiethoadon")
public class ChiTietHoaDon {
	@EmbeddedId
	IdChiTietHoaDon chiTietHoaDon;

	int soluong;
	String giatien;

	public IdChiTietHoaDon getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(IdChiTietHoaDon chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

}
