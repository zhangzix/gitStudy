package qrcode;

import com.utils.QRCodeUtil;

public class Test {
    public static void main(String[] args) throws Exception {
        /**
         * 生成二维码
         * 生成图片路径  src/二维码.png
         */
        String imgPath="src/二维码.png";
        String content="老王尼玛死了";
        String logoPath="src/logo.jpg";
        /**
         * 生成二维码
         * 加密:文字信息  ->二维码
         * 解密:二维码    ->文字信息
         */

        /*
            加密:文字信息  ->二维码
         */

        QRCodeUtil qrCodeUtil=new QRCodeUtil();
        qrCodeUtil.encoderQRCode(content,imgPath,"png",7,logoPath);
        /*
             解密:二维码    ->文字信息
         */
    }
}
