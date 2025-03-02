import java.util.*;

public class Twitter {
    private static int timestamp = 0;

    public class Tweet {
        int tweetId;
        int time;
        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private HashMap<Integer, List<Tweet>> userMap;
    private HashMap<Integer, HashSet<Integer>> followMap;

    public Twitter() {
        userMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new ArrayList<>());
        userMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Get user's tweets
        pq.addAll(userMap.getOrDefault(userId, new ArrayList<>()));

        // Get followees' tweets
        for (int followeeId : followMap.getOrDefault(userId, new HashSet<>())) {
            pq.addAll(userMap.getOrDefault(followeeId, new ArrayList<>()));
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            res.add(pq.poll().tweetId);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
