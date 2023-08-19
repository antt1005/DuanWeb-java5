package fplhn.tiennh21.sd17306.controllers.admin;

import fplhn.tiennh21.sd17306.entities.*;
import fplhn.tiennh21.sd17306.repositories.*;
import fplhn.tiennh21.sd17306.request.ChiTietSPVM;
import fplhn.tiennh21.sd17306.request.NhanVienVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("admin/chi-tiet-sp")
public class ChiTietSPController {

    @Autowired
    private ChiTietSPVM ctsp;

    @Autowired
    private ChiTietSPRepository repoCtsp;

    @Autowired
    private DongSPRepository repoDsp;

    @Autowired
    private MauSacRepository repoMs;

    @Autowired
    private NSXRepository repoNsx;

    @Autowired
    private SanPhamRepository repoSp;

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
//        List<NhanVien> listnv = this.repoNV.findAll();
        Pageable pageable = PageRequest.of(number, 4);
        Page<ChiTietSP> listctsp = this.repoCtsp.findAll(pageable);
        model.addAttribute("listCTSP", listctsp);
        model.addAttribute("view","/views/admin/chi_tiet_sp/index.jsp");
        return "layoutProNhanVien";
    }

    @GetMapping("create")
    public String createnv(Model model){
        List<DongSP> listDsp = repoDsp.findAll();
        List<MauSac> listMs =repoMs.findAll();
        List<NSX> listNsx = repoNsx.findAll();
        List<SanPham> listSp =repoSp.findAll();
        model.addAttribute("data",ctsp);
        model.addAttribute("dsps",listDsp);
        model.addAttribute("mss",listMs);
        model.addAttribute("nsxs",listNsx);
        model.addAttribute("sps",listSp);
        model.addAttribute("action","/admin/chi-tiet-sp/store");
        model.addAttribute("view","/views/admin/chi_tiet_sp/createct.jsp");
        return "layoutProNhanVien";
    }
    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") ChiTietSP nv, BindingResult result, Model model, RedirectAttributes parmar){
        if(result.hasErrors()){
            List<DongSP> listDsp = repoDsp.findAll();
            List<MauSac> listMs =repoMs.findAll();
            List<NSX> listNsx = repoNsx.findAll();
            List<SanPham> listSp =repoSp.findAll();
            System.out.println(result.toString());
            model.addAttribute("dsps",listDsp);
            model.addAttribute("mss",listMs);
            model.addAttribute("nsxs",listNsx);
            model.addAttribute("sps",listSp);
            model.addAttribute("view","/views/admin/chi_tiet_sp/createct.jsp");
            return "layoutProNhanVien";
        }
        ChiTietSP nvNew = ChiTietSP.builder()
                .sp(nv.getSp())
                .nsx(nv.getNsx())
                .ms(nv.getMs())
                .dsp(nv.getDsp())
                .namBH(nv.getNamBH())
                .moTa(nv.getMoTa())
                .soLuongTon(nv.getSoLuongTon())
                .giaNhap(nv.getGiaNhap())
                .giaBan(nv.getGiaBan())
                .build();
        this.repoCtsp.save(nvNew);
        parmar.addAttribute("message"," alert('them ok')");
        return "redirect:/admin/chi-tiet-sp/index";

    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChiTietSP nv, RedirectAttributes parmar,Model model){
        this.repoCtsp.delete(nv);
        parmar.addAttribute("message"," alert('xoa ok')");
        return "redirect:/admin/chi-tiet-sp/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChiTietSP nhanVienCu,Model model){
        List<DongSP> listDsp = repoDsp.findAll();
        List<MauSac> listMs =repoMs.findAll();
        List<NSX> listNsx = repoNsx.findAll();
        List<SanPham> listSp =repoSp.findAll();

        model.addAttribute("dsps",listDsp);
        model.addAttribute("mss",listMs);
        model.addAttribute("nsxs",listNsx);
        model.addAttribute("sps",listSp);
        model.addAttribute("data",nhanVienCu);
        model.addAttribute("action","/admin/chi-tiet-sp/update/"+nhanVienCu.getId());
        model.addAttribute("view","/views/admin/chi_tiet_sp/createct.jsp");
        return "layoutProNhanVien";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") ChiTietSP chitietsp,@Valid @ModelAttribute("data") ChiTietSP nv, BindingResult result,Model model,RedirectAttributes parmar) {
        if (result.hasErrors()) {
            List<DongSP> listDsp = repoDsp.findAll();
            List<MauSac> listMs = repoMs.findAll();
            List<NSX> listNsx = repoNsx.findAll();
            List<SanPham> listSp = repoSp.findAll();
            System.out.println(result.toString());
            model.addAttribute("dsps", listDsp);
            model.addAttribute("mss", listMs);
            model.addAttribute("nsxs", listNsx);
            model.addAttribute("sps", listSp);
            model.addAttribute("view","/views/admin/chi_tiet_sp/createct.jsp");
            return "layoutProNhanVien";
        }
        ChiTietSP nvNew = ChiTietSP.builder()
                .id(chitietsp.getId())
                .sp(nv.getSp())
                .nsx(nv.getNsx())
                .ms(nv.getMs())
                .dsp(nv.getDsp())
                .namBH(nv.getNamBH())
                .moTa(nv.getMoTa())
                .soLuongTon(nv.getSoLuongTon())
                .giaNhap(nv.getGiaNhap())
                .giaBan(nv.getGiaBan())
                .build();
        this.repoCtsp.save(nvNew);
        parmar.addAttribute("message", " alert('sua ok')");
        return "redirect:/admin/chi-tiet-sp/index";


    }

    }
