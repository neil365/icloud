package base.bill.entity;

public class TUnitCompetentDepartment {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_unit_competent_department.unit_competent_department_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer unit_competent_department_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_unit_competent_department.unit_dept_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private String unit_dept_code;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_unit_competent_department.unit_dept_name
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private String unit_dept_name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_unit_competent_department.parent_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer parent_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_unit_competent_department.delete_status
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	private Integer delete_status;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_unit_competent_department.unit_competent_department_id
	 * @return  the value of t_unit_competent_department.unit_competent_department_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getUnit_competent_department_id() {
		return unit_competent_department_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_unit_competent_department.unit_competent_department_id
	 * @param unit_competent_department_id  the value for t_unit_competent_department.unit_competent_department_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setUnit_competent_department_id(Integer unit_competent_department_id) {
		this.unit_competent_department_id = unit_competent_department_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_unit_competent_department.unit_dept_code
	 * @return  the value of t_unit_competent_department.unit_dept_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getUnit_dept_code() {
		return unit_dept_code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_unit_competent_department.unit_dept_code
	 * @param unit_dept_code  the value for t_unit_competent_department.unit_dept_code
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setUnit_dept_code(String unit_dept_code) {
		this.unit_dept_code = unit_dept_code == null ? null : unit_dept_code.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_unit_competent_department.unit_dept_name
	 * @return  the value of t_unit_competent_department.unit_dept_name
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public String getUnit_dept_name() {
		return unit_dept_name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_unit_competent_department.unit_dept_name
	 * @param unit_dept_name  the value for t_unit_competent_department.unit_dept_name
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setUnit_dept_name(String unit_dept_name) {
		this.unit_dept_name = unit_dept_name == null ? null : unit_dept_name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_unit_competent_department.parent_id
	 * @return  the value of t_unit_competent_department.parent_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getParent_id() {
		return parent_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_unit_competent_department.parent_id
	 * @param parent_id  the value for t_unit_competent_department.parent_id
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_unit_competent_department.delete_status
	 * @return  the value of t_unit_competent_department.delete_status
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public Integer getDelete_status() {
		return delete_status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_unit_competent_department.delete_status
	 * @param delete_status  the value for t_unit_competent_department.delete_status
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	public void setDelete_status(Integer delete_status) {
		this.delete_status = delete_status;
	}
}