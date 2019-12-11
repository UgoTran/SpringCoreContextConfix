package com.hivetech.servletjsp.service;

public interface UploadPhotoService<E> {
    boolean addPhotoPath(String photoPath);
    boolean editPhotoPath(E e);
    boolean deletePhotoPath(String elementId);
    String getPhotoPath();

}
