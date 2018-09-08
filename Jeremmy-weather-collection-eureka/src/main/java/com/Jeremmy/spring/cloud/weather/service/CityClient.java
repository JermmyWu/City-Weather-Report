package com.Jeremmy.spring.cloud.weather.service;

import com.Jeremmy.spring.cloud.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Jeremmy
 */
@FeignClient("Jeremmy-weather-city-eureka")
public interface CityClient {
    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}
