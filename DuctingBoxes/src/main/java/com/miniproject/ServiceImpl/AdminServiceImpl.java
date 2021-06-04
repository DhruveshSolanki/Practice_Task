package com.miniproject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.Dao.AdminDao;
import com.miniproject.Model.Project;
import com.miniproject.Model.User;
import com.miniproject.Service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	public int toAddProject(Project project) {
		return this.adminDao.addProject(project);
	}

	public Project toViewProjectById(int pId) {
		return this.adminDao.viewProjectById(pId);
	}

	public List<Project> toViewProject() {
		return this.adminDao.viewProject();
	}

	public int toEditProject(Project project) {
		return this.adminDao.editProject(project);
	}

	public int toDeleteProject(int pId) {
		return this.adminDao.deleteProject(pId);
	}

	//========User Service Impl==========
	
	public boolean toAddUser(User user) {
		return this.adminDao.addUser(user);
	}

	public User toViewUserById(int id) {
		return this.adminDao.viewUserById(id);
	}
	public List<User> toViewUser() {
		return this.adminDao.viewUser();
	}

}
