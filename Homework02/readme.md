# Домашняя работа 
## к семинару №2: Принципы ООП: Абстракция и интерфейсы.

## Задачи.
1. Создать класс: Создайте интерфейсы Soundable, Runnable, Flyable, Swimable. У интерфейсов должны быть методы получения скорости заданного действия.
2. Добавьте наследников этим интерфейсам, но таким образом, чтобы у каждого интерфейса было минимум по два наследника (при необходимости, добавьте в приложение новые классы).
3. Создать класс Doctor и подумать над его поведением. Создать класс Nurse(медсестра) и подумать над его поведением.
4. У ветеринарной клиники добавьте методы получения всех бегающих, всех плавающих, всех говорящих и всех летающих.

## Решение.

Реализация задач осуществлена на базе проекта, являющего итогом домашнего задания №1 (не использовался проект с семинара №2). При этом осуществлен рефакторинг пакетов, состояний и методов классов, имеющихся в проекте, в целях реализации текущих задач.

### *Задача №1*:

В пакет /clinique/animals/interfaces добавлены интерфейсы Soundable, Runable, Flyable, Swimable:

в рамках каждого интерфейса реализован **public default void** метод (в целях того, чтобы при последующем наследовании интерфейсов не писать множественные переопределения), 

**_принимаюший на вход:_** параметры движения: скорость, время, направление, а также для fly/swim - высоту/глубину, силу крика и время для Soundable;

**_возвращающий:_** результат движения: пройденное расстояние - _отступление от ТЗ_ (см задачу №1, т.к. скорость является входным параметром, ее можно и вернуть, но более логично показалось вернуть результат в виде пройденного пути. _Необходимо пересогласовать ТЗ с заказчиком_).

### *Задача №2*:

Реализованные интерфейсы имплементированы следующим классам в пакете /clinique/animals/tyres:
* **летающие (Flyable):** Duck, Parrot
* **плавающие (Swimable):** Fish, Turtle, Duck
* **бегающие (Runable):** Horse, Ostrich, Duck, Turtle
* **звучащие (Soundable):** Duck, Parrot, Horse, Ostrich

дефолтные методы интерфейсов не переопределялись.

### *Задача №3*:

Классы Doctor и Nurse реализованы в пакете /clinique/humans/staff.
При этом у класса Doctor имеются 2 наследника Surgeon и Therapist.

**Для класса Doctor и наследников:**

Общие наследуемые методы класса Doctor: surveyAnimal, appointTreatment

Специфические методы класса Surgeon: operateAnimal, euthanizeAnimal

Специфические методы класса Therapist: vaccinateAnimal

Все методы оформляют запись в медицинскую карту пациента о проделанных процедурах. 

**Для класса Nurse:"**
Реализованы методы cleanRoom, washAnimal, groomAnimal (2 последних, также как и методы класса Doctor формируют записи в медицинскую карту).

### *Задача №4*:
Методы отбора реализованы в пекете /clinique в классе VetClinique.

В классе Main реализован код для проверки корректности работы реазизации задач - код от слова "оторви и выбрось")))

**Вопросы по ходу выполнения:**
1. Вопрос риторический по постановке задачи №4: либо я ТЗ (задачу) некорректно понял, отчего и реализация в виде такого "ущербного" класса, либо мне не ясен замысел наличия в этом классе подобных методов... если только исключительно для осознания работы instanceof?..

2. Помимо вопроса 1 и тесто-бредо-кода в Main, насколько корректно, без существенных архитектурных косяков "спроектирована" иерархия пакетов, классов и интерфейсов? На текущий момент не увидел необходимости проектировать интерфейсы в пакете humans - верное ли это решение для данного этапа и вообще? Или надо было все таки уже на этом этапе задаться выделением методов в интерфейсы?