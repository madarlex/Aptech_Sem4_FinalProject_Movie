package com.demo.services.admin;

import java.util.List;
import java.util.Map;
 
public interface CanvasjsChartService {
 
	List<List<Map<Object, Object>>> getCanvasjsChartData();
	List<List<Map<Object, Object>>> getColumnChartData();
	List<List<Map<Object, Object>>> getLineChartData();
}
