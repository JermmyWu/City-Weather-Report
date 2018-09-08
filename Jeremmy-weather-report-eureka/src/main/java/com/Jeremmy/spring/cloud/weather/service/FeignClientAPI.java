package com.Jeremmy.spring.cloud.weather.service;

import java.util.List;

import com.Jeremmy.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.Jeremmy.spring.cloud.weather.vo.City;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * City Client.
 *
 * @author Jeremmy
 */
@Component
@FeignClient(name="Jeremmy-weather-eureka-client-zuul",fallback = DataClientFallback.class)
public interface FeignClientAPI {
    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
	@GetMapping("/city/cities")
	List<City> listCity() throws Exception;
	
	@GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
