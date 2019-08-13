package com.ruSkidex.RestMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.mail.*;
import java.io.*;
import java.util.Properties;
import javax.mail.Message;



public class PasswordMail {

    public String passMail(String IMAP_AUTH_EMAIL,String IMAP_AUTH_PWD,String IMAP_Server,String IMAP_Port) throws MessagingException, IOException {
        String pass = null;
        Properties properties = new Properties();
        properties.put("mail.debug", "false");
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imap.ssl.enable", "true");
        properties.put("mail.imap.port", IMAP_Port);

        Authenticator auth = new EmailAuthenticator(IMAP_AUTH_EMAIL,
                IMAP_AUTH_PWD);
        Session session = Session.getDefaultInstance(properties, auth);
        session.setDebug(false);

        Store store = session.getStore();

        // Подключение к почтовому серверу
        store.connect(IMAP_Server, IMAP_AUTH_EMAIL, IMAP_AUTH_PWD);

        // Папка входящих сообщений
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);


        Message message[] = inbox.getMessages();
        int numMessage = message.length -1;
//        System.out.println(numMessage + ": " + message[numMessage].getFrom()[0] + "\t"
//                + message[numMessage].getSubject());
        String content = message[numMessage].getContent().toString();



        Document html = Jsoup.parse(content);
        Elements p = html.body().getElementsByTag("p");
        if (p.size()>0) {
             pass = p.get(1).text();
        }
        return pass;
    }
}
