package com.wondersgroup.commons.util.demo.io.Excel;

import java.lang.annotation.*;

/**
 * 该注解添加在字段上，标识哪些字段需要导出到 Excel，并且添加表头说明。
 *
 * @author tangjunlin
 * @date 2022/3/1 20:15
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelHeader {

    /**
     * 表头
     * @return
     */
    String value() default "";

    /**
     * 列索引
     * @return
     */
    int columnIndex() default 0;

}