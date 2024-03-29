# **Jarvis algorithm**
Исходный код на [моем GitHub](github.com/vitterre/jarvis-algorithm).

---

**Алгоритм Джарвиса**, также известный как **алгоритм оболочки Джарвиса** или **алгоритм заворачивания подарка**, является одним из алгоритмов построения выпуклой оболочки множества точек на плоскости. Этот алгоритм получил своё название в честь Рональда Джарвиса, который в 1973 году впервые описал его в своей статье.

## **Описание**
1. Выберем точку `P0`, которая является самой "левой" среди всех точек множества. Если же таких точек несколько, то выбираем самую нижнюю из них.
2. Добавляем `P0` в выпуклую оболочку.
3. Далее находим самую "правую" точку от последней добавленной (то есть точку с минимальным полярным углом относительно неё) и добавим её в оболочку. Будем так итеративно добавлять точки, пока не "замкнёмся", то есть пока самой правой точкой не станет `P0`.

Алгоритм заканчивает свою работу, когда найденная точка совпадает с начальной точкой.

## **Демонстрация**
На gif-изображении ниже показан пример работы данного алгоритма. В данном случае первой точкой взята самая левая, ведь она гарантированно попадет в выпуклую оболочку. А дальше алгоритм действует по часовой стрелке.

![](docs/images/demonstration.gif)

## **Корректность алгоритма**
Корректность алгоритма легко доказывается по индукции:
* На нулевом шаге мы выбрали точку, точно лежащую в выпуклой оболочке.
* На `i`-ом шаге мы взяли такую точку, что все остальные лежат по левую сторону отрезка (`Pi-1`, `Pi`), и поэтому точно не перекрывают точку `Pi`.

## **Асимптотика**
Алгоритм Джарвиса является простым и надежным алгоритмом построения выпуклой оболочки, но его асимптотическая сложность не является оптимальной.

Для каждой точки выпуклой оболочки (обозначим их количество за `h`) мы из всех оставшихся `O(n)` точек будем искать оптимальную, что суммарно будет работать за `O(nh)`.

Важно помнить, что асимптотика именно `O(nh)`, а не `O(n^2)`: существуют задачи, где оболочка маленькая, и это существенно влияет на саму задачу и ее скорость выполнения.

## **Пререквезиты**
* Java версии не ниже 11
* Maven версии не ниже 3.9.1

Убедитесь, что у вас установлен Python 3.9. Затем перейдите в корневую директорию этого проекта и запустите команду:
```bash
python3 -m pip install -r requirements.txt
```

## **Тестирование**
Для начала убедитесь, что у вас установлены все необходимые зависимости.

После этого находясь в корневой директории проекта запустите команду
```bash
python3 generator/generator.py
```
В папке `jarvis/src/test/java` появится папка `resources`, содержащая в себе 100 тестовых наборов данных и 100 файлов, содержащих правильные ответы, которые потом должен будет выдать алгоритм.

Далее, запустите все JUnit тесты, перейдя в папку `jarvis`:
```bash
mvn test
```
Результаты тестирования увидите на экране.

Далее вы можете запустить команду:
```bash
python3 profiler/profiler.py
```
После ее вызова вы получите графики, построенные на результатах тестирования.

## **Применение**
На практике алгоритм Джарвиса используется для построения оболочки небольших множеств точек. Для работы с большими множествами точек применяют более эффективные алгоритмы, такие как алгоритм Грэхэма или алгоритм QuickHull.