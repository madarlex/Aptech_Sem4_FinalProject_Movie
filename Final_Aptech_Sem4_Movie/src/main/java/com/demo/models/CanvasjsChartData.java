package com.demo.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.engine.transaction.jta.platform.internal.WebSphereExtendedJtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.services.admin.MovieService;

public class CanvasjsChartData {

	@Autowired
	private MovieService movieService;
	
	static Map<Object,Object> map = null;
	static List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
	static List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
	
	
	
	static {
		map = new HashMap<Object,Object>(); map.put("label", "Other"); map.put("y", 3.2);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Paramount"); map.put("y", 2.9);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Sony"); map.put("y", 5.2);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Fox"); map.put("y", 7.9);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Warner Bros."); map.put("y", 8.6);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Universal"); map.put("y", 11.6);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Disney"); map.put("y", 17.1);dataPoints1.add(map);

		list.add(dataPoints1);
	}

	public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
		return list;
	}
}  
