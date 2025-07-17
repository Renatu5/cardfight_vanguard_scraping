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
        final String url = "https://cardfight.fandom.com/wiki/Booster_Set_11:_Seal_Dragons_Unleashed";
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
            int quantityCards = Integer.parseInt(teste[0]);
            int count = 0;
            for (Element e : details) {

                if (!e.select("td:nth-child(1)").text().startsWith("FC"))
                    break;
                else {
                    String code = e.select("td:nth-child(1)").text();
                    String name = e.select("td:nth-child(2)").text();
                    String grade = e.select("td:nth-child(3)").text();
                    String clan = e.select("td:nth-child(4)").text();
                    String type = e.select("td:nth-child(5)").text();
                    String rarity = e.select("td:nth-child(6)").text();
                    System.out.println(code + ": " + name + " - " + grade + " - " + clan + type +
                            " - " + rarity);
                }
                count++;
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