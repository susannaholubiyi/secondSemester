package diary;


import javax.swing.*;

public class MainDiary {
    private static final String smiley = "\uD83D\uDE00";
    private static final Diaries diaries = new Diaries();
    private static void print(String message){
        JOptionPane.showMessageDialog(null, message);

    }
    private static String input(String prompt){
        return JOptionPane.showInputDialog(prompt + " ");
    }

    private static void mainMenu(){
        String menu = """
                **************** Welcome to your Diary ****************
                
                         Your one-time password is 1234
                         
                Enter any of the following numbers to carry out an action
                1-> Create diary
                2-> Unlock diary
                3-> Create entry
                4-> Find entry by Id
                5-> Update entry
                6-> Delete entry
                7-> Lock diary
                8-> Delete diary
                9-> Exit App
                """;
        String choice = input(menu);

        String password;
        switch (choice) {
            case "1"->{
                String userName = input("Enter your user name: ");
                String passWord = input("Enter your password: ");
                diaries.add(userName, passWord);
                print("Your diary has been created, unlock with password to add entry");
                print("Always remember your password");
                mainMenu();

            }
            case "2" -> {
                String userName = input("Enter your user name to find diary:");
                try {
                    var diary = diaries.findDiary(userName);
                    password = input("Enter your password:");
                    diary.unlockDiary(password);
                    print("Your diary has been unlocked" + smiley);
                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {
                    mainMenu();
                }

            }
            case "3" -> {
                String userName = input("Enter your user name to find diary:");
                try {
                    var diary = diaries.findDiary(userName);
                    String title = input("Enter the title of your new entry:");
                    String body = input("Enter the body of your new entry:");
                    diary.createEntry(title, body);
                    print("Your ID is" + diary.getNumberOfEntries());
                    print("Your entry has been added" + smiley);
                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {
                    mainMenu();
                }
            }
            case  "4" -> {
                String userName = input("Enter your user name to find diary:");
                try {
                    var diary = diaries.findDiary(userName);
                    String id = input("Enter your Id:");
                   var entry  = diary.findEntry(Integer.parseInt(id));
                   print(String.valueOf(entry));
                } catch (Exception e) {
                    print(e.getMessage());
                } finally {
                    mainMenu();
                }
            }
            case "5" ->{
                String userName = input("Enter your user name to find diary:");
                 try {
                     var diary = diaries.findDiary(userName);
                     String id = input("Enter your id:");
                     String newTitle = input("Enter the new title:");
                     String newBody = input("Enter the new body");
                     diary.updateEntry(Integer.parseInt(id), newTitle, newBody);
                     print("Entry has been updated" + smiley);
                 }
                 catch (Exception e) {
                     print(e.getMessage());
                 }
                 finally {
                     mainMenu();
                 }
            }
            case "6"->{
                String userName = input("Enter your user name to find diary:");
                try {
                    var diary = diaries.findDiary(userName);
                    String id = input("Enter your id:");
                    diary.deleteEntry(Integer.parseInt(id));
                    print("Your entry has been deleted");
                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {
                    mainMenu();
                }
            }
            case "7"->{
                String userName = input("Enter your user name to find diary:");
                try {
                    var diary = diaries.findDiary(userName);
                    diary.lockDiary();
                    print("Diary is locked");
                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {
                    mainMenu();
                }
            }
            case "8"->{
                String userName = input("Enter your user name to find diary:");
                try {
                    var diary = diaries.findDiary(userName);
                    String passWord = input("Enter your password:");
                    diaries.deleteDiary(userName, passWord);
                    print("Diary has been deleted");
                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {
                    mainMenu();
                }
            }
            case "9"-> System.exit(69);
            default -> mainMenu();

        }

    }

    public static void main(String[] args) {
        mainMenu();
    }
}
