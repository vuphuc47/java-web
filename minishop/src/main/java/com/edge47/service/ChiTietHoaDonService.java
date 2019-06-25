package com.edge47.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edge47.dao.ChiTietHoaDonDao;
import com.edge47.entity.ChiTietHoaDon;
import com.edge47.imp.ChiTietHoaDonimp;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonimp{
	
	@Autowired
	ChiTietHoaDonDao chiTietHoaDonDao;

	public boolean themchitiethoadon(ChiTietHoaDon chiTietHoaDon) {
		return chiTietHoaDonDao.themchitiethoadon(chiTietHoaDon);
	}

}
