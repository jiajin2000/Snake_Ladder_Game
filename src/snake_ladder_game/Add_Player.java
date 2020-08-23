package snake_ladder_game;

import adt.ArrList;
import entity.Player;
import java.util.regex.Pattern;
import static snake_ladder_game.Snake_ladder_game.scan;
import static snake_ladder_game.Snake_ladder_game.playerList;

public class Add_Player {

    public static void addPlayer() {

        String line = "================================";
        playerList = new ArrList<>();

        int option;

        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        String data = "1";

        do {
            System.out.print("How Many Player for this Game ?(Min 2, Max 4):");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid Entry of Number of Player !");
                System.out.print("How Many Player for this Game ?(Min 2, Max 4):");
                scan.next(); // this is important!
            }
            option = scan.nextInt();
            data = Integer.toString(option);
        } while ((option < 2 || option > 4) || (pattern.matcher(data).matches() == false));

        String clear = scan.nextLine();
        for (int i = 1; i <= option; i++) {

            System.out.print("Please Enter Player " + i + "'s Name  :");
            String name = scan.nextLine();
                
            
            do{
                
            for (int y = 0; y < playerList.size(); y++) {
                
                 while ((name.length() > 3)) {
                    System.out.println("\nMaximum Length of Player's Name is 3 !\n");
                    System.out.print("Please Enter Player " + i + "'s Name  :");
                    name = scan.nextLine();
                    System.out.println("");

                }

                while(playerList.get(y).getPlayerName().equals(name)){
                    System.out.println("\nThe Name Already Been Taken !\n");
                    System.out.print("Please Enter Player " + i + "'s Name  :");
                    name = scan.nextLine();
                    System.out.println("");
                }
                
             }
            
            }while((name.length() > 3));


            playerList.add(new Player(name));

        }

        System.out.println("");
        
        confirmPlayer();
        
        System.out.println("");
        System.out.println("");
        System.out.println(line);
        System.out.println("Player Successfully Registered !\n" + line);
        System.out.println(playerList.toString());

    }
    
    private static void confirmPlayer(){
     
     String line = "================================";
         
     System.out.println(line);
     System.out.println(playerList.toString());
     System.out.println(line);
     System.out.println("1. Confirm and Start");
     System.out.println("2. Player Rename");
     System.out.println("3. Reset All Player");
     System.out.println(line);
     System.out.print("Please Select Your Option :");
     int option = scan.nextInt();
     
     while ((option > 3) || (option < 1) ) 
       {
                System.out.println("\nPlease Enter 1 to 3 only !");
                System.out.print("Please Select Your Option :");
                option = scan.nextInt();
              
       }  
     System.out.println(line);
     
     if(option == 3){
     
        playerList.clear();
     
        int num = 0;
        Player.Reset();

        addPlayer();
        
     }else if(option == 2){

         editPlayer();
     
    }else
    {

    }
     
    }
    
    private static void editPlayer(){
      
     int option;

        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        String data = "1";

        do {
            System.out.print("Which Player You Want to Rename ? :");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid Player Number !!!");
                System.out.print("Which Player You Want to Rename ? :");
                scan.next(); // this is important!
            }
            option = scan.nextInt();
           
            
            data = Integer.toString(option);
        } while ( option < 1 || option > playerList.size() || (pattern.matcher(data).matches() == false));
        
      String clear = scan.nextLine();
       
      System.out.print("Please Enter Player " + option + "'s New Name  :");
            String name = scan.nextLine();
            
            do{
                
                 for (int y = 0; y < playerList.size(); y++) {
                
                 while ((name.length() > 3)) {
                    System.out.println("\nMaximum Length of Player's Name is 3 !\n");
                    System.out.print("Please Enter Player " + option + "'s New Name  :");
                    name = scan.nextLine();
                    System.out.println("");

                }

                while(playerList.get(y).getPlayerName().equals(name)){
                    System.out.println("\nThe Name Already Been Taken !\n");
                    System.out.print("Please Enter Player " + option + "'s  New Name  :");
                    name = scan.nextLine();
                    System.out.println("");
                }
                
             }
                

            }while((name.length() > 3));
            

            playerList.get(option-1).setPlayerName(name);
            
            confirmPlayer();
    
    }

}
