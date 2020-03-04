package WanZheng.java.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlTest {

	public static void main(String[] args) {
		 XmlMapper xmlMapper = new XmlMapper();
		 ObjectMapper objectMapper = new ObjectMapper();  
		 try {
			 //xml 格式数据
			 String xml="<returnsms>" + 
			 		" 	<returnstatus></returnstatus>" +
			 		" 	<message>ok</message>" + 
			 		" 	<remainpoint>11032</remainpoint>" + 
			 		" 	<taskID>4354699</taskID>" + 
			 		" 	<test>123</test>" + 
			 		" 	<successCounts>1</successCounts>" + 
			 		"</returnsms>";
			 System.out.println(JSON.isValid(xml));
			 Map map =xmlMapper.readValue(xml, HashMap.class);
			 System.out.println(map);
			 //System.out.println(objectMapper.writeValueAsString(map));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
