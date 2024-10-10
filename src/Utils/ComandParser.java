package Utils;

import java.io.IOException;

import Enum.CommandStrategy;

public final class ComandParser {
    private static ComandParser comandParser;

    private ComandParser() {}

    public static ComandParser getInstance() {
        if (comandParser == null)
            comandParser = new ComandParser();
        return comandParser;
    }

    public static String parse(String args, CommandStrategy commandStrategy) throws IOException {
        switch (commandStrategy) {
            case ADD -> {
                return parseAdd(args);
            }
            case MODIFY -> {
                return null;
            }
            case DELETE -> {
                return null;
            }
            case MARK_DONE -> {
                return null;
            }
            case MARK_IN_PROGRESS -> {
                return null;
            }
            case LIST -> {
                return null;
            }
            case LIST_DONE -> {
                return null;
            }
            case LIST_TODO -> {
                return null;
            }
            case LIST_IN_PROGRESS -> {
                return null;
            }
            default -> {
                System.out.println("Command unknoun\n");
                return null;
            }
        }
    }

    private static String parseAdd(String args) throws IOException {
        /*
        returns: a string array of size 1 with the task description
         */
        int firstIndex = args.indexOf('"');
        int lastIndex = args.lastIndexOf('"');
        String[] cut = args.split(" ");
        if (cut.length < 2
                || firstIndex == -1
                || lastIndex == -1
                || !cut[0].equalsIgnoreCase("add")
                || firstIndex == lastIndex
                || (lastIndex + 1 != args.length()))
            throw new IOException("use case: add \"task description\"\n");

        return args.substring(firstIndex + 1, lastIndex);
    }
}


/*


 */