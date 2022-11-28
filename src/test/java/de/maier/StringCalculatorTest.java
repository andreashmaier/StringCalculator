package de.maier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void add_with_empty_string_returns_zero() {
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }

    @Test
    void add_with_one_number_returns_number() {
        assertThat(StringCalculator.add("1")).isEqualTo(1);
    }

    @Test
    void add_with_one_and_two_returns_three() {
        assertThat(StringCalculator.add("1,2")).isEqualTo(3);
    }

    @Test
    void add_with_four_and_five_returns_nine() {
        assertThat(StringCalculator.add("4,5")).isEqualTo(9);
    }

    @Test
    void add_with_three_numbers_returns_sum() {
        assertThat(StringCalculator.add("1,2,3")).isEqualTo(6);
    }

    @Test
    void add_with_five_numbers_returns_sum() {
        assertThat(StringCalculator.add("1,2,3,4,5")).isEqualTo(15);
    }

    @Test
    void add_with_one_newline_two_three_returns_six() {
        assertThat(StringCalculator.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    void add_with_one_space_two_three_returns_six() {
        assertThat(StringCalculator.add("1 2,3")).isEqualTo(6);
    }

    @Test
    void add_with_new_delimiter_use_it_return_sum() {
        assertThat(StringCalculator.add("//;\n1;2")).isEqualTo(3);
        assertThat(StringCalculator.add("//-\n5-6")).isEqualTo(11);
    }

    @Test
    void add_with_one_negative_parameter_throws_exception() {
        assertThatThrownBy(() -> {
           StringCalculator.add("1,-2");
        }).hasMessage("Negative Werte sind nicht erlaubt -2");
    }

    @Test
    void add_with_more_negative_paramter_throws_illegalArgumentException_message_contains_numbers() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            StringCalculator.add("-1,-2");
        }).withMessage("Negative Werte sind nicht erlaubt -1,-2");
    }

    @Test
    @DisplayName("Zahler größer als 1000 werden ignoriet")
    void add_numbers_larger_1000_are_ignored() {
        assertThat(StringCalculator.add("1001,2")).isEqualTo(2);
    }

}