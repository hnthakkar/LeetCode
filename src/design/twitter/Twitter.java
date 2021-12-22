package design.twitter;

import java.util.*;

public class Twitter {

    Map<Integer, User> userMap;
    int seqId;

    public static void main(String[] str) {
        Twitter sol = new Twitter();
        /*
        sol.postTweet(1,5);
        sol.getNewsFeed(1);
        sol.follow(1,2);
        sol.postTweet(2,6);
        sol.getNewsFeed(1);
        sol.unfollow(1,2);
        sol.getNewsFeed(1);

         */

        /*
        sol.postTweet(1,1);
        sol.getNewsFeed(1);
        sol.follow(2,1);
        sol.getNewsFeed(2);
        sol.unfollow(2,1);
        sol.getNewsFeed(2);

         */

        sol.postTweet(2,5);
        sol.follow(1,2);
    }

    public Twitter() {
        userMap = new HashMap<>();
        seqId = 1;
    }

    public void postTweet(int userId, int tweetId) {
        User user = getUserReference(userId);
        Tweet tweet = new Tweet(tweetId,userId,seqId++);
        user.addToMyTweets(tweet);

        for (Integer follower: user.followedBy) {
            if (userMap.containsKey(follower)) {
                User followerUser = userMap.get(follower);
                followerUser.addToFeed(tweet);
            }
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = getUserReference(userId);
        return user.getMyFeed();
    }

    public void follow(int followerId, int followeeId) {
        User follower = getUserReference(followerId);
        follower.follow(followeeId);

        User followee = getUserReference(followeeId);
        Set<Tweet> tweets = followee.addFollower(followerId);

        for (Tweet tweet: tweets) {
            follower.addToFeed(tweet);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        User user = getUserReference(followerId);
        user.unFollow(followeeId);

        User followee = getUserReference(followeeId);
        followee.removerFollower(followerId);
    }

    private User getUserReference(int userId) {
        User user;
        if (userMap.containsKey(userId)) {
            user = userMap.get(userId);
        } else {
            user = new User(userId);
            userMap.put(userId, user);
        }

        return user;
    }
}

class Tweet {
    int tweetId;
    int userId;
    int seqId;

    public Tweet(int pTweetId, int pUserId, int pSeqId) {
        tweetId = pTweetId;
        userId = pUserId;
        seqId = pSeqId;
    }
}

class User {
    int userId;
    Set<Integer> follows;
    Set<Integer> followedBy;
    PriorityQueue<Tweet> myFeed;
    Set<Tweet> myTweets;

    public User(int pUserId) {
        userId = pUserId;

        follows = new HashSet<>();
        follows.add(userId);

        followedBy = new HashSet<>();
        followedBy.add(userId);

        myFeed = new PriorityQueue<>((a, b) -> b.seqId - a.seqId);

        myTweets = new HashSet<>();
    }

    public void addToMyTweets(Tweet myTweet) {
        myTweets.add(myTweet);
    }

    public Set<Tweet> addFollower(int userId) {
        if (followedBy.contains(userId)) {
            return Collections.emptySet();
        }

        followedBy.add(userId);
        return myTweets;
    }

    public void removerFollower(Integer userId) {
        followedBy.remove(userId);
    }

    public void follow(int userId) {
        follows.add(userId);
    }

    public void unFollow(Integer userId) {
        follows.remove(userId);
    }

    public void addToFeed(Tweet tweet) {
        myFeed.add(tweet);
    }

    public List<Integer> getMyFeed() {
        List<Tweet> tmp = new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        while (result.size() < 10 && !myFeed.isEmpty()) {
            Tweet tweet = myFeed.poll();

            if (follows.contains(tweet.userId)) {
                result.add(tweet.tweetId);
                tmp.add(tweet);
            }
        }

        for (Tweet tweet: tmp) {
            myFeed.add(tweet);
        }

        return result;
    }
}
