package ru.derevenskikh.TraineeTest.dao;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
@Component

public class FileDAO {
    @SneakyThrows
    public List<Integer> getListOfIntegers(String path) {
        List<String> strings = Files.readAllLines(Path.of(path));
        return strings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
