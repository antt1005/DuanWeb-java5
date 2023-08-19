package fplhn.tiennh21.sd17306.controllers;

import fplhn.tiennh21.sd17306.entities.NhanVien;
import fplhn.tiennh21.sd17306.repositories.KhachHangRepository;
import fplhn.tiennh21.sd17306.repositories.NhanVienRepository;
import fplhn.tiennh21.sd17306.request.Account;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private HttpSession session;

    @Autowired
    private KhachHangRepository khRepo;

    @Autowired
    private NhanVienRepository nvRepo;


    @GetMapping("login")
    public String getLoginForm(Model model)
    {

        return "login";
    }

    @PostMapping("login")
//    public String login(
//        @RequestParam(name="email", defaultValue = "ngvana@fpt.edu.vn") String email,
//        @RequestParam("password") Optional<String> pwd
//    ) {
    // Khi method return void, tên view == url
    public String login(Account account,Model model){

//        session.setAttribute("nv",account);

        String sdt =  account.getEmail();
        String pass = account.getPassword();
        NhanVien nv = this.nvRepo.getNhanVienBy(sdt,pass);
        if(nv != null){
            session.setAttribute("nv",nv);
            return "redirect:/admin/ban-hang/index";
        }


        if(this.khRepo.getKhachHangBySdtEqualsAndMatKhauEquals(sdt,pass)==null){
            return "redirect:/login";
        }else{
            session.setAttribute("user",this.khRepo.getKhachHangBySdtEqualsAndMatKhauEquals(sdt,pass));
            return "redirect:/home";
        }


    }
}
