package com.solider.test.exception;

import com.solider.exception.ApplicationException;
import org.junit.Test;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public class ApplicationExceptionTest {
    @Test
    public void testApplicationException() throws Exception {
        throw new ApplicationException("测试异常");
    }
}
