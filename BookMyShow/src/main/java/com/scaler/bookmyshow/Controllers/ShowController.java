package com.scaler.bookmyshow.Controllers;

import com.scaler.bookmyshow.DTOS.CreateShowRequest;
import com.scaler.bookmyshow.Models.Show;
import com.scaler.bookmyshow.Services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ShowController {

    private ShowService showService;

    //Read API for show
    @GetMapping("/show/{id}")
    public Show readShow(@PathVariable Long id) {
        return showService.getShow(id);
    }

    //Create show API
    @PostMapping("/show")
    public Show createShow(@RequestBody CreateShowRequest request) {
        return showService.createShow(request);
    }
}
