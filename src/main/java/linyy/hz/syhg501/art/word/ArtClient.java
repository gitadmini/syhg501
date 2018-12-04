package linyy.hz.syhg501.art.word;

/**
 * 
 */

import java.io.File;

/**
 * This project is a tool for processing the image. <br>Including TWO functions :
 * <li>Color image to converted black and white picture.
 * <li>Imitating the original image to paint into the TXT file with alphabets.
 * You can change the code according to your requirement.
 * 
 * @author Hongten
 * @mail hongtenzone@foxmail.com
 * @created Jul 23, 2014
 */
public class ArtClient {

    public static String SCALED_IMAGE = ArtCommon.SCALED + ArtCommon.FULL_STOP
            + ArtScaledImageUtil.getPostfix(ArtCommon.ORIGINAL);

    public static void main(String[] args) {
        colorImage2BWPic();
        painting(ArtCommon.ORIGINAL, SCALED_IMAGE, 1);
        // remoteImageHandler("E:/images/ipad/photo"); //NOTE: Provider your
        // folder path, which includ some pictures
    }

    /**
     * Continuously review images
     * @param remotePath Other folder path(Including pictures)
     */
    private static void remoteImageHandler(String remotePath) {
        File file = new File(remotePath);
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                String originalImagePath = fileList[i].getAbsolutePath();
                System.out.println("Processing ... " + originalImagePath);
                SCALED_IMAGE = ArtCommon.SCALED + ArtCommon.FULL_STOP
                        + ArtScaledImageUtil.getPostfix(originalImagePath);
                painting(originalImagePath, SCALED_IMAGE, 1);
            }
            try {
                Thread.sleep(4000); // every four seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void painting(String originalImagePath,
            String scalImagepath, int scaled) {
        ArtScaledImageUtil
            .scaledImage(originalImagePath, scaled, scalImagepath);
        double[][] result = ArtImageUtil.getImageGRB(scalImagepath);
        StringBuffer stringBuffer = ArtImageUtil.getCanvas(result);
        ArtTextUtil.write2File(stringBuffer);
    }

    /**
     * Color image to converted black and white picture.
     */
    private static void colorImage2BWPic() {
        File input = new File(ArtCommon.ORIGINAL_IMAGE);
        File out = new File(ArtCommon.PROCESSED_IMAGE);
        ArtImageUtil.colorImage2BlackAndWhitePicture(input, out);
    }
}
