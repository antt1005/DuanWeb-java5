package fplhn.tiennh21.sd17306.controllers.admin;

import fplhn.tiennh21.sd17306.entities.ChucVu;
import fplhn.tiennh21.sd17306.repositories.ChucVuRepository;
import fplhn.tiennh21.sd17306.request.ChucVuVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuRepository cvRepo;

    @Autowired
    private ChucVuVM cv;

    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("cv", cv);
        model.addAttribute("action","/admin/chuc-vu/store");
        model.addAttribute("view","/views/admin/chuc_vu/create.jsp");
        return "layoutProNhanVien";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("cv") ChucVuVM cv,
                        BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("view","/views/admin/chuc_vu/create.jsp");
            return "layoutProNhanVien";
        }
        ChucVu chucVu = ChucVu.builder()
                .ma(cv.getMa())
                .ten(cv.getTen())
                .build();

        this.cvRepo.save(chucVu);
        return "redirect:/admin/chuc-vu/index";

    }

    @GetMapping("index")
    public String index(Model model){
        List<ChucVu> cv = this.cvRepo.findAll();
        model.addAttribute("data",cv);
        model.addAttribute("view","/views/admin/chuc_vu/index.jsp");
        return "layoutProNhanVien";

    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")ChucVu chucVu){
        this.cvRepo.delete(chucVu);
        return "redirect:/admin/chuc-vu/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")ChucVu chucVu,Model model){

        model.addAttribute("cv",chucVu);
        model.addAttribute("action","/admin/chuc-vu/update/" + chucVu.getId());
        model.addAttribute("view","/views/admin/chuc_vu/create.jsp");
        return "layoutProNhanVien";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id")ChucVu oldValue,
                         Model model,@Valid @ModelAttribute("cv")ChucVuVM newValue,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("cv",oldValue);
            model.addAttribute("action","/admin/chuc-vu/update/"+ oldValue.getId());
            model.addAttribute("view","/views/admin/chuc_vu/create.jsp");
            return "layoutProNhanVien";
        }
        ChucVu chucVu = ChucVu.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .ten(newValue.getTen())
                .build();
        this.cvRepo.save(chucVu);
        return "redirect:/admin/chuc-vu/index";
    }

}
