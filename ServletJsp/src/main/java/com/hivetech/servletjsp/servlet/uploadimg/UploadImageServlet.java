package com.hivetech.servletjsp.servlet.uploadimg;

import com.hivetech.servletjsp.model.Customer;
import com.hivetech.servletjsp.service.CustomerService;
import com.hivetech.servletjsp.service.UploadPhotoService;
import com.hivetech.servletjsp.service.impl.CustomerServiceImpl;
import com.hivetech.servletjsp.util.CopyerImg;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/customer/upload/profilephoto")
@MultipartConfig
public class UploadImageServlet extends HttpServlet {

    private UploadPhotoService<Customer> uploadPhotoService;

    public void init() {
        uploadPhotoService = new CustomerServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        //img file name + postfix
        String imgName = req.getParameter("imgUpload");
        Part imgPart = req.getPart("imgUpload");
//        InputStream is = req.getInputStream();

        String fileName = CopyerImg.saveImg(imgName, req.getInputStream());

    }
}
