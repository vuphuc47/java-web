package com.edge47.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edge47.entity.SanPham;
import com.edge47.imp.SanPhamImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDao implements SanPhamImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SanPham> danhsachsanpham(int sodau) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> list = new ArrayList<SanPham>();
		if(sodau == -1) {
			list = session.createQuery("from sanpham").getResultList();
		}else {
			list = session.createQuery("from sanpham").setFirstResult(sodau).setMaxResults(12).getResultList();
		}
		
		return list;
	}

	@Transactional
	public SanPham chitietsanpham(int masanpham) {
		Session sesion = sessionFactory.getCurrentSession();
		String str = "from sanpham sp where sp.masanpham="+ masanpham;
		SanPham sanPham = (SanPham) sesion.createQuery(str).getSingleResult();
		return sanPham;
	}

	@Transactional
	public List<SanPham> laydanhsachsptheoid(int madanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> laysptheoid = session.createQuery("from sanpham sp where sp.danhmucsanpham.madanhmuc="+madanhmuc).getResultList();
		return laysptheoid;
	}
	

	

}
