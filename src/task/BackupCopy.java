package task;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


public class BackupCopy {

    public  void createBackupCopy(String sourceDir, String backupDir) throws IOException {
        Path sourcePath = Paths.get(sourceDir);
        Path backupPath = Paths.get(backupDir);
        if (!Files.exists(backupPath)) {
            Files.createDirectories(backupPath);
            System.out.println("Directory './backup' successfully created!");
        }
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourcePath)) {
            for (Path file : stream) {
                if (Files.isRegularFile(file)) {
                    Files.copy(file, backupPath.resolve(file.getFileName()), REPLACE_EXISTING);
                }
            }
        }
    }


    public void printFileslist(String path) throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        }
    }

}
