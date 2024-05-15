package pl.allegro.tech.recruit.calc;

import java.time.Month;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public class DeveloperReputationCalculator {

    private static final int FOLLOWERS_MULTIPLIER = 2;
    private static final int HACKTOBER_BONUS = 10;

    private TimeUtil timeUtil = new TimeUtil();

    public DeveloperReputationCalculator(TimeUtil timeUtil) {
        this.timeUtil = timeUtil;
    }

    public DeveloperReputationCalculator() {
    }

    public int calculate(Developer dev) {
        final int followersScore = Optional.ofNullable(dev.getFollowers())
                .map(List::size)
                .map(cnt -> cnt * FOLLOWERS_MULTIPLIER)
                .orElse(0);

        final ZonedDateTime now = timeUtil.getZonedDateTime();
        final boolean duringHacktober = now.getMonth() == Month.OCTOBER;

        if (duringHacktober) {
            return followersScore + HACKTOBER_BONUS;
        } else {
            return followersScore;
        }
    }
}
