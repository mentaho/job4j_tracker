package ru.job4j.early;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.job4j.ex.Fact;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordValidatorTest {

    @Test
    void correctPassword() {
        String password = "Test1!te";
        String expected = PasswordValidator.validate(password);
        assertThat(expected).isEqualTo("Test1!te");
    }

    @Test
    public void whenPasswordIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new PasswordValidator().validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("The password is empty");
    }

    @Test
    public void whenWrongLength() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new PasswordValidator().validate("T");
                });
        assertThat(exception.getMessage()).isEqualTo("The length is incorrect");
    }

    @Test
    public void whenNoDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new PasswordValidator().validate("Test!test");
                });
        assertThat(exception.getMessage()).isEqualTo("Need one digital");
    }

    @Test
    public void whenNoUpperCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new PasswordValidator().validate("test1!test");
                });
        assertThat(exception.getMessage()).isEqualTo("Need one UpperCase");
    }

    @Test
    public void whenNoLowerCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new PasswordValidator().validate("TEST1!TEST");
                });
        assertThat(exception.getMessage()).isEqualTo("Need one LowerCase");
    }

    @Test
    public void whenNoSpecialSymbol() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new PasswordValidator().validate("Test1test");
                });
        assertThat(exception.getMessage()).isEqualTo("Need one special symbol");
    }

    @Test
    public void whenCommonPhrases() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new PasswordValidator().validate("Test1!Qwerty");
                });
        assertThat(exception.getMessage()).isEqualTo("Use non common phrases");
    }
}