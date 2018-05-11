package com.sundata.alarmdeal.mapper;


import java.util.List;

import com.sundata.alarmdeal.model.CarModel;
import com.sundata.common.base.BaseMapper;


public interface CarMapper<T> extends BaseMapper<T>{

public CarModel findCar(CarModel carModel);

public int carIsHave(String licensePlate);
public List<T> queryCar();
public T display(T cont);
}
