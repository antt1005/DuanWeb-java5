package fplhn.tiennh21.sd17306.repositories;

import fplhn.tiennh21.sd17306.entities.GioHang;
import fplhn.tiennh21.sd17306.entities.HoaDon;
import fplhn.tiennh21.sd17306.entities.HoaDonChiTietId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query(value = "select MAX(CONVERT(INT,hd.Ma)) from HoaDon hd",nativeQuery = true)
    Integer maxMa();

    @Query(value = "select hd from HoaDon hd where hd.ma = ?1 ")
    HoaDon getHoaDonByMa(String ma);

    @Query(value = "select gh from HoaDon gh where gh.khachHang.id = ?1 order by gh.ma desc ")
    Page<HoaDon> getHoaDonByKhachHang(UUID id, Pageable pageable);

    @Query(value = "select hd from HoaDon hd where hd.tinhTrang = ?1 ")
    List<HoaDon> getHoaDonByTrangThai(String tt);

    @Query(value = "select hd from HoaDon hd where hd.Id = ?1 ")
    HoaDon getHoaDonById(UUID id);

    @Query(value = "select * from HoaDon gh where gh.tinhTrang > -1 order by CONVERT(INT,gh.Ma) desc",nativeQuery = true)
    Page<HoaDon> HD( Pageable pageable);
}


