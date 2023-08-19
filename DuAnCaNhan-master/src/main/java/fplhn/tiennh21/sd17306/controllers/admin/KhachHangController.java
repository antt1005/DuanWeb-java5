package fplhn.tiennh21.sd17306.controllers.admin;

import fplhn.tiennh21.sd17306.entities.KhachHang;
import fplhn.tiennh21.sd17306.repositories.KhachHangRepository;
import fplhn.tiennh21.sd17306.request.KhachHangVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("admin/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangRepository khRepo;

    @Autowired
    private KhachHangVM kh;

    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("kh", kh);
       model.addAttribute("action","/admin/khach-hang/store");
        model.addAttribute("view","/views/admin/khach_hang/create.jsp");
        return "layoutProNhanVien";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("kh") KhachHangVM khachHangVM,
                        BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("view","/views/admin/khach_hang/create.jsp");
            return "layoutProNhanVien";
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
        return "redirect:/admin/khach-hang/index";

    }

    @GetMapping("index")
    public String index(Model model){
        List<KhachHang> khachHangs = this.khRepo.findAll();
        model.addAttribute("data",khachHangs);
        model.addAttribute("view","/views/admin/khach_hang/index.jsp");
        return "layoutProNhanVien";

    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")KhachHang khachHang){
        this.khRepo.delete(khachHang);
        return "redirect:/admin/khach-hang/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")KhachHang khachHang,Model model){

        model.addAttribute("data",khachHang);
        model.addAttribute("action","/admin/khach-hang/update/" + khachHang.getId());
        model.addAttribute("view","/views/admin/khach_hang/edit.jsp");
        return "layoutProNhanVien";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id")KhachHang oldValue,
                         Model model,@Valid @ModelAttribute("data")KhachHangVM newValue,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("kh",oldValue);
           model.addAttribute("action","/admin/khach-hang/update/"+ oldValue.getId());
            model.addAttribute("view","/views/admin/khach_hang/edit.jsp");
            return "layoutProNhanVien";
        }
        KhachHang khachHang = KhachHang.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .ten(newValue.getTen())
                .tenDem(newValue.getTenDem())
                .ho(newValue.getHo())
                .ngaySinh(newValue.getNgaySinh())
                .sdt(newValue.getSdt())
                .diaChi(newValue.getDiaChi())
                .thanhPho(newValue.getThanhPho())
                .quocGia(newValue.getQuocGia())
                .matKhau(newValue.getMatKhau())
                .build();
        this.khRepo.save(khachHang);
        return "redirect:/admin/khach-hang/index";
    }
    }
