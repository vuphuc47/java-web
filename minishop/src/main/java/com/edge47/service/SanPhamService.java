package com.edge47.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edge47.dao.SanPhamDao;
import com.edge47.entity.SanPham;
import com.edge47.imp.SanPhamImp;

@Service
public class SanPhamService implements SanPhamImp {
	
	@Autowired
	SanPhamDao sanPhamDao;

	public List<SanPham> danhsachsanpham(int sodau) {
		
		return sanPhamDao.danhsachsanpham(sodau);
	}

	public SanPham chitietsanpham(int masanpham) {
		
		return sanPhamDao.chitietsanpham(masanpham);
	}

	public List<SanPham> laydanhsachsptheoid(int madanhmuc) {
		return sanPhamDao.laydanhsachsptheoid(madanhmuc);
	}
	
	

}
