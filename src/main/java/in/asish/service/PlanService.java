package in.asish.service;

import java.util.List;

import in.asish.bindings.PlanForm;

public interface PlanService {
	public boolean createPlan(PlanForm planForm);
	public List<PlanForm> listPlans();
	public List<PlanForm> updatePlans();
	public String planStatusUpdate(String planId,String status);
}
