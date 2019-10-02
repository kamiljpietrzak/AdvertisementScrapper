package scrappers;


import dzialki.Dzialka;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import webConnections.ConnectionToUrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OlxPlDzialki extends DzialkaScrapper {
    public static void main(String[] args) throws IOException {


        List<Dzialka> dzialkiZnalezione = new ArrayList<Dzialka>();

        String url="https://www.olx.pl/nieruchomosci/dzialki/sprzedaz/gdynia/?search%5Bfilter_enum_type%5D%5B0%5D=dzialki-budowlane&search%5Bdist%5D=30&page=1";
        Document olx = ConnectionToUrl.connectToUrl(url);
        Elements ogloszenia = olx.select("div.offer-wrapper");

        for (Element ogloszenie: ogloszenia)
        {
            String cenaTxt = getText(ogloszenie, "div > table > tbody > tr:nth-child(1) > td.wwnormal.tright.td-price > div > p");
            double cena = getCena(cenaTxt, 4);
            String name = getText(ogloszenie, "div > table > tbody > tr:nth-child(1) > td.title-cell > div");
            String localization = getText(ogloszenie, "div > table > tbody > tr:nth-child(2) > td.bottom-cell > div > p > small:nth-child(1) > span");
            String link = getLink(ogloszenie, "div > table > tbody > tr:nth-child(1) > td.title-cell > div > h3 > a");

            Dzialka dzialka = new Dzialka.DzialkaBuilder()
                    .setPrice(cena)
                    .setName(name)
                    .setLocalization(localization)
                    .setLink(link).build();
            dzialkiZnalezione.add(dzialka);
        }
//        for (Dzialka ele: dzialkiZnalezione
//             ) {
//            System.out.println(ele.getName());
//        }
        List<Dzialka> dzialkiWszystkie = new ArrayList<Dzialka>(dzialkiZnalezione);
        }

}
