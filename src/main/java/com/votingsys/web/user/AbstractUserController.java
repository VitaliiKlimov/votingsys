package com.votingsys.web.user;

import com.votingsys.service.UserService;
import com.votingsys.to.UserTo;
import com.votingsys.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.votingsys.model.User;
import java.util.List;
import static com.votingsys.util.ValidationUtil.assureIdConsistent;
import static com.votingsys.util.ValidationUtil.checkNew;

public abstract class AbstractUserController {

    @Autowired
    private UserService userService;

    public List<User> getAll() {
        return userService.getAll();
    }

    public User get(int id) {
        return userService.get(id);
    }

    public User create(UserTo userTo) {
        return create(UserUtil.createNewFromTo(userTo));
    }

    public User create(User user) {
        checkNew(user);
        return userService.save(user);
    }

    public void delete(int id) {
        userService.delete(id);
    }

    public void update(User user, int id) {
        assureIdConsistent(user, id);
        userService.update(user);
    }

    public User getByMail(String email) {
        return userService.getByEmail(email);
    }
}