import task.BackupCopy;
import task.Game;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // Task 1 - 'backup'
        System.out.println();
        BackupCopy backupCopy = new BackupCopy();
        System.out.println("Directory for backup:");
        backupCopy.printFileslist("./source");
        System.out.println("-------------------------------");
        backupCopy.createBackupCopy("./source", "./backup");
        System.out.println("Backup of all files in a directory './source' (without subdirectories):");
        backupCopy.printFileslist("./backup");

        // Task 2 - 'tic-tac-toe'
        System.out.println();
        String gameFileName = "src/resources/tic-tac-toe";
        Game gameWriter = new Game();
        gameWriter.writeGameToFile(gameFileName);
        gameWriter.printSizeOfFile(gameFileName);
    }
}