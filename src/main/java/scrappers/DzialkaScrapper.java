package scrappers;


import dzialki.Dzialka;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;


public abstract class DzialkaScrapper {



    public static String getText(Element ogloszenie, String s) {
        return ogloszenie.select(s).text();
    }
    public static String getLink(Element ogloszenie,String path) {
        return ogloszenie.select(path).attr("href");
    }

    public static double getCena(String cenaTxt, int howManyCharsToCut) {
        cenaTxt = cenaTxt.substring(0, cenaTxt.length()-howManyCharsToCut).replace(" ", "");
        return Double.parseDouble(cenaTxt);
    }

    public List<Dzialka> fetchDzialki (String url){

        List<Dzialka> znalezioneDzialki = new ArrayList<Dzialka>();

        return znalezioneDzialki;
    }
    public List <Dzialka> dzialkiZnalezione = new ArrayList<Dzialka>();

}