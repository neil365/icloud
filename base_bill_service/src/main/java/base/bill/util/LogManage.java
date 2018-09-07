package base.bill.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @类描述：系统打印信息管理
 * @项目名称：base_bill_service
 * @包名： base.bill.util
 * @类名称：LogManage
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
public class LogManage {
	enum Toggle {  
		ALL, Logger, SystemOut, OFF  
	} 
	public static Toggle toggle = Toggle.Logger;
	private final static Logger logger = LogManager.getLogger(LogManage.class);
	
	/**
	 * @描述:打印日志
	 * 可灵活的切换打印日志的方法
	 * 当logger日志不打印时可用System.out方法打印
	 * 优点：避免了书写了大量日志需要更换日志输出时大量的修改工作
	 * @方法名: printInfo
	 * @param message
	 * @返回类型 void
	 * @创建人 wangp
	 * @创建时间 2018-8-18
	 * @修改备注
	 */
	public static void printInfo(Object message) {
		switch (toggle) {
		case ALL:
			logger.info(message);
			System.out.println(message);
			break;
		case Logger:
			logger.info(message);
			break;
		case SystemOut:
			System.out.println(message);
			break;
		case OFF:
			break;
		default:
			break;
		}
	}
}
