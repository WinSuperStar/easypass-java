package com.joshua.easypass.repository;

import com.joshua.easypass.entity.Presale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PresaleRepository extends JpaRepository<Presale, Integer>, JpaSpecificationExecutor<Presale> {
    @Query("SELECT p FROM Presale p WHERE p.saleid = :saleid")
    public Presale getPresale(@Param("saleid") Integer saleid);

    @Modifying
    @Query(value="DELETE FROM Presale p WHERE p.saleid = :saleid", nativeQuery = true)
    public void delPresale(@Param("saleid") Integer saleid);

    @Modifying
    @Query(value="UPDATE Presale p SET p.state = :state WHERE p.saleid = :saleid", nativeQuery = true)
    public void updatePresaleState(@Param("state") String state, @Param("saleid") Integer saleid);


    @Query(value = "SELECT v.* FROM Presale v WHERE v.caraddr LIKE %?1% AND v.carplate LIKE %?2%" +
            " AND v.cusmode LIKE %?3% AND v.cusname LIKE %?4%" +
            " AND v.state LIKE %?5% AND v.item_tidang = ?6 AND v.item_guohu = ?7" +
            " AND v.item_shangpai = ?8 AND v.item_weizhang = ?9 AND v.item_diya = ?10" +
            " AND v.item_jiechudiya = ?11 AND v.item_weituo = ?12 AND v.item_nianjian = ?13"+
            " AND v.item_buhuan = ?14 AND v.item_qita = ?15", nativeQuery = true)
    public Presale[] getPresale(@Param("caraddr") String caraddr, @Param("carplate") String carplate, @Param("cusmode") String cusmode,
                                        @Param("cusname") String cusname,
                                        @Param("state") String state,
                                        @Param("tidang") String tidang, @Param("guohu") String guohu, @Param("shangpai") String shangpai, @Param("weizhang") String weizhang, @Param("diya") String diya,
                                        @Param("jiechu") String jiechu, @Param("weituo") String weituo, @Param("nianjian") String nianjian, @Param("buhuan") String buhuan, @Param("qita") String qita);
}
