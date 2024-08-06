package in.asish.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.asish.bindings.PlanForm;

@Service
public class PlanServiceImpl implements PlanService{

	@Override
	public boolean createPlan(PlanForm planForm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PlanForm> listPlans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanForm> updatePlans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String planStatusUpdate(String planId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
