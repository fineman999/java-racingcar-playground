import domain.RacingGame;
import domain.port.RandomGenerator;
import util.RandomGeneratorImpl;
import view.InputView;
import view.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        RandomGenerator randomGenerator = new RandomGeneratorImpl();


        String carNames = InputView.getCarNames();
        int count = InputView.getCount();

        RacingGame racingGame = RacingGame.create(carNames, count);

        InputView.printResult();
        while (!racingGame.isEnd()) {

            racingGame.race(randomGenerator);
            ResultView.printCars(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.getWinners());

    }
}
