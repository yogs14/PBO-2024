import java.util.ArrayList;

public class MusicOrganizer {
    private ArrayList<Track> tracks; // Changed to Track type
    private MusicPlayer player;
    private TrackReader reader;

    public MusicOrganizer() {
        tracks = new ArrayList<>();
        player = new MusicPlayer();
        reader = new TrackReader();
        readLibrary("audio");
        System.out.println("Music library loaded. " + getNumberOfTracks() + 
            " tracks.");
        System.out.println();
    }

    // Adds a Track object
    public void addTrack(Track track) {
        tracks.add(track);
    }

    // Returns the total number of tracks
    public int getNumberOfTracks() {
        return tracks.size();
    }

    // Lists details of all tracks
    public void listAllTracks() {
        System.out.println("Track Listing: ");
        for (Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }

    // Removes a track from the list
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        }
    }

    // Simulates reading the library, assuming Track objects are added
    private void readLibrary(String folder) {
        // Logic to read tracks from the "audio" folder would go here
        // For simplicity, we can simulate adding a couple of tracks
        addTrack(new Track("Song1", "Artist1"));
        addTrack(new Track("Song2", "Artist2"));
    }
}

// Assuming you have a Track class like this
class Track {
    private String title;
    private String artist;

    public Track(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getDetails() {
        return title + " by " + artist;
    }
}

// Dummy MusicPlayer and TrackReader classes for compilation purposes
class MusicPlayer {
    // Player methods
}

class TrackReader {
    // Reader methods
}
