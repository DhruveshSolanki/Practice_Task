package com.miniproject.Dao;

import java.util.List;

import com.miniproject.Model.Duct;
import com.miniproject.Model.Project;

public interface AssistantDao {

	public int addDuct(Duct duct);
	
	public Duct viewDuctById(int dId);
	
	public List<Duct> viewDuct();
	
	public int editDuct(Duct duct);

	public boolean deleteDuct(int id);
	
}
