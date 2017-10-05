package com.example.demo;

import io.openshift.booster.catalog.Booster;
import io.openshift.booster.catalog.BoosterCatalogService;
import io.reactivex.Flowable;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WebsocketDemoApplicationTests {

    static BoosterCatalogService boosterCatalogService;

    static {
        boosterCatalogService =
                new BoosterCatalogService.Builder()
                        .catalogRepository("https://github.com/openshiftio/booster-catalog")
                        .catalogRef("next")
                        .build();
    }

    public static void main(String[] args) throws Exception {

        Flowable<Booster> flowable = boosterCatalogService.rxIndex();

        flowable.subscribe(booster -> System.out.println("*******" + booster.getName()),throwable -> throwable.printStackTrace());

        SECONDS.sleep(60 * 60);

    }

//    public static void main(String[] args) throws Exception {
//
//        CompletableFuture<String> future = new CompletableFuture<>();
//
//        CompletableFuture.runAsync(() -> {
//            try {
//                for (int i = 0; i < 10; i++) {
//                    Thread.sleep(3000);
//                    future.complete(i + ".Hare Krishna!");
//                }
//
//            } catch (InterruptedException e) {
//                future.completeExceptionally(e);
//            }
//        });
//
//        Flowable<String> source = Flowable.fromFuture(future);
//
//        Flowable<String> runInBackground = source.subscribeOn(Schedulers.newThread());
//        Flowable<String> foreground = runInBackground.observeOn(Schedulers.single());
//
//
//        foreground.subscribe(System.out::println, Throwable::printStackTrace);
//
//        SECONDS.sleep(60 * 60);
//    }

}
