package filter;

import com.gridnine.testing.filter.impl.GroundTimeExceedsTwoHoursFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroundTimeExceedsTwoHoursFilterTest {

    @Test
    void testFilter() {
        GroundTimeExceedsTwoHoursFilter filter = new GroundTimeExceedsTwoHoursFilter(3);

        LocalDateTime now = LocalDateTime.now();

        Flight flight1 = createFlight(
                now,
                now.plusHours(1),
                now.plusHours(2),
                now.plusHours(4)
        );

        Flight flight2 = createFlight(
                now,
                now.plusHours(2),
                now.plusHours(4),
                now.plusHours(3)
        );

        Flight flight3 = createFlight(
                now,
                now.plusHours(1),
                now.plusHours(1),
                now.plusHours(1)
        );

        List<Flight> flights = new ArrayList<>(List.of(flight1, flight2, flight3));

        List<Flight> flightsWithFilter = filter.filter(flights);

        assertEquals(2, flightsWithFilter.size());

    }

    private Flight createFlight(LocalDateTime departure1, LocalDateTime arrival, LocalDateTime departure2, LocalDateTime arrival2){
        Segment segment1 = new Segment(departure1, arrival);
        Segment segment2 = new Segment(arrival2, departure2);
        return new Flight(List.of(segment1, segment2));
    }
}