package sazby_dph;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CountryWrap {
    private String last_updated;
    private String disclaimer;
    private Map<String, Country> rates;

    List<Country> seznamZemi = new ArrayList<>();
    Map<String, Country> vybraneZeme = new HashMap<>();

    // 4)   Implementovat vyhledavaci logiku
    // 4.1) Najdi vsechny zeme
    public void najdiVsechnyZeme() {
        rates.forEach((map, country) -> {
            System.out.println(country.toString());
        });
        vybraneZeme = rates;
    }

    // 4.2) Najdi konkretni zemi na zaklade vstupu - podle zkratky
    public void najdiKonkretniZem(String zkratkaZeme) {
        List<String> vstupniList = new ArrayList<String>(Arrays.asList(zkratkaZeme.split(",")));
        rates.forEach((map, country) -> {
            for (int i = 0; i < vstupniList.size(); i++) {
                if (map.toString() == vstupniList.get(i).toUpperCase(Locale.ROOT).trim() || map.equals(vstupniList.get(i).toUpperCase().trim())) {
                    vybraneZeme.put(map, country);
                }
            }

        });
        vybraneZeme.forEach((map, zeme) -> {
            System.out.println(zeme.toString());
        });
    }

    // 6) zapis do souboru
    public void exportDat(String filename,String delimiter, Map<String, Country> vybraneZeme) {

        System.out.println("Chcete vybrané země uložit do souboru?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.toLowerCase(Locale.ROOT) == "ano" || input.toLowerCase(Locale.ROOT).equals("ano")) {
            try {
                PrintWriter writer = new PrintWriter(new FileWriter(filename));
                vybraneZeme.forEach((zkratka, zeme) -> {
                    writer.print(zeme.csvValues());
                });
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Rozhodl si se neuložit do data do souboru.");
        }
    }


    // Setter and Getter
    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Map<String, Country> getRates() {
        return rates;
    }

    public void setRates(Map<String, Country> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "CountryWrap{" +
                "last_updated='" + last_updated + '\'' +
                ", disclaimer='" + disclaimer + '\'' +
                ", rates=" + rates +
                '}';
    }

    public Map<String, Country> find3Lowest(Map<String, Country> vybraneZeme) {
        Map<String, Country> result = new HashMap<>();
        List<Country> values = new ArrayList<Country>(vybraneZeme.values());

        values.sort((a, b) -> ((int) (Float.parseFloat(a.getStandard_rate()) - Float.parseFloat(b.getStandard_rate()))));

        int count = Math.min(vybraneZeme.size(), 3);
        for (int i = 0; i < count; i++) {
            result.put(Integer.toString(i), values.get(i));
        }

        return result;
    }
    public Map<String, Country> find3Highest(Map<String, Country> vybraneZeme) {
        Map<String, Country> result = new HashMap<>();
        List<Country> values = new ArrayList<Country>(vybraneZeme.values());

        values.sort((a, b) -> ((int) (Float.parseFloat(b.getStandard_rate()) - Float.parseFloat(a.getStandard_rate()))));

        int count = Math.min(vybraneZeme.size(), 3);
        for (int i = 0; i < count; i++) {
            result.put(Integer.toString(i), values.get(i));
        }

        return result;
    }
}
