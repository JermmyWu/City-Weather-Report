package com.Jeremmy.spring.cloud.weather.service;

/**
 * Weather Data Collection Service.
 *
 * @author Jeremmy
 */
public interface WeatherDataCollectionService {

	/**
	 * 根据城市ID同步天气
	 * @param cityId
	 */
	void saveDateByCityId(String cityId);
}
