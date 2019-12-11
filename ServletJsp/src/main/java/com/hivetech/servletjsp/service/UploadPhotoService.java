package com.hivetech.servletjsp.service;

public interface UploadPhotoService<E> {
    boolean addPhotoPath(String photoPath, int customerNumber);
    boolean editPhotoPath(E e);
    String getPhotoPath(String elementId);

}
