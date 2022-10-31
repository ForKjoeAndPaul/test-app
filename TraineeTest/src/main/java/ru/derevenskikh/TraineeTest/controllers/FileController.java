package ru.derevenskikh.TraineeTest.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.derevenskikh.TraineeTest.dto.*;
import ru.derevenskikh.TraineeTest.services.FileService;
import ru.derevenskikh.TraineeTest.utils.NoSequenceException;
import ru.derevenskikh.TraineeTest.utils.PathObject;
import ru.derevenskikh.TraineeTest.utils.SequenceErrorResponse;

@RestController
@RequestMapping("/actions")
@Api("Контроллер для иллюстрации работы программы")
public class FileController {
    private final FileService fileService;
    private final AllValuesDTO allValuesDTO;

    @Autowired
    public FileController(FileService fileService, AllValuesDTO allValuesDTO) {
        this.fileService = fileService;
        this.allValuesDTO = allValuesDTO;
    }

    @PostMapping(value = "/get_max_value", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение максимального значения")
    public ResponseEntity<MaxValueDTO> getMaxValue(@RequestBody PathObject pathObject) {
        allValuesDTO.setMaxValueDTO(new MaxValueDTO(fileService.getMaxValue(pathObject.getFilePath())));
        return new ResponseEntity<>(allValuesDTO.getMaxValueDTO(), HttpStatus.OK);
    }

    @PostMapping(value = "/get_min_value", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение минимального значения")
    public ResponseEntity<MinValueDTO> getMinValue(@RequestBody PathObject pathObject) {
        allValuesDTO.setMinValueDTO(new MinValueDTO(fileService.getMinValue(pathObject.getFilePath())));
        return new ResponseEntity<>(allValuesDTO.getMinValueDTO(), HttpStatus.OK);
    }

    @PostMapping(value = "/get_median_value", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение медианы")
    public ResponseEntity<MedianValueDTO> getMedian(@RequestBody PathObject pathObject) {
        allValuesDTO.setMedianValueDTO(new MedianValueDTO(fileService.getMedian(pathObject.getFilePath())));
        return new ResponseEntity<>(allValuesDTO.getMedianValueDTO(), HttpStatus.OK);
    }

    @PostMapping(value = "/get_average_value", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение среднего арифметического значения")
    public ResponseEntity<AverageValueDTO> getAverage(@RequestBody PathObject pathObject) {
        allValuesDTO.setAverageValueDTO(new AverageValueDTO(fileService.getAverage(pathObject.getFilePath())));
        return new ResponseEntity<>(allValuesDTO.getAverageValueDTO(), HttpStatus.OK);
    }

    @PostMapping(value = "/get_incr_seq", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение самой длинной последовательности идущих подряд чисел, которая увеличивается")
    public ResponseEntity<IncrSequenceDTO> getIncrSequence(@RequestBody PathObject pathObject) {
        allValuesDTO.setIncrSequenceDTO(new IncrSequenceDTO(fileService.getIncrSequence(pathObject.getFilePath())));
        return new ResponseEntity<>(allValuesDTO.getIncrSequenceDTO(), HttpStatus.OK);
    }

    @PostMapping(value = "/get_decr_seq", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение самой длинной последовательности идущих подряд чисел, которая уменьшается")
    public ResponseEntity<DecrSequenceDTO> getDecrSequence(@RequestBody PathObject pathObject) {
        allValuesDTO.setDecrSequenceDTO(new DecrSequenceDTO(fileService.getDecrSequence(pathObject.getFilePath())));
        return new ResponseEntity<>(allValuesDTO.getDecrSequenceDTO(), HttpStatus.OK);
    }

    @PostMapping(value = "/get_all_values", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение всех значений c кэшированием результата")
    public ResponseEntity<AllValuesDTO> getAllValuesDTO(@RequestBody PathObject pathObject){
        return new ResponseEntity<>(fileService.getAllValuesDTO(pathObject), HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<SequenceErrorResponse> handleException(NoSequenceException e){
        String sequenceType = e.isIncrease() ? "Возрастающих" : "Убывающих";
        SequenceErrorResponse response =
                new SequenceErrorResponse(sequenceType + " последовательностей не найдено", System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
