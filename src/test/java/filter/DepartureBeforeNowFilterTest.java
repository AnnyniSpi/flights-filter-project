package filter;

import com.gridnine.testing.filter.impl.DepartureBeforeNowFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartureBeforeNowFilterTest {

    @Test
    void testFilter() {
        DepartureBeforeNowFilter filter = new DepartureBeforeNowFilter(2);

        LocalDateTime now = LocalDateTime.now();

        Flight flight1 = createFlight(now.plusHours(2));
        Flight flight2 = createFlight(now.minusHours(1));
        Flight flight3 = createFlight(now.plusDays(1));

        List<Flight> flights = new ArrayList<>(List.of(flight1, flight2, flight3));

        List<Flight> flightsWithFilter = filter.filter(flights);

        assertEquals(2, flightsWithFilter.size());

    }

    private Flight createFlight(LocalDateTime departure){
        Segment segment = new Segment(departure, LocalDateTime.now());
        return new Flight(List.of(segment));
    }

}