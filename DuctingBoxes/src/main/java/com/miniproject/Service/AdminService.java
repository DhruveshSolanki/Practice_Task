package com.miniproject.Service;

import java.util.List;
import com.miniproject.Model.Project;
import com.miniproject.Model.User;


public interface AdminService {


	public int toAddProject(Project project);

	public Project toViewProjectById(int pId);

	public List<Project> toViewProject();

	public int toEditProject(Project project);

	public int toDeleteProject(int pId);
	
	//-------User Service-----------
	
	public boolean toAddUser(User user);
	
	public User toViewUserById(int id);
	
	public List<User> toViewUser();

	public boolean toEditUser(User user);

	public boolean toDeleteUser(int uId);
}
