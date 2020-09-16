/*
    Author : Ahmet Cemal Sert
 */

import java.util.Scanner;

public class EmailApplication {

    public static void main(String[] args) {

        boolean isContinue = true;

        LinkedListOfEmails INBOX = new LinkedListOfEmails();
        LinkedListOfEmails ARCHIVE = new LinkedListOfEmails();
        LinkedListOfEmails TRASH = new LinkedListOfEmails();

        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println(
                "Welcome to the LinkedListOfEmails Application.\n"+
                "İnformation about the application commands:\n"+
                "N//subject//id//message//time//" + " Creates new email\n"+
                "R <id> Reads emails with the given id.\n"+
                "A <id> Archives emails with the given id.\n"+
                "D <id> Deletes emails with given id.\n"+
                "S <Folder> Shows the contents of the folder." + "\n"+
                "U <Folder> Shows all unreaded emails of the folder.\n"+
                "C <Folder> Clears the contents of the folder." + "\n"+
                "Q quits the application.\n");



        while (isContinue) {

            System.out.println("");
            String input = scan.nextLine();

            String[] parameters = input.split(" ", 2);
            switch (parameters[0]) {

                case "Q": {
                    isContinue = false;
                    break;
                }

                case "N":

                    String[] emailInfo = parameters[1].split("//");
                    Email email = new Email(emailInfo[1],emailInfo[3],Integer.parseInt(emailInfo[2]),Integer.parseInt(emailInfo[4]));
                    INBOX.addEmail(email);
                    break;


                case "R": {
                    int ID = Integer.parseInt(parameters[1]);
                    INBOX.read(ID);
                    break;
                }


                case "A": {
                    int ID = Integer.parseInt(parameters[1]);
                    Email archived = INBOX.delete(ID);
                    if (archived != null) {
                        ARCHIVE.addEmail(archived);
                        System.out.println("Email with id: "+ ID + " is archived\n");
                    } else {
                        System.out.println("Email with given ID couldn't archived\n");
                    }
                    break;
                }

                case "D": {
                    int ID = Integer.parseInt(parameters[1]);
                    Email deletedEmail = INBOX.delete(ID);
                    TRASH.addEmail(deletedEmail);
                    break;
                }


                case "S": {
                    String folder = parameters[1];
                    switch (folder) {
                        case "Inbox": {
                            System.out.print(INBOX);
                            break;
                        }

                        case "Archive": {
                            System.out.print(ARCHIVE);
                            break;
                        }

                        case "Trash": {
                            System.out.print(TRASH);
                            break;
                        }

                        default:
                            System.out.println("Such folder does not exists.");
                            break;
                    }

                    break;
                }


                case "U": {
                    String folder = parameters[1];
                    switch (folder) {
                        case "Inbox": {
                            INBOX.showAll(false);
                            break;
                        }

                        case "Archive": {
                            ARCHIVE.showAll(false);
                            break;
                        }

                        case "Trash": {
                            TRASH.showAll(false);
                            break;
                        }

                        default:
                            System.out.println("Such folder does not exists.");
                            break;
                    }

                    break;
                }

                case "C":
                    String folder = parameters[1];
                    switch (folder) {
                        case "Inbox": {
                            System.out.println(INBOX.clearFolder(TRASH));
                            break;
                        }

                        case "Archive": {
                            System.out.println(ARCHIVE.clearFolder(TRASH));
                            break;
                        }

                        case "Trash": {
                            System.out.println(TRASH.clearFolder(null));
                            break;
                        }

                        default:
                            System.out.println("Such folder does not exist.");
                            break;
                    }

                    break;
            }
        }
        scan.close();
    }
}