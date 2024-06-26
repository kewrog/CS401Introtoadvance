package lab7part2;


	import java.util.Stack;

		public class postfixevaluation {
	    public static int evaluate(String expression) {
	        Stack<Integer> stack = new Stack<>();
	        for (char c : expression.toCharArray()) {
	            if (Character.isDigit(c)) {
	                stack.push(c - '0');
	            } else {
	                int val1 = stack.pop();
	                int val2 = stack.pop();
	                switch (c) {
	                    case '+':
	                        stack.push(val2 + val1);
	                        break;
	                    case '-':
	                        stack.push(val2 - val1);
	                        break;
	                    case '*':
	                        stack.push(val2 * val1);
	                        break;
	                    case '/':
	                        stack.push(val2 / val1);
	                        break;
	                }
	            }
	        }
	        return stack.pop();
	    }
	}


