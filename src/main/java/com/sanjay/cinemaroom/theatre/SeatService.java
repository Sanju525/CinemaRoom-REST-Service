package com.sanjay.cinemaroom.theatre;


import com.sanjay.cinemaroom.exceptions.BadRequestException;
import com.sanjay.cinemaroom.exceptions.UnauthorizedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SeatService {

    List<Token> tokens = new ArrayList<>();
    Stats stats = new Stats(0,0,81);

    private boolean seatNotExists(Seat o) {
        for (Token token: tokens) {
            if (token.getSeat().equals(o)){
                return false;
            }
        }
        return true;
    }

    // GET-Done
    public Object getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        int price = 10;
        for (int i = 1; i <= 9; i++) {
            if (i > 4) {
                price = 8;
            }
            for(int j = 1; j <= 9; j++) {
                Seat seat = new Seat(i, j, price);
                if (seatNotExists(seat)) {
                    availableSeats.add(seat);
                }
            }
        }
        return Map.of("total_rows",9,
                "total_columns", 9,
                "available_seats", availableSeats);
    }

    // POST-Done
    public Object purchaseSeat(Seat seat) {
        if (seat.getRow()<1||seat.getColumn()<1||seat.getRow()>9||seat.getColumn()>9) {
            // throw new Exception 400-BAD_REQUEST
            // The number of a row or a column is out of bounds!
            throw new BadRequestException("The number of a row or a column is out of bounds!");
//            return Map.of("error", "The number of a row or a column is out of bounds!");
        }
        String tokenId = UUID.randomUUID().toString();
        if (seat.getRow() > 4) {
            seat.setPrice(8);
        } else {
            seat.setPrice(10);
        }
        if (seatNotExists(seat)) {
            Token purchaseToken = new Token(tokenId, seat);
            tokens.add(purchaseToken);
            stats.setIncome(stats.getIncome() + seat.getPrice());
            stats.setAvailableSeats(stats.getAvailableSeats() - 1);
            stats.setPurchasedTickets(stats.getPurchasedTickets() + 1);
            return purchaseToken;
        } else{
            // throw new Exception 400-BAD_REQUEST
            // The ticket has been already purchased!
            throw new BadRequestException("The ticket has been already purchased!");
//            return Map.of("error", "The ticket has been already purchased!");
        }
    }

    // POST-Done
    public Object cancelTicket(String token) {
        int i=0;
        Seat removedToken = null;
        for (Token token1: tokens) {
            if (token1.getToken().equals(token)) {
                removedToken = tokens.remove(i).getSeat();
                break;
            }
            i++;
        }
        if (removedToken==null){
            // throw new Exception 401-BAD_REQUEST
            // Wrong token!
            throw new BadRequestException("Wrong token!");
//            return Map.of("error", "Wrong token!");
        } else {
            stats.setIncome(stats.getIncome() - removedToken.getPrice());
            stats.setPurchasedTickets(stats.getPurchasedTickets() - 1);
            stats.setAvailableSeats(stats.getAvailableSeats() + 1);
            return Map.of("return_ticket", removedToken);
        }
    }

    //POST
    public Object getStats(String password) {
        // throw new Exception 401-UNAUTHORIZED
        if (password==null) {
            // throw new Exception 401-UNAUTHORIZED
            // The password is wrong!
            throw new UnauthorizedException("The password is wrong!");
        } else {
            if (password.equals("super_secret")) {
                return stats;
            } else {
                // throw new Exception 401-UNAUTHORIZED
                // The password is wrong!
                throw new UnauthorizedException("The password is wrong!");
            }
        }
    }

}
