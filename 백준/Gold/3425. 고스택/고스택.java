import java.util.*;
import java.io.*;

public class Main {
    static final String errorMsg = "ERROR";
    static Stack<Long> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            ArrayList<String> commandList = new ArrayList<>();
            
            while (true) {
                String command = br.readLine();
                if (command.equals("END")) {
                    break;
                } else if (command.equals("QUIT")) {
                    System.out.println(sb.toString().trim());
                    return;
                } else {
                    commandList.add(command);
                }
            }

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                long v = Long.parseLong(br.readLine());
                sb.append(commandActivate(commandList, v) + "\n");
            }
            sb.append("\n");

            br.readLine();
        }
    }

    private static String commandActivate(ArrayList<String> list, long init) {
        stack = new Stack<>();
        stack.push(init);

        for (String command : list) {
            if (command.startsWith("NUM") && num(Long.parseLong(command.split(" ")[1]))) {
            } else if (command.equals("POP") && pop()) {
            } else if (command.equals("INV") && inv()) {
            } else if (command.equals("DUP") && dup()) {
            } else if (command.equals("SWP") && swp()) {
            } else if (command.equals("ADD") && add()) {
            } else if (command.equals("SUB") && sub()) {
            } else if (command.equals("MUL") && mul()) {
            } else if (command.equals("DIV") && div()) {
            } else if (command.equals("MOD") && mod()) {
            } else {
                return errorMsg;
            }
        }

        return stack.size() == 1 ? "" + stack.pop() : errorMsg;
    }


    private static boolean num(long x) {
        stack.push(x);
        return true;
    }

    private static boolean pop() {
        if (stack.size() >= 1) {
            stack.pop();
            return true;
        }
        return false;
    }

    private static boolean inv() {
        if (stack.size() >= 1) {
            stack.push(stack.pop() * -1L);
            return true;
        }
        return false;
    }

    private static boolean dup() {
        if (stack.size() >= 1) {
            stack.push(stack.peek());
            return true;
        }
        return false;
    }

    private static boolean swp() {
        if (stack.size() >= 2) {
            long first = stack.pop();
            long second = stack.pop();
            stack.push(first);
            stack.push(second);
            return true;
        }
        return false;
    }

    private static boolean add() {
        if (stack.size() >= 2) {
            long sum = stack.pop() + stack.pop();
            if (!checkValue(Math.abs(sum))) {
                stack.push(sum);
                return true;
            }
        }
        return false;
    }

    private static boolean sub() {
        if (stack.size() >= 2) {
            long first = stack.pop();
            long second = stack.pop();
            long result = second - first;
            if (!checkValue(result)) {
                stack.push(result);
                return true;
            }
        }
        return false;
    }

    private static boolean mul() {
        if (stack.size() >= 2) {
            long result = stack.pop() * stack.pop();
            if (!checkValue(result)) {
                stack.push(result);
                return true;
            }
        }
        return false;
    }

    private static boolean div() {
        if (stack.size() >= 2) {
            long first = stack.pop();
            long second = stack.pop();
            if (first != 0) {
                long result = Math.abs(second) / Math.abs(first);
                if (first * second < 0) {
                    result *= -1L;
                }
                stack.push(result);
                return true;
            }
        }
        return false;
    }

    private static boolean mod() {
        if (stack.size() >= 2) {
            long first = stack.pop();
            long second = stack.pop();
            if (first != 0) {
                long result = Math.abs(second) % Math.abs(first);
                if (second < 1) result *= -1L;
                stack.push(result);
                return true;
            }
        }
        return false;
    }


    private static boolean checkValue(long sum) {
        return Math.abs(sum) > Math.pow(10, 9);
    }
}