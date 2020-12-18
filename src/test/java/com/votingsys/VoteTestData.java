package com.votingsys;

import com.votingsys.model.Restaurant;
import com.votingsys.model.Role;
import com.votingsys.model.User;
import com.votingsys.model.Vote;
import java.time.LocalDateTime;
import static com.votingsys.model.AbstractBaseEntity.START_SEQ;

/**
 * User: Vitaliy Klimov
 * Date: 30.11.2020
 */
public class VoteTestData {
    public static final TestMatcher<Vote> VOTE_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Vote.class, "user", "restaurant");

    public static final int VOTE1_ID = START_SEQ + 4;
    public static final int VOTE2_ID = START_SEQ + 5;
    public static final int USER_ID = START_SEQ;
    public static final int RESTAURANT_ID = START_SEQ + 3;

    public static final User user = new User(USER_ID, "User", "user@yandex.ru", "password", Role.USER);
    public static final Restaurant ocean = new Restaurant(RESTAURANT_ID, "Океан");

    public static final Vote vote1 = new Vote(VOTE1_ID, LocalDateTime.of(2020,01,30,10,00));
    public static final Vote vote2 = new Vote(VOTE2_ID, LocalDateTime.of(2020,11,30,23,00));

    public static Vote getNew(){ return new Vote(VOTE1_ID, LocalDateTime.of(2020,02,20,11,20));}
    public static Vote getToday() {return new Vote(VOTE1_ID,LocalDateTime.now());}
}
