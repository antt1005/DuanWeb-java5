package fplhn.tiennh21.sd17306.controllers.admin;


import fplhn.tiennh21.sd17306.entities.ChiTietSP;
import fplhn.tiennh21.sd17306.entities.HoaDon;
import fplhn.tiennh21.sd17306.entities.HoaDonChiTiet;
import fplhn.tiennh21.sd17306.entities.NhanVien;
import fplhn.tiennh21.sd17306.repositories.ChiTietSPRepository;
import fplhn.tiennh21.sd17306.repositories.HoaDonChiTietRepository;
import fplhn.tiennh21.sd17306.repositories.HoaDonRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
@RequestMapping("admin/ban-hang")
public class BanHangController {

    @Autowired
    private HoaDonRepository hdRepo;

    @Autowired
    private ChiTietSPRepository ctspRepo;

    @Autowired
    private HoaDonChiTietRepository hdctRepo;

    @Autowired
    HttpSession session;

    @GetMapping("index")
    public String index(Model model){

        model.addAttribute("listHoaDon",this.hdRepo.getHoaDonByTrangThai("1"));
        model.addAttribute("listSP",this.ctspRepo.getAllBySoLuongTon());
        model.addAttribute("view","/views/banHang.jsp");
        return "layoutProNhanVien";
    }

    @PostMapping("createHD")
    public String createHD(Model model){
        NhanVien nhanVien = (NhanVien) session.getAttribute("nv");
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa(String.valueOf(this.hdRepo.maxMa()+1));
        hoaDon.setNhanVien(nhanVien);
        hoaDon.setNgayTao(java.time.LocalDate.now().toString());
        hoaDon.setTinhTrang(1);
        this.hdRepo.save(hoaDon);
        return "redirect:/admin/ban-hang/index";
    }

    @GetMapping("/hoa-don/hien-thi/{id}")
    public String hienThiHDCT(Model model , @PathVariable("id") HoaDon hoaDon){
        session.setAttribute("hoadonhientai",hoaDon.getId());
        model.addAttribute("thanhTien",this.hdctRepo.tinhTongTien(hoaDon.getId()));
        model.addAttribute("listHDCT",this.hdctRepo.getHoaDonChiTietByHoaDon(hoaDon));
        model.addAttribute("listHoaDon",this.hdRepo.getHoaDonByTrangThai("1"));
        model.addAttribute("listSP",this.ctspRepo.getAllBySoLuongTon());
        model.addAttribute("view","/views/banHang.jsp");
        return "layoutProNhanVien";
    }

    @PostMapping("addone/{id}")
    public String addOne(Model model,@PathVariable("id") ChiTietSP sp){
        UUID id = (UUID) session.getAttribute("hoadonhientai");
        HoaDon hoaDon =  this.hdRepo.getHoaDonById(id);
        HoaDonChiTiet hdct = this.hdctRepo.findHoaDonChiTietBy(hoaDon.getId(),sp.getId());

        hdct.setSoLuongTon(hdct.getSoLuongTon()+1);
        String dongiaString = String.valueOf(hdct.getDonGia());
        Integer dongiaTong = Integer.parseInt(dongiaString) + Integer.parseInt(sp.getGiaBan()) ;
        hdct.setDonGia(BigDecimal.valueOf(dongiaTong));
        this.hdctRepo.save(hdct);
        return "redirect:/admin/ban-hang/hoa-don/hien-thi/"+id;
    }
    @PostMapping("deleteone/{id}")
    public String deleteOne(Model model,@PathVariable("id") ChiTietSP sp){
        UUID id = (UUID) session.getAttribute("hoadonhientai");
        HoaDon hoaDon =  this.hdRepo.getHoaDonById(id);
        HoaDonChiTiet hdct = this.hdctRepo.findHoaDonChiTietBy(hoaDon.getId(),sp.getId());

        if(hdct.getSoLuongTon() - 1 == 0){
            this.hdctRepo.delete(hdct);
        }else{
            hdct.setSoLuongTon(hdct.getSoLuongTon()-1);
            String dongiaString = String.valueOf(hdct.getDonGia());
            Integer dongiaTong = Integer.parseInt(dongiaString) - Integer.parseInt(sp.getGiaBan()) ;
            hdct.setDonGia(BigDecimal.valueOf(dongiaTong));
            this.hdctRepo.save(hdct);
        }


        return "redirect:/admin/ban-hang/hoa-don/hien-thi/"+id;
    }
    @PostMapping("addSP/{id}")
    public String addSP(Model model,@PathVariable("id") ChiTietSP sp){
        UUID id = (UUID) session.getAttribute("hoadonhientai");
        HoaDon hoaDon =  this.hdRepo.getHoaDonById(id);
        HoaDonChiTiet hdcehck = this.hdctRepo.findHoaDonChiTietBy(hoaDon.getId(),sp.getId());
        if(hdcehck == null){
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setHoaDon(hoaDon);
            hdct.setChiTietSp(sp);
            hdct.setSoLuongTon(1);
            Integer dongiaTong = Integer.parseInt(sp.getGiaBan()) ;
            hdct.setDonGia(BigDecimal.valueOf(dongiaTong));
            this.hdctRepo.save(hdct);

        }else{
            hdcehck.setSoLuongTon(hdcehck.getSoLuongTon()+1);
            String dongiaString = String.valueOf(hdcehck.getDonGia());
            Integer dongiaTong = Integer.parseInt(dongiaString) + Integer.parseInt(sp.getGiaBan()) ;
            hdcehck.setDonGia(BigDecimal.valueOf(dongiaTong));
            this.hdctRepo.save(hdcehck);
        }
        return "redirect:/admin/ban-hang/hoa-don/hien-thi/"+id;
    }

    @PostMapping("thanhToan")
    public String thanhToan(Model model, @RequestParam("khachTra") String tien , RedirectAttributes parmar){
        UUID id = (UUID) session.getAttribute("hoadonhientai");
        HoaDon hoaDon =  this.hdRepo.getHoaDonById(id);
        BigDecimal tongTien = (BigDecimal) this.hdctRepo.tinhTongTien(hoaDon.getId());
        Integer tien1 = Integer.parseInt(tien);
        BigDecimal khachTra = BigDecimal.valueOf(tien1);

        if(khachTra.intValue() < tongTien.intValue()){
            parmar.addAttribute("erro"," Thanh Toan Chua Du");
            return "redirect:/admin/ban-hang/hoa-don/hien-thi/"+id;
        }else{
            hoaDon.setTinhTrang(2);
            hoaDon.setNgayThanhToan(java.time.LocalDate.now().toString());
            this.hdRepo.save(hoaDon);
            session.removeAttribute("hoadonhientai");
        }
        return "redirect:/admin/ban-hang/index";
    }


}
