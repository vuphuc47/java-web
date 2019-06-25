package com.edge47.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edge47.entity.HoaDon;
import com.edge47.imp.HoaDonImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDao implements HoaDonImp{
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public int themhoadon(HoaDon hoaDon) {
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(hoaDon);
		if(0 < id) {
			return id;
		}else {
			return 0;
		}
	}
	
}
