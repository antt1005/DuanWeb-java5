package fplhn.tiennh21.sd17306.filters;

import fplhn.tiennh21.sd17306.entities.NhanVien;
import fplhn.tiennh21.sd17306.request.Account;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AdminFilter implements Filter {

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            HttpSession session = httpRequest.getSession();
            NhanVien nhanVien = (NhanVien) session.getAttribute("nv");

            if (httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/login")) {
                chain.doFilter(request, response);
            } else if (nhanVien == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            } else {
                chain.doFilter(request, response);
            }
        }

}
