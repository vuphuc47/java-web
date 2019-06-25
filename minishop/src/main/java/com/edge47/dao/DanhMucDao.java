package com.edge47.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edge47.entity.DanhMucSanPham;
import com.edge47.imp.DanhMucImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDao implements DanhMucImp{
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<DanhMucSanPham> laydanhmuc() {
		Session session = sessionFactory.getCurrentSession();
		String str = "from danhmucsanpham";
		List<DanhMucSanPham> laydanhmuc = session.createQuery(str).getResultList();
		return laydanhmuc;
	}
	
}
