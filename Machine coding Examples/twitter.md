
## Requirements
- User can follow / unfollow someone
- User can post tweet
- User timeline (Most recent first including user's own tweets)
- .
- Like Tweet
- Dislike tweet
- Reply on a tweet


-------- Entities ------

## User Entity
- Name
- userId

## Followers Entity
- Follower
- Followee

## Tweet 
- userId
- tweetId
- content
- timeStamp


-------- DTO ------

## User DTO
- userName
- list following
- list followers
- list tweets


## Tweet DTO
- userId
- tweetId
- content
- timeStamp







import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;


// Main class should be named 'Solution' and should not be public.
class Solution {
    public static void main(String[] args) {
        // System.out.println("Hello, World");
        
        MyClass myClass = new MyClass();
        myClass.myClassRun();
    }
}

class MyClass{

    class User{
        String userName;
        List<User> followers;
        List<User> following;
        List<Tweet> tweets;
        
        User(String userName){
            this.userName = userName;
            followers = new ArrayList<>();
            following = new ArrayList<>();
            tweets = new ArrayList<>();
        }
    }
    
    class Tweet implements Comparable<Tweet>{
        User author;
        int tweetId;
        String content;
        long timeStamp;
        
        Tweet(User user, String content, int id){
            timeStamp = System.currentTimeMillis();
            author = user;
            this.content = content;
            tweetId = id;   
        }
        
        public int compareTo(Tweet t2){
            // System.out.println(this.timeStamp);
            // System.out.println(t2.timeStamp);
            
            if(this.timeStamp < t2.timeStamp) return 1;
            if(this.timeStamp > t2.timeStamp) return -1;
            return 0;   
        }
    }
        
    public void myClassRun(){
        User aman = new User("aman");
        User priyasha = new User("priysha");
        User ankit = new User("Ankit");
        
        
        // aman follows priyasha
        aman.following.add(priyasha);
        priyasha.followers.add(aman);
        
        // aman posts tweet
        Tweet tweet1 = new Tweet(aman,"aman first tweet",1);
        aman.tweets.add(tweet1);
        
        // priyasha posts tweet
        Tweet tweet2 = new Tweet(priyasha,"priyasha first tweet",2);
        tweet2.timeStamp += 100;
        priyasha.tweets.add(tweet2);
        
        // Get aman's timeline
        List<Tweet> timelineAman = getTimeline(aman);
        
        for(Tweet s : timelineAman){
            System.out.println(s.content);
        }
    }
    
    public List<Tweet> getTimeline(User user){
        List<Tweet> sol = new ArrayList<>();
        
        // sol.addAll(new ArrayList<Tweet>(user.tweets));
        sol.addAll(user.tweets);
        for(User celeb : user.following){
            // sol.addAll(new ArrayList<Tweet>(celeb.tweets));
            sol.addAll(celeb.tweets);
        }
        
        Collections.sort(sol);
        return sol;
    }
    
}