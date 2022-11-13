public class Evaluate {
    public int evalRPN(String[] tokens) {
        if (tokens == null | tokens.length == 0) {
            return 0;
        }
        Stack<Integer> op = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                op.push(op.pop() + op.pop());
            } else if (token.equals("-")) {
                op.push(-op.pop() + op.pop());
            } else if (token.equals("*")) {
                op.push(op.pop() * op.pop());
            } else if (token.equals("/")) {
                int first = op.pop();
                int second = op.pop();
                op.push(second / first);
            } else {
                op.push(parseInt(token.toCharArray()));
            }
        }
        return op.peek();
    }

    private int parseInt(char[] nums) {
        int sum = 0;
        int i = 0;
        if (nums[0] == '-') {
            i = 1;
        }
        for (; i < nums.length; i++) {
            sum = sum * 10 + nums[i] - 48;
        }
        if (nums[0] == '-') {
            return 0 - sum;
        } else {
            return sum;
        }
    }
}       
}
