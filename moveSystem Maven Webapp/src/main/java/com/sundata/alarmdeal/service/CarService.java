package com.sundata.alarmdeal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.alarmdeal.mapper.CarMapper;
import com.sundata.alarmdeal.model.CarModel;
import com.sundata.common.base.BaseMapper;
import com.sundata.common.base.BaseService;

@Service
public class CarService extends BaseService<CarModel> {
	@Autowired
	private CarMapper<CarModel> carMapper;

	public CarModel findCar(CarModel carModel) {
		return carMapper.findCar(carModel);
	}

	public boolean carIsHave(String licensePlate) {
		if (carMapper.carIsHave(licensePlate) > 0)
			return true;
		return false;

	}

	public List<CarModel> queryCar() {
		return carMapper.queryCar();
	}

	public CarModel display(CarModel model) {
		return carMapper.display(model);
	}

	@Override
	public BaseMapper<CarModel> getMapper() {
		return carMapper;
	}

}
