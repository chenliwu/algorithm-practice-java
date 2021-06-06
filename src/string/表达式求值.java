package string;

import java.util.*;

/**
 * 表达式求值
 *
 * @author chenlw 2021-06-06
 * @since 1.0.0
 */
public class 表达式求值 {

    public static void main(String[] args) {
        String exp = "(56-20)/(4+2)";
        String postExp = trans(exp);
        System.out.println(postExp);
        System.out.println("计算结果：" + comValue(postExp));
    }

    static float comValue(String postExp) {
        // 运算数栈
        Stack<Float> opNumberStack = new Stack<>();
        char[] chars = postExp.toCharArray();
        int len = chars.length;
        int index = 0;
        float a, b, c, d;
        while (index < len) {
            char ch = chars[index];
            switch (ch) {
                case '+':
                    // 退栈取数
                    a = opNumberStack.pop();
                    b = opNumberStack.pop();
                    c = a + b;
                    // 将计算结果进栈
                    opNumberStack.push(c);
                    break;
                case '-':
                    a = opNumberStack.pop();
                    b = opNumberStack.pop();
                    c = b - a;
                    // 将计算结果进栈
                    opNumberStack.push(c);
                    break;
                case '*':
                    a = opNumberStack.pop();
                    b = opNumberStack.pop();
                    c = a * b;
                    // 将计算结果进栈
                    opNumberStack.push(c);
                    break;
                case '/':
                    a = opNumberStack.pop();
                    b = opNumberStack.pop();
                    if (a != 0) {
                        c = b / a;
                        // 将计算结果进栈
                        opNumberStack.push(c);
                    } else {
                        System.out.println("除数不能为0");
                        throw new RuntimeException();
                    }
                    break;
                // 处理数字字符
                default:
                    d = 0;
                    while (Character.isDigit(ch)) {
                        d = d * 10 + Float.parseFloat(String.valueOf(ch));
                        ch = chars[++index];
                    }
                    System.out.println("运算数：" + d);
                    // 运算数进栈
                    opNumberStack.push(d);
                    break;
            }
            index++;
        }
        return opNumberStack.peek();
    }

    /**
     * 将算术表达式转化为后缀表达式
     *
     * @param exp
     */
    static String trans(String exp) {
        Stack<Character> opStack = new Stack<>();
        opStack.push('=');

        char[] chars = exp.toCharArray();
        int len = chars.length;
        int index = 0;
        // 后缀表达式
        StringBuilder postExp = new StringBuilder();
        while (index < len) {
            char ch = chars[index];
            if (isOperator(ch)) {
                // 比较栈顶运算符的优先级
                switch (precede(opStack.peek(), ch)) {
                    // 栈顶运算符优先级比ch低
                    case -1:
                        // 运算符ch进栈
                        opStack.push(ch);
                        index++;
                        break;
                    // 栈顶运算符优先级与ch相同
                    case 0:
                        // 只有括号满足这种情况，将(退栈
                        opStack.pop();
                        index++;
                        break;
                    // 栈顶运算符优先级比ch高
                    case 1:
                        // 栈顶运算符要先执行，退栈运算符并将其放到postexp中
                        postExp.append(opStack.pop());
                        break;
                }
            } else {
                // ch为数字
                while (Character.isDigit(ch)) {
                    postExp.append(ch);
                    ch = chars[++index];
                }
                postExp.append("#");
            }
        }
        // exp扫描完毕，退栈到=为止
        while (opStack.peek() != '=') {
            postExp.append(opStack.pop());
        }
        return postExp.toString();
    }

    static class ExpressItem {
        public String operator;
        public Integer number;
        /**
         * type=0,是数字；type=1是运算符
         */
        public int type;
    }


    /**
     * 设置运算符优先级
     */
    static List<OperatorPrecedence> leftPres = new ArrayList<>();
    static List<OperatorPrecedence> rightPres = new ArrayList<>();

    static {
        // 数值越大，优先级越高
        leftPres.add(new OperatorPrecedence('=', 0));
        leftPres.add(new OperatorPrecedence('(', 1));
        leftPres.add(new OperatorPrecedence('*', 5));
        leftPres.add(new OperatorPrecedence('/', 5));
        leftPres.add(new OperatorPrecedence('+', 3));
        leftPres.add(new OperatorPrecedence('-', 3));
        leftPres.add(new OperatorPrecedence(')', 6));

        rightPres.add(new OperatorPrecedence('=', 0));
        rightPres.add(new OperatorPrecedence('(', 6));
        rightPres.add(new OperatorPrecedence('*', 4));
        rightPres.add(new OperatorPrecedence('/', 4));
        rightPres.add(new OperatorPrecedence('+', 2));
        rightPres.add(new OperatorPrecedence('-', 2));
        rightPres.add(new OperatorPrecedence(')', 1));
    }

    /**
     * 获取左运算符op的优先级
     *
     * @param operator
     * @return
     */
    static int getLeftPre(char operator) {
        for (OperatorPrecedence op : leftPres) {
            if (op.operator == operator) {
                return op.pre;
            }
        }
        return -1;
    }

    /**
     * 获取右运算符op的优先级
     *
     * @param operator
     * @return
     */
    static int getRightPre(char operator) {
        for (OperatorPrecedence op : rightPres) {
            if (op.operator == operator) {
                return op.pre;
            }
        }
        return -1;
    }

    /**
     * 判断是否是运算符
     *
     * @param operator
     * @return
     */
    static boolean isOperator(char operator) {
        if (operator == '(' || operator == ')'
                || operator == '+' || operator == '-' || operator == '*' || operator == '/') {
            return true;
        }
        return false;
    }

    /**
     * 运算符优先级的比较结果
     *
     * @param leftOperator
     * @param rightOperator
     * @return
     */
    static int precede(char leftOperator, char rightOperator) {
        int leftPre = getLeftPre(leftOperator);
        int rightPre = getRightPre(rightOperator);
        if (leftPre == rightPre) {
            return 0;
        } else if (leftPre < rightPre) {
            return -1;
        }
        return 1;
    }

    /**
     * 运算符优先级
     */
    static class OperatorPrecedence {

        public OperatorPrecedence() {
        }

        public OperatorPrecedence(char operator, int pre) {
            this.operator = operator;
            this.pre = pre;
        }

        /**
         * 运算符
         */
        public char operator;

        /**
         * 优先级
         */
        public int pre;

    }


}
