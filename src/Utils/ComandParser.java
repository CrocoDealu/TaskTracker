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

    public static String[] parse(String args, CommandStrategy commandStrategy) {
        switch (commandStrategy) {
            case ADD -> {
                return parseAdd(args);
            }
            case UPDATE -> {
                return parseUpdate(args);
            }
            case DELETE -> {
                return parseDelete(args);
            }
            case MARK_DONE -> {
                return parseMarkDone(args);
            }
            case MARK_IN_PROGRESS -> {
                return parseMarkInProgress(args);
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

    private static String[] parseMarkDone(String args) {
        String[] cut = args.split(" ");

        if (cut.length == 2) {
            String tid = cut[1];

            try {
                Integer.parseInt(tid);
            } catch (NumberFormatException e) {
                throw new RuntimeException("The ID is not a valid integer.");
            }
            return new String[]{tid};
        }
        throw new RuntimeException("use case: mark-done 1(tid)");
    }

    private static String[] parseMarkInProgress(String args) {
        String[] cut = args.split(" ");

        if (cut.length == 2) {
            String tid = cut[1];

            try {
                Integer.parseInt(tid);
            } catch (NumberFormatException e) {
                throw new RuntimeException("The ID is not a valid integer.");
            }
            return new String[]{tid};
        }
        throw new RuntimeException("use case: mark-in-progress 1(tid)");
    }

    private static String[] parseUpdate(String args) {
        String[] cut = args.split(" ");

        if (cut.length >= 3) {
            String[] result = new String[2];
            String tid = cut[1];
            String newDescription = args.substring(args.indexOf('"'), args.lastIndexOf('"') + 1);

            try {
                Integer.parseInt(tid);
            } catch (NumberFormatException e) {
                throw new RuntimeException("The ID is not a valid integer.");
            }

            if (!newDescription.startsWith("\"") || !newDescription.endsWith("\"")) {
                throw new RuntimeException("Description must be surrounded by double quotes.");
            }
            newDescription = newDescription.substring(1, newDescription.length() - 1);

            result[0] = tid;
            result[1] = newDescription;
            return result;
        }
        throw new RuntimeException("use case: update 1(tid) \"new description\"");
    }

    private static String[] parseDelete(String args) {
        String[] cut = args.split(" ");
        if (cut.length == 2) {
            String s = cut[1];
            return new String[]{s};
        }
        throw new RuntimeException("use case: delete \"int\" \n");
    }

    private static String[] parseAdd(String args)  {
        int firstIndex = args.indexOf('"');
        int lastIndex = args.lastIndexOf('"');
        if (firstIndex == -1
                || lastIndex == -1
                || firstIndex == lastIndex
                || (lastIndex + 1 != args.length()))
            throw new RuntimeException("use case: add \"task description\"\n");

        return new String[]{args.substring(firstIndex + 1, lastIndex)};
    }
}