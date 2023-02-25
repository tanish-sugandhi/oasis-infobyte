import java.util.Random;
import java.util.Scanner;
import static java.lang.Thread.sleep;


class task2 {
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // handle exception
        }
    }
    public static void front_screen(){
        String str = """
8b  8                 8                  .d88b                        w               .d88b                       
8Ybm8 8   8 8d8b.d8b. 88b. .d88b 8d8b    8P www 8   8 .d88b d88b d88b w 8d8b. .d88    8P www .d88 8d8b.d8b. .d88b 
8  "8 8b d8 8P Y8P Y8 8  8 8.dP' 8P      8b  d8 8b d8 8.dP' `Yb. `Yb. 8 8P Y8 8  8    8b  d8 8  8 8P Y8P Y8 8.dP' 
8   8 `Y8P8 8   8   8 88P' `Y88P 8       `Y88P' `Y8P8 `Y88P Y88P Y88P 8 8   8 `Y88    `Y88P' `Y88 8   8   8 `Y88P 
                                                                              wwdP                                
""";

        System.out.println(Colors.RED_BOLD);
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i));
            try {
                sleep(2);
            } catch (InterruptedException e) {
                int a;
            }
        }
        System.out.println(Colors.RESET);
    }
    public static void rules(){
        System.out.print(Colors.CYAN_BOLD);
        System.out.println("Rules Of Game :-\n");
        System.out.println("1) User have only 3 choices :(");
        System.out.println("2) You need to guess the number in range of 1-100 ;)");
        System.out.println("3) After 3 Chance gam will over :)");
        System.out.println("4) You can replay the game ;)\n\n");
        System.out.print(Colors.RESET);
    }
    public static void game(){
        clearConsole();
        Random random = new Random();
        int number = random.nextInt(100) ;
        Scanner sc = new Scanner(System.in);

        front_screen();
        rules();
        System.out.print("--> Your Guess (1/3): "+Colors.GREEN_BRIGHT);
        int guess = sc.nextInt();
        System.out.println(Colors.RESET);
        int attempts = 3;
        while (guess != number && attempts > 1) {
            if (guess > number) {
                System.out.print(Colors.RED);
                System.out.println("*-----------------------------------*");
                System.out.println("|The number you entered is too high.|");
                System.out.println("*-----------------------------------*\n");
                System.out.println(Colors.RESET);
            } else {
                System.out.print(Colors.RED);
                System.out.println("*----------------------------------*");
                System.out.println("|The number you entered is too low.|");
                System.out.println("*----------------------------------*\n");
                System.out.println(Colors.RESET);
            }
            System.out.print("--> Your Guess ("+(5-attempts)+"/3): "+Colors.GREEN_BRIGHT);
            guess = sc.nextInt();
            System.out.println(Colors.RESET);
            attempts--;
        }

        if (guess == number) {
            System.out.println(Colors.GREEN_BOLD);
            System.out.println("*------------------------------------------------------*");
            System.out.println("|Congratulations, you have guessed the number correctly!");
            System.out.println("*------------------------------------------------------*");
            System.out.println(Colors.RESET);
        }
        else {
            String game_over = """
                    
                     _______ _______ __   __ _______    _______ __   __ _______ ______  \s
                    |       |   _   |  |_|  |       |  |       |  | |  |       |    _ | \s
                    |    ___|  |_|  |       |    ___|  |   _   |  |_|  |    ___|   | || \s
                    |   | __|       |       |   |___   |  | |  |       |   |___|   |_||_\s
                    |   ||  |       |       |    ___|  |  |_|  |       |    ___|    __  |
                    |   |_| |   _   | ||_|| |   |___   |       ||     ||   |___|   |  | |
                    |_______|__| |__|_|   |_|_______|  |_______| |___| |_______|___|  |_|
                    """;

            System.out.println(Colors.RED+game_over+Colors.RESET);
            System.out.println(Colors.BLUE_BOLD);
            System.out.println("*-------------------------*");
            System.out.println("|The target number was: "+number+"|");
            System.out.println("*-------------------------*\n");
            System.out.println(Colors.RESET);

            rerun_ask();
        }
    }
    public static void rerun_ask(){
        Scanner scan = new Scanner(System.in);
        System.out.print(Colors.PURPLE_BRIGHT);
        System.out.print("\n\n#) Do you want to rerun (y/n): ");
        System.out.print(Colors.RESET);
        String ask = scan.nextLine();
        if(ask.contains("Y")||ask.contains("y")){
            game();
        }
    }
    public static void main(String[] args) {
        game();
    }
}
class Colors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
}