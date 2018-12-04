package linyy.hz.syhg501.art.word;

/**
 * 
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Hongten
 * @created Jul 23, 2014
 */
/**
 * @author Hongten
 * @created 2014-7-26
 */
public class ArtTextUtil {

    /**
     * Write the string to file.
     * @param stringBuffer
     */
    public static void write2File(StringBuffer stringBuffer) {
        File f = new File(ArtCommon.OUTPUT_TXT);
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(f));
            output.write(stringBuffer.toString());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
