package calculator;

import java.util.Objects;
import java.util.Scanner;

public class TeachbaseMethods {

    static int result;

    public static TeachbaseMethods introduceMenu()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Ввести пример");
        System.out.println("3. Выход");
        String choice=input.nextLine();
        if (Objects.equals(choice, "1"))
        { parseFirstExample();
            input.close();}
        if (Objects.equals(choice, "3"))
        {
            System.exit(0);
            return null;
        }
        else
        {  System.out.println("Введены некорректные данные. Повторите ввод");
            return introduceMenu();}
    }

    public static TeachbaseMethods mainContinueMenu()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Ввести пример");
        System.out.println("2. Продолжить работать с предыдущим ответом");
        System.out.println("3. Выход");
        String choice=input.nextLine();
        if (Objects.equals(choice, "1") )
        {
            parseFirstExample();}
        if (Objects.equals(choice, "2"))
        {
            return operatorMenu();}
        if (Objects.equals(choice, "3"))
        {   System.exit(0);
            return null;}
        else
        {  System.out.println("Введены некорректные данные. Повторите ввод");
            return mainContinueMenu();}
    }

    public static TeachbaseMethods operatorMenu()
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
            return mainContinueMenu();
        }
        else
        {  System.out.println("Введены некорректные данные. Повторите ввод");
            return operatorMenu();
        }


    }



    public static TeachbaseMethods operation (int operationInt)
    {
        int a = result;
        int b = getNextInt();
        switch (operationInt){
            case 1:
                 calculatePlus(a,b);
                break;
            case 2:
                calculateMinus(a,b);
                break;
            case 3:
                calculateMultiply(a,b);
                break;
            case 4:
                calculateDivide(a,b);
                break;
            case 5:
                calculateFactorial(a);
                break;
            case 6:
                calculateDegree(a,b);
                break;
            case 7:
               calculateComparison(a,b);
               introduceMenu();
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                operation (operationInt);
        }
        return mainContinueMenu();
    }

    public static int parseFirstExample()
    {
        System.out.println("Введите два целых числа и оператор между ними через пробел.");
        Scanner input = new Scanner(System.in);
        String string=input.nextLine();
        String[] words = string.split(" ");
        int a = Integer.parseInt(words[0]);
        int b = Integer.parseInt(words[2]);
        String operator = words[1];
        if (Objects.equals(operator, "+") )
        {calculatePlus(a, b);
            mainContinueMenu();
            }
        if  (Objects.equals(operator, "-"))
        {calculateMinus(a, b);
        mainContinueMenu();
        }
        if (Objects.equals(operator, "*"))
        {calculateMultiply(a, b);
        mainContinueMenu();}
        if (Objects.equals(operator, "/"))
        {calculateDivide(a, b);
        mainContinueMenu();}
        if (Objects.equals(operator, "!"))
        {calculateFactorial(a);
        mainContinueMenu();}
        if (Objects.equals(operator, "^"))
        {calculateDegree(a, b);
        mainContinueMenu();}
        if (Objects.equals(operator, "?")) {
            calculateComparison(a, b);
        mainContinueMenu();}
        else
            System.out.println("Введен некорректный пример. Введите два целых числа и оператор между ними через пробел.");
        parseFirstExample();
        return a;
    }

    private static void calculateComparison(int a, int b) {
        if (a == b)
        {System.out.println("\"?\" -  " + a + " ? " + b + " = " + a + " == " + b);
            introduceMenu();}
        if (a >= b)
        {System.out.println("\"?\" -  " + a + " ? " + b + " = " + a + " > " + b);
            introduceMenu();}
        if (a <= b)
        {System.out.println("\"?\" -  " + a + " ? " + b + " = " + a + " < " + b);
            introduceMenu();}
    }



    private static int calculateDegree(int a, int b) {
        result = (int) Math.pow(a,b);
        System.out.println("\"^\" -  "  + a + " ^ " + b + " = " + result );
        return result;
    }

    private static int calculateFactorial(int a) {


        if(a<=1)
            result = 1;
        else
            result = 1;
        for (int i = 1; i <= a; i++) {
            result = result * i;
        }
        System.out.println("\"!\" -  ! "  + a + " = " + result );
        return result;
    }

    private static int calculateDivide(int a, int b) {
        result = a/b;
        System.out.println("\"/\" -  "  + a + " / " + b + " = " + result );
        return result;
    }

    private static int calculateMultiply(int a, int b) {
        result = a * b;
        System.out.println("\"*\" -  "  + a + " * " + b + " = " + result);
        return result;
    }

    private static int calculateMinus(int a, int b) {
        result = a -  b;
        System.out.println("\"-\" -  "  + a + " - " + b + " = " + result);
        return result;
    }

    private static int calculatePlus(int a, int b) {
        result = a + b;
        System.out.println("\"+\" -  "  + a + " + " + b + " = " + result );
        return result;
    }

    public static int getNextInt(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите целое число:");
        int num;
        if(input.hasNextInt()){
            num = input.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            input.next();
            num = getNextInt();
        }
        return num;
    }


}
