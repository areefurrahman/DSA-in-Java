class LevelNode {
    String levelName;
    LevelNode prev;
    LevelNode next;

    public LevelNode(String levelName) {
        this.levelName = levelName;
        this.prev = null;
        this.next = null;
    }
}

class GameLevels {
    LevelNode head;
    LevelNode tail;
    LevelNode current; 

    public void addLevel(String levelName) {
        LevelNode newNode = new LevelNode(levelName);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void nextLevel() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Moved to next level: " + current.levelName);
        } else {
            System.out.println("No next level.");
        }
    }

    public void previousLevel() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Moved to previous level: " + current.levelName);
        } else {
            System.out.println("No previous level.");
        }
    }

    public void removeLevel(String levelName) {
        LevelNode temp = head;
        while (temp != null) {
            if (temp.levelName.equals(levelName)) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                if (current == temp) current = head;

                System.out.println("Level '" + levelName + "' removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Level not found.");
    }

    public void searchLevel(String levelName) {
        LevelNode temp = head;
        while (temp != null) {
            if (temp.levelName.equals(levelName)) {
                System.out.println("Level found: " + levelName);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Level not found.");
    }

    public void insertBonusLevel(String afterLevel, String bonusLevelName) {
        LevelNode temp = head;
        while (temp != null) {
            if (temp.levelName.equals(afterLevel)) {
                LevelNode newNode = new LevelNode(bonusLevelName);
                newNode.next = temp.next;
                newNode.prev = temp;
                if (temp.next != null) {
                    temp.next.prev = newNode;
                } else {
                    tail = newNode; 
                }
                temp.next = newNode;
                System.out.println("Bonus level inserted after " + afterLevel);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Level not found.");
    }

    public void displayLevelsReverse() {
        LevelNode temp = tail;
        System.out.println("Levels from latest to earliest:");
        while (temp != null) {
            System.out.println(temp.levelName);
            temp = temp.prev;
        }
    }

    public void displayLevels() {
        LevelNode temp = head;
        System.out.println("All levels from start to end:");
        while (temp != null) {
            System.out.println(temp.levelName);
            temp = temp.next;
        }
    }
}

public class GameLevelNavigation {
    public static void main(String[] args) {
        GameLevels game = new GameLevels();

        game.addLevel("Level 1");
        game.addLevel("Level 2");
        game.addLevel("Level 3");

        game.displayLevels();
        game.nextLevel(); 
        game.current = game.head; 
        game.nextLevel(); 
        game.previousLevel(); 

        game.insertBonusLevel("Level 1", "Bonus Level A");
        game.displayLevels();

        game.searchLevel("Level 3");
        game.removeLevel("Level 2");
        game.displayLevels();

        game.displayLevelsReverse();
    }
}
