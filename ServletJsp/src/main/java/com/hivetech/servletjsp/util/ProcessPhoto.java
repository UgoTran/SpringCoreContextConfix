package com.hivetech.servletjsp.util;

import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class ProcessPhoto {

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private static final String diskNameOutput = "D:/";
    private static final String folderPathOutput = "classicmodels/customer/profile-photo/";
    private static int maxImgSize = 10_000;

    public static String saveImg(InputStream servletInputStream, String photoNameInput) {

        String tempFileName = UUID.randomUUID().toString();
        String fileExtension = "." + FilenameUtils.getExtension(photoNameInput);
        InputStream inputStream =null;
        OutputStream outputStream = null;
        try {

            String savingPath = diskNameOutput + folderPathOutput;
            String originalFilePath = savingPath + tempFileName;


            inputStream = servletInputStream;
            outputStream = new FileOutputStream(originalFilePath + fileExtension);
            inputStream.transferTo(outputStream);

            inputStream.close();
            outputStream.close();

            String md5FromFile = genMD5FromFile(originalFilePath + fileExtension);

            File originFile = new File(originalFilePath + fileExtension);
            File fileRenamed = new File(savingPath + md5FromFile + fileExtension);
            fileRenamed.createNewFile();
            boolean renameSuccess = originFile.renameTo(fileRenamed);
            if (renameSuccess) {
                return md5FromFile;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
        return tempFileName + fileExtension;
    }

    public static String genMD5FromFile(String tempFileName)
            throws NoSuchAlgorithmException, IOException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(Files.readAllBytes(Paths.get(tempFileName)));
        byte[] digest = md.digest();
        String myChecksum = bytesToHex(digest).toUpperCase();

        return myChecksum;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

}
