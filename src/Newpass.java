import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Newpass {
    Scanner scanner;
    public Newpass() {
        scanner = new Scanner(System.in);
    }
    public void addNewpass() {
        System.out.println("\n----------Új jelszó:---------------");
        System.out.println("Használat:");
        String using = this.scanner.nextLine();
        System.out.println("Jelszó:");
        String pass = this.scanner.nextLine();
        System.out.println("Folytatáshoz nyomjon egy Entert........");
        appendToFile(using, pass);
    }
    private void appendToFile(String using, String pass) {
        try {
            tryAppendToFile(using, pass);
        } catch (Exception e) {
            System.out.println("Hiba! A fáljba írás sikertelen!");
        }
    }
    private void tryAppendToFile(String using, String pass) throws IOException{
        String key = this.getAppkey();
        System.out.println(key);
        String cryptText = getCryptedText(pass, key);
        System.out.println(cryptText);
        FileWriter fileWriter = new FileWriter("data.txt",
        Charset.forName("utf-8"),
        true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String line = using + ":" + cryptText;
        printWriter.println(line);
        printWriter.close();
    }
    private String getAppkey() {
        Proper proper = new Proper();
        String appkey = proper .readProper("AppKey");
        return appkey;
    }
    
    private String getCryptedText( String plainText, String key){
        Crypto crypto = new Crypto();
        System.out.println(plainText+key);
        String cryptText = crypto.encrypt(plainText, key);
        System.out.println(cryptText);
        return cryptText;
    }
}
