package com.edge47.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edge47.dao.HoaDonDao;
import com.edge47.entity.HoaDon;
import com.edge47.imp.HoaDonImp;

@Service
public class HoaDonService implements HoaDonImp{

	@Autowired
	HoaDonDao hoaDonDao;
	
	public int themhoadon(HoaDon hoaDon) {
		return hoaDonDao.themhoadon(hoaDon);
	}

}
