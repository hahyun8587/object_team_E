package com.util;

import com.std.User;
import com.std.Rank;
import com.record.manager.RecordManager;

/**
 * Class that builds full <code>User</code> object.
 * This class is applied builder design pattern.
 */
public class UserBuilder implements Builder {
    private User user;
    private Rank rank;
    private Selector selector;

    /**
     * Constructs <code>UserBuilder</code> object with <code>User</code> object and <code>Rank</code> object.
     * @param user not fully constructed <code>User</code> object
     * @param rank <code>Rank</code> object of the <code>User</code> object
     */
    public UserBuilder(User user, Rank rank) {
        this.user = user;
        this.rank = rank;
    }

    /**
     * Adds a specific record manager to <code>Selector</code> object.
     * @param manager a specific record manager to add
     * @return this <code>UserBuilder</code> object
     */
    public Builder addManager(RecordManager manager) {
        if(selector == null)
            selector = new Selector();
        
        selector.addManager(manager);

        return this;
    }

    /**
     * Builds full <code>User</code> object with the arguments.
     * @return full <code>User</code> object
     */
    public User build() {
        rank.setSelector(selector);
        user.setRank(rank);

        return user;
    }
}
