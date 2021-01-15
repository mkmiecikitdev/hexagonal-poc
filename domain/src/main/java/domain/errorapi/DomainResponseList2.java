package domain.errorapi;

import io.vavr.collection.Stream;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class DomainResponseList2<S1, S2, E> {

    private final Either<E, S1> result1;
    private final Either<E, S2> result2;

    public <T> Either<E, T> mapOrFirstError(final Function<Successes<S1, S2>, T> mapSuccesses) {
        return Stream.of(result1, result2)
                .find(Either::isLeft)
                .map(it -> Either.<E, T>left(it.getLeft()))
                .getOrElse(() -> Either.right(
                        mapSuccesses.apply(new Successes<>(
                                        result1.get(), result2.get()
                                )
                        ))
                );
    }

    public <T> Either<E, T> flatMapOrFirstError(final Function<Successes<S1, S2>, Either<E, T>> mapSuccesses) {
        return Stream.of(result1, result2)
                .find(Either::isLeft)
                .map(it -> Either.<E, T>left(it.getLeft()))
                .getOrElse(() -> mapSuccesses.apply(new Successes<>(
                                result1.get(), result2.get()
                        ))
                );
    }

    public static class Successes<S1, S2> {
        public S1 success1;
        public S2 success2;

        public Successes(S1 success1, S2 success2) {
            this.success1 = success1;
            this.success2 = success2;
        }
    }
}