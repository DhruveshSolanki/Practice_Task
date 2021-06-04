package com.miniproject.Service;

import java.util.List;
import com.miniproject.Model.Duct;
import com.miniproject.Model.Project;

public interface AssistantService {

	public int toAddDuct(Duct duct);
	
	public Duct toViewDuctById(int dId);

	public List<Duct> toViewDuct();
	
	public int toEditDuct(Duct duct);

	public boolean toDeleteDuct(int id);
}
