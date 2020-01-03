package WanZheng.java.utils.correlation;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


public class MapUtils {
	
	public static String regex1=";";
	public static String regex2="&";
	public static String regex3=",";
	
	public static Map<String, Object> covertStringToMap(String str,String regex){
		if(StringUtils.isEmpty(str)) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		String[] header_array = str.split(regex);
		for (String header : header_array) {
			String[] key_array = header.split("=");    //用= 分割key和value
			map.put(key_array[0], key_array[1]);
		}
		return map;
	}
	
	/**
	 * 满足 key=value;key1=value2 转换成map
	 * @param str
	 * @return
	 */
	public static Map<String, Object> covertStringToMap(String str){
		return covertStringToMap(str,regex1);
	}


	/**
	 * 满足 key=value&key1=value2 转换成map
	 * @param str
	 * @return
	 */
	public static Map<String, Object> covertStringToMap2(String str){
		return covertStringToMap(str,regex2);
	}

	public static Map<String, Object> covertStringToMap3(String str){
		return covertStringToMap(str,regex3);
	}
	
}
