Java基础

### Collection集合

#### List：可重复

三个实现类：ArrayList、Vector和LinkedList

1. ArrayList：基于数组实现，增删慢，查询快，线程不安全
2. Vector：基于数组实现，增删慢，查询快，线程安全
3. LinkedList：基于双向链表实现，增删快，查询慢，线程不安全

#### Queue

Queue是队列，Java中常见的队列如下：

- ArrayBlockingQueue：基于数组数据结构实现的有界阻塞队列
- LinkedBlockingQueue：基于链表数据结构实现的有界阻塞队列
- PriorityBlockingQueue：支持优先级排序的无界阻塞队列
- DelayQueue：支持延时操作的无界阻塞队列
- SynchronousQueue：用于线程同步的阻塞队列
- LinkedTransferQueue：基于链表数据结构实现的无界阻塞队列
- LinkedBlockingDeque：基于链表的数据结构实现的双向阻塞队列

#### Set：不可重复

- HashSet：HashTable实现，无序
- TreeSet:二叉树实现
- LinkedHashSet：HashTable实现数据存储，双向链表记录顺序

#### Map

- HashMap:数组+链表存储数据，线程不安全
- ConcurrentHashMap：分段锁实现，线程安全
- HashTable：线程安全
- TreeMap：基于二叉树数据结构
- LinkedHashMap：基于HashTable数据结构，使用链表保存插入的顺序。



### Annotation注解

#### 源码样例：

``` java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MthCache {
    String key();
}
```

#### @Target注解

功能：功能：指明了修饰的这个注解的使用范围，即被描述的注解可以用在哪里。

ElementType的取值包含以下几种：

- TYPE：类，接口或者枚举
- FIELD：域，包含枚举常量
- METHOD：方法
- PARAMETER：参数
- CONSTRUCTOR：构造方法
- LOCAL_VARIABLE：局部变量
- ANNOTATION_TYPE：注解类型
- PACKAGE：包

#### @Retention注解

功能：指明修饰的注解的生存周期，即会保留到哪个阶段。

RetentionPolicy的取值包含以下三种：

- SOURCE：源码级别的保留，编译后即丢弃。
- CLASSL：编译级别保留，编译后的class文件中存在，在jvm中运行时丢弃，这是默认值。
- RUNTIME：运行级别保留，编译后的Class文件中存在，在jvm运行时保留，可以通过反射调用。

#### @Dounmented注解

功能：指明修饰的注解，可以被例如javadoc此类的工具文档化，只负责标记，没有成员取值。

#### Inherited注解

功能：允许子类继承父类中的注解。



### InnerClass内部类

分为静态内部类、成员内部类、局部内部类和匿名内部类

#### 静态内部类

```java
public class OuterClass {
    private static  String className = "staticInnerClass";
    //定义一个静态的内部类
    public static class StaticInnerClass{
        public void getClassName(){
            System.out.println("className:"+className);
        }
    }

    public static void main(String[] args) {
        //调用静态内部类
        //StaticInnerClass staticInnerClass = new StaticInnerClass();
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        //通过“外部内.静态内部类”方法进行调用
        staticInnerClass.getClassName();
    }
}
```

#### 成员内部类

```java
public class OuterClass {
    private static  String className = "staticInnerClass";
    private static int a;
    private int b;
    //定义一个静态的内部类
    public static class StaticInnerClass{
        public void getClassName(){
            System.out.println("className:"+className);
        }
    }

    //定义一个成员内部类
    public class MemberInnerClass{
        public void print(){
            System.out.println(a);
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        //调用静态内部类
        //StaticInnerClass staticInnerClass = new StaticInnerClass();
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        //通过“外部内.静态内部类”方法进行调用
        staticInnerClass.getClassName();

        //调用成员内部类
        MemberInnerClass memberInnerClass = new OuterClass().new MemberInnerClass();
        memberInnerClass.print();
    }
}
```

#### 局部内部类

```java
    private static  String className = "staticInnerClass";
    private static int a;
    private int b;
    //定义一个静态的内部类
    public static class StaticInnerClass{
        public void getClassName(){
            System.out.println("className:"+className);
        }
    }

    //定义一个成员内部类
    public class MemberInnerClass{
        public void print(){
            System.out.println(a);
            System.out.println(b);
        }
    }

    public void partClassTest(final int c){
        final int d = 1;//局部内部类访问局部变量必须用final修饰
        //在partClassTest方法中定义一个局部内部类PastClass
        class PastClass{
            public void print(){
                System.out.println(c);
                System.out.println(d);
            }
        }
        PastClass pastClass = new PastClass();
        pastClass.print();
    }

    public static void main(String[] args) {
        //调用静态内部类
        //StaticInnerClass staticInnerClass = new StaticInnerClass();
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        //通过“外部内.静态内部类”方法进行调用
        staticInnerClass.getClassName();

        //调用成员内部类
        MemberInnerClass memberInnerClass = new OuterClass().new MemberInnerClass();
        memberInnerClass.print();

        //调用局部内部类
        OuterClass out = new OuterClass();
        out.partClassTest(3);
    }
}
```

#### 匿名内部类

匿名内部类指通过继承一个父类或者实现一个接口的方式直接定义并使用的类。匿名内部类没有class关键字，这是因为匿名内部类直接使用new生成了一个对象的引用。

```java
public abstract class Worker {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract int workTime();
}

class Test{
    public void test(Worker worker){
        System.out.println(worker.getName()+"工作时间："+worker.workTime());
    }

    public static void main(String[] args) {
        Test test = new Test();
        //在方法中定义并使用一个匿名内部类
        test.test(new Worker(){
            @Override
            public int workTime(){
                return 8;
            }
            @Override
            public String getName() {
                return "alex";
            }
        });
    }
}
```

### Generic泛型

####  泛型方法

```java
public class Generic {
    public static void main(String[] args) {
        generalMethod("1",2, new Worker() {
            @Override
            public int workTime() {
                return 0;
            }
        });
    }

    public static <T> void generalMethod(T ... inputArray){
        for (T element : inputArray){
            if (element instanceof Integer){
                System.out.println("处理Integer中的类型...");
            }else if (element instanceof String){
                System.out.println("处理String中的类型...");
            }else if (element instanceof Double){
                System.out.println("处理Double中的类型...");
            }else if (element instanceof Float){
                System.out.println("处理Float中的类型...");
            }else if (element instanceof Long){
                System.out.println("处理Long中的类型...");
            }else if (element instanceof Boolean){
                System.out.println("处理Boolean中的类型...");
            }else if (element instanceof Date){
                System.out.println("处理Date中的类型...");
            }else if (element instanceof Worker){
                System.out.println("处理Worker中的类型...");
            }
        }
    }
}
```

#### 泛型类

```java
public class GeneralClass<T> {
    public static void main(String[] args) {
        //根据需求初始化不同的类型
        GeneralClass<Integer> genInt = new GeneralClass<Integer>();
        genInt.add(1);
        GeneralClass<String> genStr = new GeneralClass<>();
        genStr.add("2");
    }
    private T t;
    public void add(T t){
        this.t = t;
    }
    public T get() {
        return t;
    }
}
```

#### 泛型接口

```java
public interface IGeneral<T> {
    public T getId();
}

//定义泛型接口的实现类
class GeneralIntegerUmpl implements IGeneral<Integer>{

    @Override
    public Integer getId() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public static void main(String[] args) {
        //使用泛型
        GeneralIntegerUmpl gen = new GeneralIntegerUmpl();
        System.out.println(gen.getId());
    }
}
```

### Serialization序列化

```java
//通过实现Serializable接口可序列化的Worker类
public class Worker implements Serializable {
    //定义序列化的ID
    private static final long serialVersionUID = 123456789L;
    //name属性将被序列化
    private String name;
    //transient修饰的属性将不被序列化
    private transient int salary;
    //静态变量属于类信息，不属于对象的状态，因此不会被序列化
    static  int age = 100;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception{
        //序列化数据到磁盘
        FileOutputStream fos = new FileOutputStream("worker.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Worker testObject = new Worker();
        testObject.setName("Hanson");
        oos.writeObject(testObject);
        oos.flush();
        oos.close();
        //反序列化磁盘数据并解析数据状态
        FileInputStream fis = new FileInputStream("worker.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Worker deTest =(Worker) ois.readObject();
        System.out.println(deTest.getName());
    }

}
```

