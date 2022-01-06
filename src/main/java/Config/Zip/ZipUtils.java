package Config.Zip;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * @author Vidhi Chapanera
 * @date 10 August 2021
 */
public class ZipUtils {

    static List<String> filesListInDir = new ArrayList<String>();


    /**
     * @author Vidhi Chapanera
     * @date 10 August 2021
     * @exception Exception
     * @throws
     * @return
     */
    public static void zipDirectory(File dir, String zipDirName) {
        try {
            populateFilesList(dir);
            FileOutputStream fos = new FileOutputStream(zipDirName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            for(String filePath : filesListInDir){
                System.out.println("Zipping "+filePath);
                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
                zos.putNextEntry(ze);
                FileInputStream fis = new FileInputStream(filePath);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method populates all the files in a directory to a List
     * @param dir
     * @throws IOException
     * @author Vidhi Chapanera
     * @date 10 August 2021
     */
    public static void populateFilesList(File dir) throws IOException {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
            else populateFilesList(file);
        }
    }


    /**
     * @throws IOException
     * @author Vidhi Chapanera
     * @date 10 August 2021
     */
    public static void zipDir(){
        SimpleDateFormat df = new SimpleDateFormat("dd_MMMM_yyyy_hh_mm_ss_a");
        String strDate = df.format(new Date());
        File dir = new File(System.getProperty("user.dir")+"\\allure-results");
        String zipDirName = System.getProperty("user.dir")+"\\a-zip\\allure-results"+strDate+".zip";
        zipDirectory(dir, zipDirName);
    }
}
