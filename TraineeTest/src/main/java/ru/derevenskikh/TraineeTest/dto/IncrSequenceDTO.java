package ru.derevenskikh.TraineeTest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class IncrSequenceDTO {
    private List<List<Integer>> incr_sequence;
}
