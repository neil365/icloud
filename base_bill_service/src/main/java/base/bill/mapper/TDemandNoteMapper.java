package base.bill.mapper;

import base.bill.entity.TBillInfoMaintain;
import base.bill.entity.TDemandNote;
import base.bill.entity.TDemandNoteExample;
import base.bill.entity.vo.BillInfoMaintainVO;
import base.bill.entity.vo.TDemandNoteVO2;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TDemandNoteMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	long countByExample(TDemandNoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByExample(TDemandNoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer demand_note_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insert(TDemandNote record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int insertSelective(TDemandNote record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	List<TDemandNote> selectByExample(TDemandNoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	TDemandNote selectByPrimaryKey(Integer demand_note_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TDemandNote record, @Param("example") TDemandNoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByExample(@Param("record") TDemandNote record, @Param("example") TDemandNoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKeySelective(TDemandNote record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_demand_note
	 * @mbg.generated  Wed Sep 05 10:25:24 CST 2018
	 */
	int updateByPrimaryKey(TDemandNote record);

	/**
	 * 
	 * @描述: 获取一般缴款单信息
	 * @方法名: getTDemandNoteList
	 * @param aMap
	 * @return
	 * @返回类型 List<TDemandNote>
	 * @创建人 wangp
	 * @创建时间 2018-08-13
	 * @since
	 * @throws
	 */
	public List<TDemandNote> getTDemandNoteList(TDemandNote tDemandNote);
	
	List<TDemandNote> selectByExampleSelective(@Param("record") TDemandNote record, @Param("example") TDemandNoteExample example);
	
	/**
	 * 
	 * @描述: 通过ID修改数据的删除状态
	 * @方法名: updateByPrimaryKeyID
	 * @param aMap
	 * @return
	 * @返回类型 List<TDemandNote>
	 * @创建人 wangp
	 * @创建时间 2018-08-13
	 * @since
	 * @throws
	 */
	public List<TDemandNoteVO2> updateByPrimaryKeyID(TDemandNoteVO2 tDemandNoteVO2);
}