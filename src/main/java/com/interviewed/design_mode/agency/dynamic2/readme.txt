静态代理和动态代理区别
1.静态代理：
    |实现目标代理对象的接口
    |维护一个代理对象Proxy,并提供构入参为目标代理实例对象的构造方法
    |执行代理对象实现的接口方法，实现对目标对象的操作干预
2.动态代理：
 分为JDK代理和CGlib代理
 JDK代理：
    |顶级接口
    |接口实现类，构造Proxy.newProxyInstance(目标类代理对象类加载器，目标类代理对象数组，new InvocationHandler)参数
    |(ClassLoader loader,Class<?>[] interfaces, InvocationHandler h)

 Cglib代理：
    | implements MethodInterceptor
    |可以直接代理类，使用字节码技术，不能对 final类进行继承。使用了动态生成字节码技术。
    |可以做到不对目标对象进行修改的前提下，对目标对象进行功能的扩展和拦截。

 区别：
    动态生成字节码技术：
    cglib
    public class CglibTestSon$$EnhancerByCGLIB$$3119e01d extends CglibTestSon implements Factory {
        ......
    }
    jdk:
    public final class Ddd extends Proxy implements JavaProxyInterface {
        ......
    }

    可以看到cglib是直接继承了原有类，实现了Factory接口，而jdk是实现了自己的顶层接口，继承了Proxy接口。这里需要注意一下，这样的话，
    按照类来找话，jdk就找不到他的实现了，因为他的实现类实际上是一个Proxy类，而不是他自己。



