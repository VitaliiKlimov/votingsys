package com.votingsys.web;

import com.votingsys.DishTestData;
import com.votingsys.RestaurantTestData;
import com.votingsys.UserTestData;
import com.votingsys.VoteTestData;
import com.votingsys.model.Restaurant;
import com.votingsys.model.Vote;
import com.votingsys.repository.DataJpaDishRepository;
import com.votingsys.repository.DataJpaRestaurantRepository;
import com.votingsys.repository.DataJpaVoteRepository;
import com.votingsys.web.json.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static com.votingsys.DishTestData.*;
import static com.votingsys.RestaurantTestData.*;
import static com.votingsys.TestUtil.readFromJson;
import static com.votingsys.TestUtil.userAuth;
import static com.votingsys.VoteTestData.RESTAURANT_ID;
import static com.votingsys.VoteTestData.VOTE_MATCHER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * User: Vitaliy Klimov
 * Date: 09.12.2020
 */
class UserRestaurantRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = UserRestaurantRestController.REST_URL + '/';

    @Autowired
    private DataJpaVoteRepository voteRepository;

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL)
                .with(userAuth(UserTestData.user)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_MATCHER.contentJson(actual));
    }

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + RESTAURANT_ID)
                .with(userAuth(UserTestData.user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_MATCHER.contentJson(ocean));
    }

    @Test
    void getDishesByRestId() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + RESTAURANT1_ID + "/dishes")
                .with(userAuth(UserTestData.user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_MATCHER.contentJson(DishTestData.menu1));

    }

    @Test
    void create() throws Exception {
        Vote newVote = VoteTestData.getToday(), getted;
        LocalDateTime tmp;
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(ocean))
                .with(userAuth(UserTestData.user)))
                .andExpect(status().isCreated());
        Vote created = readFromJson(action, Vote.class);
        int newId = created.id();
        newVote.setId(newId);
        tmp = newVote.getDateTime().withSecond(0).withNano(0);
        newVote.setDateTime(tmp);
        tmp = created.getDateTime().withSecond(0).withNano(0);
        created.setDateTime(tmp);
        VOTE_MATCHER.assertMatch(created, newVote);

        getted = voteRepository.get(newId);
        tmp = getted.getDateTime().withSecond(0).withNano(0);
        getted.setDateTime(tmp);
        VOTE_MATCHER.assertMatch(getted, newVote);
    }
}