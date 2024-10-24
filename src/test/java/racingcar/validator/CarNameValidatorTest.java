package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {
    @DisplayName("자동차 이름이 5자 이하면 통과한다")
    @ParameterizedTest
    @ValueSource(strings = {"car1","car2","car3","car4","kim","pobi"})
    void validateCarNameLength_success(String input){
        assertDoesNotThrow(() -> CarNameValidator.validateCarNameLength(input));
    }

    @DisplayName("자동차 이름이 5자 이상이면 예외가 발생한다")
    @Test
    void validateCarNameLength_throwsException(){
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.validateCarNameLength("kimhyunsoo"));
    }

    @DisplayName("문장의 마지막이 콤마(,)로 끝나면 예외가 발생한다")
    @Test
    void validateEnd_throwsException(){
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.validateEnd("kim,pobi,"));
    }
}