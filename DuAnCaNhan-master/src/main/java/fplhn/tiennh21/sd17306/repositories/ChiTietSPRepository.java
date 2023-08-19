package fplhn.tiennh21.sd17306.repositories;

import fplhn.tiennh21.sd17306.entities.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, UUID> {
    @Query(value = "select ctsp from ChiTietSP ctsp where ctsp.soLuongTon > '0'")
    List<ChiTietSP>getAllBySoLuongTon();
}
