package ru.derevenskikh.TraineeTest.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.derevenskikh.TraineeTest.dao.FileDAO;
import ru.derevenskikh.TraineeTest.dto.AllValuesDTO;
import ru.derevenskikh.TraineeTest.utils.NoSequenceException;
import ru.derevenskikh.TraineeTest.utils.PathObject;

import java.util.*;

@Service
public class FileService {
    private final FileDAO fileDAO;
    private final AllValuesDTO allValuesDTO;
    private String checkSum;

    @Autowired
    public FileService(FileDAO fileDAO, AllValuesDTO allValuesDTO) {
        this.fileDAO = fileDAO;
        this.allValuesDTO = allValuesDTO;
    }

    public int getMaxValue(String path) {
        return Integer.parseInt(Collections.max(new ArrayList(fileDAO.getListOfIntegers(path))).toString());
    }

    public int getMinValue(String path) {
        return Integer.parseInt(Collections.min(new ArrayList(fileDAO.getListOfIntegers(path))).toString());
    }

    public double getMedian(String path) {
        int[] numArray = fileDAO.getListOfIntegers(path).stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(numArray);
        double median;
        if (numArray.length % 2 == 0)
            median = ((double) numArray[numArray.length / 2] + (double) numArray[numArray.length / 2 - 1]) / 2;
        else
            median = numArray[numArray.length / 2];
        return median;
    }

    public double getAverage(String path) {
        OptionalDouble average = Arrays.stream(fileDAO.getListOfIntegers(path).stream().mapToInt(Integer::intValue).toArray()).average();
        return average.getAsDouble();
    }

    public List<List<Integer>> getIncrSequence(String path) {
        return getSequence(path, true);
    }

    public List<List<Integer>> getDecrSequence(String path) {
        return getSequence(path, false);
    }

    private List<List<Integer>> getSequence(String path, boolean isIncrease) {
        int[] numArray = fileDAO.getListOfIntegers(path).stream().mapToInt(Integer::intValue).toArray();

        List<Integer> position = new ArrayList<>();  // Хранение позиций

        int maxIncr = 0;
        int currentIncr = 0;

        for (int i = 1; numArray.length > i; i++) {
            if (isIncrease ? (numArray[i - 1] < numArray[i]) : (numArray[i - 1] > numArray[i])) {
                currentIncr++;
            } else {
                currentIncr = 0;
            }
            if (maxIncr < currentIncr) {
                position.clear();
                position.add(i - currentIncr);
                maxIncr = currentIncr;
            } else if (currentIncr != 0 && (maxIncr == currentIncr)) {
                position.add(i - currentIncr);
            }
        }
        if (position.isEmpty()) {
            throw new NoSequenceException(isIncrease);
        }
        List<List<Integer>> resultSequences = new ArrayList<>();
        for (int pos : position) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; maxIncr >= i; i++) {
                list.add(numArray[pos + i]);
            }
            resultSequences.add(list);
        }
        return resultSequences;
    }

    @SneakyThrows
    @Cacheable(value = "allValues", key = "#pathObject.getCheckSum()")
    public AllValuesDTO getAllValuesDTO(PathObject pathObject){
        Thread.sleep(2000); //проверка работы кэширования
        if(checkSum == null){
            checkSum = pathObject.getCheckSum();
        }
        if(!checkSum.equals(pathObject.getCheckSum())){
            allValuesDTO.dropValues();
        }
        return allValuesDTO;
    }
}
