import java.util.*;
import java.lang.*;
class Claculator
{
    static boolean divideByZero = false;
    private static int precedence(String s)
    {
        if(s.equals("/") || s.equals("*") || s.equals("%"))
        {
            return 2;
        }
        if(s.equals("+") || s.equals("-"))
        {
            return 1;
        }
        return 0;
    }
    private static String infixToPostfix(String[] tokens)
    {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(String s : tokens)
        {
            if(s.matches("-?\\d+(\\.\\d+)?"))
            {
                sb.append(s);
                sb.append(" ");
            }
            else
            {
                // System.out.println("ch->"+ch);
                if(st.isEmpty() || s == "()" || st.peek() == "("|| (precedence(s) > precedence(st.peek())))
                {
                    st.push(s);
                }
                else if(precedence(s)!=0 & precedence(st.peek()) >= precedence(s))
                {
                    while(!st.isEmpty() && precedence(s) <= precedence(st.peek()))
                    {
                        sb.append(st.pop());
                        sb.append(" ");
                    }
                    st.push(s);
                }
                else if(s == ")")
                {
                    while(st.peek()!="(")
                    {
                        sb.append(st.pop());
                        sb.append(" ");
                    }
                    st.pop();
                }
                else if(precedence(s)==0)
                {
                    return "INVALID_EXPRESSION";
                }
            }
        }
        while(!st.isEmpty())
        {
            sb.append(st.pop());
            sb.append(" ");
        }
        return sb.toString();
    }
    private static double evaluatePostfix(String postfix)
    {
        String[] tokens = postfix.split(" ");
        double ans = 0;
        Stack<Double> st = new Stack<>();
        for(String s : tokens)
        {
            if(s.matches("-?\\d+(\\.\\d+)?"))
            {
                st.push(Double.parseDouble(s));
            }
            else{
                Double num1,num2,val;
                switch(s)
                {
                    case "+": 
                    num2 = st.pop();
                    num1 = st.pop();
                    val = num1+num2;
                    ans = val;
                    st.push(ans);
                    break;
                    case "-": 
                    num2 = st.pop();
                    num1 = st.pop();
                    val = num1-num2;
                    ans = val;
                    st.push(ans);
                    break;
                    case "*": 
                    num2 = st.pop();
                    num1 = st.pop();
                    val = num1*num2;
                    ans = val;
                    st.push(ans);
                    break;
                    case "/": 
                    num2 = st.pop();
                    num1 = st.pop();
                    try {
                        val = num1/num2;
                        ans = val;
                        st.push(ans);
                    } catch (Exception e) {
                        System.out.println("Divide By Zero");
                    }
                    break;
                } 
            }
        }
        return ans;

    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter your expression with sapce seperated by each number and operator \n eg: 2 + 45 / 56 * 21 :");
        String str = input.nextLine();
        String[] tokens = str.split(" ");
        String postfix = infixToPostfix(tokens);
        if(postfix.equals("INVALID_EXPRESSION"))
        {
            System.out.println("INVALID_EXPRESSION");
            return ;
        }
        double ans = evaluatePostfix(postfix);
        System.out.println("ANS: "+ans); 
    }


}
