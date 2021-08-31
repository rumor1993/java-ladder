package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {
    private static final int MIN_LADDER_HIGH = 1;

    private List<Line> lines;

    public Ladder(String high, int numberOfUser, LadderStrategy ladderStrategy) {
        isBlank(high);
        isOverMinHigh(high);

        generateLine(getParseInt(high), numberOfUser, ladderStrategy);
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    private int getParseInt(String high) {
        return Integer.parseInt(high.trim());
    }

    private void isBlank(String high) {
        if (high == null || high.trim().isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다. 다시 입력해주세요");
        }
    }

    private void isOverMinHigh(String high) {
        if (getParseInt(high) < MIN_LADDER_HIGH) {
            throw new IllegalArgumentException("최소" + MIN_LADDER_HIGH + "이상 입력해주세요");
        }
    }

    private void generateLine(int ladderHigh, int numberOfUser, LadderStrategy ladderStrategy) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < ladderHigh; i++) {
            lines.add(new Line(numberOfUser, ladderStrategy));
        }
    }

    public List<List<Boolean>> getLadder() {
        return lines.stream()
                        .map(Line::getLine)
                        .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}