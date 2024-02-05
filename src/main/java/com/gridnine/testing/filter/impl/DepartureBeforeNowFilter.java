package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;
import java.time.LocalDateTime;
import java.util.List;

public class DepartureBeforeNowFilter implements Filter {

    private final int id;

    public DepartureBeforeNowFilter(int id) {
        this.id = id;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        flights.removeIf(flight -> flight.getSegments().stream()
                .anyMatch(segment -> segment.getDepartureDate().isBefore(now)));
        return flights;
    }

    public int getId() {
        return id;
    }
}
