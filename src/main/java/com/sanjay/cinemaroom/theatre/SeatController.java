package com.sanjay.cinemaroom.theatre;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SeatController {

    @Autowired
    SeatService seatService;

    @RequestMapping("/seats")
    public Object getAvailableSeats() {
        return seatService.getAvailableSeats();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/purchase")
    public Object purchaseSeat(@RequestBody Seat purchaseSeat) {
        return seatService.purchaseSeat(purchaseSeat);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/return/")
    public Object returnTicket(@RequestParam(value = "token") String token) {
        return seatService.cancelTicket(token);
    }

    @RequestMapping("/stats/")
    public Object getStats(@RequestParam(value = "password", required = false) String password) {
        return seatService.getStats(password);
    }

}
