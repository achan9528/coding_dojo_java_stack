import java.util.HashMap;
import java.util.Set;

public class SongsLyrics{
    public HashMap<String,String> someSongs(){
        HashMap<String, String> tracklist = new HashMap<String,String>();
        tracklist.put(
            "Misty Blue",
            "Oh, it's been such a long, long time\nLook like I'd get you off of my mind\nBut I can't\nJust the thought of you (just the thought of you)\nTurns my whole world misty blue (misty blue)"
        );
        tracklist.put(
            "Let's Get It On",
            "I've been really tryin', baby\nTryin' to hold back this feeling for so long\nAnd if you feel like I feel, baby\nThen, c'mon, oh, c'mon, whoa"
        );
        tracklist.put(
            "P.S. I Love You",
            "Dear, I thought I drop a line\nThe weather is cool\nThe fools are fine\nI'm in bed each night at nine\nP.s. I love you"
        );
        tracklist.put(
            "Let's Stay Together",
            "I'm, I'm so in love with you\nWhatever you want to do\nIs alright with me\n'Cause you make me feel so brand new\nAnd I want to spend my life with you"
        );

        System.out.println(tracklist.get("Misty Blue"));

        Set<String> tracks = tracklist.keySet();
        for (String track:tracks){
            System.out.println(track + ": \n" + tracklist.get(track) + "\n");
        }
        return tracklist;
    }
}