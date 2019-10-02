package webConnections;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;

public class ConnectionToUrl {

    //Brak potrzeby tworzenia nowy obiektów w pętli, wystarczy podmieniać url przez setter
    public ConnectionToUrl() {
    }

    public static Document connectToUrl(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        System.out.println("Połączenie ze stroną: " + url);
        return doc;
    }
}
