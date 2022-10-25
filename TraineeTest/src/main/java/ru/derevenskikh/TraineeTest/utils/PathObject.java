package ru.derevenskikh.TraineeTest.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PathObject {
    @JsonAlias("file_path")
    private String filePath;
}
