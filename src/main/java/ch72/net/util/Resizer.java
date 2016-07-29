package ch72.net.util;

import java.io.File;
import java.nio.file.Paths;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;


/**
 * Created by asato on 2016/07/29.
 */
public class Resizer {

    public static void resize(String filepath) {
        IplImage source = cvLoadImage(filepath, CV_LOAD_IMAGE_ANYDEPTH | CV_LOAD_IMAGE_ANYCOLOR);
        System.out.println("path = " + filepath);
        System.out.println("image = " + source);

        File destDir = new File(Paths.get(filepath).getParent().getParent() + "/thumbnail/");
        if (!destDir.exists()) {
            destDir.mkdir();
        }


        if (source != null) {
            IplImage dest = cvCreateImage(cvSize(source.width() / 5, source.height() / 5), source.depth(), source.nChannels());
            cvResize(source, dest, CV_INTER_NN);
            cvSaveImage(destDir.toString() + "/" + Paths.get(filepath).getFileName().toString(), dest);
            cvReleaseImage(source);
            cvReleaseImage(dest);
        }
    }

}
