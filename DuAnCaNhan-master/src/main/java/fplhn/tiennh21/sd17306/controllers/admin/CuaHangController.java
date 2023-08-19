package fplhn.tiennh21.sd17306.controllers.admin;

import fplhn.tiennh21.sd17306.entities.CuaHang;
import fplhn.tiennh21.sd17306.repositories.CuaHangRepository;
import fplhn.tiennh21.sd17306.request.CuaHangVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("admin/cua-hang")
public class CuaHangController {
    @Autowired
    @Qualifier("cuaHangVM1")
    private CuaHangVM vm;

    @Autowired
    private CuaHangRepository cuaHangRepo;

    @GetMapping("createch")
    public String create(Model model)
    {
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/admin/cua-hang/store");
        model.addAttribute("view","/views/admin/cua_hang/createch.jsp");
        return "layoutProNhanVien";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") CuaHang cuaHang, Model model)
    {
        vm.loadFromDomain(cuaHang);
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/admin/cua-hang/update/" + cuaHang.getId());
        model.addAttribute("view","/views/admin/cua_hang/createch.jsp");
        return "layoutProNhanVien";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") CuaHang domainModel,
            @Valid @ModelAttribute("ms") CuaHangVM vm,
            BindingResult result, Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("view","/views/admin/cua_hang/createch.jsp");
            return "layoutProNhanVien";
        } else {
            domainModel.loadFromVM(vm);
            this.cuaHangRepo.save(domainModel);
        }
        return "redirect:/admin/cua-hang/index";
    }

    @PostMapping("store")
    public String store(
        @Valid @ModelAttribute("ms") CuaHangVM vm,
        BindingResult result,Model model
    ) {
        if (result.hasErrors()) {
            // Báo lỗi
            System.out.println(vm.getTen());
            model.addAttribute("view","/views/admin/cua_hang/createch.jsp");
            return "layoutProNhanVien";
        } else {
            CuaHang ch = new CuaHang();
            ch.setTen(vm.getTen());
            ch.setMa(vm.getMa());
            ch.setDiaChi(vm.getDiaChi());
            ch.setThanhPho(vm.getThanhPho());
            ch.setQuocGia(vm.getQuocGia());
            this.cuaHangRepo.save(ch);
        }
        return "redirect:/admin/cua-hang/index";
    }

    @GetMapping("index")
    public String index(Model model)
    {
        List<CuaHang> ds = cuaHangRepo.findAll();
        model.addAttribute("data", ds);
        model.addAttribute("view","/views/admin/cua_hang/index.jsp");
        return "layoutProNhanVien";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") CuaHang cuaHang)
    {
        System.out.println(cuaHang.getTen());
        System.out.println(cuaHang.getMa());
        this.cuaHangRepo.delete(cuaHang);
        return "redirect:/admin/cua-hang/index";
    }
}
