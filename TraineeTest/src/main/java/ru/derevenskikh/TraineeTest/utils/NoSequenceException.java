package ru.derevenskikh.TraineeTest.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NoSequenceException  extends RuntimeException{
    private boolean isIncrease;
}
