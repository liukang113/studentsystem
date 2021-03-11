### 静态同步synchronized方法
    1.关键字synchronized还可以应用在static静态方法上，那是对当前的*.java文件对应的Class类进行持锁
    2.结论：异步原因是持有不同的锁，一个是对象锁，另外一个是Class锁，而Class锁可以对所有对象实例起作用
### synchronized(class)代码块
    1.