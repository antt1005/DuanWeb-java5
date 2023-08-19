package fplhn.tiennh21.sd17306.controllers.admin;

import fplhn.tiennh21.sd17306.entities.NSX;
import fplhn.tiennh21.sd17306.entities.SanPham;
import fplhn.tiennh21.sd17306.repositories.SanPhamRepository;
import fplhn.tiennh21.sd17306.request.NSXVM;
import fplhn.tiennh21.sd17306.request.SanPhamVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("admin/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamRepository spRepo;

    @Autowired
    private SanPhamVM sp;

    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("sp", sp);
        model.addAttribute("action","/admin/san-pham/store");
        model.addAttribute("view","/views/admin/san_pham/create.jsp");
        return "layoutProNhanVien";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("sp") SanPhamVM sanPhamVM,
                        BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("view","/views/admin/san_pham/create.jsp");
            return "layoutProNhanVien";
        }
        SanPham sanPham = SanPham.builder()
                .ma(sanPhamVM.getMa())
                .ten(sanPhamVM.getTen())
                .build();

        this.spRepo.save(sanPham);
        return "redirect:/admin/san-pham/index";

    }

    @GetMapping("index")
    public String index(Model model){
        List<SanPham> sanPhams = this.spRepo.findAll();
        model.addAttribute("data",sanPhams);
        model.addAttribute("view","/views/admin/san_pham/index.jsp");
        return "layoutProNhanVien";

    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")SanPham sanPham){
        this.spRepo.delete(sanPham);
        return "redirect:/admin/san-pham/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")SanPham sanPham,Model model){

        model.addAttribute("sp",sanPham);
        model.addAttribute("action","/admin/san-pham/update/" + sanPham.getId());
        model.addAttribute("view","/views/admin/san_pham/create.jsp");
        return "layoutProNhanVien";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") SanPham oldValue,
                         Model model, @Valid @ModelAttribute("sp") SanPhamVM newValue, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("sp",oldValue);
            model.addAttribute("action","/admin/san-pham/update/"+ oldValue.getId());
            model.addAttribute("view","/views/admin/san_pham/create.jsp");
            return "layoutProNhanVien";
        }
        SanPham sanPham = SanPham.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .ten(newValue.getTen())
                .build();
        this.spRepo.save(sanPham);
        return "redirect:/admin/san-pham/index";
    }
}
