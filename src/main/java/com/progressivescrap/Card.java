package com.progressivescrap;

public class Card {
    ;
    private String cardId;
    private String name;
    private String type;
    private int grade;
    private String skill;
    private int power;
    private int critcal;
    private String nation;
    private String clan;
    private String race;
    private String format;
    private String cardEffect;

    public Card(String cardId, String name, String type, int grade, String skill, int power, int critcal, String nation,
            String clan, String race, String format, String cardEffect) {
        this.cardId = cardId;
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
    }

    public String getcardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getGrade() {
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

}
