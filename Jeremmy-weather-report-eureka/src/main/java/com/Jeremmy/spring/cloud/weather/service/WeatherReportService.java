package com.Jeremmy.spring.cloud.weather.service;

import com.Jeremmy.spring.cloud.weather.vo.Weather;

/**
 * Weather Report Service.
 *
 * @author Jeremmy
 */
public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气信息
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);
}
