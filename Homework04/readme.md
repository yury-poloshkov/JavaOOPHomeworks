# Домашняя работа 
## к семинару №4: Обобщения. часть 1.

## Задачи.

Задания на выбор: можно сделать оба, а можно какое то одно.

1. На основе интерфейса GBList создать свою реализацию LinkedList с методами вставки в начало, конец списка, получения размера списка и получения элемента по индексу.

2. **Создать класс FileRepository (аналог кастомной БД) который будет уметь создавать базу данных в виде файла с расширением .txt и именем по имени ЛЮБОГО сохраняемого класса. Должны быть методы получения объекта по id, удаления объекта по id, обновления по id, сохранения нового объекта в БД.

Формат сдачи: ссылка на гитхаб проект.


## Решение.

### *Задача №1*:
**Проект: JavaOOPhw04-1**
Реализован односвязный список на основе интерфейса GBList. Бонусом (помимо всех методов интерфейса GBList) реализованы методы reverse и findNodeFromEnd (_за один проход по односвязному списку находится n-я нода с конца_) - наследие курса "Алгоритмы и структуры данных"))).

В модуле Main написан тест-код для проверки работоспособности реализованного класса на примере заполнения LinkedList Integer с последующим преобразованием.

### *Задача №2*:
**Проект: JavaOOPhw04-2**
Package: /core/repositorium

**Вопросы по ходу выполнения:**

по Задаче №1: Вопрос к корректности реализации Iterator'а - судя по выводу в Main - вроде бы, работает, но какое-то смутное чувство, что что-то не так, все-таки осталось...

по Задаче №2:

1. Есь предположение, что в том виде, в каком сохраняется база данных, чтобы было все красиво, надо работать через json фреймворк, но до этого пока не было времени догуглиться... я прав со своим предположением?

2. Вопрос, на который опять таки не хватило времени: как прописывать _**относительный**_ path для создаваемых файлов, чтобы он упал в целевую папку, например data, являющейся подпапкой будущего размещения скомпилированного приожения, а не как сейчас в корневой папке сейчас проекта (JavaOOPhw04-2)? 