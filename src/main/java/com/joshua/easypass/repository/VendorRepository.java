package com.joshua.easypass.repository;

import com.joshua.easypass.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    @Query("SELECT v FROM Vendor v WHERE v.vdrid = :vdrid")
    public Vendor getVdr(@Param("vdrid") Integer vdrid);

    @Query("SELECT v FROM Vendor v")
    public Vendor[] getAllVdrs();

    @Query("SELECT v FROM Vendor v WHERE v.vdraddr LIKE %:vdraddr% AND v.vdrplate LIKE %:vdrplate% AND v.contact LIKE %:contact% AND v.contactphone LIKE %:contactphone% AND" +
            " v.commitdate IS NOT NULL AND v.commitdate > :firstdate1 AND v.commitdate < :firstdate2 AND v.state LIKE %:state% AND" +
            " v.itemTidang = :tidang AND v.itemGuohu = :guohu AND v.itemShangpai = :shangpai AND v.itemWeizhang = :weizhang AND v.itemDiya = :diya AND" +
            " v.itemJiechudiya = :jiechu AND v.itemWeituo = :weituo AND v.itemNianjian = :nianjian AND v.itemBuhuan = :buhuan AND v.itemQita = :qita")
    public Vendor[] getVdrsWithDate(@Param("vdraddr") String vdraddr, @Param("vdrplate") String vdrplate, @Param("contact") String contact,
                            @Param("contactphone") String contactphone, @Param("firstdate1") Date firstdate1, @Param("firstdate2") Date firstdate2,
                            @Param("state") String state,
                            @Param("tidang") String tidang, @Param("guohu") String guohu, @Param("shangpai") String shangpai, @Param("weizhang") String weizhang, @Param("diya") String diya,
                            @Param("jiechu") String jiechu, @Param("weituo") String weituo, @Param("nianjian") String nianjian, @Param("buhuan") String buhuan, @Param("qita") String qita);

    @Query("SELECT v FROM Vendor v WHERE v.vdraddr LIKE %:vdraddr% AND v.vdrplate LIKE %:vdrplate% AND v.contact LIKE %:contact% AND v.contactphone LIKE %:contactphone% AND" +
            " v.state LIKE %:state% AND" +
            " v.itemTidang = :tidang AND v.itemGuohu = :guohu AND v.itemShangpai = :shangpai AND v.itemWeizhang = :weizhang AND v.itemDiya = :diya AND" +
            " v.itemJiechudiya = :jiechu AND v.itemWeituo = :weituo AND v.itemNianjian = :nianjian AND v.itemBuhuan = :buhuan AND v.itemQita = :qita")
    public Vendor[] getVdrsWithoutDate(@Param("vdraddr") String vdraddr, @Param("vdrplate") String vdrplate, @Param("contact") String contact,
                                    @Param("contactphone") String contactphone,
                                    @Param("state") String state,
                                    @Param("tidang") String tidang, @Param("guohu") String guohu, @Param("shangpai") String shangpai, @Param("weizhang") String weizhang, @Param("diya") String diya,
                                    @Param("jiechu") String jiechu, @Param("weituo") String weituo, @Param("nianjian") String nianjian, @Param("buhuan") String buhuan, @Param("qita") String qita);
}
