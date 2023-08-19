package fplhn.tiennh21.sd17306.repositories;

import fplhn.tiennh21.sd17306.entities.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
    @Query(value = "select gh from GioHang gh where gh.khachHang.id = ?1")
    GioHang getGioHangByKhachHang(UUID id);

    @Query(value = "select MAX(CONVERT(INT,hd.Ma)) from GioHang hd",nativeQuery = true)
    Integer maxMa();
}
