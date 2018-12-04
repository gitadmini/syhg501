package linyy.hz.syhg501.art.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame {

    // 开发
    // public static void main(String args[]) {
    // GraphicsDemo myGraphicsFrame = new GraphicsDemo();
    // }

    // 导出
    public static void main(String args[]) {
        export();
    }

    private static void export() {
        ShapesPanel panel = new ShapesPanel();
        File f = new File("F:/111111linyy/art/paint/" + new Date().getTime()
                + ".png");
        Dimension imageSize = panel.getSize();
        BufferedImage image = new BufferedImage(imageSize.width,
            imageSize.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        panel.paint(g);
        g.dispose();
        try {
            ImageIO.write(image, "png", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("ok");
    }
}

class ShapesPanel extends JPanel {

    float width = 1366;

    float height = 768;

    float widPlusHei = 1366 + 768;

    int help1 = 0;

    int help2 = 0;

    int help3 = 0;

    float help4 = 0;

    float help5 = 0;

    float help6 = 0;

    ShapesPanel() {
        setBackground(Color.white);
        setSize((int) width, (int) height);
    }

    // 根据坐标计算对应点的颜色
    private Color getColor(int x, int y) {
        float xjoin = x / width;
        float yjoin = y / height;
        float r = x / width;
        float g = y / height;
        float b = y / height;
        float R = m1(r);
        float G = m2(g);
        float B = m3(b);
        return new Color(R, G, B);
    }

    // 一组方法，都是：入参0~1，出参0~1
    private float m1(float in) {
        return (float) Math.sin(in);
    }

    private float m2(float in) {
        return (float) Math.cos(in);
    }

    private float m3(float in) {
        return in * in;
    }

    private float m4(float in) {
        return 1 - in;
    }

    private float m5(float in) {
        return new Random().nextFloat();
    }

    private float m6(float in) {
        return (in + new Random().nextFloat()) / 2;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setPaintMode();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                g.setColor(getColor(i, j));
                g.drawLine(i, j, i, j);
            }
        }
    }
}

class GraphicsDemo extends JFrame {
    public GraphicsDemo() {
        this.getContentPane().add(new ShapesPanel());
        setTitle("基本绘图方法演示");
        setSize(300, 300);
        setVisible(true);
    }
}
