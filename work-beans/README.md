# Работа с Spring Context

## Используемый стек технологий

- Java 8
- Maven 3.6.3
- Lombok
- Spring Boot 2

## Задача 1

Реализовать bean A, содержащий строку. Строка должна внедряться через setter.

[Решение](src/main/java/ru/niatomi/beans/BeanA.java)

## Задача 2

Реализовать bean B, содержащий компонент bean A. Компонент A должен внедряться через конструктор.

[Решение](src/main/java/ru/niatomi/beans/BeanB.java)

## Задача 3

Реализовать bean B, содержащий компонент bean C, являющимся прототипом. Использовать Lookup.

[Решение](src/main/java/ru/niatomi/beans/BeanB.java)

## Задача 4

Реализовать bean D, вывести сообщения из этапов жизненого цикла.

[Решение](src/main/java/ru/niatomi/beans/BeanD.java)

## Задача 5

Реализовать bean E, являющимся прототипом, вывести сообщения из этапов жизненого цикла.

[Решение](src/main/java/ru/niatomi/beans/BeanE.java)

## Вопросы/Ответы

1. Чем отличаются компоненты реализованные в задачах 4 и 5 ?

```
Ответ: Паттерном проектирования.
Без указания области видимости бин создаётся синглтоном(beanD), 
поэтому его жизненный цикл имеет destroy-method. bean E, являясь 
прототипом, не вызывает destroy-method
```

## Вывод

1. Реализация [BeanA](src/main/java/ru/niatomi/beans/BeanA.java) представляет собой метод, в котором с помощью аннотации `@Value` внедряется тестовая строка.

2. Внедрение [BeanA](src/main/java/ru/niatomi/beans/BeanA.java) в [BeanB](src/main/java/ru/niatomi/beans/BeanB.java) осуществляется при помощи аннотации `@Autowired`, так как [BeanA](src/main/java/ru/niatomi/beans/BeanA.java) имеет только конструктор, то внедрение происходит непосредственно через него.

3. [BeanC](src/main/java/ru/niatomi/beans/BeanC.java) имеет аннотацию `@Scope("prototype")`, поэтому данный бин является прототипом. Для внедрения прототипа в синглтон [BeanB](src/main/java/ru/niatomi/beans/BeanB.java) используется метод `createBeanC()` с навешенной на него аннотацией `@Lookup`.

4. [BeanD](src/main/java/ru/niatomi/beans/BeanD.java) и [BeanE](src/main/java/ru/niatomi/beans/BeanE.java) имеют похожие реализации, `initMethod()` и `destroyMethod()` c навешенными на них аннотациями `@PostConstruct` и `@PreDestroy` соотвественно. Только [BeanE](src/main/java/ru/niatomi/beans/BeanE.java) имеет `@Scope("prototype")`, из-за чего метод `destroyMethod()` не вызывается.

5. См. пункт 4
