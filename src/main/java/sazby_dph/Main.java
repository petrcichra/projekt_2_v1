package sazby_dph;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.json.JSONException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, JSONException{

        // 1 a 2) API a stazeni JSON souboru
        String mojeURL = "https://euvatrates.com/rates.json";
        Api mojeApi = new Api();
        String JSONtext = mojeApi.zavolejAPI(mojeURL);

        // 3) Naparsovat JSON soubor do objektu
        ObjectMapper objectMapper = new ObjectMapper();
        CountryWrap countryWrap = objectMapper.readValue(JSONtext, CountryWrap.class);

        // 4) Implementovat vyhledavaci logiku

        // 5) Vypsat hodnoty pomoci interaktivni prikazove radky
        System.out.println("Vítej v příkazové řádce. Vyber si ze dvou možností. " + '\n' +
                "První ti ukáže a uloží všechny země."  + '\n' +
                "Druhá ti na základě tvého vstupu ukáže a uloží konkrétní země." + '\n' +
                "Třetí ti ukaáže a uloží nejvyšší sazby." + '\n' +
                "Čtvrtá ti ukáže a uloží nejnižší sazby." + '\n'
        );
        System.out.print("Vyber možnost 1 až 4: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        int result = -1;
        try {
             result = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.err.println("Zadal si text a ne číslo: " + userInput);
        }

        if (result == 1 ) {
            System.out.println("Ukážu ti všechny země a jejich sazby:");
            countryWrap.najdiVsechnyZeme();
            countryWrap.exportDat("export.csv",";",countryWrap.vybraneZeme);
        } else if (result == 2) {
            System.out.print("Zadej zkratku/y země oddělené čárkou (například 'AT,GB,..'): ");
            String userInput2 = scanner.nextLine();
            countryWrap.najdiKonkretniZem(userInput2);
            countryWrap.exportDat("export.csv",";",countryWrap.vybraneZeme);
        } else if (result == 3) {
            System.out.println("Ukaži ti země s nejvyššími sazbami.");
            Map<String, Country> highest = countryWrap.find3Highest(countryWrap.getRates());
            countryWrap.exportDat("export.csv",";",highest);
            highest.forEach((s,zem) -> {
                System.out.println(zem.toString());
            });
        } else if (result == 4) {
            System.out.println("Ukažu ti země s nejnižšími sazbami");
            Map<String, Country> lowest = countryWrap.find3Lowest(countryWrap.getRates());
            countryWrap.exportDat("export.csv",";",lowest);
            lowest.forEach((s,zem) -> {
                System.out.println(zem.toString());
            });
        } else {
            System.out.println("Nevybral si žádnou možnost.");
        }

    }
}
