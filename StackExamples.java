import java.util.Scanner;
import java.util.Stack;

public class StackExamples {
    public static boolean noProblem = false;
    public static int choice = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] options = {
                "1: Function that corrects a pathway for you",
                "2: Function that removes two letters that are next to each other"
        };
        for(String option: options){
            System.out.println(option);

        }
        System.out.println("Enter in the integer that represents the function you want to use: ");
        try{
            choice = scanner.nextInt();
            noProblem = true;
        } catch(Exception e){
            System.out.println("You did not enter in an integer");
        }


        if(noProblem){
            if(choice == 1){
                System.out.println("Please Enter Pathway to file: ");
                String path = scanner.nextLine();
                path = simplifyPath(path);
                System.out.println("The correct pathway is the following: " + path);
            } else if(choice == 2){
                System.out.print(" Please Enter a String in: ");
                String s = scanner.next();
                s = makeGood(s);
                System.out.println("The correct string is the following: " + s);

            }
        }


    }
    public static String simplifyPath(String path){
        Stack<String> stack = new Stack<>();
        String [] items = path.split("/");

        for(String item: items){
            if(item.isEmpty()){
            } else if(item.equals("..")){
                if(!stack.empty())
                    stack.pop();
            }
            else{
                stack.add(item);
            }

        }

        StringBuilder sb = new StringBuilder();
        for(String name: stack){
            sb.append("/");
            sb.append(name);
        }
        return sb.toString().length() > 0 ? sb.toString(): "/";
    }

    public static String makeGood(String s){
        Stack <Character> stack = new Stack<>();
        for (Character character: s.toCharArray()){
            if (!stack.isEmpty() && Math.abs(stack.lastElement() - character) == 32)
                stack.pop();
            else
                stack.add(character);
        }
        StringBuilder ans = new StringBuilder();
        for (char currChar : stack)
            ans.append(currChar);
        return ans.toString();
    }
}
