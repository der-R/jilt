package org.jilt.test;

import org.jilt.test.data.typesafe.optional.TypeSafeOptionalsValue;
import org.jilt.test.data.typesafe.optional.TypeSafeOptionalsValueBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TypeSafeOptionalsTest {
    @Test
    public void test_type_safe_builder_with_optional_values() throws Exception {
        TypeSafeOptionalsValue optionalsValue = TypeSafeOptionalsValueBuilder.typeSafeOptionalsValue()
                .opt2(true) // we skip opt1
                .opt3('c')
                .req1(3.14)
                .req2("req2")
                .opt4(2.71F)
                .build(); // we skip opt5 and go straight to the build

        assertThat(optionalsValue.getOpt1()).isNull();
        assertThat(optionalsValue.getOpt2()).isTrue();
        assertThat(optionalsValue.getOpt3()).isEqualTo('c');
        assertThat(optionalsValue.getReq1()).isEqualTo(3.14);
        assertThat(optionalsValue.getReq2()).isEqualTo("req2");
        assertThat(optionalsValue.getOpt4()).isEqualTo(2.71F);
        assertThat(optionalsValue.getOpt5()).isNull();
    }
}
