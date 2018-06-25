package com.joshua.easypass.repository;

import com.joshua.easypass.entity.Carinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarinfoRepository extends JpaRepository<Carinfo, Integer> {
    @Query("SELECT DISTINCT c.brand from Carinfo c ORDER BY c.brand DESC")
    public List<String> getBrand();

    @Query("SELECT DISTINCT c.subbrand from Carinfo c WHERE c.brand = :brand ORDER BY c.subbrand DESC")
    public List<String> getSet(@Param("brand") String brand);

    @Query("SELECT c from Carinfo c WHERE c.brand like %:brand% AND c.subbrand like %:subbrand%")
    public Carinfo[] getCarInfos(@Param("brand") String brand, @Param("subbrand") String subbrand);

    @Query("SELECT c from Carinfo c WHERE c.infoid = :infoid")
    public Carinfo getCarInfo(@Param("infoid") Integer infoid);

    @Modifying
    @Query(value="DELETE FROM Carinfo WHERE infoid = :infoid", nativeQuery = true)
    public void delCarinfo(@Param("infoid") Integer infoid);
}
