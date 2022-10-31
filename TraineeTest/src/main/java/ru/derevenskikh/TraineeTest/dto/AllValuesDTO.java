package ru.derevenskikh.TraineeTest.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AllValuesDTO {

    private MaxValueDTO maxValueDTO;
    private MinValueDTO minValueDTO;
    private AverageValueDTO averageValueDTO;
    private MedianValueDTO medianValueDTO;
    private IncrSequenceDTO incrSequenceDTO;
    private DecrSequenceDTO decrSequenceDTO;

    public void dropValues(){
        setMaxValueDTO(null);
        setMinValueDTO(null);
        setAverageValueDTO(null);
        setMedianValueDTO(null);
        setIncrSequenceDTO(null);
        setDecrSequenceDTO(null);
    }
}
