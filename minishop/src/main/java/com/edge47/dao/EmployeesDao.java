package com.edge47.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edge47.entity.Employees;
import com.edge47.imp.NhanVienImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeesDao implements NhanVienImp {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean kiemtradangnhap(String email, String matkhau) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Employees nhanvien = (Employees) session
					.createQuery("FROM employees WHERE email='" + email + "' AND matkhau='" + matkhau + "'")
					.getSingleResult();
			if (nhanvien != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean themnhanvien(Employees employees) {
		Session session = sessionFactory.getCurrentSession();
		session.save(employees);
		return false;
	}

}
