package utils;

import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class TemplateMatching {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat source = null;
        Mat template = null;
        //Load image file
        source = Imgcodecs.imread(".//src/main/java/utils/image/signInScreenshot.png");
        template = Imgcodecs.imread(".//src/main/java/utils/pattern/textView.png");

        Mat outputImage = new Mat();
        int machMethod = Imgproc.TM_CCOEFF;
        //Template matching method
        Imgproc.matchTemplate(source, template, outputImage, machMethod);

        MinMaxLocResult mmr = Core.minMaxLoc(outputImage);
        Point matchLoc = mmr.maxLoc;
        //Draw rectangle on result image
        Imgproc.rectangle(source, matchLoc, new Point(matchLoc.x + template.cols(),
                matchLoc.y + template.rows()), new Scalar(255, 255, 255));

        Imgcodecs.imwrite(".//src/main/java/utils/image/result.png", source);
        System.out.println("Completed");
    }

}

