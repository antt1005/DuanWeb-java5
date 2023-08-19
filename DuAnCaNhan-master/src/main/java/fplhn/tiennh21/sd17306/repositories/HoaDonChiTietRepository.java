package fplhn.tiennh21.sd17306.repositories;

import fplhn.tiennh21.sd17306.entities.GioHangChiTiet;
import fplhn.tiennh21.sd17306.entities.HoaDon;
import fplhn.tiennh21.sd17306.entities.HoaDonChiTiet;
import fplhn.tiennh21.sd17306.entities.HoaDonChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, HoaDonChiTietId> {
    public List<HoaDonChiTiet> getHoaDonChiTietByHoaDon(HoaDon hoaDon);


    @Query(value = "select SUM(ghct.donGia) from HoaDonChiTiet ghct where ghct.hoaDon.Id = ?1")
    Object tinhTongTien(UUID idgh);

    @Query(value = "select gh from HoaDonChiTiet gh where gh.hoaDon.Id = ?1 and gh.chiTietSp.id = ?2")
    HoaDonChiTiet findHoaDonChiTietBy(UUID idgh, UUID idct);
}
