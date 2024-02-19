import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

class Forum {
    private List<ForumUser> userList;

    public Forum() {
        this.userList = new ArrayList<>();
    }

    public void addUser(ForumUser user) {
        userList.add(user);
    }

    public List<ForumUser> getUserList() {
        return userList;
    }
}
