package com.sanjay.cinemaroom.theatre;

public class Stats {
    private int income;
    private int purchasedTickets;
    private int availableSeats;

    public Stats() {
    }

    public Stats(int income, int purchasedTickets, int availableSeats) {
        this.income = income;
        this.purchasedTickets = purchasedTickets;
        this.availableSeats = availableSeats;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(int purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
