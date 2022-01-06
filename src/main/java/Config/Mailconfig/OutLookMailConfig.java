package Config.Mailconfig;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author vidhi chapanera
 * @date 27 July 2020
 */
public class OutLookMailConfig {

    public static String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\mailConfig.properties";

    /**
     * @throws Exception
     * @author vidhi chapanera
     * @date 27 July 2020
     * @implNote
     */
    public static void sendEmailUsingOutlookMail() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader(fileLocation));
        props.put(Constant.HOST, Constant.HOST_VALUE);
        props.put(Constant.AUTH, Constant.AUTH_VALUE);
        props.put(Constant.PORT, "587");
        props.put(Constant.SOC_PORT, "587");
        props.put(Constant.SSL_ENABLE, "true");

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Constant.USERNAME, Constant.PASSWORD);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Constant.EMAIL_TO_VIDHI));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(Constant.EMAIL_TO_VIDHI));
            message.setSubject(Constant.EMAIL_SUBJECT);

            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText(Constant.EMAIL_TEXT);

            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            File f = new File(System.getProperty("user.dir") + "\\report\\");
            File[] files = f.listFiles(File::isFile);
            long lastModifiedTime = Long.MIN_VALUE;
            File chosenFile = null;
            if (files != null) {
                for (File file : files) {
                    if (file.lastModified() > lastModifiedTime) {
                        chosenFile = file;
                        lastModifiedTime = file.lastModified();
                    }
                }
                System.out.println(chosenFile);
            }
            DataSource source = new FileDataSource(chosenFile);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(String.valueOf(chosenFile));
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("message sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


}
