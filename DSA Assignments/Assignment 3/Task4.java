class DeviceNode {
    int deviceCode;
    DeviceNode leftLink, rightLink;

    public DeviceNode(int code) {
        this.deviceCode = code;
        this.leftLink = null;
        this.rightLink = null;
    }
}

class DeviceManager {
    DeviceNode entryPoint;

    public DeviceNode addDevice(DeviceNode node, int code) {
        if (node == null) {
            return new DeviceNode(code);
        }
        if (code < node.deviceCode) {
            node.leftLink = addDevice(node.leftLink, code);
        } else {
            node.rightLink = addDevice(node.rightLink, code);
        }
        return node;
    }

    public void showInOrder(DeviceNode node) {
        if (node != null) {
            showInOrder(node.leftLink);
            System.out.print(">> Device ID: " + node.deviceCode + " | ");
            showInOrder(node.rightLink);
        }
    }

    public void showPreOrder(DeviceNode node) {
        if (node != null) {
            System.out.print("-- Starting Device ID: " + node.deviceCode + " | ");
            showPreOrder(node.leftLink);
            showPreOrder(node.rightLink);
        }
    }

    public void showPostOrder(DeviceNode node) {
        if (node != null) {
            showPostOrder(node.leftLink);
            showPostOrder(node.rightLink);
            System.out.print("~~ Turning Off Device ID: " + node.deviceCode + " | ");
        }
    }
}

public class Task4 {
    public static void main(String[] args) {
        DeviceManager manager = new DeviceManager();

        int[] codes = {45, 25, 65, 15, 35, 55, 75};
        for (int code : codes) {
            manager.entryPoint = manager.addDevice(manager.entryPoint, code);
        }

        System.out.println("=== Device Log View (In-Order Display) ===");
        manager.showInOrder(manager.entryPoint);
        System.out.println("\n");

        System.out.println("=== Device Boot Process (Pre-Order Display) ===");
        manager.showPreOrder(manager.entryPoint);
        System.out.println("\n");

        System.out.println("=== Power Off Sequence (Post-Order Display) ===");
        manager.showPostOrder(manager.entryPoint);
        System.out.println();
    }
}



