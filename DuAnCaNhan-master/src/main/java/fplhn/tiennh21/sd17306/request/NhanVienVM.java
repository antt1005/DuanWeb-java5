package fplhn.tiennh21.sd17306.request;

import fplhn.tiennh21.sd17306.entities.ChucVu;
import fplhn.tiennh21.sd17306.entities.CuaHang;
import fplhn.tiennh21.sd17306.entities.NhanVien;
import fplhn.tiennh21.sd17306.repositories.CuaHangRepository;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class NhanVienVM {

    @NotBlank(message = "Mã không được để trống")
    private String ma;

    @NotBlank(message = "Tên không được để trống")
    private String ten;

    @NotBlank(message = "Tên Đệm không được để trống")
    private String tenDem;

    @NotBlank(message = "Họ không được để trống")
    private String ho;

    @NotBlank(message = "Giới Tính không được để trống")
    private String gioiTinh;

    @NotBlank(message = "Ngày Sinh không được để trống")
    private String ngaySinh;

    @NotBlank(message = "Địa Chỉ không được để trống")
    private String diaChi;

    @NotBlank(message = "Sdt không được để trống")
    private String sdt;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String matKhau;

    @NotBlank(message = "Trạng Thái không được để trống")
    private String trangThai;

    private CuaHang ch;

    private ChucVu cv;



}
