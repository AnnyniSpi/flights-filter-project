package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;
import java.util.List;


public class ArrivalBeforeDepartureFilter implements Filter {

    private final int id;

    public ArrivalBeforeDepartureFilter(int id) {
        this.id = id;
    }

        @Override
            public List<Flight> filter(List<Flight> flights) {
            flights.removeIf(flight -> flight.getSegments().stream()
                    .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()))
            );

            return flights;

        }

    public int getId() {
        return id;
    }
}
