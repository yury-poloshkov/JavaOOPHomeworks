# Домашняя работа 
## к семинару №1: Принципы ООП: Инкапсуляция, наследование, полиморфизм

## Задачи.
1. Добавить в класс Animal методы двигаться(toGo), летать(fly), плавать(swim). 
2. Создать по два класса наследника Animal, умеющих летать, плавать, бегать. (При этом добиться того, чтобы не умеющие летать или плавать, не могли этого сделать.)

3. **САМОЕ ВАЖНОЕ!** В файле readme.md в репозитории гитхаб описать какие проблемы в таком проектировании Вы увидели, а также там же написать возникшие при выполнении дз вопросы (если они есть).

## Решение.
### *Задача №1*:
В класс Animal добавлены методы:
* public void go(float speed, float time, String direction)
* public void fly(float speed, float time, float height, String direction)
* public void swim(float speed, float time, float depth, String direction)

**_принимают на вход:_** параметры движения: скорость, время, направление, а также для fly/swim - высоту/глубину;

**_осуществляют вывод:_** результаты движения: пройденное расстояние и время в пути.

*Как вариант: Можно было в параметры класса добавить координаты в пространстве (например 3D или GPS) и, принимая в методы "направление" в виде вектора движения, соответственно пересчитывать и выдавать новые координаты.*    

### *Задача №2*:
Созданы следующие наследники класса Animal:
* **летающие:** Duck, Parrot
* **плавающие:** Fish, Turtle
* **бегающие:** Horse, Ostrich

Подзадача решена _**путем переопределения**_ соответствующих _**невыполнимых для наследника**_ методов движения в каждом классе-наследнике: заменой вывода результатов движения на вывод невозможности подобного вида движения для данного наследника.

Если понимать под *"не могли это сделать"* - невозможность вызвать метод у экземпляра класса-наследника, то скрыть *невыполнимые* методы внутри классов-наследников не удалось, т.е. получается технически, что это поведение как-бы есть (_во всяком случае его для экземпляра наследника можно вызвать... но, с другой стороны, почему бы не попробовать заставить страуса, а он как никак, но все же птица, взлететь?_), но оно не работает по базовому алгоритму - нет результата движения (_вместо полета страус прячет голову в песок и никуда не летит_).

### *Задача №3*:
**Идентифицированная проблема проектирования:** 

_Низкий уровень (несоблюдение требований принципа) абстракции_

В базовый класс вынесено поведение, присущее не всей совокупности потенциальных наследуемых классов сразу:

Даже если предположить, что все 3 метода могут быть вызваны у любого экземпляра любого из классов-наследников (например, можно бросить рыбу на землю, чтобы "поползла" трепыхаясь, как частный случай ходьбы, или пнуть птиц типа пингвина или страуса, чтобы подпрыгнули, или столкнуть их со скалы/айсберга в море, как частные случаи полета))) - эти частные случаи поведения все-равно будут кардинально отличаться от базового нормального поведения, присущего классу-наследнику, предполагающего результатом ожидаемый пройденный путь и изменение координат в пространстве, которые могут быть описаны формулами движения, как минимум в части дополнительных (порой летальных, как например для рыбы, пытающейся "пробежать" 100 метровку) последствий, а значит их все-равно придется переопределять внутри классов-наследников. С учетом того, что классов-наследников может быть несколько тысяч, а то и больше (видов в природе немеряно), объем кода всех переопределений будет не менее впечатляющим.

Плюс переопределение не решают вопроса простой недоступности (сокрытия) того или иного вида поведения для экземпляра класса-наследника, чтобы его невозможно было вызвать в принципе.

**Вопросы по ходу выполнения:**

Вопрос №1: риторический, возникший в результате попытки при переопределении метода _"ужесточить"_ режим видимости с public (в базовом) до private (в наследнике) - почему нет возможности это сделать? Хотя, это только бы плодило проблемы множественных переопределений, корявость принципов абстрактности и наследования...

Вопрос №2: насколько я понял, в классах-наследниках конструкторы из базового не наследуются? их придется дублировать по количеству необходимых сигнатурных конструкций? Или я где-то что-то не так делал?
