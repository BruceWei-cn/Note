package com.ming.demo.threadlocal;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 本类测试针对父线程向子线程传递信息测试
 *
 * @author Ming
 * @date 14/2/2022-下午 4:56
 */
public class ThreadLocalFatherSonDemo {


    /**
     * 下面测试1，当子线程想从主线程获取消息，是无法获取道德；
     */
    @Test
    public void test01() {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("我是主线程");
        Thread thread = new Thread(() -> {
            // local.get() = null 获取不到
            System.out.println("local.get() = " + local.get());
        });
        thread.start();
    }

    /**
     * 方法二用并行流，子线程去读取主线程数据，会出现无法读取或者读取错乱等问题。
     * <P>严重可导致内存泄露等问题</P>
     */
    @Test
    public void test02() {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("我是主线程");

        IntStream.range(1, 10).parallel().forEach(id -> System.out.printf("%s-%s%n", id, local.get()));
    }

    /**
     * 方法三子线程可以正确读取父线程数据
     * <P>但是若是使用线程池，那么子线程从父线程获取数据依然会有问题</P>
     * <P>原因见测试方法5</P>
     */
    @Test
    public void test03() {
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set("我是主线程");
        Thread thread = new Thread(() -> {
            System.out.printf("Thread-%s%n", inheritableThreadLocal.get());
        });
        thread.start();

        IntStream.range(1, 10).parallel().forEach(id -> System.out.printf("%s-%s%n", id, inheritableThreadLocal.get()));
    }

    /**
     * 使用线程池,线程1Copy(此处copy是浅拷贝)父线程所有Entry并将Hawaii修改为California;
     * <P>线程B再次获取到的是线程A之前缓存下来的，而无法被获取到父线程的数据</P>
     * <P>结论：<P>1.线程池中若没有线程会对父线程进行修改那么线程池可以获取到父线程的值</P>
     * <P>2.若线程池中有对父线程值copy后进行修改的动作，那么其余线程池中的线程无法获取到父线程的值只能获取之前线程池中子线程修改后的缓存值</P>
     * </P>
     */
    @Test
    public void test05() throws InterruptedException {
        final InheritableThreadLocal<Span> inheritableThreadLocal = new InheritableThreadLocal<Span>();
        inheritableThreadLocal.set(new Span("Hawaii"));
        //输出 xiexiexie
        System.out.println("o = " + inheritableThreadLocal.get().name);
        Runnable runnable = () -> {
            System.out.println("========");
            inheritableThreadLocal.get();
            inheritableThreadLocal.set(new Span("California"));
            System.out.println("inheritableThreadLocal.get() = " + inheritableThreadLocal.get().name);

        };
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(runnable);
        TimeUnit.SECONDS.sleep(1);
        executorService.submit(runnable);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("========");
        Span span = inheritableThreadLocal.get();
        // 此处修改父线程的值
        span.name = "Los Angeles";
        System.out.println("span.name = " + span.name);
    }

    static class Span {
        public String name;
        public int age;

        public Span(String name) {
            this.name = name;
        }
    }

    /**
     * 使用阿里的transmittable-thread-local，在线程池中传递主线程的信息；
     * @link:https://github.com/alibaba/transmittable-thread-local#1-%E7%AE%80%E5%8D%95%E4%BD%BF%E7%94%A8
     */
    @Test
    public void test06(){
//        new T
    }
}

