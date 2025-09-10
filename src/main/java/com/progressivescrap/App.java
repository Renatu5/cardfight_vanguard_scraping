package com.progressivescrap;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Scraping of wiki fandom of cardgame Cardfight Vanguard
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
                    if (card == null)
                        return;
                    box.addCard(card);
                    // System.out.println(box.getCardsById(code).getName());
                    fw.write(card.toString());
                    // break;
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
            Thread.sleep(2000, 5000);
            Document document = Jsoup.connect(source).get();
            // Testando pegar atributos de forma mais generica - @Renatu5
            // System.out.println(document.select("[title*=grade]"));
            // System.out.println(document.select("[title~=Drive|Skill]").text());

            fw.write((document.body().html()));
            Elements properties = document.select("div.info-main > table > tbody");
            System.out.println(properties.size());
            // System.out.println(properties.select("tr").dataNodes());
            // System.out.println(properties.select("[title~=Drive|Skill]"));
            // System.out.println(document.select("title*=name"));
            // System.out.println(properties);
            String name = properties.select("td:containsOwn(name) + td").text();
            if (name.equals("Energy"))
                return null;
            // System.out.println(name);
            String type = properties.select("td:containsOwn(Card Type) + td").text();
            // System.out.println(type);
            String[] gradeSkill = document.selectFirst("td:containsOwn(grade) + td").text().split("/");
            String grade = gradeSkill[0].trim();
            System.out.println(grade);
            String skill = gradeSkill.length > 1 ? gradeSkill[1].trim():"";
            System.out.println(skill);
            Element powerElement = document.selectFirst("td:containsOwn(Power) + td");
            int power = 0;
            if (powerElement != null) {
                power = Integer.parseInt(powerElement.text().replaceAll("\\D", ""));
            }

            Element criticalElement = document.selectFirst("td:containsOwn(Critical) + td");
            int critical = 0;
            if (criticalElement != null) {
                critical = Integer.parseInt(criticalElement.text().replaceAll("\\D", ""));
            }
            // System.out.println(critical);
            String nation = properties.select("td:containsOwn(Nation) + td").text();
            // System.out.println(nation);
            String clan = properties.select("td:containsOwn(Clan) + td").text();
            // System.out.println(clan);
            String race = properties.select("td:containsOwn(Race) + td").text();
            // System.out.println(race);
            String format = properties.select("td:containsOwn(format) + td").text();
            // System.out.println(format);
            String cardEffect = document.select("div.info-extra > table.effect > tbody > tr:nth-child(2) > td").text();
            // System.out.println(cardEffect);
            Card card = new Card(code, name, type, grade, skill, power, critical, nation, clan,
                    race, format, cardEffect,
                    source, rarity);
            System.out.println(card.toString());
            return card;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
}
// //*[@id="mw-content-text"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]
// skill
// drive