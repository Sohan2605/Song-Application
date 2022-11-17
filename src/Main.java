import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Album album=new Album("Hindi","Lata Mangeshakar");

        album.addSong("piya",3.5);
        album.addSong("sshh",4);
        album.addSong("fdwd",5);
        album.addSong("ews",3);

        LinkedList<Song> myPlayList=new LinkedList<>();
        album.addToPlaylist("piya",myPlayList);
        album.addToPlaylist("sshh",myPlayList);
        album.addToPlaylist("fdwd",myPlayList);

        play(myPlayList);
    }

    public static void play(LinkedList<Song> playList){

       Scanner sc=new Scanner(System.in);
       ListIterator itr= playList.listIterator();

       if(!itr.hasNext()){
           System.out.println("PlayList is Empty");
           return;
       }

       System.out.println("You are now listning "+itr.next());
       showMenu();
       boolean forward=true;
       while(true){
           int option=sc.nextInt();
           switch(option){
               case 0:
                   return;
               case 1:
                   showMenu();
                   break;
               case 2:
                   printPlayList(playList);
                   break;
               case 3:
                   playNextSong(playList,itr,forward);
                   forward=true;
                   break;
               case 4:
                   playPreviousSong(playList,itr,forward);
                   forward=false;
                   break;
           }
       }
    }
    public static void printPlayList(LinkedList<Song> playList){
        ListIterator itr=playList.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static void playNextSong(LinkedList<Song> playList,ListIterator itr,boolean forward){
        if(!forward){
            if(itr.hasNext())
                itr.next();
        }

        if(itr.hasNext()){
            System.out.println(itr.next());
        }
        else{
            System.out.println("You reached at last of the Playlist!!");
        }
    }

    public static void playPreviousSong(LinkedList<Song> playList,ListIterator itr,boolean forward){
        if(forward){
            if(itr.hasPrevious())
                itr.previous();
        }
        if(itr.hasPrevious()){
            System.out.println(itr.previous());
        }
        else{
            System.out.println("You reached at start of Playlist!!");
        }
    }
    public static void showMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show the list of all Songs in the playlist");
        System.out.println("3. Play next song");
        System.out.println("4. Play previous Song");
        System.out.println("5. Repeat the song");
        System.out.println("6. Delete the song");
    }
}