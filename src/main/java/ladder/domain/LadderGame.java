package ladder.domain;

import java.util.*;

public class LadderGame {
    private List<User> users;
    private List<LadderLine> lines;
    private Map<String, Integer> results = new HashMap<>();

    public LadderGame(List<User> gameContributors) {
        users = gameContributors;
    }

    public Map<String, Integer> start() {
        for (int i = 0; i < users.size(); i++) {
            results.put(users.get(i).getName(), getTarget(i));
        }
        return results;
    }

    private Integer getTarget(int position) {
        int target = position;
        for (LadderLine line : lines) {
            target = line.move(target);
        }
        return target;
    }

    public List<LadderLine> create(int height) {
        List<LadderLine> ladderLines = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            ladderLines.add(LadderLine.init(users.size()));
        }

        this.lines = ladderLines;
        return ladderLines;
    }

}
