package pl.allegro.tech.recruit.calc.data;

import pl.allegro.tech.recruit.calc.Developer;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class TestData1 {

    public static ZonedDateTime getMockDateOctober() {
        return ZonedDateTime.of(
                2020, 10, 12, 0, 0, 0, 0,
                ZoneId.of("UTC"));
    }

    public static ZonedDateTime getMockDateNotOctober() {
        return ZonedDateTime.of(
                2021, 2, 12, 0, 0, 0, 0,
                ZoneId.of("UTC"));
    }

    public static Developer getJohn() {
        return new Developer("John", emptyListDevelopers());
    }

    public static Developer getAnn() {
        return new Developer("Ann", emptyListDevelopers());
    }

    public static Developer getMike2() {
        return new Developer("Mike", listOfDevelopers2());
    }

    public static Developer getKate3() {
        return new Developer("Kate", listOfDevelopers3());
    }

    public static List<Developer> emptyListDevelopers() {
        return List.of();
    }

    public static List<Developer> listOfDevelopers3() {
        return List.of(getJohn(), getAnn(), getMike2());
    }

    public static List<Developer> listOfDevelopers2() {
        return List.of(getJohn(), getAnn());
    }
}