package com.hivetech.servletjsp.servlet.handlphoto;

import com.hivetech.servletjsp.model.Customer;
import com.hivetech.servletjsp.service.UploadPhotoService;
import com.hivetech.servletjsp.service.impl.CustomerServiceImpl;
import com.hivetech.servletjsp.util.ProcessPhoto;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/customer/upload/profilephoto")
@MultipartConfig
public class UploadProfilePhotoServlet extends HttpServlet {

    private UploadPhotoService<Customer> uploadPhotoService;

    public void init() {
        uploadPhotoService = new CustomerServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        Part imgPart = req.getPart("imgUpload");

        String photoNameInput = Paths.get(imgPart.getSubmittedFileName()).getFileName().toString();

        String photoNameOutput = ProcessPhoto.saveImg(imgPart.getInputStream(), photoNameInput);
        Customer customer = new Customer();
        customer.setCustomerNumber(103);
        customer.setProfilePhotoName(photoNameOutput);
        uploadPhotoService.editPhotoPath(customer);

    }
}
