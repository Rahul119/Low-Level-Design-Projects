package com.scaler.bookmyshow.Strategies;

import com.scaler.bookmyshow.Models.Booking;
import com.scaler.bookmyshow.Models.Show;
import com.scaler.bookmyshow.Models.ShowSeat;

public interface PricingStrategy {
    Double calculatePrice(Booking booking);
}
