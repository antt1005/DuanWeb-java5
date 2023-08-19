package fplhn.tiennh21.sd17306.controllers.admin;

import fplhn.tiennh21.sd17306.entities.DongSP;
import fplhn.tiennh21.sd17306.repositories.DongSPRepository;
import fplhn.tiennh21.sd17306.request.DongSPVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("admin/dong-sp")
public class DongSPController {
    @Autowired
    private DongSPRepository dspRepo;

    @Autowired
    private DongSPVM dsp;

    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("dsp", dsp);
        model.addAttribute("action","/admin/dong-sp/store");
        model.addAttribute("view","/views/admin/dong_sp/create.jsp");
        return "layoutProNhanVien";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("dsp") DongSPVM dspp,
                        BindingResult result,Model model ){
        if(result.hasErrors()){
            model.addAttribute("view","/views/admin/dong_sp/create.jsp");
            return "layoutProNhanVien";
        }
        DongSP dongSP = DongSP.builder()
                .ma(dspp.getMa())
                .ten(dspp.getTen())
                .build();

        this.dspRepo.save(dongSP);
        return "redirect:/admin/dong-sp/index";

    }

    @GetMapping("index")
    public String index(Model model){
        List<DongSP> dsp = this.dspRepo.findAll();
        model.addAttribute("data",dsp);
        model.addAttribute("view","/views/admin/dong_sp/index.jsp");
        return "layoutProNhanVien";

    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")DongSP dongSP){
        this.dspRepo.delete(dongSP);
        return "redirect:/admin/dong-sp/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")DongSP dongSP,Model model){

        model.addAttribute("dsp",dongSP);
        model.addAttribute("action","/admin/dong-sp/update/" + dongSP.getId());
        model.addAttribute("view","/views/admin/dong_sp/create.jsp");
        return "layoutProNhanVien";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id")DongSP oldValue,
                         Model model,@Valid @ModelAttribute("dsp")DongSPVM newValue,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("dsp",oldValue);
            model.addAttribute("action","/admin/dong-sp/update/"+ oldValue.getId());
            model.addAttribute("view","/views/admin/dong_sp/create.jsp");
            return "layoutProNhanVien";
        }
        DongSP dongSP = DongSP.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .ten(newValue.getTen())
                .build();
        this.dspRepo.save(dongSP);
        return "redirect:/admin/dong-sp/index";
    }

}
