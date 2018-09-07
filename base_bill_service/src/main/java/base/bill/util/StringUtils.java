package base.bill.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @类描述：String相关处理
 * @项目名称：spr-nontaxrevenue-service
 * @包名： com.spr.nontaxrevenue.business.util
 * @类名称：StringUtils
 * @创建人：wangp
 * @创建时间：2018-8-18
 * @修改备注：
 */
public class StringUtils {
	static final Pattern p = Pattern.compile("[A-Z]");
	/**
	 * 小驼峰转下划线==类名转表名
	 * 
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param) {
		// 简单写法
		// return param.replaceAll("[A-Z]", "_$0").toLowerCase();
		// 高效写法
		if (param == null || param.equals("")) {
			return "";
		}
		Matcher mc = p.matcher(param);
		StringBuffer sb = new StringBuffer();
		while (mc.find()) {
			mc.appendReplacement(sb, "_" + mc.group(0).toLowerCase());
		}
		mc.appendTail(sb);
		return sb.toString();
	}
	/**
	 * 大驼峰转下划线==类名转表名
	 * 
	 * @param param
	 * @return
	 */
	public static String CamelToUnderline(String param) {
		return captureName(camelToUnderline(param).replaceFirst("_", ""));
	}
	/**
	 * 下划线转小驼峰==表名转类名
	 * 
	 * @param param
	 * @return
	 */
	public static String underlineToCamel(String param) {
		param = param.toLowerCase();
		Matcher matcher = Pattern.compile("_(\\w)").matcher(param);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	/**
	 * 下划线转大驼峰==表名转类名
	 * 
	 * @param param
	 * @return
	 */
	public static String UnderlineToCamel(String param) {
		return captureName(underlineToCamel(param));
	}
	/**
	 * 首字母大写
	 * @param c
	 * @return
	 */
	public static String captureName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
	
	
	/******************非空验证*********************/
	
	/**
     * 验证string类型的是否为空
     * 数组时依次验证
     * "undefined" and "null" 视为空
     */
    public static boolean isNullorEmpty(String... string) {
    	for (String str : string) {
	        //为了执行忽略大小写的比较，可以调用equalsIgnoreCase( )方法。当比较两个字符串时，它会认为A-Z和a-z是一样的。
	        if ((str == null) || ("".equals(str)) || ("null".equalsIgnoreCase(str)) || ("undefined".equalsIgnoreCase(str))) {
	            return true;
	        }
    	}
        return false;
    }

    /**
     * 验证实体是否为空
     */
    public static <T> boolean isNullorEmpty(T entity) {
        if (entity == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证StringBuffer类型的是否为空
     */
    public static boolean isNullorEmpty(StringBuffer str) {
        if (str == null ||"".equals(str.toString())  || str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证Map类型的是否为空
     */
    public static boolean isNullorEmpty(Map<?, ?> map) {
        if ((map == null) || (map.size() == 0)) {
            return true;
        }
        return false;
    }

    /**
     * 验证Object数组类型的是否为空
     */
    public static boolean isNullorEmpty(Object[] obj) {
        if ((obj == null) || (obj.length == 0)) {
            return true;
        }
        return false;
    }

    /**
     * 验证Long类型的是否为空
     */
    public static boolean isNullorEmpty(Long longTime) {
        if ((longTime == null) || (longTime.longValue() <= 0L)) {
            return true;
        }
        return false;
    }
    
    
    /***************String其它处理*************************/
    
    /**
     * 描述:[String[] To String]
     * @param ss 中的元素不能为空（包括"undefined" and "null"）
     * @param 连接符 一般为 ,
     */
    public static String StringArrayToString(String[] ss,String join) {
    	
    	if (isNullorEmpty(ss)) {
			return "";
		}
    	StringBuffer sb = new StringBuffer();
    	sb.append(ss[0]);
    	for (int i = 1; i < ss.length; i++) {
    		sb.append(join+ss[i]);
    	}
		return sb.toString();
    }
    
}
