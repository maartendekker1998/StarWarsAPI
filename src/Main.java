public class Main {

    public static void main(String[] args) {

        ArgumentSwitcher argumentSwitcher = new ArgumentSwitcher();

        //if no arguments are given, show how to get help and exit program
        if (args.length == 0) {
            System.out.println("no parameters, enter help as parameter for manual");
            return;
        }
        //the program manual
        if (args[0].equalsIgnoreCase("help")) {
            System.out.println("For getting all results in a category");
            System.out.println("usage: [category]");
            System.out.println("");
            System.out.println("For searching in results in a category");
            System.out.println("usage: [category]  [search]");
            System.out.println("");
            System.out.println("[category] : films, planets, starships");
            System.out.println("[search] you can search on following fields per category");
            System.out.println("");
            System.out.println("films : title");
            System.out.println("planets : name");
            System.out.println("starships : name, model");
            return;
        }
        //get all in category
        if (args.length == 1) {
            argumentSwitcher.switcher(args[0], null);
            return;
        }
        //get search in category
        if (args.length == 2) {
            argumentSwitcher.switcher(args[0], args[1]);
            return;

        }
    }
}
