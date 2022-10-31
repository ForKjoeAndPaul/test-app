# test-app
 RESTfullAPI

В теле HTTP POST-запроса передается путь к файлу в формает JSON: {"file_path": "C:/../test-app/TraineeTest/src/main/resources/static/10m.txt"}


Ответы приходят в формате JSON/XML

POST-запросы:
1. /actions/get_max_value - получение максимального значения

   Ответ:  {"max_value": 92}
   
2. /actions/get_min_value - получение минимального значения
3. 
    Ответ:  {"min_value": 3}
    
3. /actions/get_median_value - получение медианы

    Ответ:  {"median_value": 34.0}
    
4. /actions/get_average_value - получение cреднего арифметического значения

    Ответ:  {"average_value": 32.69230769230769}
    
5. /actions/get_incr_seq - получение самой длинной последовательности идущих подряд чисел, которая увеличивается

    Ответ:  {
    "incr_sequence": [
        [
            12,
            42,
            56
        ],
        [
            16,
            23,
            45
        ]
    ]
}
    
6. /actions/get_decr_seq - получение самой длинной последовательности идущих подряд чисел, которая уменьшается

    Ответ:  {
    "decr_sequence": [
        [
            92,
            12,
            3
        ],
        [
            34,
            22,
            16
        ]
    ]
}

7. /actions/get_all_values - получение всех значений c кэшированием результата

    Ответ: {
    "maxValueDTO": {
        "max_value": 92
    },
    "minValueDTO": {
        "min_value": 3
    },
    "averageValueDTO": {
        "average_value": 32.69230769230769
    },
    "medianValueDTO": {
        "median_value": 34.0
    },
    "incrSequenceDTO": {
        "incr_sequence": [
            [
                12,
                42,
                56
            ],
            [
                16,
                23,
                45
            ]
        ]
    },
    "decrSequenceDTO": {
        "decr_sequence": [
            [
                92,
                12,
                3
            ],
            [
                34,
                22,
                16
            ]
        ]
    }
}
    
    
