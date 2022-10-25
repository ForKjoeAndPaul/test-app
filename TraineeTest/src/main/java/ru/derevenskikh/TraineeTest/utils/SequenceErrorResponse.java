package ru.derevenskikh.TraineeTest.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SequenceErrorResponse {
    private String message;
    private long timestamp;
}
