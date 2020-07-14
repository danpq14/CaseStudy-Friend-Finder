package com.friend.finder.services;

import com.friend.finder.models.Newsfeed;

public interface NewsfeedService extends FullService<Newsfeed> {
    Newsfeed getNewsfeedByAccount(String username);
}
