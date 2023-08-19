package fplhn.tiennh21.sd17306.controllers.admin;

import fplhn.tiennh21.sd17306.entities.HoaDon;
import fplhn.tiennh21.sd17306.entities.HoaDonChiTiet;
import fplhn.tiennh21.sd17306.repositories.HoaDonChiTietRepository;
import fplhn.tiennh21.sd17306.repositories.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("admin/hoa-don-chi-tiet")
public class HoaDonChiTietController {

    @Autowired
    private HoaDonChiTietRepository hdRepo;

    @GetMapping("index/{id}")
    public String index(Model model, @PathVariable("id") HoaDon hd){
        List<HoaDonChiTiet> hdct = this.hdRepo.getHoaDonChiTietByHoaDon(hd);

        model.addAttribute("hdct", hdct);
        model.addAttribute("view","/views/admin/hoa_don_chi_tiet/index.jsp");
        return "layoutProNhanVien";
    }
}
