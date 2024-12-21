import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число от 1 до 12: ");
        String str = "";
        int n = 0;
        String[] months =  {"январь", "февраль", "март", "апрель", "май",
                "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        try {
            str = in.next();
            n = Integer.parseInt(str);
            if(n!=2) System.out.println(months[n-1]+" "+dom[n-1]);
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.out.println("Недопустимое число: " + str);
            return;
        }
        if(n == 2){
            System.out.println("Введите год: ");
            int year = 0;
            try {
                year = in.nextInt();
                if(year<0) throw new InputMismatchException();
            }catch (InputMismatchException e){
                System.out.println("Недопустимое число года");
                return;
            }
            System.out.println(year%4==0 &&  year%100!=0 ?"Високосный 29":"Не високосный 28");
        }
    }
}