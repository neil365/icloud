package base.bill.entity.vo;

public class BudgetSubjectProjectVO {
	private Integer notax_project_id;
	private Integer[] budget_subject_ids;
	private Integer budget_subject_id;
	
	public Integer getBudget_subject_id() {
		return budget_subject_id;
	}
	public void setBudget_subject_id(Integer budget_subject_id) {
		this.budget_subject_id = budget_subject_id;
	}
	public Integer getNotax_project_id() {
		return notax_project_id;
	}
	public void setNotax_project_id(Integer notax_project_id) {
		this.notax_project_id = notax_project_id;
	}
	public Integer[] getBudget_subject_ids() {
		return budget_subject_ids;
	}
	public void setBudget_subject_ids(Integer[] budget_subject_ids) {
		this.budget_subject_ids = budget_subject_ids;
	}
}
