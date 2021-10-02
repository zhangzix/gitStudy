package com.utils;

import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

public class QRCodeUtil {

//    加密:文字信息  ->二维码

    /**
     *
     * @param content   文字信息
     * @param imgPath   生成图片路径
     * @param imgType   生成图片类型
     * @param size      大小
     * @throws Exception
     */
    public void encoderQRCode(String content,String imgPath,String imgType,int size,String logoPath)throws Exception{

        //用BufferedImage替代接口RenderedImage
        //BufferedImage:代表内存中的图片
        BufferedImage bufImg=qRCodeCommon(content,imgType,size,logoPath);
        File file =new File(imgPath);
        //生成图片 API
        ImageIO.write(bufImg,imgType,file);

    }

    /**
     *
     * @param content   二维码中 隐藏中的信息
     * @param imgType   二维码类型
     * @param size      二维码边长
     * @return
     */
    public BufferedImage qRCodeCommon(String content,String imgType,int size,String logoPath)throws Exception{
        int imgSize=67+12*(size-1);
        BufferedImage bufImg=null;
        //采用RGB作为基础颜色BufferedImage.TYPE_INT_RGB
        bufImg=new BufferedImage(imgSize,imgSize,BufferedImage.TYPE_INT_RGB);
        //产生一个面板
        Graphics2D gs = bufImg.createGraphics();
        gs.setBackground(Color.white);//背景色白色
        gs.clearRect(0,0,imgSize,imgSize);//初始化
        gs.setColor(Color.BLACK);//设置画板上图像的颜色 （二维码颜色）

        /*
            把字符串变为二维数组
            QRCode对象:字符串->boolean[][]
         */
        Qrcode qrcode = new Qrcode();
        //设置二维码的排错率:7% L<Q<M<H 30% :排错率越高，可存储的信息越少；但是对二维码清晰度要求越小
        qrcode.setQrcodeErrorCorrect('M');
        //可存放的信息类型: N:数字、 A:数字+(A-Z) 、B:所有董支持
        qrcode.setQrcodeEncodeMode('B');
        //尺寸:取值范围:1-40
        qrcode.setQrcodeVersion(size);
        byte[] contentBytes = content.getBytes();
        //  byte[]-->boolean[][]
        boolean[][] codeOut = qrcode.calQrcode(contentBytes);

        int pixoff=2;//定义偏移量

        for(int i=0;i<codeOut.length;i++){
            for (int j = 0; j < codeOut.length; j++) {
                if (codeOut[j][i]){
                    gs.fillRect(j*3+pixoff,i*3+pixoff,3,3);
                }
            }
        }

        //增加logo
        Image logoImage=ImageIO.read(new File(logoPath));
        int MaxHeight = bufImg.getHeight();
        int MaxWidth = bufImg.getWidth();
        //在已经生成好的二维码上画logo
        gs.drawImage(logoImage,imgSize/5*2,imgSize/5*2,MaxWidth/5*125/100,MaxHeight/5*125/100,null);

        gs.dispose();//释放空间
        bufImg.flush();
        return bufImg;
    }





//    解密:二维码    ->文字信息

}
