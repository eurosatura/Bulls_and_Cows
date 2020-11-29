import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        String url = scan.nextLine();
        String[] urlSplitted = url.split("\\?");
        String password = "";
        for (String pairs : urlSplitted[1].split("&")) {
            String[] params = pairs.split("//?");

            if (params[0].substring(params[0].length()- 1).equals("=")) {
                System.out.println(params[0].substring(0, params[0].length() - 1 ) + " : not found");
            } else {
                String[] keyValue = params[0].split("=");
                if (keyValue[0].equals("pass")) {
                    password = keyValue[1];
                    System.out.println(keyValue[0] + " : " + keyValue[1]);
                } else {
                    System.out.println(keyValue[0] + " : " + keyValue[1]);
                }
            }
        }

        if (!password.equals("")) {
            System.out.println("password : " + password);
        }

    }
}