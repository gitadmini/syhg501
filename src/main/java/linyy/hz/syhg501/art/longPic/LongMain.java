package linyy.hz.syhg501.art.longPic;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//把一个文件夹下的图片合并成为一张很长的图片
public class LongMain {

    public static void main(String[] args) throws IOException {
        JPanel jPanel = new JPanel();
        List<File> list = new ArrayList<File>();
        File files = new File("src/main/java/linyy/hz/syhg501/art/longPic/in"); // 文件夾
        File out = new File(
            "E:\\eclipse\\work\\syhg501\\src\\main\\java\\linyy\\hz\\syhg501\\art\\longPic\\out\\"
                    + new Date().getTime() + ".png");
        FileOutputStream fos = new FileOutputStream(out);
        int height = 0;
        int allHeight = 0, allWidth = 0;
        for (File file : files.listFiles()) {
            Image image = ImageIO.read(file);
            allHeight += image.getHeight(null);
            if (image.getWidth(null) > allWidth) {
                allWidth = image.getWidth(null);
            }
            list.add(file);
        }
        BufferedImage bufferedImage = new BufferedImage(allWidth, allHeight,
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bufferedImage.createGraphics();
        Collections.sort(list);
        for (File file : list) {
            Image image = ImageIO.read(file);
            g.drawImage(image, 0, height, null);
            height = height + image.getHeight(null);
        }
        jPanel.paint(g);
        g.dispose();
        try {
            ImageIO.write(bufferedImage, "png", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fos.close();
        System.out.println("ok");
    }
}
