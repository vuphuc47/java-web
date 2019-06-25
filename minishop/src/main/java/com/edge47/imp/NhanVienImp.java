package com.edge47.imp;

import com.edge47.entity.Employees;

public interface NhanVienImp {
	boolean kiemtradangnhap(String email, String matkhau);
	boolean themnhanvien(Employees employees);
}
