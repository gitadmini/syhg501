package linyy.hz.syhg501.art.gif;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

public class GifMain {
    public static void main(String[] args) throws IOException {
        List<File> list = new ArrayList<File>();
        File files = new File("f:\\temp"); // 文件夾
        File out = new File(
            "f:\\temp\\"
                    + new Date().getTime() + ".gif");
        for (File file : files.listFiles()) {
            list.add(file);
        }
        Collections.sort(list);
//        Collections.reverse(list);
        FileOutputStream fos = new FileOutputStream(out);
        AnimatedGifEncoder e = new AnimatedGifEncoder();
//        e.setRepeat(1);
        e.start(fos);
        e.setDelay(50);
        for (File file : list) {
            BufferedImage src = ImageIO.read(file);
            e.addFrame(src);
        }
        e.finish();
        System.out.println("ok");
    }
}
