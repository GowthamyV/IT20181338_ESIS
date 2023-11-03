package com.njoyfashion.util;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;
import java.util.Scanner;

@Slf4j
@Data
@Component
public class FTPFileUploadUtil {
//    @Value("${ftp.host}")
//    private String host;
//
//    @Value("${ftp.port}")
//    private String port;
//
//    @Value("${ftp.user}")
//    private String user;
//
//    @Value("${ftp.password}")
//    private String password;
//
//    @Value("${ftp.privateKey}")
//    private String privateKey;
//
//    @Value("${ftp.privateKeyPem}")
//    private String privateKeyPem;

    private JSch jsch;

    private Session session;

    private Channel channel;

    private ChannelSftp sftpChannel;

    @Autowired
    ResourceLoader resourceLoader;

//    public void openConnection() {
//
//        log.info("FTPFileUploadUtil.openConnection() invoked. Host - [{}], user - [{}] ", host, user);
//        try {
//            ClassLoader classLoader = getClass().getClassLoader();
//            InputStream inputStream = classLoader.getResourceAsStream("Keys1/Ionos_prod.pem");
//            File file = File.createTempFile("privateKey.tmp", null);
//            try (OutputStream outputStream = new FileOutputStream(file)) {
//                IOUtils.copy(inputStream, outputStream);
//            } catch (FileNotFoundException e) {
//                log.error("Error occured: file not found");
//            } catch (IOException e) {
//                log.error("Error occured: I/O exception");
//            }
//
//            String passwordKey = readPassword();
//            jsch = new JSch();
//            session = jsch.getSession("root", "10.13.144.190", 22);
//            session.setConfig("StrictHostKeyChecking", "no");
//            session.setPassword(passwordKey);
//            jsch.addIdentity(file.getAbsolutePath(), passwordKey);
//            session.connect();
//            log.info("ftp password {}", passwordKey);
//            channel = session.openChannel("sftp");
//            channel.connect();
//            sftpChannel = (ChannelSftp) channel;
//
//            log.info("FTPFileUploadUtil.openConnection() Host - [{}] new connection succeeded from user - [{}] ", host,
//                    user);
//            file.delete();
//        } catch (Exception e) {
//            log.error("Exception occured FTP connection", e);
//        }
//    }

    public static void main (String[] args){
        FTPFileUploadUtil ftpFileUploadUtil = new FTPFileUploadUtil();
//        ftpFileUploadUtil.openConnection();
    }

    /**
     * Close FTP connection
     */
//    public void closeConnection() {
//        log.info("FTPFileUploadUtil.closeConnection() invoked. Host - [{}], user - [{}] ", host, user);
//        sftpChannel.disconnect();
//        channel.disconnect();
//        session.disconnect();
//        log.info("FTPFileUploadUtil.closeConnection() Host - [{}] connection colsed from user - [{}] ", host, user);
//    }


    /**
     * upload base 64 file
     *
     * @param remotePath
     * @param filename
     * @param base64file
     * @return Boolean
     */
    public Boolean uploadBase64File(String remotePath, String filename, String base64file) {
//        log.info("FTPFileUploadUtil.uploadBase64File() invoked. for host - [{}], by user - [{}] ", host, user);
        boolean result = false;
//        openConnection();
        try {

            byte[] decodedBytes = Base64.getDecoder().decode(base64file.substring(base64file.indexOf(",") + 1));
            log.info("paramers {}", remotePath, decodedBytes, filename);
            // sftpChannel.cd(remotePath);
            try {
                log.info("paramers with stat {}", remotePath );
                sftpChannel.stat(remotePath );
                log.info("paramers with stat end {}", remotePath );
            } catch (Exception e) {
                log.info("paramers with mkdir {}", remotePath );
                sftpChannel.mkdir(remotePath );
//				sftpChannel.mkdir("./opt/amlidentityupload/");
//				sftpChannel.mkdir("." + remotePath + ApplicationConstants.SUFFIX);
            }
            InputStream inputStream = new ByteArrayInputStream(decodedBytes);
            log.info("paramers input {}", remotePath, inputStream, filename);
            sftpChannel.put(inputStream, remotePath + filename);
//            log.info("FTPFileUploadUtil.upload(). File - [{}] succeeded for host - [{}] by user - [{}] ", filename,
//                    host, user);
            result = true;
        } catch (Exception e) {
            log.error("Exception occured", e);
            result = false;
        }
        return result;
    }

    public String readPassword() {
        Scanner scan = null;
        String passPhrase = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("Keys1/password_prod.txt");
            File file = File.createTempFile("password.tmp", null);
            try (OutputStream outputStream = new FileOutputStream(file)) {
                IOUtils.copy(inputStream, outputStream);
            } catch (FileNotFoundException e) {
                log.error("Error occured: file not found");
            } catch (IOException e) {
                log.error("Error occured: I/O exception");
            }
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                passPhrase = scan.nextLine();
            }
            file.delete();
        } catch (Exception e) {
            log.error("Exception :", e);
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return passPhrase;
    }
}
