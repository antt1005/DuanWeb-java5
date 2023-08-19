package fplhn.tiennh21.sd17306.controllers.admin;

import fplhn.tiennh21.sd17306.entities.ChucVu;
import fplhn.tiennh21.sd17306.entities.CuaHang;
import fplhn.tiennh21.sd17306.entities.NhanVien;
import fplhn.tiennh21.sd17306.repositories.ChucVuRepository;
import fplhn.tiennh21.sd17306.repositories.CuaHangRepository;
import fplhn.tiennh21.sd17306.repositories.NhanVienRepository;
import fplhn.tiennh21.sd17306.request.MauSacVM;

import fplhn.tiennh21.sd17306.request.NhanVienVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("admin/nhan-vien")

public class NhanVienController {

    @Autowired
    private NhanVienVM nv;

    @Autowired
    private NhanVienRepository repoNV;

    @Autowired
    private CuaHangRepository repoCH;

    @Autowired
    private ChucVuRepository repoCV;



    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number,Model model){
//        List<NhanVien> listnv = this.repoNV.findAll();
        Pageable pageable = PageRequest.of(number, 2);
        Page<NhanVien> listnv = this.repoNV.findAll(pageable);
        model.addAttribute("listNV", listnv);
        model.addAttribute("view","/views/admin/nhan_vien/index.jsp");
        return "layoutProNhanVien";
    }

    @GetMapping("create")
    public String createnv(Model model){
        List<CuaHang> listCH = repoCH.findAll();
        List<ChucVu> listCV =repoCV.findAll();
        model.addAttribute("nv",nv);
        model.addAttribute("chs",listCH);
        model.addAttribute("cvs",listCV);
        model.addAttribute("action","/admin/nhan-vien/store");
        model.addAttribute("view","/views/admin/nhan_vien/createnv.jsp");
        return "layoutProNhanVien";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("nv") NhanVienVM nv, BindingResult result,Model model,RedirectAttributes parmar){
        if(result.hasErrors()){
            List<CuaHang> listCH = repoCH.findAll();
            List<ChucVu> listCV =repoCV.findAll();
            System.out.println(result.toString());
            model.addAttribute("chs",listCH);
            model.addAttribute("cvs",listCV);
            model.addAttribute("view","/views/admin/nhan_vien/createnv.jsp");
            return "layoutProNhanVien";
        }
            NhanVien nvNew = NhanVien.builder()
                    .ma(nv.getMa())
                    .ten(nv.getTen())
                    .tenDem(nv.getTenDem())
                    .ho(nv.getHo())
                    .gioiTinh(nv.getGioiTinh())
                    .ngaySinh(nv.getNgaySinh())
                    .diaChi(nv.getDiaChi())
                    .sdt(nv.getSdt())
                    .matKhau(nv.getMatKhau())
                    .trangThai(Integer.parseInt(nv.getTrangThai()))
                    .ch(nv.getCh())
                    .cv(nv.getCv()).build();
            this.repoNV.save(nvNew);
        parmar.addAttribute("message"," alert('them ok')");
            return "redirect:/admin/nhan-vien/index";


    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") NhanVien nhanVienCu,Model model){
        List<CuaHang> listCH = repoCH.findAll();
        List<ChucVu> listCV =repoCV.findAll();
        model.addAttribute("chs",listCH);
        model.addAttribute("cvs",listCV);
        model.addAttribute("nv",nhanVienCu);
        model.addAttribute("action","/admin/nhan-vien/update/"+nhanVienCu.getId());
        model.addAttribute("view","/views/admin/nhan_vien/createnv.jsp");
        return "layoutProNhanVien";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") NhanVien nhanVienCu,@Valid @ModelAttribute("nv") NhanVienVM nv, BindingResult result,Model model,RedirectAttributes parmar){
        if(result.hasErrors()){
            List<CuaHang> listCH = repoCH.findAll();
            List<ChucVu> listCV =repoCV.findAll();
            System.out.println(result.toString());
            model.addAttribute("chs",listCH);
            model.addAttribute("cvs",listCV);
            model.addAttribute("view","/views/admin/nhan_vien/createnv.jsp");
            return "layoutProNhanVien";
        }
        NhanVien nvNew = NhanVien.builder()
                .id(nhanVienCu.getId())
                .ma(nv.getMa())
                .ten(nv.getTen())
                .tenDem(nv.getTenDem())
                .ho(nv.getHo())
                .gioiTinh(nv.getGioiTinh())
                .ngaySinh(nv.getNgaySinh())
                .diaChi(nv.getDiaChi())
                .sdt(nv.getSdt())
                .matKhau(nv.getMatKhau())
                .trangThai(Integer.parseInt(nv.getTrangThai()))
                .ch(nv.getCh())
                .cv(nv.getCv()).build();
        this.repoNV.save(nvNew);
        parmar.addAttribute("message"," alert('sua ok')");
        return "redirect:/admin/nhan-vien/index";
    }

     @GetMapping("delete/{id}")
     public String delete(@PathVariable("id") NhanVien nv, RedirectAttributes parmar,Model model){
         this.repoNV.delete(nv);
         parmar.addAttribute("message"," alert('xoa ok')");
         return "redirect:/admin/nhan-vien/index";
     }


}
