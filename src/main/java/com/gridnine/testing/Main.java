package com.gridnine.testing;

import com.gridnine.testing.factory.FilterBuilder;
import com.gridnine.testing.factory.FlightBuilder;
import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>(FlightBuilder.createFlights());
        List<Integer> ids = new ArrayList<>();

        System.out.println("Таблица рейсов: " + flights);

        printMenu();

        try (Scanner scanner = new Scanner(System.in)) {
            String choice = "";

            while (true){
                choice = scanner.nextLine();

                if (choice.equals("exit")){
                    break;
                }

                ids.add(parseInt(choice));
            }
        }

        Set<Filter> filters = FilterBuilder.createFiltersDynamic(ids);

        filters.forEach(filter -> filter.filter(flights));

        System.out.println(flights);

    }

    private static void printMenu() {
        System.out.println("Введите номер фильтрации рейсов: ");
        System.out.println("1. Дата прилёта раньше даты вылета.");
        System.out.println("2. Вылет до текущего момента времени.");
        System.out.println("3. Общее время, проведённое на земле превышает два часа.");
        System.out.println("4. Введите exit для завершения операции.");
    }
}