package com.edge47.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edge47.dao.DanhMucDao;
import com.edge47.entity.DanhMucSanPham;
import com.edge47.imp.DanhMucImp;

@Service
public class DanhMucService implements DanhMucImp{
	
	@Autowired
	DanhMucDao danhMucDao;

	public List<DanhMucSanPham> laydanhmuc() {
		
		return danhMucDao.laydanhmuc();
	}

}
