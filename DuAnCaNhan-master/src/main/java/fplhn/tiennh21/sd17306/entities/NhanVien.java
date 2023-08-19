package fplhn.tiennh21.sd17306.entities;

import fplhn.tiennh21.sd17306.request.CuaHangVM;
import fplhn.tiennh21.sd17306.request.NhanVienVM;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
        @Id
        @Column(name = "Id")
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(name = "Ma")
        private String ma;

        @Column(name = "Ten")
        private String ten;

        @Column(name = "TenDem")
        private String tenDem;

        @Column(name = "Ho")
        private String ho;

        @Column(name = "GioiTinh")
        private String gioiTinh;

        @Column(name = "NgaySinh")
        private String ngaySinh;

        @Column(name = "DiaChi")
        private String diaChi;

        @Column(name = "Sdt")
        private String sdt;

        @Column(name = "MatKhau")
        private String matKhau;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "IdCH", referencedColumnName = "id")
        private CuaHang ch;

        @ManyToOne(fetch =FetchType.LAZY )
        @JoinColumn(name ="IdCV",referencedColumnName = "id")
        private ChucVu cv;

        private int trangThai;




}


