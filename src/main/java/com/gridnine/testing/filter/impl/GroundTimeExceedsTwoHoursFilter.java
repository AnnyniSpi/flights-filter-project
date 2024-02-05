package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GroundTimeExceedsTwoHoursFilter implements Filter {

    private final int id;

    public GroundTimeExceedsTwoHoursFilter(int id) {
        this.id = id;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        flights.removeIf(flight -> {
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrival = segments.get(i).getArrivalDate();
                LocalDateTime departure = segments.get(i + 1).getDepartureDate();
                Duration groundTime = Duration.between(arrival, departure);
                if (groundTime.toHours() > 2) {
                    return true;
                }
            }

            return false;
        });

        return flights;
    }

    public int getId() {
        return id;
    }
}
