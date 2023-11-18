package org.example;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class OperatorOtherTest {
    private OperatorOther operatorOther = new OperatorOther();

    @Test
    void fluxConcatMap() {
        StepVerifier.create(operatorOther.fluxConcatMap())
                .expectNextCount(100)
                .verifyComplete();
    }

    @Test
    void monoFlatMapMany() {
        StepVerifier.create(operatorOther.monoFlatMapMany())
                .expectNextCount(10)
                .verifyComplete();
    }

    @Test
    void defaultIfEmpty1() {
        StepVerifier.create(operatorOther.defaultIfEmpty1())
                .expectNext(30)
                .verifyComplete();
    }

    @Test
    void switchIfEmpty1() {
        StepVerifier.create(operatorOther.switchIfEmpty1())
                .expectNext(60)
                .verifyComplete();
    }

    @Test
    void switchIfEmpty2() {
        StepVerifier.create(operatorOther.switchIfEmpty2())
                .expectError()
                .verify();
    }

    @Test
    void fluxMerge() {
        StepVerifier.create(operatorOther.fluxMerge())
                .expectNext("1", "2", "3", "4")
                .verifyComplete();
    }

    @Test
    void monoMerge() {
        StepVerifier.create(operatorOther.monoMerge())
                .expectNext("1", "2", "3")
                .verifyComplete();
    }

    @Test
    void fluxZip() {
        StepVerifier.create(operatorOther.fluxZip())
                .expectNext("ad", "be", "cf")
                .verifyComplete();
    }

    @Test
    void monoZip() {
        StepVerifier.create(operatorOther.monoZip())
                .expectNext(6)
                .verifyComplete();
    }
}