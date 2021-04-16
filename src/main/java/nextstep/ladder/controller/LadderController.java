package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.strategy.RandomDirectionStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Players players = new Players(inputView.players());
        Prizes prizes = new Prizes(players.countOfPlayer(), inputView.prizes());
        LadderHeight ladderHeight = new LadderHeight(inputView.height());
        Ladder ladder = new Ladder(players.countOfPlayer(), ladderHeight, new RandomDirectionStrategy());
        printLadderResult(players, prizes, ladder);

        MatchedResult matchedResult = ladder.map(players.names(), prizes.names());
        resultView.printmappedResult(matchedResult, inputView.targetPlayer());
    }

    private void printLadderResult(Players players, Prizes prizes, Ladder ladder) {
        resultView.printResultPhrase();
        resultView.printNames(players.names());
        resultView.printLadder(ladder.linesConnection());
        resultView.printNames(prizes.names());
    }
}