package filter;

import com.gridnine.testing.filter.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrivalBeforeDepartureFilterTest {

    @Test
    void testFilter() {
        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter(1);

        Flight flight1 = createFlight(LocalDateTime.now().plusHours(2), LocalDateTime.now());
        Flight flight2 = createFlight(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4));
        Flight flight3 = createFlight(LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(6));

        List<Flight> flights = new ArrayList<>(List.of(flight1, flight2, flight3));

        List<Flight> flightsWithFilter = filter.filter(flights);

        assertEquals(2, flightsWithFilter.size());
    }


    private Flight createFlight(LocalDateTime departure, LocalDateTime arrival){
        Segment segment = new Segment(departure, arrival);
        return new Flight(List.of(segment));
    }

}