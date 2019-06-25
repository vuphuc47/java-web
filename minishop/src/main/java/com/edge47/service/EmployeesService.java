package com.edge47.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edge47.dao.EmployeesDao;
import com.edge47.entity.Employees;
import com.edge47.imp.NhanVienImp;

@Service
public class EmployeesService implements NhanVienImp{
	
	@Autowired
	EmployeesDao employeesDao;

	public boolean kiemtradangnhap(String email, String matkhau) {
		boolean kiemtra = employeesDao.kiemtradangnhap(email, matkhau);
		return kiemtra;
	}

	public boolean themnhanvien(Employees employees) {
		boolean ktthemnv = employeesDao.themnhanvien(employees);
		return ktthemnv;
	}
}
