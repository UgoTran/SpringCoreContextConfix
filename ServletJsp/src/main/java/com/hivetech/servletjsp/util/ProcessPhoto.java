package com.hivetech.servletjsp.util;

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
    private static String imgName = "D:/imgtest.jpg";
    private static int maxImgSize = 10_000;

    public static String saveImg(InputStream servletInputStream) {

        String tempFileName = UUID.randomUUID().toString();

        try {
            InputStream inputStream = servletInputStream;
            String savingPath = diskNameOutput + folderPathOutput;
            String originalFilePath = savingPath + tempFileName;
            OutputStream outputStream = new FileOutputStream(originalFilePath);
            inputStream.transferTo(outputStream);

            String md5FromFile = genMD5FromFile(originalFilePath);
            File f1 = new File(originalFilePath);
            File f2 = new File(savingPath + md5FromFile);
            boolean renameSuccess = f1.renameTo(f2);
            if (renameSuccess) {
                return md5FromFile;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tempFileName;
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
