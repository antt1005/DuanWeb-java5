package fplhn.tiennh21.sd17306.repositories;

import fplhn.tiennh21.sd17306.entities.KhachHang;
import fplhn.tiennh21.sd17306.entities.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query(value = "SELECT kh FROM NhanVien kh WHERE kh.sdt = ?1 and kh.matKhau = ?2" )
    NhanVien getNhanVienBy(String sdt, String matkhau);
}
