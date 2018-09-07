package base.bill.mapper;

import base.bill.entity.TEmporaryGuaranteeApplication;
import base.bill.entity.TEmporaryGuaranteeApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TEmporaryGuaranteeApplicationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emporary_guarantee_application
     *
     * @mbg.generated Wed Sep 05 10:25:24 CST 2018
     */
    long countByExample(TEmporaryGuaranteeApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emporary_guarantee_application
     *
     * @mbg.generated Wed Sep 05 10:25:24 CST 2018
     */
    int deleteByExample(TEmporaryGuaranteeApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emporary_guarantee_application
     *
     * @mbg.generated Wed Sep 05 10:25:24 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emporary_guarantee_application
     *
     * @mbg.generated Wed Sep 05 10:25:24 CST 2018
     */
    int insert(TEmporaryGuaranteeApplication record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emporary_guarantee_application
     *
     * @mbg.generated Wed Sep 05 10:25:24 CST 2018
     */
    int insertSelective(TEmporaryGuaranteeApplication record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emporary_guarantee_application
     *
     * @mbg.generated Wed Sep 05 10:25:24 CST 2018
     */
    List<TEmporaryGuaranteeApplication> selectByExample(TEmporaryGuaranteeApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emporary_guarantee_application
     *
     * @mbg.generated Wed Sep 05 10:25:24 CST 2018
     */
    TEmporaryGuaranteeApplication selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emporary_guarantee_application
     *
     * @mbg.generated Wed Sep 05 10:25:24 CST 2018
     */
    int updateByExampleSelective(@Param("record") TEmporaryGuaranteeApplication record, @Param("example") TEmporaryGuaranteeApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emporary_guarantee_application
     *
     * @mbg.generated Wed Sep 05 10:25:24 CST 2018
     */
    int updateByExample(@Param("record") TEmporaryGuaranteeApplication record, @Param("example") TEmporaryGuaranteeApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emporary_guarantee_application
     *
     * @mbg.generated Wed Sep 05 10:25:24 CST 2018
     */
    int updateByPrimaryKeySelective(TEmporaryGuaranteeApplication record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emporary_guarantee_application
     *
     * @mbg.generated Wed Sep 05 10:25:24 CST 2018
     */
    int updateByPrimaryKey(TEmporaryGuaranteeApplication record);
}