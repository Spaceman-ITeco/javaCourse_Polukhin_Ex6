package calculator;

import java.util.Objects;
import java.util.Scanner;

public class Methods {

   public static Methods mainMenu()
   {
       Scanner input = new Scanner(System.in);
       System.out.println("1. Ввести пример");
       System.out.println("3. Выход");
       String choice=input.nextLine();
       if (Objects.equals(choice, "1"))
       { parseExample();}
       if (Objects.equals(choice, "3"))
       {
           return null;
       }
       else
       {  System.out.println("Введены некорректные данные. Повторите ввод");
       return mainMenu();}

   }

    public static Methods mainMenuContinue()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Ввести пример");
        System.out.println("2. Продолжить работать с предыдущим ответом");
        System.out.println("3. Выход");
        String choice=input.nextLine();
        if (Objects.equals(choice, "1") )
        {
            parseExample();}
        if (Objects.equals(choice, "2"))
        {
            return operationMenu();}
        if (Objects.equals(choice, "3"))
        {   System.exit(0);
            return null;}
        else
        {  System.out.println("Введены некорректные данные. Повторите ввод");
            return mainMenuContinue();}
    }

    public static Methods operationMenu()
    {
        int choiceOperationInt=0;
        Scanner input = new Scanner(System.in);
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        System.out.println("5. Факториал");
        System.out.println("6. Возведение в степень");
        System.out.println("7. Сравнение");
        System.out.println("8. Назад");
        String choiceOperation=input.nextLine();
        if (Objects.equals(choiceOperation, "1") || Objects.equals(choiceOperation, "2")
                || Objects.equals(choiceOperation, "3") || Objects.equals(choiceOperation, "4")
                || Objects.equals(choiceOperation, "5") || Objects.equals(choiceOperation, "6")
                || Objects.equals(choiceOperation, "7")
        )
        {choiceOperationInt = Integer.parseInt(choiceOperation);
            System.out.println(choiceOperationInt);
            return operation(choiceOperationInt);}
        if (Objects.equals(choiceOperation, "8")) {
            return mainMenuContinue();
        }
        else
        {  System.out.println("Введены некорректные данные. Повторите ввод");
            return operationMenu();
        }


    }

    public static Methods operation (int operationInt)
    {
        String operator="";
        int a= 0;
        int b = getInt();
        switch (operationInt){
            case 1:
                operator = "+";
                break;
            case 2:
                operator = "-";
                break;
            case 3:
                operator = "*";
                break;
            case 4:
                operator = "/";
                break;
            case 5:
                operator = "!";
                break;
            case 6:
                operator = "^";
                break;
            case 7:
                operator = "?";
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                operation (operationInt);
        }
        calculate(a, b, operator);
        return null;
    }

    public  static void calculate(int a, int b, String operator)
    {
        int result = 0;
        switch (operator){
            case "+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "*":
                result = a*b;
                break;
            case "/":
                result = a/b;
                break;
            case "!":
                if(a<=1)
                result = 1;
                else
                    result = 1;
                for (int i = 1; i <= a; i++) {
                    result = result * i;
                }
                break;
            case "^":
                result = (int) Math.pow(a,b);
                break;
//       case "?":

//           break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");

        }
        System.out.printf("%s ",  operator + " " + a + " " + operator + " " + b + " = " + result);
        System.out.println();

    }


    public static  void parseExample()
    {
        System.out.println("Введите два целых числа и оператор между ними через пробел.");
        Scanner input = new Scanner(System.in);
        String string=input.nextLine();
        String[] words = string.split(" ");
        int a = Integer.parseInt(words[0]);
        int b = Integer.parseInt(words[2]);
        String operator = words[1];
        if (Objects.equals(operator, "+") || Objects.equals(operator, "-")
                || Objects.equals(operator, "*") || Objects.equals(operator, "/")
                || Objects.equals(operator, "!") || Objects.equals(operator, "^")
                || Objects.equals(operator, "?")
        ) {
            calculate(a, b, operator);
            mainMenuContinue();
        }
       else
          System.out.println("Введен некорректный пример. Введите два целых числа и оператор между ними через пробел.");
        parseExample();
    }

    public static int getInt(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите целое число:");
        int num;
        if(input.hasNextInt()){
            num = input.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            input.next();
            num = getInt();
        }
        return num;
    }

    public static int getResultInt(int a)
    {
        return a;
    }

}
