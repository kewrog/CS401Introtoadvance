package lab7part2;

 
	import java.util.Stack;
	public class infixtopostfix {
	    public static String convert(String expression) {
	        StringBuilder result = new StringBuilder();
	        Stack<Character> stack = new Stack<>();
	        for (char c : expression.toCharArray()) {
	            if (Character.isDigit(c)) {
	                result.append(c);
	            } else if (c == '(') {
	                stack.push(c);
	            } else if (c == ')') {
	                while (!stack.isEmpty() && stack.peek() != '(') {
	                    result.append(stack.pop());
	                }
	                stack.pop();
	            } else {
	                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
	                    result.append(stack.pop());
	                }
	                stack.push(c);
	            }
	        }
	        while (!stack.isEmpty()) {
	            if (stack.peek() == '(') return "Invalid Expression";
	            result.append(stack.pop());
	        }
	        return result.toString();
	    }

	    private static int precedence(char ch) {
	        switch (ch) {
	            case '+':
	            case '-':
	                return 1;
	            case '*':
	            case '/':
	                return 2;
	        }
	        return -1;
	    }
	}


