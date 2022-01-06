package Config.Mailconfig;

/**
 * @author Vidhi Chapanera
 * @date 3 July 2020
 */
public interface Constant {

    public static final String AUTH = "mail.smtp.auth";
    public static final String AUTH_VALUE="true";
    public static final String HOST = "mail.smtp.host";
    public static final String HOST_VALUE="email-smtp.us-west-1.amazonaws.com";
    public static final String SOC_PORT = "mail.smtp.socketFactory.port";
    public static final String PORT = "mail.smtp.port";
    public static final String PORT_VALUE="465";
    public static final String SSL_ENABLE = "mail.smtp.starttls.enable";
    public static final String ENABLE_VALUE="true";
    public static final String CLASS = "mail.smtp.socketFactory.class";
    public static final String CLASS_VALUE="javax.net.ssl.SSLSocketFactory";
    public static final String USERNAME = "AKIAR77WG2HIVSV5WXH3";
    public static final String PASSWORD = "BGFZsGgcHuus6xsQq7tWaMRDPCzZGV586UCTHnCfOx8m";
    public static final String EMAIL_TO_VIDHI = "vidhi@hikeup.com";
    public static final String EMAIL_SUBJECT = "[No-replay] Hike Automation Test Report";
    public static final String EMAIL_TEXT = "Hi Team,\n" +
            "\n" +
            "We Executed all the TestCase and please find the atteched execution report\n" +
            "\n" +
            "Thanks and Regards,\n" +
            "Vidhi";


}
