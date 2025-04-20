// import java.util.*;

// public class IteratorSongPlaylist {
//     LinkedList<String> songs = new LinkedList<>();
//     ListIterator<String> iterator = songs.listIterator();
//     String currentSong = null;

//     public void addNewSong(String song) {
//         iterator = songs.listIterator(); // reset iterator
//         songs.addFirst(song);
//         currentSong = song;
//         System.out.println("Song added successfully!");
//     }

//     public void playSong() {
//         if (currentSong == null) {
//             System.out.println("No song is currently selected.");
//         } else {
//             System.out.println("Playing: " + currentSong);
//         }
//     }

//     public void nextSong() {
//         if (songs.isEmpty()) {
//             System.out.println("Playlist is empty.");
//             return;
//         }

//         if (!iterator.hasNext()) {
//             iterator = songs.listIterator(); // restart from beginning (circular behavior)
//         }
//         currentSong = iterator.next();
//         System.out.println("Next Song: " + currentSong);
//     }

//     public void previousSong() {
//         if (songs.isEmpty()) {
//             System.out.println("Playlist is empty.");
//             return;
//         }

//         if (!iterator.hasPrevious()) {
//             iterator = songs.listIterator(songs.size()); // move to end (circular behavior)
//         }
//         currentSong = iterator.previous();
//         System.out.println("Previous Song: " + currentSong);
//     }

//     public void removeSong(int srNo) {
//         if (srNo < 1 || srNo > songs.size()) {
//             System.out.println("Invalid song number.");
//             return;
//         }

//         String removed = songs.remove(srNo - 1);
//         System.out.println("Removed: " + removed);

//         if (songs.isEmpty()) {
//             currentSong = null;
//             iterator = songs.listIterator();
//         } else {
//             iterator = songs.listIterator(); // reset
//             if (iterator.hasNext()) currentSong = iterator.next();
//         }
//     }

//     public void displaySongs() {
//         if (songs.isEmpty()) {
//             System.out.println("Playlist is empty.");
//             return;
//         }

//         int i = 1;
//         for (String song : songs) {
//             System.out.println(i + ". " + song);
//             i++;
//         }
//     }

//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         IteratorSongPlaylist playlist = new IteratorSongPlaylist();

//         while (true) {
//             System.out.println("\n1) Add Song  2) Play Song  3) Next  4) Previous  5) Remove  6) Display  7) Exit");
//             int choice = input.nextInt();
//             input.nextLine();

//             switch (choice) {
//                 case 1 -> {
//                     System.out.print("Enter song name: ");
//                     String name = input.nextLine();
//                     playlist.addNewSong(name);
//                 }
//                 case 2 -> playlist.playSong();
//                 case 3 -> playlist.nextSong();
//                 case 4 -> playlist.previousSong();
//                 case 5 -> {
//                     System.out.print("Enter song number to remove: ");
//                     int no = input.nextInt();
//                     playlist.removeSong(no);
//                 }
//                 case 6 -> playlist.displaySongs();
//                 case 7 -> {
//                     System.out.println("Goodbye!");
//                     input.close();
//                     return;
//                 }
//                 default -> System.out.println("Invalid option!");
//             }
//         }
//     }
// }



// Solution 2

import java.util.*;

// Song class represents a single song
class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String toString() {
        return title + " by " + artist;
    }
}

// Playlist class manages the list and player logic
class Playlist {
    private LinkedList<Song> songs;
    private ListIterator<Song> iterator;
    private Song currentSong;

    public Playlist() {
        songs = new LinkedList<>();
        iterator = songs.listIterator();
    }

    public void addSong(Song song) {
        songs.add(song);
        resetIterator();
        System.out.println(" Song added: " + song);
    }

    public void playFirstSong() {
        if (songs.isEmpty()) {
            System.out.println(" Playlist is empty.");
            return;
        }
        iterator = songs.listIterator();
        currentSong = iterator.next();
        System.out.println("Now playing: " + currentSong);
    }

    public void playNextSong() {
        if (songs.isEmpty()) {
            System.out.println(" Playlist is empty.");
            return;
        }
        if (!iterator.hasNext()) {
            iterator = songs.listIterator(); // loop back to start
        }
        currentSong = iterator.next();
        System.out.println("Next song: " + currentSong);
    }

    public void playPreviousSong() {
        if (songs.isEmpty()) {
            System.out.println(" Playlist is empty.");
            return;
        }

        if (!iterator.hasPrevious()) {
            // Go to end
            while (iterator.hasNext()) {
                iterator.next();
            }
        }

        if (iterator.hasPrevious()) {
            currentSong = iterator.previous();
            System.out.println(" Previous song: " + currentSong);
        }
    }

    public void removeCurrentSong() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (currentSong != null) {
            iterator.remove();
            System.out.println("Removed: " + currentSong);

            // After removal, decide what to play next
            if (iterator.hasNext()) {
                currentSong = iterator.next();
            } else if (iterator.hasPrevious()) {
                currentSong = iterator.previous();
            } else {
                currentSong = null;
                System.out.println("Playlist is now empty.");
            }
        } else {
            System.out.println("No song is currently playing.");
        }
    }

    public void displayPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("\n🎶 Current Playlist:");
        for (Song song : songs) {
            System.out.println("- " + song);
        }
    }

    private void resetIterator() {
        iterator = songs.listIterator();
    }
}

// Main class for user interaction
public class SongPlayListBuiltinLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int choice;

        do {
            System.out.println("\n --- Song Playlist Menu ---");
            System.out.println("1. Add a new song");
            System.out.println("2. Play song");
            System.out.println("3. Next song");
            System.out.println("4. Previous song");
            System.out.println("5. Remove current song");
            System.out.println("6. Display playlist");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;
                case 2:
                    playlist.playFirstSong();
                    break;
                case 3:
                    playlist.playNextSong();
                    break;
                case 4:
                    playlist.playPreviousSong();
                    break;
                case 5:
                    playlist.removeCurrentSong();
                    break;
                case 6:
                    playlist.displayPlaylist();
                    break;
                case 7:
                    System.out.println("Exiting Playlist. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
