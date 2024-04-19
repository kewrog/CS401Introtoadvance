package lab7part2;

public class main {

	    public static void main(String[] args) {
	        String[] infixExpressions = {
	            "1+9*3",
	            "9+6-3*2+5",
	            "5+2-8/2+6-7+6*3"
	        };

	        for (String infix : infixExpressions) {
	            String postfix = infixtopostfix.convert(infix);
	            int evaluationResult = postfixevaluation.evaluate(postfix);
	            System.out.println("Infix: " + infix);
	            System.out.println("Postfix: " + postfix);
	            System.out.println("Evaluation: " + evaluationResult);
	            System.out.println();
	        }
	    }
	}


