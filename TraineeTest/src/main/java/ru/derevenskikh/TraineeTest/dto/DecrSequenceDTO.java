package ru.derevenskikh.TraineeTest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class DecrSequenceDTO {
    private List<List<Integer>> decr_sequence;
}
