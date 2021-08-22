## Инструкции по работе Spring
### Оглавление
***Spring начало***

0. [Что такое Spring?](#Что-такое-Spring?)
1. [Модули Spring](#Модули-Spring)
2. [Введение в IoC и DI в Spring](#Введение-в-IoC-и-DI-в-Spring)
3. [Inversion of Control (инверсия управления)](#Inversion-of-Control-(инверсия-управления))
4. [Dependency Injection (внедрение зависимостей)](#Dependency-Injection-(внедрение-зависимостей))
5. [Сведения о конфигурации Spring](#Сведения-о-конфигурации-Spring)
6. [Конфигурация бинов с помощью Xml файла](#Конфигурация-бинов-с-помощью-Xml-файла)
7. [Конфигурация бинов с помощью аннотации](#Конфигурация-бинов-с-помощью-аннотации)
8. [Внедрение зависимостей](#Внедрение-зависимостей)
9. [Внедрение зависимостей с помощью аннотаций](#Внедрение-зависимостей-с-помощью-аннотаций)
10. [Внедрение зависимостей с помощью Xml файла](#Внедрение-зависимостей-с-помощью-Xml-файла)
11. [Область видимости бинов](#Область-видимости-бинов)
12. [Добавление scope с помощью Xml файла](#Добавление-scope-с-помощью-Xml-файла)
13. [Добавление scope через аннотации](#Добавление-scope-через-аннотации)
14. [Жизненный цикл бинов](#Жизненный-цикл-бинов)
15. [Init метод](#Init-метод)
16. [Destroy метод](#Destroy-метод)
17. [Тонкости выполнение init() и destroy() методов](#Тонкости-выполнение-init()-и-destroy()-методов)
18. [Выполнение init() и destroy() методов через xml конфигурацию](#Выполнение-init()-и-destroy()-методов-через-xml-конфигурацию)
19. [Выполнение init() и destroy() методов через аннотацию](#Выполнение-init()-и-destroy()-методов-через-аннотацию)
20. [Фабричный метод (Factory method)](#Фабричный-метод-(Factory-method))
21. [Тонкости использование фабричного метода](#Тонкости-использование-фабричного-метода)
22. [Использование фабричного метода при xml конфигурации](#Использование-фабричного-метода-при-xml-конфигурации)
23. [Использование фабричного метода при использовании аннотаций](#Использование-фабричного-метода-при-использовании-аннотаций)

***Spring АОП***

0. [Что такое АОП?](#Что-такое-АОП?)
1. [Концепции АОП](#Концепции-АОП)
2. [Типы АОП](#Типы-АОП)
3. [Статическое АОП](#Статическое-АОП)
4. [Динамическое АОП](#Динамическое-АОП)
5. [Введение в Spring АОП](#Введение-в-Spring-АОП)
6. [Точки соединения в Spring](#Точки-соединения-в-Spring)
7. [Аспекты в Spring](#Аспекты-в-Spring)
8. [ProxyFactory в Spring](#ProxyFactory-в-Spring)
9. [Типы советов в Spring](#Типы-советов-в-Spring)
10. [Интерфейсы для создания совета](#Интерфейсы-для-создания-совета)
11. [Создание совета "перед"](#Создание-совета-"перед")
12. [Защита доступа к методам с использованием совета "перед"](#Защита-доступа-к-методам-с-использованием-совета-"перед")
13. [Создание совета "после возврата"](#Создание-совета-"после-возврата")
14. [Создание совета "после возврата" для дополнительной проверки](#Создание-совета-"после-возврата"-для-дополнительной-проверки)
15. [Создание совета "вокруг"](#Создание-совета-"вокруг")
16. [Создание совета "перехват"](#Создание-совета-"перехват")
17. [Выбор типа совета](#Выбор-типа-совета)
18. [Советы и срезы](#Советы-и-срезы)
19. [Интерфейс Pointcut](#Интерфейс-Pointcut)
20. [Создание статического среза с использованием StaticMethodMatcherPointcut](#Создание-статического-среза-с-использованием-StaticMethodMatcherPointcut)
21. [Создание динамического среза с использованием DynamicMethodMatcherPointcut](#Создание-динамического-среза-с-использованием-DynamicMethodMatcherPointcut)
22. [Создание среза с использованием простого сопоставления имён (NameMatchMethodPointcut)](#Создание-среза-с-использованием-простого-сопоставления-имён-(NameMatchMethodPointcut))
23. [Создание среза с использованием AspectJ](#Создание-среза-с-использованием-AspectJ)
24. [Создание среза с использованием аннотации](#Создание-среза-с-использованием-аннотации)



---
***Spring начало***
## Что такое Spring?
Основная задача Spring - это упростить и сократить работу программиста при создании Java-приложения. 
Spring - это фрэймворк, который представляет контейнер внедрения зависимостей с несколькими модулями.
В случае необходимости модули можно легко подключить к проекту.

## Модули Spring
Модули — это наборы инструментов.
Разработчик может указать, набор модулей, помимо базового набора, который он хочет импортировать в качестве зависимостей для конкретного приложения.

| Модуль | Описание |
|:---:|:--------:|
| aop | Этот модуль содержит все классы, необходимые для применения в приложении средств аспектно-ориентированного программирования [(АОП)](https://ru.wikipedia.org/wiki/Аспектно-ориентированное_программирование)  из Spring. 
| aspects | Этот модуль содержит все классы, предназначенные для расширенной интеграции с библиотекой АОП в AspectJ. Данный модуль понадобится если вы нуждаетесь в управлениями транзакциями с помощью аннотаций в стиле AspectJ. 
| beans | Этот модуль содержит все классы, предназначенные для поддержки манипуляций с бинами Spring. В этот модуль упакованы классы, требуемые для обработки XML-файл конфигурации Spring и Java-аннотаций.
| context | Этот модуль содержит классы, которые предоставляю расширения для ядра Spring, связанные с поддержкой класса. 
| context-support | Этот модуль содержит дополнительные расширения для модуля spring-context. Здесь упакованы класса для интеграции с различными библиотеками выполнения и планирования задач (CommonJ Quartz). 
| core | Это основный модуль, необходимый для каждого приложения Spring.
| expression | Этот модуль содержит все классы поддержки для языка SpEL (Spring Expression Language - язык выражений Spring).
| instrument | Этот модуль включает агент инструментирования Spring для начальной загрузки виртуальной машины Java. 
| instrument-tomcat | Этот модуль включает агент инструментирования Spring для начальной загрузки виртуальной машины Java на сервере Tomcat. 
| jdbc | Модуль включает в себя все классы, предназначенные для поддержки JDBC. Данный модуль необходим для всех приложений, которым требуется доступ к БД. 
| orm | Этот модуль включает расширенный набор средств JDBC платформы Spring поддержкой популярных инструментов [ORM](https://ru.wikipedia.org/wiki/ORM) (Hibernate, JDO, JPA).
| oxm | Этот модуль предоставляет поддержку OXM (Object/XML Mapping - отображение объектов на XML). В данный модуль упакованы классы, предназначенные для маршализации и демаршализации XML.
| test | Этот модуль предоставляет набор классов для помощи в тестировании приложений.
| tx | Этот модуль предоставляет все классы, предназначенные для поддержки транзакций Spring. 
| web | Этот модуль предоставляет основные классы для использования Spring в веб-приложениях.
| webmvc | Этот модуль содержит все классы для собственной структуры MVC платформы Spring.
| websocket | Этот модуль предоставляет поддержку Java API для WebSocket.

## Введение в IoC и DI в Spring

#### Inversion of Control (инверсия управления)
Одна из ключевой особенностью приложения написанного на Spring, заключается в том, что большую часть объектов создаёт не программист, а сам Spring.
Программист лишь объясняет Spring (с помощью аннотаций либо в конфигурационном XML), какие именно объекты он должен создать самостоятельно.
Spring управляет жизненным циклом объектов и потому его контейнер называется IoC-контейнер.
IoC расшифровывается как Inversion of Control [(IoC)](https://ru.wikipedia.org/wiki/Инверсия_управления). 
А объекты, которые создаются контейнером и находятся под его управлением, называются бинами.

#### Dependency Injection (внедрение зависимостей)
В ходе создания бинов Spring самостоятельно инициализирует поля в соответствии инструкциями, которые указал сам программист(с помощью аннотаций либо в конфигурационном XML).
Внедрение зависимости – это и есть процесс инициализации полей бинов другими бинами (зависимостями).

## Сведения о конфигурации Spring
Как говорилось ранее, программист может объяснить Spring какие именно бины нужно создать с помощью конфигурационного файла или же с помощью аннотаций.  
ApplicationContext — это главный интерфейс в Spring-приложении, который предоставляет информацию о конфигурации приложения. В зависимости от способа конфигурации приложения, будет создаваться различный объект интерфейса ApplicationContext.  
Как уже сказано, контейнеру для создания бинов требуется конгфигурация, так что конструктор контейнера принимает аргумент. Существуют два подкласса ApplicationContext: ClassPathXmlApplicationContext берет конфигурацию из XML-файла, а AnnotationConfigApplicationContext – из аннотаций.
У Spring есть 4 способа конфигурации:

* Xml конфигурация — ClassPathXmlApplicationContext(”context.xml”);
* Groovy конфигурация — GenericGroovyApplicationContext(”context.groovy”);
* Конфигурация через аннотации с указанием пакета для сканирования — AnnotationConfigApplicationContext(”package.name”);
* JavaConfig — конфигурация через аннотации с указанием класса (или массива классов) помеченного аннотацией @Configuration — AnnotationConfigApplicationContext(JavaConfig.class).

В качестве примера ниже будет показано конфигурация бинов с помощью Xml файла и использования аннотации (JavaConfig).

Прежде чем создавать приложение, необходимо добавить зависимостей (в зависимости от инструмента сборки, процесс добавления зависимостей может различаться), ниже показаны зависимости, которые необходимо добавить при использовании Maven (версии зависимостей могут быть другими):
 ````xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.2.4.RELEASE</version>
</dependency>
````
Создадим простейший интерфейс: 
````java
public interface Action {
    void action();
}
````
Создадим класс, который будет имплементировать данный интерфейс: 
````java
public class HelloWorld implements Action {

    @Override
    public void action() {
        System.out.println("Hello word!");
    }
}
````
### Конфигурация бинов с помощью Xml файла
Для конфигурирование бина Spring с помощью xml файла необходимо создать конфигурационный файл в папке resources
````xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
</beans>
````
Для того чтобы Spring понимал какой бин необходимо создать, нам необходимо добавить информацию о классе в этот конфигурационный файл
````xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <bean id="hello" class="ru.zubov.springbean.xml.HelloWorld"/>
</beans>
````
Тут мы видим что присваивается id, по которому мы будем получать данный бин и месторасположение данного класса. (конфигурационный файл находится в проекте находиться [тут](https://github.com/ZubovVP/spring/blob/master/spring-bean/src/main/resources/app-context.xml)) 

Для тестирования нашего приложения создадим класс Test в котором постараемся вызвать метод action из бина:
````java
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "app-context.xml"
        );
        Action hello = context.getBean("helloXML", HelloWorld.class);
        hello.action();
    }
}
````
При создании ApplicationContext мы указали объект ClassPathXmlApplicationContext, которому передали название нашего конфигурационного файла.
 ````java
ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
````
Далее мы получаем бин по его id и вызываем метод action().
 ````java
        Action hello = context.getBean("helloXML", HelloWorld.class);
        hello.action();
```` 
При запуске данного приложения мы увидим информацию в консоле. С полной реализацией данного принципа можно ознакомиться [(тут)](https://github.com/ZubovVP/spring/tree/master/spring-bean/src/main/java/ru/zubov/springbean/xml)
Для получение несколько бинов одного класса нужно будет в xml файле их указать как показано ниже (id  бина должны быть различные)
````xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <bean id="First" class="ru.zubov.springbean.xml.HelloWorld"/>
    <bean id="Second" class="ru.zubov.springbean.xml.HelloWorld"/>
</beans>
````
Тогда в нашем контейнере создадутся два бина одного класса, которые можно будет получить от из ApplicationContext использую команду getBean() с указанием id бина.
````java
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "app-context.xml"
        );
        Action first = context.getBean("First", HelloWorld.class);
        hello.action();
        Action second = context.getBean("Second", HelloWorld.class);
        hello.action();
    }
}
````
### Конфигурация бинов с помощью аннотации
При конфигурировании бинов с помощью аннотации нам не нужно создавать конфигурационный файл, всё указывается непосредственно в классах.
````java
@Component("helloAnnotation")
public class HelloWorld implements Action {

    @Override
    public void action() {
        System.out.println("Hello word!");
    }
}
````
Появилась аннотация @Component("helloAnnotation"), которая говорит Spring что необходимо будет создать бин данного класса и присвоить ему id = "helloAnnotation".
В отличие от конфигурировании xml класс Test тоже приобретает некоторые отличия:
````java
@Configuration
@ComponentScan("ru.zubov.springbean.annotation")
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        Action hello = context.getBean("helloAnnotation", HelloWorld.class);
        hello.action();
    }
}
````
Аннотация @Configuration("helloAnnotation") говорит Spring, что объект является источником определений bean-компонентов, а аннотация @ComponentScan("ru.zubov.springbean.annotation") говорит Spring где вести поиск бинов, которые необходимо будет создать.
Т.к. мы конфигурируем с использованием аннотаций, соответственно нам необходимо создавать объект AnnotationConfigApplicationContext и передать ему в конструктор класс, который помечен аннотацией @Configuration.

При запуске такого приложения, мы увидим аналогичный результат, что и в предыдущем. С полной реализацией данного принципа можно ознакомиться [(тут)](https://github.com/ZubovVP/spring/tree/master/spring-bean/src/main/java/ru/zubov/springbean/annotation)

Для получение несколько бинов одного класса нужно будет в конфигурационном классе создать с метод с указанием аннотации @Bean.
````java
@Configuration
@ComponentScan("ru.zubov.springbean.annotation")
public class Test {
    @Bean("First")
    public HelloWorld createHello1(){
        return new HelloWorld();
    }

    @Bean("Second")
    public HelloWorld createHello2(){
        return new HelloWorld();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        Action hello = context.getBean("helloAnnotation", HelloWorld.class);
        hello.action();
    }
}
````
Получение данных бинов будет аннологичен, как и при созданни нескольких бинов через xml
````java
@Configuration
@ComponentScan("ru.zubov.springbean.annotation")
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        Action first = context.getBean("First", HelloWorld.class);
        first.action();
        Action second = context.getBean("Second", HelloWorld.class);
        second.action();
    }
}
````
Разница между аннотациями @Bean и @Component в том, что @Bean более гибкая аннотация, ею мы аннотируем метод, а не класс:

* С помощью @Bean можно конфигурировать бины для тех классов, код которых вы не можете редактировать, например, классы из чужих библиотек.
* С помощью @Bean можно также конфигурировать классы, создаваемые фабричными методами.
## Внедрение зависимостей
Dependency Injection (внедрение зависимостей) – ключевой шаблон проектирования в Spring. Мы говорим фреймворку создать за нас бины (иначе говоря – объекты) и внедрить их в другие бины. И фреймворк это делает.
Существует несколько способов внедрения зависимостей в бины, внедрять зависимости можно через конструктор(constructor-based injection) или же через сеттер(setter-based injection).  
Предположим у нас есть два класса:
````java
public class Child {
    private String name;
} 
````
У класса Child есть всего одно поле - name.
````java
public class Parent {
    private String name;
    private int age;
    private Child child;
}
````
У класса Parent есть 3 поля.
### Внедрение зависимостей с помощью аннотаций
Существует несколько аннотаций, которые позволяют программисту объяснить Spring как внедрять зависимости:
* использование аннотации @Value  
При использовании аннотации @Value программист может указать какое-либо конкретное значение, либо указать значение из файла имеющее расширение properties.
Для того чтобы внедрить зависимость через сеттер, достаточно установить аннотацию над полем или же над сеттером
````java
@Component
public class Child {
    @Value("Tom")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
````
Как показано выше, при создании данного бина, Spring установит полю name значение Tom. При присваивании данного значения Spring будет вызывать сеттер и указывать ему значение. 
Аннотация @Component говорит фреймворку превратить класс в бин. При запуске Spring создаст экземпляр класса Child. Этот экземпляр будет синглтоном в нашем случае. Мы сможем его впоследствии получить из контекста приложения.
````java
@Component
public class Child {
    private String name;

    public Child(@Value("${child.name}") String name) {
        this.name = name;
    }
}
````
При таком коде, Spring будет получать значение из файла имеющее расширение properties. ВАЖНО! В таком случае нужно указать в конфигурационном классе аннотацию @PropertySource с указанием месторасположением данного файла (Пример @PropertySource ("classpath:/application.properties")).
````java
@Configuration
@ComponentScan("ru.zubov.di.annotation")
@PropertySource("classpath:/application.properties")
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
                Child child = context.getBean(Child.class);
    }
}
````
* использование аннотации @Autowired
Использование данной аннотации Spring сам будет искать в контейнере из уже созданных бинов, какой бин туда можно подставить.
Возьмём класс Chil и не будем указывать аннотацию @Component, тем самым Spring не создаст самостоятельно бин данного класса.
````java
public class Child {
    private String name;

    public Child(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
````
Возьмём класс Parent в котором будет использоватся аннотация @Autowired.
````java
@Component
public class Parent {
    @Value("Tom")
    private String name;
    @Value("20")
    private int age;
    @Autowired
    private final Child child;

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Child getChild() {
        return child;
    }
}
````
Создадим в конфигурационный класс.
````java
@Configuration
@ComponentScan("ru.zubov.di.annotation")
@PropertySource("classpath:/application.properties")
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        Parent parent = context.getBean(Parent.class);
    }
}
````
При запуске такого приложения мы получим Exception, т.к. Spring не найдёт бин, который можно будет подставить в поле child классу Parent.
Для решения данной проблемы мы в конфигурационном файле добавим бин, который Spring сможет использовать.
````java
@Configuration
@ComponentScan("ru.zubov.di.annotation")
@PropertySource("classpath:/application.properties")
public class Test {
    @Bean("child")
    public Child createChild(){
        return new Child("Duke");
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        Parent parent = context.getBean(Parent.class);
    }
}
````
Теперь Spring сможет найти бин Child и добавить его в поле child класса Parent.

В случае когда есть несколько бинов, которые подходят для внедрения в данное поле, то необходимо использовать уточнение, а именно аннотацию @Qualifier(), внутри которой указывается либо конкретный класс, либо id бина.
Допустим у нас в конфигурационном классе будут созданы два бина: 
````java
@Configuration
@ComponentScan("ru.zubov.di.annotation")
@PropertySource("classpath:/application.properties")
public class Test {
    @Bean("child_1")
    public Child createChild_1(){
        return new Child("Duke");
    }
    @Bean("child_2")
    public Child createChild_2(){
        return new Child("Alex");
    }


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        Parent parent = context.getBean(Parent.class);
    }
}
````
Класс Parent остаётся без изменения, тогда при запуске такого приложения у нас появится Exception, т.к. Spring не знает какой из бинов добавить в поле child класса Parent.
Для решения данной проблемы нам необходимо внести уточнение в классе Parent.
````java
@Component
public class Parent {
    @Value("Tom")
    private String name;
    @Value("20")
    private int age;
    @Autowired
    @Qualifier("child_1")
    private final Child child;

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Child getChild() {
        return child;
    }
}
````
Над полем child мы указали id бина, который необъодимо будет туда подставить.
В данном случае Spring будет понимать какой бин использовать при создании бина Parent.  Подробно с кодом можно ознакомится [(тут)](https://github.com/ZubovVP/spring/tree/master/spring-bean/src/main/java/ru/zubov/di/annotation)
 
* использование аннотации @Inject  
Аннотация @Inject является более новой версией аннотации @Autowired, принцип работы аналогичен.
### Внедрение зависимостей с помощью Xml файла
А теперь сконфигурируем все то же самое с помощью XML. Создадим конфигурационный файл:
````xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <bean id="child" class="ru.zubov.di.xml.Child" >
        <property name="name" value="Duke" />
    </bean>
    <bean class="ru.zubov.di.xml.Parent">
        <constructor-arg ref="child" />
        <property name="name" value="Alex"/>
        <property name="age" value="35"/>
    </bean>
</beans>
````
Строка <bean id="child" class="ru.zubov.di.xml.Child"> говорит о том что необходимо будет Spring создать бин класса Child.
Строка <property name="name" value="Duke" /> говорит о том что нужно присвоить полю name значение Duke. Значение будет присваиваться через сеттер(setter-based injection) (аналог @Value).
````xml
    <bean class="ru.zubov.di.xml.Parent">
        <constructor-arg ref="child" />
        <property name="name" value="Alex"/>
        <property name="age" value="35"/>
    </bean>
````
В данном фрагменте кода Spring создаст бин класса Parent, в котором ранее созданный бин Child будет внедряться в новый бин Child через конструктор (constructor-based injection), а два других поля будут заполнены Spring через сеттер(setter-based injection).
Для получения данного бина необходимо будет создать ApplicationContext с указанием правильного конфигурационного файла:
````java
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml"
        );
        Parent parent = context.getBean(Parent.class);
        System.out.println(parent);
    }
}
````
Получать бин можно через обращение через id бина, либо через класс, в случае если обращение через было создано 2 или более подобных бинов, то будет получен Exception (рекомендую всегда обращаться через id и в xml файле всегда присваивать id).
Полный программный код можно посмотреть [(тут)](https://github.com/ZubovVP/spring/tree/master/spring-bean/src/main/java/ru/zubov/di/xml)
## Область видимости бинов
Область видимости бинов (Scope) - используется для определения количества создания экземпляров класса. Scope говорит Spring как нужно будет создавать бины. Существуют разные виды scope:
* **Singleton**\
Данный scope задаётся по умолчанию. При всех вызовах метода getBean() возвращается ссылка на один и тот же (единственный) объект.
* **Prototype**\
Данный scope при всех вызовах метода getBean() возвращается каждый раз ссылка на новый объект.
* **Request**\
Данный scope создаёт один экземпляр класса на каждый HTTP-запрос.
* **Session**\
Данный scope создаёт один экземпляр класса на каждую сессию.
* **Global-session**\
Данный scope создаёт один экземпляр класса на каждую глобальную сессию.
Для примера создадим класс:
````java
public class Person {
   private String name = "Alex";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
````
### Добавление scope с помощью Xml файла
Scope указывается в xml файле при создании бина. Создадим xml конфигурацию в которой создадим два бина с различными scope:
````xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
    <bean id="personSingleton"
          class="ru.zubov.scope.xml.Person"
          scope="singleton">
    </bean>
    <bean id="personPrototype"
          class="ru.zubov.scope.xml.Person"
          scope="prototype">
    </bean>
</beans>
````
Создадим класс для получения данных бинов и их тестирования:
````java
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-contextForScopes.xml");
        System.out.println("Test singleton bean :");
        Person person = (Person) context.getBean("personSingleton");
        System.out.println(person.getName());
        person.setName("Duke");
        person = (Person) context.getBean("personSingleton");
        System.out.println(person.getName());

        System.out.println("Test prototype bean:");
        person = (Person) context.getBean("personPrototype");
        System.out.println(person.getName());
        person.setName("Duke");
        person = (Person) context.getBean("personPrototype");
        System.out.println(person.getName());
    }
}
````
При создании бина со scope = singleton, это означает что у нас создаться один экземпляр класса на всё приложение и в случае каких-либо изменений в этом классе, то изменение отобразится у всех пользователей этого бина.
При создании бина со scope = personPrototype, при внесении изменений внутри бина, то если другой пользователь запросит данный бин методом getBean(), то он их не увидит.
Результат данного тестирования можно увидеть ниже:
````text
Test singleton bean :
Alex
Duke
Test prototype bean:
Alex
Alex
````
Подробней с данным програмным кодом можно ознакомится [(тут)](https://github.com/ZubovVP/spring/tree/master/spring-bean/src/main/java/ru/zubov/scope/xml)
### Добавление scope через аннотации
Указание scope происходит внутри класса:
````java
@Component
@Scope("prototype")
public class PersonPrototype {
    private String name = "Alex";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@Component
@Scope("singleton")
public class PersonSingleton {
    private String name = "Alex";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
````
Создадим конфигурационный класс для получения данных бинов и их тестирования:
````java
@Configuration
@ComponentScan("ru.zubov.scope.annotation")
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        System.out.println("Test singleton bean :");
        PersonSingleton personSingleton = context.getBean(PersonSingleton.class);
        System.out.println(personSingleton.getName());
        personSingleton.setName("Duke");
        personSingleton = context.getBean(PersonSingleton.class);
        System.out.println(personSingleton.getName());

        System.out.println("Test prototype bean:");
        PersonPrototype personPrototype = context.getBean(PersonPrototype.class);
        System.out.println(personPrototype.getName());
        personPrototype.setName("Duke");
        personPrototype = context.getBean(PersonPrototype.class);
        System.out.println(personPrototype.getName());
    }
}
````
Результат данного тестирования можно увидеть ниже:
````text
Test singleton bean :
Alex
Duke
Test prototype bean:
Alex
Alex
````
Подробней с данным програмным кодом можно ознакомится [(тут)](https://github.com/ZubovVP/spring/tree/master/spring-bean/src/main/java/ru/zubov/scope/annotation)
## Жизненный цикл бинов
При создании бина, каждый бин проходит свой жизненный цикл:
1) После запуска Spring приложения происходит создания контейнера (ApplicationContext);
2) Создание всех бинов из конфигурационного файла;
3) Внедрение зависимостей во все созданные бины (Dependency Injection);
4) Вызов init-method у бина.

Бин готов к использованию.
После завершения Spring приложения, Spring совершит следующие действия:
1) Вызов destroy-method у бина;
2) Остановка Spring приложения.

На изображении представлен жизненный цикл бинов.
![Жизненный цикл бинов](https://github.com/ZubovVP/spring/blob/master/spring-bean/src/main/resources/images/SpringBeanLifeCycle.png "Жизненный цикл бинов в Spring")                                     

### Init метод
Init-method - это метод, который запускается в ходе инициализацию бина. В этом методе может быть любая логика, но обычно данный метод используется для подключения к БД или инициализации ресурсов.  
### Destroy метод
Destroy-method - это метод, который запускается в ходе уничтожения бина. Данный метод обычно используют для закрытия потоков ввода-вывода или для отключения от БД.
### Тонкости выполнение init() и destroy() методов
У init() и destroy() методов может быть любой модификатор доступа (public, protected, private).\
Название данных методов может быть любым.\
На вход никакие аргументы методы не должны принимать.\
Тип возвращаемого значения может быть любой, но мы не сможем его получить, поэтому рекомендуется использовать void.\
Для бинов со scope "prototype" Spring не вызывает destroy-method.
### Выполнение init() и destroy() методов
#### Выполнение init() и destroy() методов через xml конфигурацию
При создании бинов в конфигурационном xml файле, определение init-method и destroy-method будет указыватся следующим способом:
````xml
<bean id="person" 
class="ru.zubov.lifecycle.xml.Person"
 init-method = "init"
 destroy-method = "destroy">
    </bean>
````
Методы init() и destroy() должны быть созданы в классе бина (Child), Spring возьмёт на себя вызовы этих методов в павильный момент жизненного цикла.
Сам класс Person будет выглядить следующим образом :
````java
public class Person {
    public void init(){
        System.out.println("Start init-method");
    }

    public void destroy(){
        System.out.println("Start destroy-method");
    }
}
````
Для тестирования init() и destroy() методов необходимо будет создать контейнер (ClassPathXmlApplicationContext) и его закрыть:
````java
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-contextForLifecycle.xml");
        context.close();
    }
}
````
В результате создания и закрытия контейнера, на экран появиться информация о старте выполнения init() и destroy() методов. С полным программным кодом можно ознакомится [(тут)](https://github.com/ZubovVP/spring/tree/master/spring-bean/src/main/java/ru/zubov/lifecycle/xml)
#### Выполнение init() и destroy() методов через аннотацию
Сначала необходимо добавить следующую зависимость в проект:
````xml
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.2</version>
</dependency>
````
Init() и destroy() методы в классе отмечаются аннотациями непосредственно в самом классе:\
````java
@Component
public class Person {
    @PostConstruct
    public void init(){
        System.out.println("Start init-method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Start destroy-method");
    }
}
````
Init-method помечается аннотацией @PostConstruct.
Destroy-method помечается аннотацией @PreDestroy.
Для тестирования init() и destroy() методов необходимо будет создать контейнер (ClassPathXmlApplicationContext) и его закрыть:
````java
@Configuration
@ComponentScan("ru.zubov.lifecycle.annotation")
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        context.close();
    }
}
````
В ходе запуска данной программы, результат будет аналогичен, что и при конфигурировании через xml файл. С полным программным кодом можно ознакомится [(тут)](https://github.com/ZubovVP/spring/tree/master/spring-bean/src/main/java/ru/zubov/lifecycle/annotation)
#### Фабричный метод (Factory method)
Фабричный метод (Factory method) - это [паттерн программирования](https://ru.wikipedia.org/wiki/Шаблон_проектирования).
Данный паттерн позволяет создавать объекты не напрямую (использование оператора new), а через вызов специального (фабричного) метода, который после создания объекта передаёт его в качестве возвращаемого типа. Внутри данного метода всё равно создаются объекты при помощи оператора new, но это будет происходить уже внутри метода. Данная реализация удобна, когда необходимо перед использованием объекта произвести какие-либо настройки внутри объекта. Более подробно с фабричным методом можно ознакомится [тут](https://refactoring.guru/ru/design-patterns/factory-method).
Если объекты класса создаются через фабричный метод, то Spring необходимо объяснить какой метод создаёт объект данного класса, чтобы в дальнейшем он создавал бины через данный метод. Допустим у нас есть следующий класс:
````java
public class Person {
    private Person() {
    }

    public void init(){
        System.out.println("Start init-method");
    }
    
    public static Person createPerson() {
            System.out.println("Create Person");
            return new Person();
        }

    public void destroy(){
        System.out.println("Start destroy-method");
    }
}
````
В данном примере метод getPerson() является фабричным методом.
#### Тонкости использование фабричного метода
Для того чтобы ограничить пользователя к созданию объекта через оператор new, необходимо создать приватный конструктор.
Фабричный метод должен быть статическим, метод должен вызываться на классе, а не на объекте. Если метод будет не статическим, то получается что у нас не будет объекта на котором можно вызвать фабричный метод, а единственный метод получить новый объект - это вызвать фабричный метод.
Фабричный метод должен возвращать объекта класса на котором он вызывается. 
#### Использование фабричного метода при xml конфигурации
В случае если конфигурирование Spring приложение происходит через xml файл, то непосредственно в этом xml файле (внутри бина) необходимо указать название метода в параметр factory-method, чтобы Spring понимал что в дальнейшем создание бинов производить только через этот фабричный метод.
````xml
<bean id="person"
  class="ru.zubov.lifecycle.xml.Person"
  factory-method="createPerson"
  init-method = "init"
  destroy-method = "destroy">
</bean>
````
Для тестирования фабричного метода необходимо будет создать контейнер (ClassPathXmlApplicationContext) и получить объект:
````java
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-contextForLifecycle.xml");
        Person person = contex.getBean(Person.class);
        context.close();
    }
}
````
С полным программным кодом можно ознакомится [(тут)](https://github.com/ZubovVP/spring/tree/master/spring-bean/src/main/java/ru/zubov/lifecycle/xml)
#### Использование фабричного метода при использовании аннотаций
Создадим отдельный класс, в котором мы не будет аннотации @Component для того, чтобы Spring самостоятельно не создавал бины:
````java
public class PersonForFactoryMethod {
    private PersonForFactoryMethod() {
    }

    public static PersonForFactoryMethod createPerson() {
        System.out.println("Create Person");
        return new PersonForFactoryMethod();
    }
}
````
Для получения бина созданного через фабричный метод необходимо в конфигурационном файле создать метод, в котором будет создаваться данный объект с аннотацией @Bean:
````java
@Configuration
public class TestForFactoryMethod {
    @Bean
    public PersonForFactoryMethod createPerson(){
        return PersonForFactoryMethod.createPerson();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestForFactoryMethod.class);
        PersonForFactoryMethod person = context.getBean(PersonForFactoryMethod.class);
        context.close();
    }
}
````
При запуске Spring приложения мы получим объект созданный через фабричный метод. С полным программным кодом можно ознакомится [(тут)](https://github.com/ZubovVP/spring/tree/master/spring-bean/src/main/java/ru/zubov/lifecycle/annotation)

---
***Spring AOP***
### Что такое АОП?
[AOP (аспектно-ориентированное программирование)](https://ru.wikipedia.org/wiki/Аспектно-ориентированное_программирование) - это парадигма программирования являющейся дальнейшим развитием процедурного и объектно-ориентированного программирования (ООП). Идея АОП заключается в выделении так называемой сквозной функциональности.\
Помимо внедрения зависимостей (Dependence Injection - DI) Spring предлагает поддержку аспектно-ориентированного программирования (АОП). На АОП часто ссылаются как на инструмент реализации сквозной функциональности. Сквозная функциональность имеет отношение к логике, которая не может быть отделена от остальной части приложения и в результате приводить к дублированию кода. За счёт использования АОП можно избежать дублирования кода.\
Представьте себе приложение, которое в целях отладки регистрирует в журнале начало и завершение каждого метода. Можно вынести код регистрации в журнале в специальный класс, однако в дальнейшем придётся вызывать каждый раз методы этого класса для каждого метода нашего приложения. Используя АОП, можно просто указать что методы регистрирующего класса должны вызыватся перед и после каждого вызова метода в приложении.
### Концепции АОП
Как и большинство технологий, АОП имеет собственный специфичный набор концепций и терминов. В следующем списке приведены ключевые концепции АОП.

| Концепция | Описание |
|:---:|:--------:|
| Точка соединения (joinpoint) | Точки соединения являются ключевой концепцией АОП и определяют места в приложении, в которые можно вставлять дополнительную логику с применение АОП.
| Совет (advice) | Фрагмент кода, который должен выполняться в отдельной точке соединения, представляет собой совет, определённым методом в классе. Существует много типов советов, среди которых перед, когда совет выполняется до точки соединения, и после, когда совет выполняется после точки соединения.
| Срез (pointcut) | Это коллекция точек соединения, которая используется для определения ситуации, когда совет должен быть выполнен.
| Аспект (aspect) | Эта комбинация совета и срезов, инкапсулированных в классе. 
| Связывание (weaving) | Представляет собой процесс вставки аспектов в определённую точку точку внутри кода приложения. 
| Цель (target) | Это объект, поток выполнения которого изменяется каким-то процессов АОП. 
| Введение (introduction) | Представляет собой процесс, посредством которого можно изменить структуру объекта за счёт помещения в него дополнительных методов и или полей.
### Типы АОП
Различают два типа АОП : статическое и динамическое. Разница между ними касается точки, в которой происходит процесс связывания, а также того, каким образом этот процесс осуществляется.
#### Статическое АОП
При статической реализации аспектно-ориентированного программирования связывание является отдельным шагом в процессе построения программного продукта путем модификации  байт-кода классов, изменяя и дополняя его необходимым образом.\
Полученный в результате такого подхода код является более производительным, чем при использовании динамического АОП, так как во время исполнения нет необходимости отслеживать момента, когда надо выполнить ту или иную сквозную функциональность, представленную в виде совета (aspect).\\
Недостатком такого подхода реализации аспектно-ориентированного программирования является необходимость перекомпилирования приложения даже в том случае, когда надо только добавить новый срез (pointcut).
#### Динамическое АОП
Продукты, реализующие динамический вариант АОП отличается от статического тем, что процесс связывания (weaving) происходит динамически в момент исполнения. В Spring используется именно такой способ связывания и это реализовано с помощью использования специальных объектов-посредников (proxy) для объектов, к которым должны быть применены советы (advice). Недостатки статического подхода АОП являются достоинствами динамического: поскольку связывание происходит динамически, то нет необходимости перекомпилировать приложение для изменения аспектов. Однако эта гибкость достигается ценой небольшой потери производительности.
### Введение в Spring АОП
Ключевая архитектура АОП в Spring основана на proxy (основана на использовании объектов-посредников). Когда вы хотите создать экземлпяр класса, снабжённым советом (advice), то должны использовать класс [ProxyFactory](https://docs.spring.io/spring-framework/docs/3.0.x/javadoc-api/org/springframework/aop/framework/ProxyFactory.html), однако на практике чаще все используется декларативный способ создания посредников, основанный на ProxyFactoryBean.
Во время выполнения платформа Spring анализирует сквозную функциональность, определённую для бинов в ApplicationContext, и динамически генерирует прокси-бины (которые являются оболочками для лежащих в основе целевых бинов). Вместо обращения к целевому бину напрямую вызывающие объекты внедряю прокси-бин.
### Точки соединения в Spring
Одним из наиболее заметных упрощений АОП в Spring следует считать поддержку только одного типа точек соединения(jointpoint)  - вызовы методов классов. Это с одной стороны является существенным упрощением по сравнению с такими тяжеловесными реализациями АОП как AspectJ. Точка соединения типа вызов метода является наиболее часто используемой из всех доступных точек соединения и с её помощью можно решить практически любую задачу, которые делают АОП полезным в повседневной разработке. Главное не забыть что нужно снабдить советом некоторый код в точке соединения.
### Аспекты в Spring
В реализации АОП в Spring аспект представляется экземпляром класса, который реализует интерфейс [Advisor](https://docs.spring.io/spring-framework/docs/3.0.x/javadoc-api/org/springframework/aop/Advisor.html). Платформа Spring предлагает удобные реализации Advisor, которые можно применять в своих прилоржениях, устраняя необходимость в создании специальных реализаций Advisor. Существует два подчинённых интерфейса [IntroductionAdvisor](https://docs.spring.io/spring-framework/docs/3.0.x/javadoc-api/org/springframework/aop/IntroductionAdvisor.html) и  [PointcutAdvisor](https://docs.spring.io/spring-framework/docs/3.0.x/javadoc-api/org/springframework/aop/PointcutAdvisor.html).  
Интерфейс PointcutAdvisor реализован со всеми реализациями Advisor, которые используют срезы (pointcut) для управления применением совета к точкам соединения.  
С помощью интерфейса IntroductionAdvisor можно управлять классами, к которым применяется введение (introduction).
### ProxyFactory в Spring
Класс ProxyFactory управляет процессом связывания и создания прокси АОП в Spring. Прежде чем вы сможете создать прокси, необходимо указать снабжённый советом или целевой объект. Это можно сделать с использованием метода setTarget(). Внутри ProxyFactory делегирует процесс создания прокси экземпляру DefaultAopProxyFactory, который в вою очередь делегирует его либо Cglib2AopProxy, либо JdkDynamicAopProxy, в зависимости от параметров приложения. Создание прокси более подробно рассматривается далее.  
Класс ProxyFactory предоставляет метод addAdvice(), который создает экземпляр класса DefaultPointcutAdvisor и создает срез, который применяется ко всем методам исходного класса.  
Один и тот же экземпляр ProxyFactory можно применять для создания множества прокси, каждый из которых имеет отличающий аспект. Чтобы помочь в этом, в ProxyFactory предусмотрены методы removeAdvice() и removeAdvisor(), позволяющий удалять из ProxyFactory любой совет  или реализации Advisor, которые ранее были добавлены. Для проверки, имеет ли ProxyFactory конкретный присоединённый к нему совет, можно воспользоваться методом adviceIncluded(), передав ему проверяемый объект совета.
### Типы советов в Spring
Платформа Spring поддерживет шесть разновидностей советов, которые описаны ниже:

| Название совета | Название интерфейса |  Описание 
|:---:|:--------:|:--------:|
|  Перед(before) | org.springframework.aop.MethodBeforeAdvice | Используя совет "перед", можно осуществлять специальную обработку перед входом в точку соединения. Поскольку в Spring точка соединения - всегда вызов метода, по существу это позволяет реализовать предварительную обработку до вызова метода.
|  После возврата (after returning) | org.springframework.aop.AfterReturningAdvice | Совет "после возврата" выполняется после завершения выполнения вызова метода в точке соединения и возврата значения. Совет "после возврата" выполняется только в случае ***нормального завершения метода***
|  После (after finally) | org.springframework.aop.AfterAdvice | Совет "после" выполняется вне зависимости от результата метода, снабжённого советом.
|  Вокруг (around) | org.aopalliance.intercept.MethodInterceptor | Совету "вокруг" разрешено выполняться перед и после вызова метода.
|  Перехват (throws) | org.springframework.aop.ThrowsAdvice | Совет "перехват" выполняется после возврата из вызова метода, но только в случае, если во время вызова метода было сгенерировано исключение.
|  Введение (introduction) | org.springframework.aop.IntroductionInterceptor | Используя перехватчик введения, можно указать реализацию методов, которые должны быть введены советом.

### Интерфейсы для создания совета
В Spring предусмотрена чётко определённая иерархия интерфейсов советов.

![Иерархия интерфейсов](https://github.com/ZubovVP/spring/blob/master/aop/src/main/resources/images/TypeOfAdvice.png "Интерфейсы для типов советов Spring")

Такая иерархия обладает не только преимуществом своей объектно-ориентированной природы, но также и возможностью работы с типами советов обобщенным образом, используя единственный метод addAdvice() класса ProxyFactory, и добавление новых типов советов без необходимости в модификации класса ProxyFactory.
### Создание совета "перед"
Совет "перед" является одним из наиболее часто применяемых типов советов, доступных в Spring. В качестве разбора работы совета "перед" создадим следующий класс:
````java
public class WriterMessage {

    public void write(String s) {
        System.out.println(s);
    }
}
````
Класс WriterMessage получает строку и выводит на экран. Для того чтобы выполнять какое-либо действие перед вызовом метода write(String s) создадим следующий совет:
````java
public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Starting before method : " + method.getName());
    }
}
````
Данный класс имплементит интерфейс MethodBeforeAdvice и переопределяет метод before(). В данном методе мы будем просто выводить строку на экран.
Создадим класс для тестирования:
````java
public class TestBeforeAdvice {
    public static void main(String[] args) {
        ProxyFactory px = new ProxyFactory();
        px.setTarget(new WriterMessage());
        px.addAdvice(new SimpleBeforeAdvice());
        WriterMessage wm = (WriterMessage) px.getProxy();
        wm.write("Hello world!");
    }
}
````
Создаём ProxyFactory, вызываем метод setTarget() которому передаём наш экземляр класса WriterMessage.В данный момент мы используем срез по умолчанию, добавляем совет в наш ProxyFactory используя метод addAdvice() и добавляем класс SimpleBeforeAdvice, который имплементирует интерфейс MethodBeforeAdvice.
В результате выполнения этого примера генерируется следующий вывод:
````text
Starting before method : write
Hello world!
````
Как можно увидеть, вывод, полученный из вызова write("Hello world!"), присутствует, но перед ним находится вывод, сгенерированный SimpleBeforeAdvice.
### Защита доступа к методам с использованием совета "перед"
В этом разделе постараемся реализовать совет "перед", который проверяет учётные данные пользователя перед тем как разрешить вызов метода. Если учётные данный некоректны или не введены, то совет генерирует исключение, предотвращая выполнение метода.
Создадим класс, который будет отображать сообщение на экране.
````java
public class WriterMessages {

    public void write(String s) {
        System.out.println(s);
    }
}
````
Данном примере будет использоваться lombok, для его использования рекомендуется в проект добавить зависимость.
 ````xml
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.20</version>
            <scope>provided</scope>
        </dependency>
````
 Поскольку в этом примере требуется аутентификация пользователя, так или иначе, мы должны предусмотреть хранение логина и пароля. Код класса User предназначен для хранения учётных записи пользователя. 
````java
@Data
@AllArgsConstructor
public class User {
    private String login;
    private String psw;
}
````
Далее представлен класс SecurityManager, отвечающий за аутентификацию пользователей и сохранение данных с целью извлечение в будущем (данный класс имеет существенный упрощения, т.к. в этом примере ставиться задача по использованию совета "перед")
````java
public class SecurityManager {
    private static ThreadLocal<User> user = new ThreadLocal<>();

    public void login(String name, String psw) {
        user.set(new User(name, psw));
    }

    public void logout() {
        user.set(null);
    }

    public User getLoginAndPassword(){
        return user.get();
    }
}
````
Приложение использует класс SecurityManager для аутентификации пользователя и последующего извлечения деталей, связанный с аутентифицированным пользователем. Пользователь аутентифицируется с помощью метода login(). В реальном приложении, данный метод имел бы подключение к БД и перед добавлением пользователя проверял его наличе в БД и в случае если нет, то его бы добавлял в БД. В нашем примере метод login() создаёт User и сохроняет его в текущем потоке с применением ThreadLocal.Метод logout() полю ThreadLocal присваивается значение null. Метод getLoginAndPassword предоставляет информацию о зарегистрированном пользователе. Если аутенфицированый пользователь отсутствует, этот метод вернёт null.
Чтобы проверить аутентифицирован ли пользователь, мы должны создать совет, который перед методом сравнивает параметры User, в случае если параметры совпадают, то позволяет вызвать метод, если параметры не совпадают, то вызывается исключение и метод не вызывается. Класс SecurityAdvice, предоставляющий этот совет показан ниже.
````java
@AllArgsConstructor
public class SecurityAdvice implements MethodBeforeAdvice {
    private final SecurityManager sm;

    @Override
    public void before(Method method, Object[] objects, Object o) {
        User user = this.sm.getLoginAndPassword();
        if (user.getLogin() == null || user.getPsw() == null) {
            throw new SecurityException("Don't fill in login and password");
        }
        if (!user.getLogin().equals("Duke") || !user.getPsw().equals("psw")) {
            throw new SecurityException("Incorrect login or password!");
        }
        System.out.println("Everything is OK!");
    }
}
````
Класс SecurityAdvice получает в конструкторе экземпляр класса SecurityManager. В методе before() мы проводим простую проверку, соответствует ли имя и пароль указанным требованиям. Если это так, мы предоставляет доступ, а в противном случае генерируем исключение.
Создадим класс Test и протестируем наш совет.
````java
public class Test {
    private static WriterMessages WM;

    public static void main(String[] args) {
        checkWithCorrectNameAndPassword();
        try {
            checkWithIncorrectNameAndPassword();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        try {
            checkWithNameAndPasswordAreNull();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private static void checkWithCorrectNameAndPassword() {
        WM = getWriter("Duke", "psw");
        WM.write("Hello world!");
    }

    private static void checkWithIncorrectNameAndPassword() {
        WM = getWriter("Alex", "psw");
        WM.write("Hello world!");
    }

    private static void checkWithNameAndPasswordAreNull() {
        WM = getWriter(null, null);
        WM.write("Hello world!");
    }

    private static WriterMessages getWriter(String name, String psw) {
        WriterMessages writerMessages = new WriterMessages();
        SecurityManager smg = new SecurityManager();
        smg.login(name, psw);
        SecurityAdvice advice = new SecurityAdvice(smg);
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(writerMessages);
        pf.addAdvice(advice);
        return (WriterMessages) pf.getProxy();
    }
}
````
В данном классе мы тестируем наш код на 3 случая:
* Когда имя и пароль введены корректно;
* Когда имя и пароль введены не корректно;
* Когда имя и пароль не введены.

После запуска данного теста, в консоле можно увидеть следующее. При корректном имене и пароле наш раннее созданный совет позволяет выполнить метод:
````text
Everything is OK!
Hello world!
````
При указании не корректного имени и пароля на экране появляется exception:
````text
java.lang.SecurityException: Incorrect login or password!
	at ru.zubov.advice.before.exampleWithVerificate.SecurityAdvice.before(SecurityAdvice.java:28)
````
Если мы имя и пароль не указываем, то на экране появляется следующий exception:
````text
java.lang.SecurityException: Don't fill in login and password
	at ru.zubov.advice.before.exampleWithVerificate.SecurityAdvice.before(SecurityAdvice.java:25)
````
Несмотря на простоту, этот пример подчёркивает полезность совета "перед". Безопасность - типичный пример совета "перед", но данный совет находит как же применение когда требуется модификации аргументов, передаваемых методу.
Подробнее с программным кодом по созданию совета "перед" можно ознакомиться [(тут)](https://github.com/ZubovVP/spring/tree/master/aop/src/main/java/ru/zubov/advice/before).
### Создание совета "после возврата"
Совет "после возврата" выполняется после того, как произошёл возврат из вызова метода в точке соединения. Учитывая, что метод уже выполнен, переданные ему аргументы модифицировать невозможно. Несмотря на то что совет "после возврата" не позволяет изменять возвращаемое значение вызова метода, можно сгенерировать исключение, которое будет передано вверх по стеку вместо возвращаемого значения. Далее будет рассмотренно два примера использования совета "после возврата". В первом примере после вызова метода будет осуществляться вывод сообщение в консоль. Во втором примере показано, как можно использовать совет "после возврата" для добавления к методу проверки ошибок. 
Создадим совет, который после возвращения из метода будет выводить сообщение в консоль.
````java
public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Staring afterReturning after.");
        System.out.println("After method: " + method.getName());
    }
}
````
Данный класс имплементирует интерфейс AfterReturningAdvice, соответственно нам необходимо реализовать единственный метод afterReturning(). 
Для демонстрации работы совета, возьмём ранее реализованный класс WriterMessage.
````java
public class WriterMessage {
    public void write(String s) {
        System.out.println(s);
    }
}
````
Создадим класс, который продемонстрирует работу совета "после возврата". 

````java
public class TestAfterReturning {
    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(new WriterMessage());
        pf.addAdvice(new SimpleAfterReturningAdvice());
        WriterMessage wm = (WriterMessage) pf.getProxy();
        wm.write("Hello world!");
    }
}
````
Запуск этого примера даёт в результате следующий вывод:
````text
Hello world!
Staring afterReturning after.
After method: write
````
Вывод очень похож на результат, полученный в примере с советом "перед", за исключением того, что сообщение, записываемое советом, находится после сообщения записываемое методом write().
### Создание совета "после возврата" для дополнительной проверки 
Совет "после возврата" удобно применять при проведении дополнительной проверки ошибки, когда это возможно, для метода возвращаемое недопустимое значение.
Создадим класс, который будет предоставлять рандомное число от 0 до 9.
````java
public class NumberGenerator {
    private static final Random RD = new Random();

    public int getNumber() {
        return RD.nextInt(10);
    }
}
````
Экземлпяр данного класса при вызове метода getNumber(), предоставляет случайное число от 0 до 9.
Создадим совет, который будет проводить проверку чисел.
````java
public class CheckNumberAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        if ((o1 instanceof NumberGenerator) && ("getNumber".equals(method.getName()))) {
            if ((Integer) o > 5) {
                System.out.println("Number is OK - " + o);
            } else {
                throw new SecurityException("Number is wrong!");
            }
        }
    }
}
````
Данный совет производить проверку получаемого результата и в случае если  значение меньше 5, то будет передано дальше в стек исключение.
Создадим класс дла тестирования ранее созданного совета.
````java
public class TestCheckNumberAdvice {
    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new CheckNumberAdvice());
        pf.setTarget(new NumberGenerator());
        NumberGenerator ng = (NumberGenerator) pf.getProxy();
        for (int x = 0; x < 10; x++) {
            try {
                 ng.getNumber();
            } catch (SecurityException ex) {
                System.out.println("Number is wrong!");
            }
        }
    }
}
````
Запуск этого примера даёт в результате следующий вывод:
````text
Number is wrong!
Number is OK - 8
Number is wrong!
Number is OK - 6
Number is OK - 7
Number is OK - 7
Number is wrong!
Number is OK - 9
Number is wrong!
Number is OK - 8
````
Как и ожидалось, временами генерируемое число будет меньше 5, в результате чего будет сгенерировано исключение SecurityException.
Подробнее с программным кодом по созданию совета "после возврата" можно ознакомиться [(тут)](https://github.com/ZubovVP/spring/tree/master/aop/src/main/java/ru/zubov/advice/afterreturning).
### Создание совета "вокруг"
Совет "вокруг" функционирует подобно комбинации советов "перед" и " после", но с одним отличием - имеется возможность модифицировать возвращаемое значение. Кроме того, можно предотвратить выполнение метода. Совет "вокруг" в Spring моделируется как перехватчик с использованием интерфейса MethodInterceptor.
Создадим класс, который будет иметь один метод. Данный метод будет получать какое-либо значение, выводить это значение в консоль и его возвращать его без изменений.
````java
public class WriterMessages {

    public int write(int count) {
        System.out.println("Count = " + count);
        return count;
    }
}
````
Создадим совет, который будет выводить информацию до вызова основного метода, выводить информацию после вызова основного метода, а так же увеличивать возвращаемое значение в два раза.
````java
public class AroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Start around advice");
        Object retVal = (int) methodInvocation.proceed() * 2;
        System.out.println("Finish around advice ");
        return retVal;
    }
}
````
Создадим класс, в котором протестируем наш ранее созданный совет.
````java
public class TestAroundAdvice {

    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(new WriterMessages());
        pf.addAdvice(new AroundAdvice());
        WriterMessages wm = (WriterMessages) pf.getProxy();
        int result = wm.write(5);
        System.out.println("count after advice - " + result);
    }
}
````
Запуск этого примера даёт в результате следующий вывод:
````text
Start around advice
Count = 5
Finish around advice 
Result - 10
````
Вывод позволяет видеть, что раннее созданный совет "вокруг" добавил текст перед вызовом основного метода, а так же после. Передаваемое значение было так же советом увеличено в два раза.
Подробнее с программным кодом по созданию совета "вокруг" можно ознакомиться [(тут)](https://github.com/ZubovVP/spring/tree/master/aop/src/main/java/ru/zubov/advice/around).
### Создание совета "перехват"
Совет "перехват" похож на совет "после возврата" тем, что выполняется после точки соединения, которая всегда является вызовом метода, но совет "перехват" инициируется, только после метод генерирует исключение. При использованни совета "перехват" нельзя проигнорировать возникшее исключение и взамен возвратить какое-то значение. Единственная модификация, которую можно внести в поток управления программы, заключается в изменении типа сгенерированного исключения.
Совет "перехват" реализован интерфейсом ThrowsAdvice. У данного интерфейса не определено ни одного метода; он просто является маркерным интерфейсом, применяемой Spring.
Для демонстрации работы создадим класс Error
````java
public class Error {

    public void doSomethingMethod() throws Exception {
        throw new Exception("doSomethingMethod");
    }

    public void doAnotherSomethingMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("doAnotherSomethingMethod");
    }

}
```` 
Данный класс имеет два метода, которые генерируют исключения разных типов.
Код класса SimpleThrowsAdvice отображает обе сигнатуры методов, которые Spring ищет для совета "перехват".
````java
public class SimpleThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex) throws Throwable{
        System.out.println("***");
        System.out.println("Generic Exception ");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) throws Throwable {
        System.out.println("***");
        System.out.println("IllegalArgumentException Exception ");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***\n");

    }
}
````
Первый метод afterThrowing() в классе SimpleThrowsAdvice принимает единственный аргумент типа Exception. В нём можно указывать любой тип исключения, и этот метод идеально подходит, когда вас не интересует метод, сгенерировавший исключение, или переданные ему аргументы. Данный метод перехватывает Exception и любые подтипы Exception, если только для них не предусмотрены собственные методы.
Во втором методе afterThrowing() объявлено четыре аргумента для указания метода, сгенерировавшего исключение, аргументов в этом методе важен, и они должны быть указаны все четыре. Данный метод перехватывает исключения типа IllegalArgumentException (или его подтипа).
Создадим класс для тестирования совета "перехват":
````java
public class TestThrowsAdvice {
    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleThrowsAdvice());
        pf.setTarget(new Error());
        Error er = (Error) pf.getProxy();
        try {
            er.doSomethingMethod();
        } catch (Exception ignored) {
        }
        try {
            er.doAnotherSomethingMethod();
        } catch (Exception ignored) {
        }
    }
}
`````
Выполнение этого примера даёт следующий вывод:
````text
***
Generic Exception 
Caught: java.lang.Exception
***

***
IllegalArgumentException Exception 
Caught: java.lang.IllegalArgumentException
***
````
Как видно из вывода в консоль, когда генерируется простое исключение Exception, вызывается первый метод afterThrowing(), но при генерации IllegalArgumentException вызывается второй метод afterThrowing(). В ситуации, когда совет "перехват" имеет дело с двумя методами afterThrowing(), причём оба объявлены с тем самым типом Exception, но один принимает единственный аргумент, а другой - четыре аргумента, Spring вызывает метод с четырьмя аргументами.
Данный совет удобен при отладке готовых приложений, т.к. он позволяет добавлять дополнительный код регистрации в журнале, не изменяя код самого приложения.Подробнее с программным кодом по созданию совета "вокруг" можно ознакомиться [(тут)](https://github.com/ZubovVP/spring/tree/master/aop/src/main/java/ru/zubov/advice/throws_advice).
### Выбор типа совета
В общем случае выбор типа совета зависит от поставленной задачи, выбирать нужно наиболее специфический тип совета. Другими словами, не нужно использовать совет "вокруг", если подходит совет "перед". В большинстве случаев совет "вокруг" может обеспечить всё то, что поддерживают остальные три типа советов, однако он может оказаться излишним для реализации задуманного. Применяя наиболее подходящий тип совета, вы делаете программный код более понятным, а так же сокращается возможность совершения ошибок.  
### Советы и срезы
Ранее во всех примерах при конфигурировании совета для прокси вызывался метод ProxyFactory.addAdvice(). Внутри этот метод делегирует свою работу методу addAdvisor(), создающий экземпляр DefaultPointcutAdvisor и конфигурирующему его со срезом, который указывает *на все методы*. В такоей ситуации совет применяется ко всем методам целевого объекта, но зачастую нам нет необходимости в использовании совета ко всем методам целевого объекта. Самое просто что может прийти в голову, это выполнять проверку, подходит или не подходит метод, но в таком подходе есть существенные недостатки. Один из которых заключается в том, что присутствует жёсткое кодирование применяемых методов в совете и тем самым теряется возможность многократного использования. С помощью срезов можно конфигурировать перечень методов, к которым будет применим совет, не помещая этот код внутрь совета, тем самым квеличивается возможность многократного использования совета.
Если снабжаемый советом метод проверяется внутри совета, проверка выполняется каждый раз, когда вызывается любой метод целевого объекта, тем самым страдает производительность. Когда применяется срезы, проверка выполняется один раз к одному методу, а резульаты кэшируется для дальнейшего использования.
Настоятельно рекомендуется использовать срезы (где это возможно) для избежания жёстко кодирования и увеличения производительности программы, но не рекомендуется злоупотреблять этим, так как это может привести к замедлению работы программы.
### Интерфейс Pointcut
Срезы в Spring создаются путём реализации интерфейса Pointcut. В интерфейсе Pointcut определены два метода, getClassFilter() и getMethodMatcher(), которые возвращают экземпляры ClassFilter и MethodMatcher. К счастью, реализовывать данный методы не обязательно, поскольку Spring предоставляет реализации Pointcut на выбор, покрывающие большинство сценариев использования.
При выявлении, применим ли интерфейс Pointcut к конкретному методу, Spring сначала проверяет, применим ли Pointcut к классу этого метода, который возвращается вызовом Pointcut.getClassFilter(). В интерфейсе ClassFilter определён единственный метод matches(), который принимает экземпляр Class для проверки и возвращает true если срез применим классу или в противном случае false.
Интерфейс MethodMatcher сложнее интерфейса ClassFilter. В Spring поддерживается два типа MethodMatcher, статический и динамический, что определяется по возвращаемому значению метода isRuntime(), если данный метод возвращает false, то значит что MethodMatcher является статическим или же динамическим, что отражается значением true.
Для статического среза Spring вызывает метод matches(Method, Class<T>) интерфейса MethodMatcher по одному разу для каждого метода целевого объекта.\
Для динамического среза Spring вызывает метод matches(Method, Class<T>) интерфейса MethodMatcher единожды, чтобы определить общую принадлежность этого метода и если результат окажется true, то Spring проводит дальнейшую проверку для каждого вызова метода используя matches(Method, Class<T>, Object[]). Таким образом динамический MethodMatcher может выяснить, должен ли применяться срез, на основе конкретного вызова метода, а не только самого метода.\
Очевидно что статические срезы выполняются намного быстрее динамических, т.к. не требуют дополнительной проверки при каждом вызове. В общем случае рекомендуется использовать статические срезы везде, где это возможно.
### Доступные реализации Pointcut
В Spring 4.0 предлагается восемь реализаций интерфейса Pointcut, а именно два абстрактных класса служащие для создания статических и динамических срезов, и шесть конкретных классов предназначенных для решения следующих задач:
* объединение множества срезов в одно целое;
* поддержка срезов потока управления;
* выполнение простых сопоставлений на основе имени;
* определение срезов с применением регулярных выражений;
* определение срезов с применением AspectJ;
* определение срезов, которые ищут специфические аннотации на уровне классов и методов;

| Класс реализации | Описание 
|:---:|:--------:|
| org.springframework.aop.support.annotation.AnnotationMatchingPointcut | Срез, который ищет специфическую Java-аннотацию в классе или методе.   
| org.springframework.aop.aspectJ.AspectJExpressionPointcut | Срез, который использует средство связывания AspectJ для оценки выражения среза, представленного с помощью синтаксиса AspectJ.
| org.springframework.aop.support.ComposablePointcut | Класс ComposablePointcut применяется для объединения двух и более срезов с помощью методов как union() и intersection().   
| org.springframework.aop.support.ControlFlowPointcut | Класс ControlFlowPointcut представляет срез, предназначенный для специального случая, который соответствует любому методу, который вызван прямо или косвенно в результате выполнения другого метода.
| org.springframework.aop.support.DynamicMethodMatcherPointcut | Класс DynamicMethodMatcherPointcut применяется для построения динамических срезов.
| org.springframework.aop.support.StaticMethodMatcherPointcut | Класс StaticMethodMatcherPointcut применяется для построения статических срезов.
| org.springframework.aop.support.JdkRegexpMethodPointcut | Класс JdkRegexpMethodPointcut применяется для построения срезов с использованием регулярных выражений.
| org.springframework.aop.support.NameMatchMethodPointcut | Класс NameMatchMethodPointcut применяется для построения среза, который выполняет сопоставление со списком имён методов.

### Создание статического среза с использованием StaticMethodMatcherPointcut
Создадим два простых класса Bean, которые будут иметь два метода:
````java
public class BeanFirst {
    
    public void doSomethingOne(){
        System.out.println("BeanFirst: starting method doSomethingOne");
    }

    public void doSomethingTwo(){
        System.out.println("BeanFirst: starting method doSomethingTwo");
    }

}

public class BeanSecond {
    
    public void doSomethingOne(){
        System.out.println("BeanSecond: starting method doSomethingOne");
    }

    public void doSomethingTwo(){
        System.out.println("BeanSecond: starting method doSomethingTwo");
    }

}
````
Методы в классе BeanFirst и BeanSecond просто выводят информацию в консоль. В этом примере нам нужно будет создать прокси для обоих классов, но применить совет только к одному методу doSomethingOne() класса BeanFirst.
Чтобы это сделать, нам необходимо создать класс SimpleStaticPointcut, который наследуется от класса StaticMethodMatcherPointcut:
````java
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return ("doSomethingOne".equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return aClass == BeanFirst.class;
            }
        };
    }
}
````
Реализация метода matches(Method method, Class<?> aClass) возвращает true, если метод имеет имя doSomethingOne и false если другое. Нам необходимо переопределить метод getClassFilter() для того, чтобы статический срез соответствовал только для методов класса BeanFirst.
Создадим простой совет, который будет выводить сообщения перед началом выполнения метода и после его выполнения (совет around):
````java
public class SimpleAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before method " + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        System.out.println("After method " + methodInvocation.getMethod().getName());
        return result;
    }
}
````
Создадим класс для тестирования статического среза:
````java
public class TestStaticPointcut {
    public static void main(String[] args) {
        BeanFirst bf = new BeanFirst();
        BeanSecond bs = new BeanSecond();

        Pointcut pc = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(bf);
        BeanFirst beanProxyFirst = (BeanFirst) pf.getProxy();

        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(bs);
        BeanSecond beanProxySecond = (BeanSecond) pf.getProxy();

        beanProxyFirst.doSomethingOne();
        beanProxyFirst.doSomethingTwo();
        System.out.println("---------------------");
        beanProxySecond.doSomethingOne();
        beanProxySecond.doSomethingTwo();
    }
}
````
Выполнение этого примера даёт следующий результат:
````text
Before method doSomethingOne
BeanFirst: starting method doSomethingOne
After method doSomethingOne
BeanFirst: starting method doSomethingTwo
---------------------
BeanSecond: starting method doSomethingOne
BeanSecond: starting method doSomethingTwo
````
Как видно из результата выполнения тестирования, единственный метод, к которому применялся совет SimpleAdvice, был метод doSomethingOne() класса BeanFirst.
Подробнее с программным кодом можно ознакомиться [(тут)](https://github.com/ZubovVP/spring/tree/master/aop/src/main/java/ru/zubov/pointcut/static_pointcut).

### Создание динамического среза с использованием DynamicMethodMatcherPointcut
Создание динамического среза не сильно отличается от статического среза, поэтому будем использовать пример из предыдущего раздела с небольшими модификациями. Создадим один класс с двумя методами, но в методы мы будем передавать аргумент:
````java
public class BeanFirst {

    public void doSomethingOne(int x){
        System.out.println("BeanFirst: starting method doSomethingOne, count = " + x);
    }

    public void doSomethingTwo(int x){
        System.out.println("BeanFirst: starting method doSomethingTwo, count = " + x);
    }

}
````
Как и в случае со статическим срезом, для создания динамических срезов создадим класс, который будет наследоваться от DynamicMethodMatcherPointcut:
````java
public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("Check method for " + method.getName());
        return ("doSomethingOne".equals(method.getName()) && (int) objects[0] >= 100);
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return aClass == BeanFirst.class;
            }
        };
    }
}
````
В методе matches(Method method, Class<?> aClass, Object... objects) мы хотим снабдить метод doSomethingOne() советом, при условии если приходящий к нему аргумент равен 100 или более, то возвращает true, в противном случае возвращает false. В классе метод ClassFilter() подобно предыдущему примеру устраняет необходимость в проверке класса в методах сопоставления имён методов.
Создадим простой совет, который будет выводить сообщения перед началом выполнения метода и после его выполнения (совет around):
````java
public class SimpleAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before method " + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        System.out.println("After method " + methodInvocation.getMethod().getName());
        return result;
    }
}
````
Создадим класс для тестирования динамического среза:
````java
public class TestDynamicPointcut {
    public static void main(String[] args) {
        BeanFirst bf = new BeanFirst();

        Pointcut pc = new SimpleDynamicPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(bf);
        BeanFirst beanProxyFirst = (BeanFirst) pf.getProxy();

        beanProxyFirst.doSomethingOne(1);
        beanProxyFirst.doSomethingOne(10);
        beanProxyFirst.doSomethingOne(100);

        beanProxyFirst.doSomethingTwo(100);

    }
}
````
Выполнение этого примера даёт следующий результат:
````text
Check method for doSomethingOne
BeanFirst: starting method doSomethingOne, count = 1
Check method for doSomethingOne
BeanFirst: starting method doSomethingOne, count = 10
Check method for doSomethingOne
Before method doSomethingOne
BeanFirst: starting method doSomethingOne, count = 100
After method doSomethingOne
Check method for doSomethingTwo
BeanFirst: starting method doSomethingTwo, count = 100
````
Как видно из результата выполнения тестирования, единственный метод, к которому применялся совет SimpleAdvice, был метод doSomethingOne(). При условии если переданный аргумент был 100 или больше, то к нему применялся совет SimpleAdvice. Все остальные методы работают без изменения.
Подробнее с программным кодом можно ознакомиться [(тут)](https://github.com/ZubovVP/spring/tree/master/aop/src/main/java/ru/zubov/pointcut/dynamic_pointcut).
### Создание среза с использованием простого сопоставления имён (NameMatchMethodPointcut)
Очень часто при создании среза требуются выполнить сопоставление на основе лишь названия метода, игнорируя сигнатуру и возвращаемый тип. Для таких целей используется подкласс StaticMethodMatcherPointcut - NameMatchMethodPointcut. Когда используется NameMatchMethodPointcut, то никакого внимания сигнатуре не уделяется, поэтому в не зависимости от того какие аргументы передаются методу, они будут выполняться оба.    
В качестве примера создадим следующий класс:
````java
public class BeanFirst {

    public void testOne() {
        System.out.println("Processing method - testOne without arguments");
    }

    public int testOne(int count) {
        System.out.println("Processing method - testOne with arguments");
        return count;
    }

    public void testTwo() {
        System.out.println("Processing method - testTwo without arguments");
    }
}
````
В рассматриваемом примере мы снабдим метод testOne() советом, в не зависимости от того какой из двух методов вызывается.
Возьмём совет из предыдущего примера:
````java
public class SimpleAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before method " + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        System.out.println("After method " + methodInvocation.getMethod().getName());
        return result;
    }
}
```` 
Создадим класс для тестирования:
````java
public class TestNamePointcut {
    public static void main(String[] args) {
        BeanFirst bf = new BeanFirst();
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("testOne");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(bf);
        pf.addAdvisor(advisor);

        BeanFirst proxy = (BeanFirst) pf.getProxy();
        proxy.testOne();
        System.out.println("---------------");
        proxy.testTwo();
        System.out.println("---------------");
        proxy.testOne(10);
    }

}
````
Потребность в построении класс для среза отсутствует, достаточно просто создать экземпляр класса NameMatchMethodPointcut и с помощью метода addMethodName(), добавить названия методов к котором необходимо применить совет. Запуск этого примера даёт следующий результат:
````text
Before method testOne
Processing method - testOne without arguments
After method testOne
---------------
Processing method - testTwo without arguments
---------------
Before method testOne
Processing method - testOne with arguments
After method testOne
````
Как и ожидалось, благодаря срезу методы testOne() и testOne(int count) были снабжены советом, а метод testTwo() остался не тронутым.
Подробнее с программным кодом можно ознакомиться [(тут)](https://github.com/ZubovVP/spring/tree/master/aop/src/main/java/ru/zubov/pointcut/name_pointcut).
### Создание среза с использованием AspectJ
Для работы с выражениями срезов AspectJ необходимо к проекту добавить зависимости:
````xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.9.7</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.7</version>
    <scope>runtime</scope>
</dependency>
````
Возьмём бин из прошлого примера добавим третий метод и постараемся сделать так, чтобы совет применялся ко всем методам, которые начинаются на do, но с использованием AspectJ:
````java
public class BeanFirst {

    public void doSomethingOne(){
        System.out.println("BeanFirst: starting method doSomethingOne");
    }

     public int doSomethingTwo(int count){
            System.out.println("BeanFirst: starting method doSomethingTwo");
            return count;
        }

    public void somethingThree(){
        System.out.println("BeanFirst: starting method somethingThree");
    }
}
````
Возьмём совет из предыдущего примера:
````java
public class SimpleAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before method " + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        System.out.println("After method " + methodInvocation.getMethod().getName());
        return result;
    }
}
```` 
С помощью среза, основанного на выражении AspectJ, можно также обеспечить сопоставление со всеми методами этого класса, которые начинаются с do.
````java
public class TestAspectJPointcut {
    public static void main(String[] args) {
        BeanFirst bf = new BeanFirst();
        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression("execution(* do*(..))");
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(bf);
        pf.addAdvisor(advisor);

        BeanFirst proxy = (BeanFirst) pf.getProxy();
        proxy.doSomethingOne();
        System.out.println("------------");
        proxy.doSomethingTwo(100);
        System.out.println("------------");
        proxy.somethingThree();
    }
}
````
Метод setExpression() класса AspectJExpressionPointcut используется для установки критерия совпадения. Выражение pc.setExpression("execution(* do*(..))") означает, что совет должен применяться к выполнению любых методов, которые имею имена начинающиеся на do, принимают любые аргументы и возвращает значения любого типа.
Запуск программы даст следующий результат:
````text
Before method doSomethingOne
BeanFirst: starting method doSomethingOne
After method doSomethingOne
------------
Before method doSomethingTwo
BeanFirst: starting method doSomethingTwo
After method doSomethingTwo
------------
BeanFirst: starting method somethingThree
````
Применение совета произошло только к методу doSomethingOne и doSomethingTwo, а именно тех, которые начинаются на do.
Подробнее с программным кодом можно ознакомиться [(тут)](https://github.com/ZubovVP/spring/tree/master/aop/src/main/java/ru/zubov/pointcut/aspctj).
### Создание среза с использованием аннотации
