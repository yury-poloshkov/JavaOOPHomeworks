# Домашняя работа

## к семинару №6: ООП Дизайн и Solid

## Задачи

1. Реструктуризировать проект homework с учетом теоретических основ SOLID. О найденых нарушениях и проделанной работе написать в файле ридми.

2. Продолжить проект, "Записная книжка", содержащий работу с записями из консоли (можно прочитать все записи, создать одну запись, отредактировать запись, удалить, и прочитать одну запись по ID), запись содержит в себе как минимум 3 поля Id, заголовок и текст, можно добавить дату. Хранение по вашему выбору, можно в текстовом файле (или каждая запись в одном файле, как вам удобнее). Можно сделать по аналогии с программой из 5 урока. Если все не успеете, то часть задания можно перенести на следующий урок.

Формат сдачи: ссылка на гитхаб проект.

## Решение

### *Задача №1*

Идентифицированы следующие нарушения принципов SOLID в классе User:

1. Single responcibility: помимо полей класса, конструктора и геттера, User содержит методы save() и report(), отвечающие за сохранение данных пользователя в "репозиторий" и предоставления пользователю отчета, что не является поведением самого класса User -> Triple responcibility.

2. Dependency Inversion: метод save() класса User зависит от экземпляра класса *Persister persister = new Persister(this);* (да еще и по сути от себя самого).

**Refactoring:**

1. Оба метода класса User, нарушающие принцип Single responcibility, удалены (одновременно устранено, при удалении метода save(), и второе из идентифицированных нарушений принципов SOLID). При этом метод report() вынесен в отдельный класс ConsoleReport с единственной ответственностью - предоставление отчета, а метод save() уже имеется в классе Persister.

2. Осуществлено распределение классов по пакетам core и repository.

3. Переписан модуль Main, работающий в новой архитектуре приложения.

### *Задача №2*

Реализация задачи осуществлена путем рефакторинга и развития проекта, являвшегося домашним заданием к семинару №5 - организация справочника пользователей.

Рефакторинг имеющегося проекта коснулся перераспределения классов по пакетам в соответствии с полученными рекомендациями/замечаниями при оценке ДЗ №5.

Функционал работы с заметками реализован параллельно функционалу справочника пользователей в тех же пакетах. Также добавлен стартовый пользовательский интерфейс StertView, с функцией выбора ветки работы приложения: интерфейс администрирования пользователей или интерфейс личного кабинета пользователя записной книжки (при этом модуль Main получился вообще красивый - всего 2 строки))).

**Вопросы по ходу выполнения:**

*по Задаче №1:* правильно ли по функциональной принадлежности было разместить интерфейс Reporter и его консольную реализацию в пакет core (как относящийся к модели дизайна MVC) или он должен быть в пакете repository?  

*по Задаче №2:*

1. Закрадывается мысль, что клас StartView пакета ui нарушает таки те же 2 принципа SOLID, которые были идентифицированы в задаче №1: Single responcibility (в части блока Login) и Dependency Inversion... так ли это? или в отношении этого модуля SOLID не догма?

2. Насколько теперь логично классы распределены по пакетам? Как по функциональности, так и с точки зрения единого размещения (как вариант, можно было верхнеуровнево разделить на пакеты useradministration и notes в каждом из которых бы были свои пакеты core+ui+repo)?

3. Учитывая, что в каждом из пакетов классы по веткам user и notes сильно идентичны, наверняка должен быть какой-то механизм чтобы это все можно было не дублировать? Пока идея архитектуры пришла только с дубляжом...

*в общем, чем обширнее проект, тем, на данном этапе становления, все больше вопросов... чем больше узнаешь, тем обширнее область видимого непознанного*
;)
