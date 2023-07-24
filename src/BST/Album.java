package BST;



import java.util.Arrays;
import java.util.List;

//Afreen Ahmad
public class Album implements Comparable<Album> {
    private int id;
    private List<String> artists;
    private String title;
    private int numSongs;

    public Album(int id, List<String> artists, String title, int numSongs) {
        this.id = id;
        this.artists = artists;
        this.title = title;
        this.numSongs = numSongs;
    }

    public int getId() {
        return id;
    }

    public List<String> getArtists() {
        return artists;
    }

    public String getTitle() {
        return title;
    }

    public int getNumSongs() {
        return numSongs;
    }

    @Override
    public int compareTo(Album other) {
        return Integer.compare(this.numSongs, other.numSongs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append(" -- ");
        sb.append("[");
        for (int i = 0; i < artists.size(); i++) {
            sb.append(artists.get(i));
            if (i != artists.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] -- ");
        sb.append("Num Songs: ").append(numSongs);
        return sb.toString();
    }
}

