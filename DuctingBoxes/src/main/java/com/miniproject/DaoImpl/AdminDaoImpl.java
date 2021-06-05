package com.miniproject.DaoImpl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.miniproject.Dao.AdminDao;
import com.miniproject.Model.Project;
import com.miniproject.Model.User;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int addProject(Project project) {

		int id = 0;
		try {
			id = (Integer) this.hibernateTemplate.save(project);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
	}

	public Project viewProjectById(int pId) {
		Project p = null;
		try {
			p = this.hibernateTemplate.get(Project.class, pId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}

	public List<Project> viewProject() {
		List<Project> p = null;
		try {
			p = this.hibernateTemplate.loadAll(Project.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}

	@Transactional
	public int editProject(Project project) {

		int id = 0;
		try {
			Project p = this.hibernateTemplate.get(Project.class, project.getpId());
			p.setpTitle(project.getpTitle());
			p.setpDescription(project.getpDescription());
			p.setpCity(project.getpCity());
			p.setpState(project.getpState());
			p.setpCountry(project.getpCountry());
			id = p.getpId();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return id;

	}

	@Transactional
	public int deleteProject(int pId) {
		int id = 0;
		try {
			Project p = this.hibernateTemplate.get(Project.class, pId);
			id = p.getpId();
			this.hibernateTemplate.delete(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
	}

	// -------User Dao-----------

	@Transactional
	public boolean addUser(User user) {
		try {
			 this.hibernateTemplate.save(user);
			 return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<User> viewUser() {
		List<User> u = null;
		try {
			u = this.hibernateTemplate.loadAll(User.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}

	public User viewUserById(int id) {
		User u = null;
		try {
			u = this.hibernateTemplate.get(User.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}

	@Transactional
	public boolean editUser(User user) {
		try {
			User u = this.hibernateTemplate.get(User.class, user.getuId());
			u.setuEmail(user.getuEmail());
			u.setuPassword(user.getuPassword());
			u.setuRole(user.getuRole());
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Transactional
	public boolean deleteUser(int uId) {
		try {
			User u = this.hibernateTemplate.get(User.class, uId);
			this.hibernateTemplate.delete(u);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
