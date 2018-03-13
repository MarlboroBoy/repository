package com.sundata.common.util.car.service;

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
	

	@Override
	public BaseMapper<CarModel> getMapper() {
		// TODO Auto-generated method stub
		return carMapper;
	}

}
