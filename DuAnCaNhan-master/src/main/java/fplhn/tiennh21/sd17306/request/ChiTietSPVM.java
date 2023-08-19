package fplhn.tiennh21.sd17306.request;

import fplhn.tiennh21.sd17306.entities.DongSP;
import fplhn.tiennh21.sd17306.entities.MauSac;
import fplhn.tiennh21.sd17306.entities.NSX;
import fplhn.tiennh21.sd17306.entities.SanPham;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ChiTietSPVM {


    private SanPham sp;


    private NSX nsx;


    private MauSac ms;


    private DongSP dsp;

    @NotBlank(message = " không được để trống")
    private String namBH;

    @NotBlank(message = " không được để trống")
    private String moTa;

    @NotBlank(message = " không được để trống")
    private String soLuongTon;

    @NotBlank(message = " không được để trống")
    private String giaNhap;

    @NotBlank(message = " không được để trống")
    private String giaBan;
}
