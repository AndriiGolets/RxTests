package rxtest;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Solution2 {

    public static void main(String[] args) throws InterruptedException {
        Observable.just(2, 3, 5)
                .flatMap(delay -> serviceReturningSingleWithDelay(delay).toObservable())
                .filter(d-> d == 3)
                .firstOrError()
                .subscribe(System.out::println);

        Thread.sleep(6000);
    }

    private static Single<Integer> serviceReturningSingleWithDelay(Integer delay) {
        return Single.just(delay)
                .delay(delay, TimeUnit.SECONDS)
                .doOnSuccess(s -> System.out.printf("Delay %d: Thread : %s \n", delay, Thread.currentThread().getName()));
    }

}
