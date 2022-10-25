# test-app
 RESTfullAPI

В теле HTTP POST-запроса передается путь к файлу в формает JSON: {"file_path": "C:/../test-app/TraineeTest/src/main/resources/static/10m.txt"}

POST-запросы:
1. /actions/get_max_value - получение максимального значения

   Ответ:  {"max_value": 4234}
   
2. /actions/get_min_value - получение минимального значения
    Ответ:  {"min_value": 1}
    
3. /actions/get_median_value - получение медианы

    Ответ:  {"median_value": 179.5}
    
4. /actions/get_average_value - получение cреднего арифметического значения

    Ответ:  {"average_value": 1728.7857142857142}
    
5. /actions/get_incr_seq - получение самой длинной последовательности идущих подряд чисел, которая увеличивается

    Ответ:  {
    "incr_sequence": [[ 16, 236, 456, 12313]]} 
    
6. /actions/get_decr_seq - получение самой длинной последовательности идущих подряд чисел, которая уменьшается

    Ответ:  {"decr_sequence": [[923, 12, 3, 1] ]} 
    
