package flipkart.rukmini.helpers;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Helper to execute the image resize process
 */
public class ImageResizeHelper {

    private static final Logger log = LoggerFactory.getLogger("ImageResizeHelper");

    public static File resize(final String inputImagePath, final int height, final int width) throws IOException, InterruptedException {
        File fTemp = new File(FileUtils.getTempDirectoryPath() +"/" + UUID.randomUUID().toString() +".jpeg");
        log.debug("Converting image to: " +fTemp.getAbsolutePath());
        ProcessBuilder builder = new ProcessBuilder()
                .command("resize-image", "-source", inputImagePath, "-dest",
                        fTemp.getAbsolutePath(), "-h",
                        String.valueOf(height), "-w",
                        String.valueOf(width), "-scaled")
                .directory(new File("/usr/bin"));
        log.debug("Convert command: " + StringUtils.join(builder.command(), ' '));
        Process process = builder.start();
        process.waitFor();
        log.debug("Converted file size: " + FileUtils.sizeOf(fTemp));
        FileUtils.deleteQuietly(new File(inputImagePath));
        return fTemp;
    }
}