package fplhn.tiennh21.sd17306.controllers.admin;

import fplhn.tiennh21.sd17306.entities.ChiTietSP;
import fplhn.tiennh21.sd17306.entities.HoaDon;
import fplhn.tiennh21.sd17306.repositories.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin/hoa-don")
public class HoaDonController {

    @Autowired
    private HoaDonRepository hdRepo;

    @GetMapping("index")
    public String index(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number){

        Pageable pageable = PageRequest.of(number, 8);
        Page<HoaDon> hds = this.hdRepo.HD(pageable);
        model.addAttribute("list", hds);
        model.addAttribute("view","/views/admin/hoa_don/index.jsp");
        return "layoutProNhanVien";

    }
}
