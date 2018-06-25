package com.joshua.easypass.service;

import com.joshua.easypass.entity.Car;
import com.joshua.easypass.entity.Carinfo;
import com.joshua.easypass.repository.CarRepository;
import com.joshua.easypass.repository.CarinfoRepository;
import com.joshua.easypass.util.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class CarService {
    public final static Logger logger = LoggerFactory.getLogger(CarService.class);
    @Autowired
    private CarRepository carRepo;
    @Autowired
    private CarinfoRepository carinfoRepo;

    public Car[] getCarsByNum(String carnum){return carRepo.getCarsByNum(carnum);}

    public List<String> getBrand(){
        return DataUtil.listSort(carinfoRepo.getBrand());
    }

    public List<String> getSubBrand(String brand){
        return DataUtil.listSort(carinfoRepo.getSet(brand));
    }

    public Car[] getAllCars(){
        return carRepo.getAllCars();
    }

    public Car[] getCarsWithdate(String carnum, String carbrand, String carset, Date firstdate1, Date firstdate2, String creator ){
        return carRepo.getCarsWithdate(carnum,carbrand,carset,firstdate1,firstdate2,creator);
    }

    public Car[] getCars(String carnum, String carbrand, String carset, String creator ){
        return carRepo.getCars(carnum,carbrand,carset,creator);
    }

    public void saveCar(Car car){
        carRepo.save(car);
    }

    public Car getCar(Integer carid){
        return carRepo.getCar(carid);
    }

    public void addBrandInfo(String brand, String set){
        Carinfo cif = new Carinfo();
        cif.setBrand(brand);
        cif.setSubbrand(set);
        carinfoRepo.saveAndFlush(cif);
    }

    public Carinfo[] getCarinfos(String brand, String set){
        return carinfoRepo.getCarInfos(brand, set);
    }

    public Carinfo getCarinfo(Integer infoid){
        return carinfoRepo.getCarInfo(infoid);
    }

    @Transactional
    public void delCarinfo(Integer infoid) {
        carinfoRepo.delCarinfo(infoid);
    }

    public void udpateCarinfo(Integer infoid, String brand, String set){
        Carinfo c = carinfoRepo.getOne(infoid);
        c.setBrand(brand);
        c.setSubbrand(set);
        carinfoRepo.saveAndFlush(c);
    }
}
