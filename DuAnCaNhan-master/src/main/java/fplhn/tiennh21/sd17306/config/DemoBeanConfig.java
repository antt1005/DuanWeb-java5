package fplhn.tiennh21.sd17306.config;

import fplhn.tiennh21.sd17306.filters.AdminFilter;
import fplhn.tiennh21.sd17306.request.CuaHangVM;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoBeanConfig {
    @Bean("cuaHangVM1")
    public CuaHangVM getCuaHangVM1()
    {
        CuaHangVM vm = new CuaHangVM();
        vm.setTen("Cua Hang 1");
        vm.setMa("CH0001");
        vm.setDiaChi("HN");
        vm.setQuocGia("VN");

        return vm;
    }

    @Bean("cuaHangVM2")
    public CuaHangVM getCuaHangVM2()
    {
        CuaHangVM vm = new CuaHangVM();
        vm.setTen("Cua Hang 2");
        vm.setMa("CH0002");
        vm.setDiaChi("HCM");
        vm.setQuocGia("VN");

        return vm;
    }
    @Bean
    public FilterRegistrationBean<AdminFilter> sessionFilter() {
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AdminFilter());
        registrationBean.addUrlPatterns("/admin/*");
        return registrationBean;
    }
}
