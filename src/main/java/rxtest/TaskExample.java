package rxtest;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TaskExample {

    public static void main(String[] args) throws InterruptedException {
        Observable.just(2, 3, 5)
                .map(delay -> serviceReturningSingleWithDelay(delay))
                .toList()
                .flatMap(list ->
                        Single.zip(list,  output -> Arrays.stream(output)
                                .map(d -> (Integer) d)
                                .filter(delay -> delay == 3)
                                .findFirst()
                                .orElse(0)
                        ))
                .subscribe(System.out::println);

        Thread.sleep(6000);
    }

    private static Single<Integer> serviceReturningSingleWithDelay(Integer delay) {
        return Single.just(delay)
                .delay(delay, TimeUnit.SECONDS)
                .doOnSuccess(s -> System.out.printf("Delay %d: Thread : %s \n", delay, Thread.currentThread().getName()));
    }

}
