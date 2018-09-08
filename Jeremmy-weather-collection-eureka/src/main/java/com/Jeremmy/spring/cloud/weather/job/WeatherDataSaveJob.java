package com.Jeremmy.spring.cloud.weather.job;

import java.util.ArrayList;
import java.util.List;

import com.Jeremmy.spring.cloud.weather.service.CityClient;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.Jeremmy.spring.cloud.weather.service.WeatherDataCollectionService;
import com.Jeremmy.spring.cloud.weather.vo.City;

/**
 * Weather Data Save Job.
 *
 * @author Jeremmy
 */
public class WeatherDataSaveJob extends QuartzJobBean {
	
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSaveJob.class);

	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;
	@Autowired
    private CityClient cityClient;
	
	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Weather Data Sync Job. Start！");
		// 获取城市ID列表
		
		List<City> cityList = null;
		
		try {
		    //由城市数据API微服务来提供数据
            cityList = cityClient.listCity();
			
		} catch (Exception e) {
			logger.error("Exception!", e);
		}
		
		// 遍历城市ID获取天气
		for (City city : cityList) {
			String cityId = city.getCityId();
			logger.info("Weather Data Sync Job, cityId:" + cityId);
			
			weatherDataCollectionService.saveDateByCityId(cityId);
		}
		
		logger.info("Weather Data Sync Job. End！");
	}

}
