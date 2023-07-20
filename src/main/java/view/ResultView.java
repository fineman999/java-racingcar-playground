package view;

import domain.Car;
import domain.Cars;

public class ResultView {
    public static void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            printCar(car);
        }
        System.out.println();
    }

    private static void printCar(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName())
                .append(" : ");
        stringBuilder.append("-".repeat(Math.max(0, car.getPosition())));
        System.out.println(stringBuilder);
    }

    public static void printWinners(Cars winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners.getCars()) {
            stringBuilder.append(winner.getName())
                    .append(", ");
        }
        String result = stringBuilder.substring(0, stringBuilder.length() - 2);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
