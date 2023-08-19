package fplhn.tiennh21.sd17306.controllers;


import fplhn.tiennh21.sd17306.entities.GioHang;
import fplhn.tiennh21.sd17306.entities.KhachHang;
import fplhn.tiennh21.sd17306.repositories.GioHangRepository;
import fplhn.tiennh21.sd17306.repositories.KhachHangRepository;
import fplhn.tiennh21.sd17306.request.KhachHangVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class DangKyController {

    @Autowired
    private KhachHangVM kh;

    @Autowired
    private KhachHangRepository khRepo;

    @Autowired
    private GioHangRepository ghRepo;


    @GetMapping("dang-ky")
    public String dangKy(Model model){
        kh.setMa(String.valueOf(khRepo.maxMa()+1));
        model.addAttribute("kh", kh);
        return "dangNhap";
    }

    @PostMapping("dang-ky")
    public String dangKyS(Model model,@Valid @ModelAttribute("kh") KhachHangVM khachHangVM,
                          BindingResult result){
        if(result.hasErrors()){
            return "/dang-ky";
        }
        KhachHang khachHang = KhachHang.builder()
                .ma(khachHangVM.getMa())
                .ten(khachHangVM.getTen())
                .tenDem(khachHangVM.getTenDem())
                .ho(khachHangVM.getHo())
                .ngaySinh(khachHangVM.getNgaySinh())
                .sdt(khachHangVM.getSdt())
                .diaChi(khachHangVM.getDiaChi())
                .thanhPho(khachHangVM.getThanhPho())
                .quocGia(khachHangVM.getQuocGia())
                .matKhau(khachHangVM.getMatKhau())
                .build();

        this.khRepo.save(khachHang);

        KhachHang kh = this.khRepo.getKhachHangByMa(khachHang.getMa());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String dateInString = java.time.LocalDate.now().toString();

        try {
            Date date = formatter.parse(dateInString);
            GioHang gh = new GioHang();
            gh.setMa(String.valueOf(this.ghRepo.maxMa()+1));
            gh.setKhachHang(kh);
            gh.setNgayTao(date);
            gh.setTrangThai(0);
            this.ghRepo.save(gh);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        return "dangNhap";
    }
}
