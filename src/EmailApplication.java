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


                if(parameters[0].equals("Q")) isContinue = false;

                else if(parameters[0].equals("N")){
                String[] emailInfo = parameters[1].split("//");
                Email email = new Email(emailInfo[1], emailInfo[3], Integer.parseInt(emailInfo[2]), Integer.parseInt(emailInfo[4]));
                INBOX.addEmail(email);
            }


                else if(parameters[0].equals("R")) {
                    int ID = Integer.parseInt(parameters[1]);
                    INBOX.read(ID);
                }


                else if(parameters[0].equals("A")){
                    int ID = Integer.parseInt(parameters[1]);
                    Email archived = INBOX.delete(ID);
                    if (archived != null) {
                        ARCHIVE.addEmail(archived);
                        System.out.println("Email with id: "+ ID + " is archived\n");
                    } else {
                        System.out.println("Email with given ID couldn't archived\n");
                    }
                }

                else if(parameters[0].equals("D")) {
                    int ID = Integer.parseInt(parameters[1]);
                    Email deletedEmail = INBOX.delete(ID);
                    TRASH.addEmail(deletedEmail);
                }


                else if(parameters[0].equals("S")) {
                    String folder = parameters[1];
                    if(folder.equals("Inbox")) System.out.print(INBOX);

                    else if(folder.equals("Archive")) System.out.print(ARCHIVE);

                    else if(folder.equals("Trash")) System.out.print(TRASH);

                    else System.out.println("Such folder does not exists.");

                }


                else if(parameters[0].equals("U")) {
                    String folder = parameters[1];

                        if(folder.equals("Inbox")) INBOX.showAll(false);

                        else if(folder.equals("Archive")) ARCHIVE.showAll(false);

                        else if(folder.equals("Trash")) TRASH.showAll(false);

                        else System.out.println("Such folder does not exists.");

                }

                else if(parameters[0].equals("C")){
                    String folder = parameters[1];

                    if(folder.equals("Inbox")) System.out.println(INBOX.clearFolder(TRASH));

                    else if(folder.equals("Archive"))  System.out.println(ARCHIVE.clearFolder(TRASH));

                    else if(folder.equals("Trash")) System.out.println(TRASH.clearFolder(null));

                    else System.out.println("Such folder does not exist.");


            }
        }
        scan.close();
    }
}
