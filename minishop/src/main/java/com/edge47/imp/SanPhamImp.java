package com.edge47.imp;

import java.util.List;

import com.edge47.entity.SanPham;

public interface SanPhamImp {
	List<SanPham> danhsachsanpham(int sodau);
	SanPham chitietsanpham(int masanpham);
	List<SanPham> laydanhsachsptheoid(int madanhmuc);
}
