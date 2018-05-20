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

    @Query(value = "SELECT v.* FROM Vendor v WHERE v.vdraddr LIKE %?1% AND v.vdrplate LIKE %?2%" +
            " AND v.contact LIKE %?3% AND v.contactphone LIKE %?4%" +
            " AND v.state LIKE %?5% AND v.item_tidang = ?6 AND v.item_guohu = ?7" +
            " AND v.item_shangpai = ?8 AND v.item_weizhang = ?9 AND v.item_diya = ?10" +
            " AND v.item_jiechudiya = ?11 AND v.item_weituo = ?12 AND v.item_nianjian = ?13"+
            " AND v.item_buhuan = ?14 AND v.item_qita = ?15", nativeQuery = true)
    public Vendor[] getVdrsWithoutDate(@Param("vdraddr") String vdraddr, @Param("vdrplate") String vdrplate, @Param("contact") String contact,
                                       @Param("contactphone") String contactphone,
                                       @Param("state") String state,
                                       @Param("tidang") String tidang, @Param("guohu") String guohu, @Param("shangpai") String shangpai, @Param("weizhang") String weizhang, @Param("diya") String diya,
                                       @Param("jiechu") String jiechu, @Param("weituo") String weituo, @Param("nianjian") String nianjian, @Param("buhuan") String buhuan, @Param("qita") String qita);
}
