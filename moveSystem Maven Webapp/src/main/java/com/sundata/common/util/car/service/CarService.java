package com.sundata.common.util.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.common.base.BaseMapper;
import com.sundata.common.base.BaseService;
import com.sundata.common.util.car.mapper.CarMapper;
import com.sundata.common.util.car.model.CarModel;

@Service
public class CarService extends BaseService<CarModel> {
	@Autowired
	private CarMapper<CarModel> carMapper;
	
	public CarModel findCar(CarModel carModel){
			return  carMapper.findCar(carModel);
	}
	
	public boolean carIsHave(String licensePlate){
		if(carMapper.carIsHave(licensePlate)>0)
		
			return true;
		return false;
		
		
	}
	

	@Override
	public BaseMapper<CarModel> getMapper() {
		return carMapper;
	}

}
