package com.edge47.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edge47.entity.ChiTietHoaDon;
import com.edge47.entity.IdChiTietHoaDon;
import com.edge47.imp.ChiTietHoaDonimp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDao implements ChiTietHoaDonimp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean themchitiethoadon(ChiTietHoaDon chiTietHoaDon) {
		Session session = sessionFactory.getCurrentSession();
		IdChiTietHoaDon id = (IdChiTietHoaDon) session.save(chiTietHoaDon);
		if(null != id) {
			return true;
		}else {
			return false;
		}
	}

}
