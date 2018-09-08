package com.Jeremmy.spring.cloud.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Jeremmy.spring.cloud.weather.vo.Weather;
import com.Jeremmy.spring.cloud.weather.vo.WeatherResponse;

/**
 * Weather Report Service.
 *
 * @author Jeremmy
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    @Qualifier("feignClientAPI")
	private FeignClientAPI feignClientAPI;
	@Override
	public Weather getDataByCityId(String cityId) {
		
		// 由天气数据API微服务来提供
		WeatherResponse resp = feignClientAPI.getDataByCityId(cityId);
		Weather data = resp.getData();
		return data;
	}

}
