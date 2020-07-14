package com.web.recruit.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Tracy
 * @date 2020/7/9 18:08
 */
@Component
@PropertySource(value = {"classpath:mail.properties"})
public class MailUtil {

    @Value("${mail.sender}")
    private String sender;

    @Value("${mail.receiver}")
    private String receiver;

    @Value("${mail.uploadPath}")
    private String uploadPath;

    //获取日期
    public String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
