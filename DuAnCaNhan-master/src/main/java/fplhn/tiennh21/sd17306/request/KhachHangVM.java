package fplhn.tiennh21.sd17306.request;

import fplhn.tiennh21.sd17306.entities.NSX;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class KhachHangVM {
    @NotBlank(message = "Mã không được để trống")
    private String ma;
    @NotBlank(message = "Tên không được để trống")
    private String ten;
    @NotBlank(message = "Tên đệm không được để trống")
    private String tenDem;
    @NotBlank(message = "Họ không được để trống")
    private String ho;
    @NotBlank(message = "Ngày sinh không được để trống")
    private String ngaySinh;

    @NotBlank(message = "SDT không được để trống")
    private String sdt;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;

    @NotBlank(message = "Thành Phố không được để trống")
    private String thanhPho;

    @NotBlank(message = "Quốc gia không được để trống")
    private String quocGia;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String matKhau;

}
