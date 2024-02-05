package com.gridnine.testing.factory;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filter.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filter.impl.DepartureBeforeNowFilter;
import com.gridnine.testing.filter.impl.GroundTimeExceedsTwoHoursFilter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterBuilder {

    public static Set<Filter> createFiltersDynamic(List<Integer> params) {
        return params.stream()
                .map(FilterBuilder::createFilterById)
                .collect(Collectors.toSet());
    }

    private static Filter createFilterById(int id){

        return switch (id) {
            case 1 -> new ArrivalBeforeDepartureFilter(1);
            case 2 -> new DepartureBeforeNowFilter(2);
            case 3 -> new GroundTimeExceedsTwoHoursFilter(3);
            default -> throw new UnsupportedOperationException("Вы ввели неверный фильтр!");
        };

    }

}
