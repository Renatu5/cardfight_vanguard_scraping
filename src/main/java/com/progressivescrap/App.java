package com.progressivescrap;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App {

    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o Link da wiki do produto:");
        final String url = sc.nextLine();
        final String baseURI = "https://cardfight.fandom.com/";
        // System.out.println(baseURI);
        try {
            Document document = Jsoup.connect(url).get();
            // list of cards
            Elements details = document.select("#mw-content-text > div > table.sortable tbody tr");

            details.remove(0);
            String boxPrefix = details.selectFirst("td:nth-child(1)").text().split("/")[0];
            // System.out.println(boxPrefix);
            Box box = new Box(boxPrefix, details.size());
            FileWriter fw = new FileWriter("out.txt");
            for (Element e : details) {
                if (!e.select("td:nth-child(1)").text().startsWith(boxPrefix))
                    break;
                else {
                    String code = e.select("td:nth-child(1)").text();
                    // System.out.println(e.select("a").attr("href"));
                    String source = baseURI + e.select("a").attr("href");
                    System.out.println(source);
                    String rarity = e.select("td:nth-child(6)").text();
                    Card card = getCardProperties(source, code, rarity);
                    box.addCard(card);
                    // System.out.println(box.getCardsById(code).getName());
                    fw.write(card.toString());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private Card getCardProperties(String source, String code, String rarity) {
        if (source.equals(null))
            return null;
        try {
            FileWriter fw = new FileWriter("teste.txt");
            Thread.sleep(1, 3);
            Document document = Jsoup.connect(source).get();

            // Testando pegar atributos de forma mais generica - @Renatu5
            System.out.println(document.select("[title*=grade]").get(1).text());
            System.out.println(document.select("[title*=skill]").text());

            fw.write((document.body().html()));
            // Elements properties = document.select("div.info-main > table > tbody");
            // String name = properties.select("tr:nth-child(1) > td:nth-child(2)").text();
            // String type = properties.select("tr:nth-child(5) > td:nth-child(2)").text();
            // String grade = properties.select("tr:nth-child(6) >
            // td:nth-child(2)").text().split("/")[0].trim();

            // System.out.println(properties.select("categories-top-more-4").text());

            // String skill = properties.select("tr:nth-child(6) >
            // td:nth-child(2)").text().split("/")[1].trim();
            // int power = Integer.parseInt(properties.select("tr:nth-child(7) >
            // td:nth-child(2)").text());
            // int critical = Integer.parseInt(properties.select("tr:nth-child(8) >
            // td:nth-child(2)").text());
            // String nation = properties.select("tr:nth-child(9) >
            // td:nth-child(2)").text();
            // String clan = properties.select("tr:nth-child(10) > td:nth-child(2)").text();
            // String race = properties.select("tr:nth-child(11) > td:nth-child(2)").text();
            // String format = properties.select("tr:nth-child(12) >
            // td:nth-child(2)").text();
            // String cardEffect = document.select("div.info-extra > table.effect > tbody >
            // tr:nth-child(2) > td").text();
            // Card card = new Card(
            // code, name, type, grade, skill, power, critical, nation, clan, race, format,
            // cardEffect,
            // source, rarity);
            // System.out.println(card.toString());
            // Card card = new Card(source, source, source, 0, source, 0, 0, source, source,
            // source, source, source,
            // source);
            // return card;
        } catch (Exception e) {
            System.err.println(e);

        }
        return null;
    }
}