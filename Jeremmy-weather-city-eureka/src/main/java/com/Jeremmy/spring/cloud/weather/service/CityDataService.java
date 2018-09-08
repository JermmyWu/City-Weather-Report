package com.Jeremmy.spring.cloud.weather.service;

import java.util.List;

import com.Jeremmy.spring.cloud.weather.vo.City;

/**
 * City Data Service.
 * 
 * @author Jeremmy
 */
public interface CityDataService {

	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
