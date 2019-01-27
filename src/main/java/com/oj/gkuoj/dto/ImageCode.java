package com.oj.gkuoj.dto;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author m969130721@163.com
 * @date 19-1-2 下午6:16
 */
public class ImageCode implements Serializable {

    private BufferedImage bufferedImage;

    private String code;

    private LocalDateTime expireTime;

    public ImageCode(String code,LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }


    public ImageCode(BufferedImage bufferedImage,String code,int time){
        this.bufferedImage = bufferedImage;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(time);
    }


    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "ImageCode{" +
                "bufferedImage=" + bufferedImage +
                ", code='" + code + '\'' +
                ", expireTime=" + expireTime +
                '}';
    }
}
