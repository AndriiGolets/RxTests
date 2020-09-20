package rxtest;


import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;


public class RxTestJava {

    private static final Logger log = Logger.getLogger(RxTestJava.class.getName());


    public static void main(String[] args) throws InterruptedException {

/*
        List<String> stringList = new ArrayList<String>() {{
            add("First");
            add("Second");
            add("Third");
        }};

        Observable.fromIterable(stringList)
                .flatMap(so -> Observable.just(createSingleWrapper(so)
                        .subscribeOn(Schedulers.newThread())
                        //.doOnNext(i -> System.out.println("Thread:" + Thread.currentThread()))
                        .filter(si -> si.equals("Second")))

                )
                .map(m-> m.)
                .subscribe(System.out::println);


        Thread.currentThread().join();
    }

    private static Single<String> createSingleWrapper(String s) {
        System.out.println("Thread:" + Thread.currentThread());
        return Single.just(s);

 */
    }



}
