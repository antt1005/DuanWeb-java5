package fplhn.tiennh21.sd17306.request;

import fplhn.tiennh21.sd17306.entities.CuaHang;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class CuaHangVM {
    @NotBlank(message = "Không được để trống")
    @Length(max = 255, message = "Không vượt quá 255 kí tự")
    private String ma;

    @NotBlank
    @Length(max = 255)
    private String ten;

    @NotBlank
    @Length(max = 255)
    private String diaChi;

    @NotBlank
    @Length(max = 255)
    private String thanhPho;

    @NotBlank
    @Length(max = 255)
    private String quocGia;

    public CuaHangVM(String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }

    public CuaHangVM() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public void loadFromDomain(CuaHang domainModel)
    {
        this.setTen(domainModel.getTen());
        this.setMa(domainModel.getMa());
        this.setDiaChi(domainModel.getDiaChi());
        this.setThanhPho(domainModel.getThanhPho());
        this.setQuocGia(domainModel.getQuocGia());
    }
}
