import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<>();
    }

    //find
    public boolean findSong(String title){
        for(Song checkSong:this.songs){
            if(checkSong.getTitle().equals(title)){
                System.out.println("Song Found !!");
                return true;
            }
        }

        return false;
    }
    //add song
    public boolean addSong(String title,double duration){
        if(findSong(title)==true){
            System.out.println("Song Already Present");
            return false;
        }
        else{
            Song newSong=new Song(title,duration);
            songs.add(newSong);
            return true;
        }
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        for(Song checkSong:songs){
            if(checkSong.getTitle().equals(title)){
                playlist.add(checkSong);
                return true;
            }
        }
        return false;
    }

    public boolean addToPlaylist(int trackNumber,LinkedList<Song> playlist){
        int index=trackNumber-1;
        if(index>=0&&index<=songs.size()-1){
            playlist.add(songs.get(index));
            return true;
        }
        return false;
    }

}
