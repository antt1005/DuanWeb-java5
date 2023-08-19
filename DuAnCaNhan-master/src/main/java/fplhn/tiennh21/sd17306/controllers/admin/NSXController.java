package fplhn.tiennh21.sd17306.controllers.admin;

import fplhn.tiennh21.sd17306.entities.NSX;
import fplhn.tiennh21.sd17306.repositories.NSXRepository;
import fplhn.tiennh21.sd17306.request.NSXVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("admin/n-sx")
public class NSXController {
    @Autowired
    private NSXRepository nsxRepo;

    @Autowired
    private NSXVM nsx;

    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("nsx", nsx);
        model.addAttribute("action","/admin/n-sx/store");
        model.addAttribute("view","/views/admin/nsx/create.jsp");
        return "layoutProNhanVien";


    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("nsx") NSXVM nsxx,
                        BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("view","/views/admin/nsx/create.jsp");
            return "layoutProNhanVien";
        }
        NSX nsx1 = NSX.builder()
                .ma(nsxx.getMa())
                .ten(nsxx.getTen())
                .build();

        this.nsxRepo.save(nsx1);
        return "redirect:/admin/n-sx/index";

    }

    @GetMapping("index")
    public String index(Model model){
        List<NSX> nsxes = this.nsxRepo.findAll();
        model.addAttribute("data",nsxes);
        model.addAttribute("view","/views/admin/nsx/index.jsp");
        return "layoutProNhanVien";

    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")NSX nsx){
        this.nsxRepo.delete(nsx);
        return "redirect:/admin/n-sx/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")NSX nsx,Model model){

        model.addAttribute("nsx",nsx);
        model.addAttribute("action","/admin/n-sx/update/" + nsx.getId());
        model.addAttribute("view","/views/admin/nsx/create.jsp");
        return "layoutProNhanVien";

    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id")NSX oldValue,
                         Model model,@Valid @ModelAttribute("nsx")NSXVM newValue,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("nsx",oldValue);
            model.addAttribute("action","/admin/n-sx/update/"+ oldValue.getId());
            model.addAttribute("view","/views/admin/nsx/create.jsp");
            return "layoutProNhanVien";
        }
        NSX nsx = NSX.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .ten(newValue.getTen())
                .build();
        this.nsxRepo.save(nsx);
        return "redirect:/admin/n-sx/index";
    }
}
