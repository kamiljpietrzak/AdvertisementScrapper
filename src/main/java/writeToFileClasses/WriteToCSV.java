package writeToFileClasses;

import dzialki.Dzialka;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class WriteToCSV implements WriteToFile {


    //European countries use ";" as
    //CSV separator because "," is their digit separator
    private static final String CSV_SEPARATOR = ",";

    @Override
    public void writeToFile(List<Dzialka> dzialkiWszystkie) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/dzialki.csv"), StandardCharsets.UTF_8));
            for (Dzialka dzialka : dzialkiWszystkie) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(dzialka.getName().trim().length() == 0 ? "" : dzialka.getName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(dzialka.getPrice() < 0 ? "" : dzialka.getPrice());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(dzialka.getLocalization().trim().length() == 0 ? "" : dzialka.getLocalization());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(dzialka.getLink().trim().length() == 0 ? "" : dzialka.getLink());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }


}
//
//                    .setPrice(cena)
//                            .setName(name)
//                            .setLocalization(localization)
//                            .setLink(link).build();