package com.miniproject.DaoImpl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miniproject.Dao.AssistantDao;
import com.miniproject.Model.Duct;
import com.miniproject.Model.Project;

@Repository
public class AssistantDaoImpl implements AssistantDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int addDuct(Duct duct) {
		int id = 0;
		try {
			id = (Integer) this.hibernateTemplate.save(duct);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
	}
	
	public Duct viewDuctById(int dId) {
		Duct d = null;
		try {
			d = this.hibernateTemplate.get(Duct.class, dId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return d;
	}

	public List<Duct> viewDuct() {
		List<Duct> d = null;
		try {
			d = this.hibernateTemplate.loadAll(Duct.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return d;
	}
	
	@Transactional
	public int editDuct(Duct duct) {
		int id = 0;
		try {
			Duct d = this.hibernateTemplate.get(Duct.class, duct.getdId());
			d.setdName(duct.getdName());
			d.setdLatitude(duct.getdLatitude());
			d.setdLongitude(duct.getdLongitude());
			id = d.getdId();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return id;
	}

	@Transactional
	public boolean deleteDuct(int dId) {
		try {
			Duct d = this.hibernateTemplate.get(Duct.class, dId);
			d.getdId();
			this.hibernateTemplate.delete(d);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
