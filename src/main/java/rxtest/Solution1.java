package rxtest;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Solution1 {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> sList = new ArrayList<>();

        Observable.just(2, 3, 5)
                .flatMap(delay -> Observable.just(serviceReturningSingleWithDelay(delay)
                        .subscribe(success -> {
                            if (success == 3) {
                                sList.add(success);
                                //System.out.println(" Running new logic here");
                            }
                        }))).subscribe();

        Observable.interval(500, 500, TimeUnit.MILLISECONDS)
                .flatMap(l -> Observable.just(sList.size() > 0 ? sList.get(0) : 0))
                .filter(i -> i > 0)
                .first(0)
                .doOnSuccess(System.out::println)
                .subscribe();

        Thread.sleep(6000);

    }

    private static Single<Integer> serviceReturningSingleWithDelay(Integer delay) {
        return Single.just(delay)
                .delay(delay, TimeUnit.SECONDS)
                .doOnSuccess(s -> System.out.printf("Delay %d: Thread : %s \n", delay, Thread.currentThread().getName()));
    }

}
