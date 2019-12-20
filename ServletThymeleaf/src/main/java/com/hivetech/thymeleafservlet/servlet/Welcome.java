package com.hivetech.thymeleafservlet.servlet;

import com.hivetech.thymeleafservlet.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {

    private TemplateEngine te;

    @Override
    public void init() throws ServletException {
        te = TemplateEngineUtil.getTemplateEngine(this.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
//        req.setAttribute("world","world");
        context.setVariable("world", "World");
        te.process("_th_Welcome.html", context, resp.getWriter());
    }
}
