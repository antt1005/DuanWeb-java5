package fplhn.tiennh21.sd17306.repositories;


import fplhn.tiennh21.sd17306.entities.GioHang;
import fplhn.tiennh21.sd17306.entities.GioHangChiTiet;
import fplhn.tiennh21.sd17306.entities.GioHangChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, GioHangChiTietId> {
    @Query(value = "select gh from GioHangChiTiet gh where gh.gioHang.id = ?1")
    List<GioHangChiTiet> getGioHangChiTietByGioHang(UUID id);

    @Query(value = "select gh from GioHangChiTiet gh where gh.gioHang.id = ?1 and gh.chiTietSp.id = ?2")
    GioHangChiTiet findGioHangChiTietByGioHangAndCAndChiTietSp(UUID idgh,UUID idct);

    @Query(value = "select SUM(ghct.donGia) from GioHangChiTiet ghct where ghct.gioHang.id = ?1")
    Object tinhTongTien(UUID idgh);



}
