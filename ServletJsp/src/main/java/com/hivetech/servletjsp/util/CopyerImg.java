package com.hivetech.servletjsp.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class CopyerImg {

    private static final String diskNameOutput = "D:/";
    private static final String folderPathOutput = "classicmodels/customer/profile-photo/";
    private static String imgName = "D:/imgtest.jpg";
    private static int maxImgSize = 10_000;

    public static String saveImg(String imgName, InputStream servletInputStream) {

//        File fileInput = new File(imgPathInput);
//        try {
//            InputStream inputStream = new FileInputStream(fileInput);
//            //Creating a byte array
//            byte bytes[] = new byte[(int) fileInput.length()];
//            //Reading data into the byte array
//            int numOfBytes = inputStream.read(bytes);
//            //Creating a FileInputStream object
//            OutputStream outputStream = new FileOutputStream(diskNameOutput + folderPathOutput + fileInput.getName());
//            //Writing the contents of the Output Stream to a file
//            outputStream.write(bytes);
//
//        }catch (IOException ex){
//            ex.printStackTrace();
//        }

//        InputStream input = null;
//        OutputStream output = null;
//        try {
//            input = servletInputStream;
//            output = new FileOutputStream(diskNameOutput + folderPathOutput + imgName);
//            byte[] buf = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = input.read(buf)) > 0) {
//                output.write(buf, 0, bytesRead);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                input.close();
//                output.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

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

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

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
