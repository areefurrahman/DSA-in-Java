import java.util.Scanner;

class Node {
    String song;
    Node next;
    Node prev;

    public Node(String song) {
        this.song = song;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedlist {
    Node head = null;
    Node tail = null;
    Node currentPosition = null;
    int count = 0;

    public void addNewSong(String song) {
        Node newNode = new Node(song);
        count++;

        if (head == null) {

            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
            currentPosition = head;

            return;
        }

        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        tail.next = newNode;
        head = newNode;

        currentPosition = head;

    }

    public void playSong() {
        System.out.println("Playing: " + currentPosition.song);
    }

    public void nextSong() {
        currentPosition = currentPosition.next;
        System.out.println("Next Song: " + currentPosition.song);
    }

    public void previousSong() {
        currentPosition = currentPosition.prev;
        System.out.println("Previous Song: " + currentPosition.song);

    }

    public void removeSong(int srNO) {

        if (srNO < 1 || srNO > count) {
            System.out.println("Song Not found");
            return;
        }

        if (head == tail && srNO == 1) {
            head = tail = currentPosition = null;
            count--;
            return;
        }

        Node current = head;
        for (int i = 1; i < srNO; i++) {
            current = current.next;
        }

        if (current == head) head = head.next;
        if (current == tail) tail = tail.prev;

        if (current == currentPosition) currentPosition = current.next;

        current.prev.next = current.next;
        current.next.prev = current.prev;

        count--;
        System.out.println("Song removed successfully.");


    }

    public void displaySongs() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        int i = 1;

        do {
            System.out.println(i + ". " + current.song);
            i++;
            current = current.next;
        } while (current != head);

    }
}

public class SongPlayListCircularDoublyLinkedList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DoublyLinkedlist songList = new DoublyLinkedlist();

        while (true) {
            System.out.println("\n1) Add a new song to the playlist  2) Play Song  3) Next Song  4) Previous Song  5) Remove a song from the playlist  6) Display the current playlist in order  7) Exit");
            switch (input.nextInt()) {
                case 1 -> {
                    input.nextLine();
                    System.out.print("Song Name: ");
                    String songName = input.nextLine();
                    songList.addNewSong(songName);
                    System.out.println("Song added successfully!");

                }
                case 2 -> {
                    songList.playSong();
                }
                case 3 -> {
                    songList.nextSong();
                }
                case 4 -> {
                    songList.previousSong();

                }
                case 5 -> {
                    input.nextLine();
                    System.out.print("Enter song Serial No: ");
                    int songNo = input.nextInt();

                    songList.removeSong(songNo);

                }
                case 6 -> {
                    songList.displaySongs();
                }

                case 7 -> {
                    System.out.println("Exiting...");
                    input.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
