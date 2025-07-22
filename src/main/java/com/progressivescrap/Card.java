package com.progressivescrap;

import java.util.ArrayList;

public class Card {
    private ArrayList<String> cardIds;
    private String name;
    private String type;
    private String grade;
    private String skill;
    private int power;
    private int critcal;
    private String nation;
    private String clan;
    private String race;
    private String format;
    private String cardEffect;
    private String source;
    private ArrayList<String> rarities;

    public Card(String cardId, String name, String type, String grade, String skill, int power, int critcal,
            String nation,
            String clan, String race, String format, String cardEffect, String source, String rarity) {
        this.cardIds = new ArrayList<>();
        this.cardIds.add(cardId);
        this.name = name;
        this.type = type;
        this.grade = grade;
        this.skill = skill;
        this.power = power;
        this.critcal = critcal;
        this.nation = nation;
        this.clan = clan;
        this.race = race;
        this.format = format;
        this.cardEffect = cardEffect;
        this.source = source;
        this.rarities = new ArrayList<>();
        rarities.add(rarity);
    }

    public String getcardId() {
        return cardIds.toString();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getGrade() {
        return grade;
    }

    public String getSkill() {
        return skill;
    }

    public int getPower() {
        return power;
    }

    public int getCritcal() {
        return critcal;
    }

    public String getNation() {
        return nation;
    }

    public String getClan() {
        return clan;
    }

    public String getRace() {
        return race;
    }

    public String getFormat() {
        return format;
    }

    public String getCardEffect() {
        return cardEffect;
    }

    public String getSource() {
        return source;
    }

    public void addCardId(String id) {
        cardIds.add(id);
    }

    public String getRarities() {
        return rarities.toString();
    }

    @Override
    public String toString() {
        return String.format(
                "Card {\n" +
                        "  cardId: %s,\n" +
                        "  name: '%s',\n" +
                        "  type: '%s',\n" +
                        "  grade: '%s',\n" +
                        "  skill: '%s',\n" +
                        "  power: %d,\n" +
                        "  critcal: %d,\n" +
                        "  nation: '%s',\n" +
                        "  clan: '%s',\n" +
                        "  race: '%s',\n" +
                        "  format: '%s',\n" +
                        "  cardEffect: '%s',\n" +
                        "  source: '%s'\n" +
                        "   Rarities: '%s'\n" +
                        "}",
                cardIds.toString(), name, type, grade, skill, power, critcal, nation, clan, race, format, cardEffect,
                source, rarities.toString());
    }

}
