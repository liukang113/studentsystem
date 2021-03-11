1.ClassLoader 作用：
1>负责将 Class 加载到 JVM 中
2>审查每个类由谁加载（父优先的等级加载机制）
3>将 Class 字节码重新解析成 JVM 统一要求的对象格式


程序在启动的时候，并不会一次性加载程序所要用的所有class文件，而是根据程序的需要，通过Java的类加载机制（ClassLoader）来动态加载
某个 class 文件到内存当中的，从而只有 class 文件被载入到了内存之后，才能被其它 class 所引用。所以 ClassLoader 就是用来动态加载
class 文件到内存当中用的。

2、ClassLoader 的等级加载机制
Java默认提供的三个ClassLoader:
BootStrap ClassLoader 称为启动类加载器，是Java类加载层次中最顶层的类加载器，负责加载JDK中的核心类库，如：rt.jar、resources.jar、
charsets.jar等，可通过如下程序获得该类加载器从哪些地方加载了相关的jar或class文件：

Extension ClassLoader：称为扩展类加载器，负责加载Java的扩展类库，Java 虚拟机的实现会提供一个扩展库目录。该类加载器在此目录里面查
找并加载 Java 类。默认加载JAVA_HOME/jre/lib/ext/目下的所有jar。

App ClassLoader：称为系统类加载器，负责加载应用程序classpath目录下的所有jar和class文件。一般来说，Java 应用的类都是由它来完成加载的。
可以通过 ClassLoader.getSystemClassLoader()来获取它。