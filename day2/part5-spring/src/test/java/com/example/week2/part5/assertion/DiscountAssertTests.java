package com.example.week2.part5.assertion;

import com.example.week2.part5.DiscountDto;
import com.example.week2.part5.Occupation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DiscountAssertTests {

	@Test
	void should_not_throw_exception_when_no_discount() {
		DiscountAssert discountAssert = new DiscountAssert(new DiscountDto("foo", Occupation.UNEMPLOYED, 0D));

		assertThatNoException().isThrownBy(discountAssert::isNotSet);
	}

	@Test
	void should_throw_exception_when_discount_present() {
		DiscountAssert discountAssert = new DiscountAssert(new DiscountDto("foo", Occupation.UNEMPLOYED, 5D));

		assertThatThrownBy(discountAssert::isNotSet)
				.isInstanceOf(AssertionError.class)
				.hasMessage("Expected not to have any discount but the discount was <5.0>");
	}

	@Test
	void should_not_throw_exception_when_discount_rate_equal() {
		DiscountAssert discountAssert = new DiscountAssert(new DiscountDto("foo", Occupation.UNEMPLOYED, 5D));

		assertThatNoException().isThrownBy(() -> discountAssert.isEqualTo(5D));
	}

	@Test
	void should_throw_exception_when_discount_rate_not_equal() {
		DiscountAssert discountAssert = new DiscountAssert(new DiscountDto("foo", Occupation.UNEMPLOYED, 2D));

		assertThatThrownBy(() -> discountAssert.isEqualTo(5D))
				.isInstanceOf(AssertionError.class)
				.hasMessage("Expected discount rate to be equal to <5.0> but the rate was <2.0>");
	}
}
