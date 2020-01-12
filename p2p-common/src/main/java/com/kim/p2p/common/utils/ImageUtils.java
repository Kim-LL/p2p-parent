package com.kim.p2p.common.utils;


import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
public class ImageUtils {

    public static final String FORMAT_PNG = "png";
    public static final String FORMAT_JPG = "jpg";
    public static final String FORMAT_JPEG = "jpeg";
    public static final String FORMAT_GIF = "gif";

    public static byte[] imageToBytes(BufferedImage bufferedImage, String imageFormat){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, imageFormat, out);
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("imageToBytes", e);
        }
        return null;
    }
}
