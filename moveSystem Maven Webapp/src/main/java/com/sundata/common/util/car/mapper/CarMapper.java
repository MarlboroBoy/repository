package com.sundata.common.util.car.mapper;


import com.sundata.common.base.BaseMapper;
import com.sundata.common.util.car.model.CarModel;

public interface CarMapper<T> extends BaseMapper<T>{

public CarModel findCar(CarModel carModel);

public int carIsHave(String licensePlate);
}
