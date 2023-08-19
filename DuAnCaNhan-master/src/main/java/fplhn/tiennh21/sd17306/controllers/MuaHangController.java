package fplhn.tiennh21.sd17306.controllers;

import fplhn.tiennh21.sd17306.entities.*;
import fplhn.tiennh21.sd17306.repositories.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MuaHangController {

    @Autowired
    private ChiTietSPRepository ctspRepo;

    @Autowired
    private GioHangRepository ghRepo;

    @Autowired
    private HoaDonRepository hdRepo;

    @Autowired
    private HoaDonChiTietRepository hdctRepo;

    @Autowired
    private GioHangChiTietRepository ghctRepo;


//    trang chu
    @Autowired
    HttpSession sessions;
    @GetMapping("home")
    public String home(Model model,@RequestParam(defaultValue = "0", name = "page") Integer number){
        Pageable pageable = PageRequest.of(number, 8);
        Page<ChiTietSP> listctsp = this.ctspRepo.findAll(pageable);
        model.addAttribute("sp", listctsp);
        model.addAttribute("view","/views/homeProduct.jsp");
        return "layoutPro";
    }



//    mua hang
    @GetMapping("detail-product/{id}")
    public String detail(@PathVariable("id") ChiTietSP sp, Model model){
        model.addAttribute("ctsp",sp);
        model.addAttribute("view","/views/detailProduct.jsp");
        return "layoutPro";
    }

    @GetMapping("gio-hang/user")
    public String giohang(Model model){
        // user dang nhap thanh cong - > session co chua tat ca thong tin thang day
        KhachHang kh = (KhachHang) sessions.getAttribute("user");
        if(kh == null){
            return "redirect:/login";
        }

        GioHang ghUser = this.ghRepo.getGioHangByKhachHang(kh.getId());

        List<GioHangChiTiet> ghct = this.ghctRepo.getGioHangChiTietByGioHang(ghUser.getId());

        for (GioHangChiTiet hd: ghct
             ) {
            System.out.println(hd.toString());
        }
        this.ghctRepo.tinhTongTien(ghUser.getId());

        model.addAttribute("dongia",this.ghctRepo.tinhTongTien(ghUser.getId()));
        model.addAttribute("gh",ghct);
        model.addAttribute("view","/views/giohangUser.jsp");
        return "layoutPro";
    }
    @PostMapping("add-to-gio-hang/{id}")
    public String addToGHCT(@PathVariable("id") ChiTietSP sp, Model model){
        KhachHang kh = (KhachHang) sessions.getAttribute("user");

        GioHang ghUser = this.ghRepo.getGioHangByKhachHang(kh.getId());

        if(this.ghctRepo.findGioHangChiTietByGioHangAndCAndChiTietSp(ghUser.getId(),sp.getId()) == null){
            GioHangChiTiet ghCreate = new GioHangChiTiet();
            ghCreate.setGioHang(ghUser);
            ghCreate.setChiTietSp(sp);
            ghCreate.setSoLuongTon(1);
            ghCreate.setDonGia(BigDecimal.valueOf(Integer.parseInt(sp.getGiaBan())));

            this.ghctRepo.save(ghCreate);
        }else{
            GioHangChiTiet ghctUpadte = this.ghctRepo.findGioHangChiTietByGioHangAndCAndChiTietSp(ghUser.getId(),sp.getId());
            ghctUpadte.setSoLuongTon(ghctUpadte.getSoLuongTon()+1);
            String dongiaString = String.valueOf(ghctUpadte.getDonGia());
            Integer dongiaTong = Integer.parseInt(dongiaString) * 2;
            ghctUpadte.setDonGia(BigDecimal.valueOf(dongiaTong));

            this.ghctRepo.save(ghctUpadte);
        }

        return "redirect:/gio-hang/user";
    }

    @PostMapping("delete-product/{id}")
    public String deleteProductOne(@PathVariable("id") ChiTietSP sp, Model model){
//        get kh dang nhap
        KhachHang kh = (KhachHang) sessions.getAttribute("user");
// tim gio hang thong qua khach hang tren
        GioHang ghUser = this.ghRepo.getGioHangByKhachHang(kh.getId());
// tim sp trong gio hang
        GioHangChiTiet ghctUpadte = this.ghctRepo.findGioHangChiTietByGioHangAndCAndChiTietSp(ghUser.getId(),sp.getId());


            this.ghctRepo.delete(ghctUpadte);

        return "redirect:/gio-hang/user";
    }

    @PostMapping("/gio-hang/AddOne/{id}")
    public String addOne(@PathVariable("id") ChiTietSP sp, Model model){

        KhachHang kh = (KhachHang) sessions.getAttribute("user");

        GioHang ghUser = this.ghRepo.getGioHangByKhachHang(kh.getId());

        GioHangChiTiet ghctUpadte = this.ghctRepo.findGioHangChiTietByGioHangAndCAndChiTietSp(ghUser.getId(),sp.getId());


            ghctUpadte.setSoLuongTon(ghctUpadte.getSoLuongTon() + 1);
            String dongiaString = String.valueOf(ghctUpadte.getDonGia());
            Integer dongiaTong = Integer.parseInt(dongiaString) + Integer.parseInt(sp.getGiaBan()) ;
            ghctUpadte.setDonGia(BigDecimal.valueOf(dongiaTong));

            this.ghctRepo.save(ghctUpadte);

        return "redirect:/gio-hang/user";
    }
    @PostMapping("/gio-hang/TruOne/{id}")
    public String truOne(@PathVariable("id") ChiTietSP sp, Model model){

        KhachHang kh = (KhachHang) sessions.getAttribute("user");

        GioHang ghUser = this.ghRepo.getGioHangByKhachHang(kh.getId());

        GioHangChiTiet ghctUpadte = this.ghctRepo.findGioHangChiTietByGioHangAndCAndChiTietSp(ghUser.getId(),sp.getId());


        ghctUpadte.setSoLuongTon(ghctUpadte.getSoLuongTon() - 1);
        String dongiaString = String.valueOf(ghctUpadte.getDonGia());
        Integer dongiaTong = Integer.parseInt(dongiaString) - Integer.parseInt(sp.getGiaBan()) ;
        ghctUpadte.setDonGia(BigDecimal.valueOf(dongiaTong));



        this.ghctRepo.save(ghctUpadte);

        return "redirect:/gio-hang/user";
    }

    @PostMapping("/gio-hang/thanh-toan")
    public String thanhToan(@RequestParam("ten") String ten,
                            @RequestParam("sdt") String sdt,
                            @RequestParam("diaChi") String diaChi){

        KhachHang kh = (KhachHang) sessions.getAttribute("user");

        GioHang ghUser = this.ghRepo.getGioHangByKhachHang(kh.getId());

        List<GioHangChiTiet> ghct = this.ghctRepo.getGioHangChiTietByGioHang(ghUser.getId());

        Integer maxMa = this.hdRepo.maxMa()+1;
    // create hoa don moi
        System.out.println(this.hdRepo.maxMa());
        HoaDon hoadon = new HoaDon();
        hoadon.setKhachHang(kh);
        hoadon.setMa(String.valueOf(maxMa.toString()));
        hoadon.setNgayTao(java.time.LocalDate.now().toString());
        hoadon.setNgayThanhToan(java.time.LocalDate.now().toString());
        hoadon.setTenNguoiNhan(ten);
        hoadon.setSdt(sdt);
        hoadon.setDiaChi(diaChi);
        hoadon.setTinhTrang(0);
//
        this.hdRepo.save(hoadon);
//         lay hoa don bang ma va insert to hoadonchitiet = for
//        id sp and hoadon id


        HoaDon hdFind = this.hdRepo.getHoaDonByMa(String.valueOf(maxMa.toString()));
        System.out.println(hdFind.toString());

        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        for (GioHangChiTiet a : ghct
             ) {
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setHoaDon(hdFind);
            hdct.setChiTietSp(a.getChiTietSp());
            hdct.setSoLuongTon(a.getSoLuongTon());
            hdct.setDonGia(a.getDonGia());
            listHDCT.add(hdct);
        }
        this.hdctRepo.saveAll(listHDCT);

        this.ghctRepo.deleteAll(ghct);
        return "redirect:/gio-hang/user";
    }

//    hoa don
@GetMapping("/hoa-don/user")
public String hoaDonUser(Model model,@RequestParam(defaultValue = "0", name = "page") Integer number){
    Pageable pageable = PageRequest.of(number, 8);
    KhachHang kh = (KhachHang) sessions.getAttribute("user");
    if(kh == null){
        return "redirect:/login";
    }
    Page<HoaDon> listctsp = this.hdRepo.getHoaDonByKhachHang(kh.getId(),pageable);
    model.addAttribute("hd", listctsp);
    model.addAttribute("view","/views/hoaDonUser.jsp");
    return "layoutPro";
}


    @GetMapping("/user/hoa-don-chi-tiet/{id}")
    public String hoaDDonChiTietUser(@PathVariable("id") HoaDon hoadon,Model model){
        KhachHang kh = (KhachHang) sessions.getAttribute("user");

        List<HoaDonChiTiet> hdct = this.hdctRepo.getHoaDonChiTietByHoaDon(hoadon);
        model.addAttribute("donGia",this.hdctRepo.tinhTongTien(hoadon.getId()));
        model.addAttribute("hdct",hdct);
        model.addAttribute("hd",hoadon);
        model.addAttribute("kh",kh);
        model.addAttribute("view","/views/HoaDonBill.jsp");
        return "layoutPro";
    }
    @PostMapping("/thanh-toan/{id}")
    public String thanhToan(@PathVariable("id") HoaDon hoadon,Model model){
        hoadon.setNgayNhan(java.time.LocalDate.now().toString());
        this.hdRepo.save(hoadon);
        return "redirect:/hoa-don/user";
    }
}
