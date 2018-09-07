package base.bill.entity.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import base.bill.entity.TDemandNote;
import io.swagger.annotations.ApiParam;

public class TDemandNoteVO2{
	
	@ApiParam(required = !true, name = "主键ID ", value = "主键ID：\n\r主键ID ")
	private Integer demand_note_id;

	public Integer getDemand_note_id() {
		return demand_note_id;
	}

	public void setDemand_note_id(Integer demand_note_id) {
		this.demand_note_id = demand_note_id;
	}
	
}
