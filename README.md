# Spring

## Инструкции по работе Spring

### Оглавление
0. [Что такое Spring?](#Что-такое-Spring?)
1. [Модули Spring](#Модули-Spring)
2. [Введение в IoC и DI в Spring](#Введение-в-IoC-и-DI-в-Spring)
3. [Сведения о конфигурации Spring](#Сведения-о-конфигурации-Spring)
4. [Внедрение зависимостей](#Внедрение-зависимостей)
5. [Жизненный цикл бинов](#Жизненный-цикл-бинов)


## Что такое Spring?
Spring - это фрэймворк, который предствляет из себя контейнер внедрения зависимостей с несколькими модулями.
Модули легко подключаются к проекту в случае необходимости.
Spring позволяет вам быстрее и удобней создавать Java-приложения. 

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
Одна из ключевой особенностью приложения, написанного на Spring, состоит в том что большую часть объектов создаем не программист, а сам Spring.
Программист лишь объясняет Spring (с помощью аннотаций либо в конфигурационном XML), какие именно объекты он должен создать самостоятельно.
Spring управляет созданием объектов и потому его контейнер называется IoC-контейнер.
IoC расшифровывается как Inversion of Control [(IoC)](https://ru.wikipedia.org/wiki/Инверсия_управления). 
А объекты, которые создаются контейнером и находятся под его управлением, называются бинами.

#### Dependency Injection (внедрение зависимостей)
В ходе создания бинов Spring самостоятельно инициализирует поля в соответствии инструкциями, которые указал сам программист(с помощью аннотаций либо в конфигурационном XML).
Внедрение зависимости – это и есть процесс инициализации полей бинов другими бинами (зависимостями).

## Сведения о конфигурации Spring
Как говорилось ранее, программист может объяснить Spring какие именно бины нужно создать с помощью конфигурационного файла или же с помощью аннотаций.  
ApplicationContext — это главный интерфейс в Spring-приложении, который предоставляет информацию о конфигурации приложения. В зависимости от способа конфигурации приложения, будет создаваться различный объект интерфейса ApplicationContext.  
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
    <artifactId>spring-core</artifactId>
    <version>5.2.4.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-beans</artifactId>
    <version>5.2.4.RELEASE</version>
</dependency>
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
Для того чтобы Spring понимал какой бин необходимо создать, то мы должны добавить информацию о классе в этот конфигурационный файл
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
 При запуске данного приложения мы увидим информацию на консоле. С полной реализацией данного принципа можно ознакомиться [(тут)](https://github.com/ZubovVP/spring/tree/master/spring-bean/src/main/java/ru/zubov/springbean/xml)
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
Можно увидеть что появилась аннотация @Component("helloAnnotation"), которая говорит Spring что необходимо будет создать бин данного класса и присвоить ему id = "helloAnnotation".
В отличие от конфигурировании xml класс тест тоже приобретает некоторые отличия:
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
## Внедрение зависимостей
Существует несколько способов внедрения зависимостей в бины, внедрять зависимости можно через конструктор или же через сеттер.  
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
### Внедрение зависимостей с помощью Xml файла

### Внедрение зависимостей с помощью аннотаций
Существует несколько аннотаций, которые позволяют программисту объяснить Spring как внедрять зависимости:
* использование аннотации @Value  

При использовании аннотации @Value программист может указать какое-либо конкретное значение, либо указать значение из файла имеющее расширение properties. Ниже показано как это можно сделать.
Для того чтобы внедрить зависимость через сеттер, то достаточно установить аннотацию над полем или же над сеттером
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
Использование данной аннотации Spring сам будет искать из уже созданных бинов, какой бин туда можно подставить, в случае если ни одного подходящего нет или же их больше чем 1, то выскочит exception.

* использование аннотации @Inject  


![Alt-текст](https://wiki.wolf-a.ru/images/f/f2/SpringBeanLifeCycle.png )
