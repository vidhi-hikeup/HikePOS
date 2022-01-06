package Config.ScreenRecorder;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import static org.monte.media.VideoFormatKeys.*;

/**
 * @author vidhi chapanera
 * @date 12 January 2021
 */
public class ScreenRecorderUtil extends ScreenRecorder{

    public static ScreenRecorder screenRecorder;
    public String name;
    public ScreenRecorderUtil(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                              Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }


    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     * @param fileFormat
     * @return
     */
    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if(!movieFolder.exists()) {
            movieFolder.mkdirs();
        }else if(!movieFolder.isDirectory()) {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }
        return new File(movieFolder,
                name + "." + Registry.getInstance().getExtension(fileFormat));

    }


    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     * @param methodName
     */
    public static void startRecord(String methodName) throws Exception {
        File file = new File(System.getProperty("user.dir") + "\\script-recording\\");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0, 0, width, height);

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();
        screenRecorder = new ScreenRecorderUtil(gc, captureSize,
                new Format(FormatKeys.MediaTypeKey, MediaType.FILE, FormatKeys.MimeTypeKey, FormatKeys.MIME_AVI),
                new Format(FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FormatKeys.FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, FormatKeys.KeyFrameIntervalKey, 15 * 60),
                new Format(FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, "black", FormatKeys.FrameRateKey, Rational.valueOf(30)),
                null, file, methodName);
        screenRecorder.start();
    }


    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     */
    public static void stopRecord() throws Exception
    {
        screenRecorder.stop();
    }


    /**
     * @author vidhi chapanera
     * @date 24 November 2021
     */
    public static void clean_Directory() throws Exception
    {
        FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + "\\script-recording"));
    }


}

