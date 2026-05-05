import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<String> generateBigBangArray(int start, int end) {
        List<String> result = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("BIG BANG");
            } else if (i % 3 == 0) {
                result.add("BIG");
            } else if (i % 5 == 0) {
                result.add("BANG");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

    public static void writeToJsonFile(List<String> data, String filePath) {
        try (FileWriter file = new FileWriter(filePath)) {

            file.write("[\n");

            for (int i = 0; i < data.size(); i++) {
                file.write("  \"" + data.get(i) + "\"");
                if (i != data.size() - 1) file.write(",");
                file.write("\n");
            }

            file.write("]");

            System.out.println("✅ File saved successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printToConsole(List<String> data) {
        System.out.println("\n=== BIG BANG OUTPUT ===");
        for (String s : data) {
            System.out.print(s + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {

        List<String> result = generateBigBangArray(1, 100);

        printToConsole(result);

        // 🔥 FORCE SAVE TO DESKTOP/case_study_versa
        String desktopPath = System.getProperty("user.home")
                + File.separator + "Desktop"
                + File.separator + "case_study_versa";

        // create folder if not exists
        File folder = new File(desktopPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String filePath = desktopPath + File.separator + "output.json";

        writeToJsonFile(result, filePath);

        System.out.println("📁 Saved at: " + filePath);
    }
}