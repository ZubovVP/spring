# Spring

## Инструкции по работе Spring

### Оглавление
0. [Что такое Spring?](#Что-такое-Spring?)
1. [Модули Spring](#Модули-Spring)
2. [Введение в IoC и DI в Spring](#Введение-в-IoC-и-DI-в-Spring)
3. [Сведения о конфигурации Spring](#Сведения-о-конфигурации-Spring)
4. [Внедрение зависимостей](#Внедрение-зависимостей)
5. [Жизненный цикл бинов](#Жизненный-цикл-бинов)
6. [Init метод](#Init-метод)
7. [Destroy метод](#Destroy-метод)
8. [Тонкости выполнение init() и destroy() методов](#Тонкости-выполнение-init()-и-destroy()-методов)
9. [Выполнение init() и destroy() методов через xml конфигурацию](#Выполнение-init()-и-destroy()-методов-через-xml-конфигурацию)
10. [Выполнение init() и destroy() методов через аннотацию](#Выполнение-init()-и-destroy()-методов-через-аннотацию)
11. [Фабричный метод (Factory method)](#Фабричный-метод-(Factory-method))





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

На изображении представлен представлен жизненный цикл бинов.                                          
![Alt-текст](https://wiki.wolf-a.ru/images/f/f2/SpringBeanLifeCycle.png )
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
###№ Тонкости использование фабричного метода
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



