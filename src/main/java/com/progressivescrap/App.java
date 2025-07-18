package com.progressivescrap;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o Link da wiki do produto:");
        final String url = sc.nextLine();
        final String baseURI = url.split("/", 2)[0];
        System.out.println(baseURI);
        try {
            Document document = Jsoup.connect(url).get();
            // list of cards
            Elements details = document.select("#mw-content-text > div > table.sortable tbody tr");
            // number of cards
            Element content = document.selectFirst("#mw-content-text > div > ul > li:nth-child(1)");

            // #mw-content-text > div > table.sortable.jquery-tablesorter > tbody
            // #mw-content-text > div > table.sortable.jquery-tablesorter > tbody
            // #mw-content-text > div > table.sortable.jquery-tablesorter > tbody >
            // tr:nth-child(1)

            String[] teste = content.text().split("");
            // System.out.println(content.text());
            // System.out.println(details.text());
            System.out.println(details.first());
            details.remove(0);
            String[] boxPrefix = details.selectFirst("td:nth-child(1)").text().split("/");
            System.out.println(boxPrefix[0]);
            Box box = new Box(boxPrefix[0], details.size());
            for (Element e : details) {
                if (!e.select("td:nth-child(1)").text().startsWith(boxPrefix[0]))
                    break;
                else {
                    String code = e.select("td:nth-child(1)").text();
                    String name = e.select("td:nth-child(2)").text();
                    System.out.println(e.select("td:nth-child(2)"));
                    String grade = e.select("td:nth-child(3)").text();
                    String clan = e.select("td:nth-child(4)").text();
                    String type = e.select("td:nth-child(5)").text();
                    String rarity = e.select("td:nth-child(6)").text();
                    Card card = new Card(
                            code, name, type, Integer.parseInt(grade), rarity, 0, 0, rarity, rarity,
                            rarity, rarity, rarity);
                    box.addCard(card);
                    System.out.println(box.getCardsById(code).getName());
                }
            }
            // int count = 0;
            // String code = "", name = "", grade = "", clan = "", type = "", rarity = "";
            // for (Element e : details) {
            // if (count == 0)
            // code = e.text();
            // if (count == 1)
            // name = e.text();
            // if (count == 2)
            // grade = e.text();
            // if (count == 3)
            // clan = e.text();
            // if (count == 4)
            // type = e.text();
            // if (count == 5)
            // rarity = e.text();
            // count++;
            // if (count >= 6)
            // break;
            // }
            // System.out.println("code: " + code + "\n" +
            // "nome: " + name + "\n" +
            // "grade: " + grade + "\n" +
            // "clan: " + clan + "\n" +
            // "type: " + type + "\n" +
            // "Rarity " + rarity + "\n");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}