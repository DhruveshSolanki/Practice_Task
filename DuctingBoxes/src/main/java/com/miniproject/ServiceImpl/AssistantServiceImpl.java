package com.miniproject.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.Dao.AssistantDao;
import com.miniproject.Model.Duct;
import com.miniproject.Service.AssistantService;

@Service
public class AssistantServiceImpl implements AssistantService {

	@Autowired
	private AssistantDao assistantDao;

	public int toAddDuct(Duct duct) {
		return this.assistantDao.addDuct(duct);
	}

	public Duct toViewDuctById(int dId) {
		return this.assistantDao.viewDuctById(dId);
	}
	
	public List<Duct> toViewDuct() {
		return this.assistantDao.viewDuct();
	}

	public int toEditDuct(Duct duct) {
		return this.assistantDao.editDuct(duct);
	}
	
	public boolean toDeleteDuct(int id) {
		
		return this.assistantDao.deleteDuct(id);
	}
}
