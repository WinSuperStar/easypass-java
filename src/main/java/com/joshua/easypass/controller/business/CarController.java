package com.joshua.easypass.controller.business;

import com.joshua.easypass.entity.Car;
import com.joshua.easypass.entity.Carinfo;
import com.joshua.easypass.service.CarService;
import com.joshua.easypass.util.DateUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CarController {
    public final static Logger logger = LoggerFactory.getLogger(CarController.class);
    @Autowired
    private CarService carService;

    @GetMapping(value = "/allCars")
    public Car[] getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping(value = "/car/{carid}")
    public Car getCar(@PathVariable("carid") Integer carid) {
        return carService.getCar(carid);
    }

    @GetMapping(value = "/carsByNum")
    public Car[] getCarsByNum(@RequestParam("carnum") String carnum) {
        return carService.getCarsByNum(carnum);
    }

    @PostMapping(value = "/cars")
    public Car[] getCars(@RequestParam("carnum") String carnum,
                         @RequestParam("carbrand") String carbrand,
                         @RequestParam("carset") String carset,
                         @RequestParam("firstdate1") String firstdate1,
                         @RequestParam("firstdate2") String firstdate2,
                         @RequestParam("creator") String creator) throws Exception {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //加上时间
        Date date1 = "".equals(firstdate1) ? null : sDateFormat.parse(firstdate1);
        Date date2 = "".equals(firstdate1) ? null : sDateFormat.parse(firstdate2);
        if ("".equals(firstdate1)) {
            return carService.getCars(carnum, carbrand, carset, creator);
        } else {
            return carService.getCarsWithdate(carnum, carbrand, carset, sDateFormat.parse(firstdate1), sDateFormat.parse(firstdate2), creator);
        }

    }

    @PostMapping(value = "/saveCar")
    public void saveCar(@RequestParam("car") String car) {
        logger.info(car);
        JSONObject jasonV = JSONObject.fromObject(car);
        if (jasonV.get("createdate") == null) {
            jasonV.put("createdate", new Date());
        }
        if (jasonV.get("firstdate") != null) {
            jasonV.put("firstdate", DateUtil.StrToDate(jasonV.get("firstdate").toString()));
        }
        logger.info("JSON转对象前的创建日期为" + jasonV.get("createdate").toString());
        Car c = (Car) JSONObject.toBean(jasonV, Car.class);
        logger.info("JSON转对象后的创建日期为" + c.getCreatedate().toString());
        carService.saveCar(c);
    }

    @GetMapping(value = "/brand")
    public List<String> getBrand() {
        return carService.getBrand();
    }

    @PostMapping(value = "/subBrand")
    public List<String> getSubBrand(@RequestParam("brand") String brand) {
        return carService.getSubBrand(brand);
    }

    @PostMapping(value = "/addBrandInfo")
    public void addBrandInfo(@RequestParam("brand") String brand,
                             @RequestParam("set") String set) {
        carService.addBrandInfo(brand, set);
    }

    @PostMapping(value = "/getCarinfos")
    public Carinfo[] getCarinfos(@RequestParam("brand") String brand,
                                @RequestParam("set") String set) {
        return carService.getCarinfos(brand, set);
    }

    @PostMapping(value = "/getCarinfo")
    public Carinfo getCarinfo(@RequestParam("infoid") Integer infoid) {
        return carService.getCarinfo(infoid);
    }

    @PostMapping(value = "/updateCarinfo")
    public void udpateCarinfo(@RequestParam("infoid") Integer infoid,
                           @RequestParam("brand") String brand,
                           @RequestParam("set") String set) {
        carService.udpateCarinfo(infoid, brand, set);
    }

    @PostMapping(value = "/delCarinfo")
    public void delCarinfo(@RequestParam("infoid") Integer infoid) {
        carService.delCarinfo(infoid);
    }
}
