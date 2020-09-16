/*
    Author : Ahmet Cemal Sert
 */


public class LinkedListOfEmails {

    private Node head;
    private Node tail;
    private int counter = 0;

    private class Node {

        Email information;
        Node next;

        public Node(Email email) {
            this.information = email;
        }
    }

    public void addEmail(Email email) {

        Node node = new Node(email);
        node.next = null;

        if (this.head == null) {
            this.head = node;
            this.tail = node;

        } else {
            node.next = this.head;
            this.head = node;
        }
        
        this.counter++;
    }

    public void read(int ID) {
        Node node = head;

        for (int i = 0; i < this.counter; i++) {
            if (ID == node.information.getID()) {
                System.out.print(node.information);
                node.information.setFlag(true);
                return;
            }
            node = node.next;
        }
        System.out.println("Email couldn't found with the ID :" + ID);
    }


    public String clearFolder(LinkedListOfEmails folder) {

        if (this.head == null) return "Folder is already empty!\n";

        if (folder == null) {
            for (int i = 0; i < this.counter; i++) {
                this.delete();
            }
        } else for (int i = 0; i < this.counter; i++) {
            folder.addEmail(this.delete());
        }

        return "Folder is cleared!\n";
    }

    public Email delete() {
        Node node = this.head;
        this.head = this.head.next;
        this.counter--;

        return node.information;
    }

    public Email delete(int id) {
        Node node = this.head;

        if (this.head.information.getID() == id) {
            this.head = this.head.next;
            this.counter--;
            return node.information;
        }

        Node previous = null;
        while (node.next != null) {
            previous = node;
            node = node.next;

            if (node.information.getID() == id) {
                previous.next = node.next;
                this.counter--;
                return node.information;
            }
        }
        return null;
    }

    public void showAll(boolean flag) {
        Node node = head;

        for (int i = 0; i < this.counter; i++) {
            if (flag == node.information.getFlag()) System.out.print(node.information);
            node = node.next;
        }
    }

    @Override
    public String toString() {
        String outputString = null;
        Node node = this.head;

        if (node == null) {
            return "Folder is already empty!\n";
        }

        System.out.printf("%s %-35s %-45s %s %s ","Email", "Subject", "Body", "Time", "Read");
        System.out.println();

        for (int i = 0; i < this.counter; i++) {
            Email email = node.information;
            outputString += String.format("%s %-35s %-45s %s %s \n", email.getID(), email.getSubject(), email.getMessage(),
                    email.getTime(), email.getFlag());

            node = node.next;
        }
        return outputString;
    }
}