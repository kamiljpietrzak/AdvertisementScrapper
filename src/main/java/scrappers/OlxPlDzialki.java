package scrappers;


import dzialki.Dzialka;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import webConnections.ConnectionToUrl;
import writeToFileClasses.WriteToCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OlxPlDzialki extends DzialkaScrapper {
    public static void main(String[] args) throws IOException, InterruptedException {


        List<Dzialka> dzialkiWszystkie = new ArrayList<>();
        List<Dzialka> dzialkiZnalezione = new ArrayList<>();

        final String url="https://www.olx.pl/nieruchomosci/dzialki/sprzedaz/gdynia/?search%5Bfilter_enum_type%5D%5B0%5D=dzialki-budowlane&search%5Bdist%5D=30&page=";
        final String lastPageNumberPath = "div:nth-child(3) > div > div.pager.rel.clr > span:nth-child > data.cy=\"page-link-last\"";
        Document olxToGetLastSiteNumber = ConnectionToUrl.connectToUrl(url + "1");
        String lastPageNumberText = olxToGetLastSiteNumber.select(lastPageNumberPath).last().text();
        System.out.println(lastPageNumberText);
//        int lastPageNumber = Integer.parseInt(lastPageNumberText);
        int lastPageNumber =9;
        for (int i = 1; i < lastPageNumber; i++) {
            Document olx = ConnectionToUrl.connectToUrl(url + i);
            Elements ogloszenia = olx.select("div.offer-wrapper");
            getDataFromOneSite(dzialkiZnalezione, ogloszenia);
            dzialkiWszystkie.addAll(dzialkiZnalezione);
            Thread.sleep(2000);
        }
        WriteToCSV csv = new WriteToCSV();
        csv.writeToFile(dzialkiWszystkie);
        }

    private static List<Dzialka> getDataFromOneSite(List<Dzialka> dzialkiZnalezione, Elements ogloszenia) {
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
        return dzialkiZnalezione;
    }


}
