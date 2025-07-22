package com.progressivescrap;

import java.util.ArrayList;

public class Box {
    private String boxId;
    private int quantityCards;
    ArrayList<Card> cards;

    public Box(String boxId, int quantityCards) {
        this.boxId = boxId;
        this.quantityCards = quantityCards;
        this.cards = new ArrayList<Card>();
    }

    public String getBoxId() {
        return boxId;
    }

    // public void setBoxId(String boxId) {
    // this.boxId = boxId;
    // }

    public int getQuantityCards() {
        return quantityCards;
    }

    // public void setQuantityCards(int quantityCards) {
    // this.quantityCards = quantityCards;
    // }

    public Card getCardsById(String id) {
        if (id.equals(null))
            return null;
        for (Card c : cards) {
            if (c.getcardId().equals(id))
                return c;
        }
        return null;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Box {")
                .append("boxId='").append(boxId).append('\'')
                .append(", quantityCards=").append(quantityCards)
                .append(", cards=[");

        for (int i = 0; i < cards.size(); i++) {
            sb.append(cards.get(i));
            if (i < cards.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

}
