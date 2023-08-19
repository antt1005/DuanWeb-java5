package fplhn.tiennh21.sd17306.controllers.admin;

import fplhn.tiennh21.sd17306.entities.ChucVu;
import fplhn.tiennh21.sd17306.entities.CuaHang;
import fplhn.tiennh21.sd17306.entities.MauSac;
import fplhn.tiennh21.sd17306.repositories.MauSacRepository;
import fplhn.tiennh21.sd17306.request.ChucVuVM;
import fplhn.tiennh21.sd17306.request.CuaHangVM;
import fplhn.tiennh21.sd17306.request.MauSacVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Controller
@RequestMapping("admin/mau-sac")
public class MauSacController {
    @Autowired
    private MauSacVM ms;

    @Autowired
    private MauSacRepository repo;

//    @GetMapping("index")
//    public String index(Model model)
//    {
//        List<MauSac> ds = repo.findAll();
//        model.addAttribute("data", ds);
//        return "admin/mau_sac/index";
//    }
@GetMapping("index")
public String getAll(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
    // Page => Trang => Noi dung cua 1 trang
    // 6 phan tu list
    // 1 : size ( 1 trang muon size = bn) : 4 => 4 phan tu 1/trang
    // => Page 1: 4 phan tu dau tien => Page = 0
    // => Page 2: 2 phan tu con lai => Page = 1
    // 2:  soPage => Trang so may : pageNo
    Pageable pageable = PageRequest.of(number, 2);
    Page<MauSac> ds = repo.findAll(pageable);
    model.addAttribute("lis", ds );
    model.addAttribute("view","/views/admin/mau_sac/index.jsp");
    return "layoutProNhanVien";
}

    @GetMapping("createms")
    public String create(Model model)
    {
        model.addAttribute("data", ms);
        model.addAttribute("action", "/admin/mau-sac/store");
        model.addAttribute("view","/views/admin/mau_sac/createms.jsp");
        return "layoutProNhanVien";
    }
    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") MauSacVM ms,
            BindingResult result,Model model
    ) {
        if (result.hasErrors()) {
            // Báo lỗi
            System.out.println(ms.getTen());
            model.addAttribute("view","/views/admin/mau_sac/createms.jsp");
            return "layoutProNhanVien";
        } else {
            MauSac mauSac = MauSac.builder()
                    .ma(ms.getMa())
                    .ten(ms.getTen())
                    .build();
            this.repo.save(mauSac);
        }
        return "redirect:/admin/mau-sac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") MauSac mauSac)
    {
        System.out.println(mauSac.getTen());
        System.out.println(mauSac.getMa());
        this.repo.delete(mauSac);
        return "redirect:/admin/mau-sac/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")MauSac mauSac,Model model){

        model.addAttribute("data",mauSac);
        model.addAttribute("action","/admin/mau-sac/update/" + mauSac.getId());
        model.addAttribute("view","/views/admin/mau_sac/createms.jsp");
        return "layoutProNhanVien";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") MauSac oldValue,
                         Model model, @Valid @ModelAttribute("data") MauSacVM newValue, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("data",oldValue);
            model.addAttribute("action","/admin/mau-sac/update/"+ oldValue.getId());
            System.out.println("1");
            model.addAttribute("view","/views/admin/mau_sac/createms.jsp");
            return "layoutProNhanVien";

        }
        MauSac mauSac = MauSac.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .ten(newValue.getTen())
                .build();
        this.repo.save(mauSac);
        System.out.println("2");
        return "redirect:/admin/mau-sac/index";
    }

}
