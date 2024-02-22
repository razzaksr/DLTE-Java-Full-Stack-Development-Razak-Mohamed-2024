package handle.logs.chances;

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NestedStructure {
    public static void main(String[] args) {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Scanner scanner=new Scanner(System.in);
        int index=0;
        String[] myBankProducts={"CASA","Funds","Card"};
        logger.log(Level.CONFIG,resourceBundle.getString("members.init"));

        // read find value by position
        System.out.println("enter the position to find my bank products");
        try{
            index=scanner.nextInt();
            logger.log(Level.INFO,resourceBundle.getString("data.collected"));
            System.out.println(myBankProducts[index]);
            logger.log(Level.INFO,resourceBundle.getString("collected.okay"));
        }
        catch (InputMismatchException inputException){
            Scanner scanner1=new Scanner(System.in);
            System.out.println(resourceBundle.getString("exception.input"));
            logger.log(Level.WARNING,resourceBundle.getString("exception.input"));
            try{
                index=scanner1.nextInt();
                logger.log(Level.INFO,resourceBundle.getString("data.collected"));
                System.out.println(myBankProducts[index]);
                logger.log(Level.INFO,resourceBundle.getString("collected.okay"));
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
                System.out.println(resourceBundle.getString("exception.boundry")+myBankProducts.length);
                logger.log(Level.WARNING,resourceBundle.getString("exception.boundry")+myBankProducts.length);
                index=scanner1.nextInt();
                logger.log(Level.INFO,resourceBundle.getString("data.collected"));
                System.out.println(myBankProducts[index]);
                logger.log(Level.INFO,resourceBundle.getString("collected.okay"));
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayException){
            System.out.println(resourceBundle.getString("exception.boundry")+myBankProducts.length);
            logger.log(Level.WARNING,resourceBundle.getString("exception.boundry")+myBankProducts.length);
            index=scanner.nextInt();
            logger.log(Level.INFO,resourceBundle.getString("data.collected"));
            System.out.println(myBankProducts[index]);
            logger.log(Level.INFO,resourceBundle.getString("collected.okay"));
        }
        catch(Exception exception){
            logger.log(Level.SEVERE,exception.getClass().toString());
        }
        finally {
            scanner.close();
        }
    }
}
