package com.miniproject.Dao;

import java.util.List;

import com.miniproject.Model.Project;
import com.miniproject.Model.User;

public interface AdminDao {
	
	public int addProject(Project project);
	
	public Project viewProjectById(int pId);
	
	public List<Project> viewProject();
	
	public int editProject(Project project);
	
	public int deleteProject(int pId);
	
	//User Model
	
	public boolean addUser(User user);
	
	public User viewUserById(int id);
	
	public List<User> viewUser();

}
