package com.demo.daos;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.models.*;
 
@Service
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}
 
} 
