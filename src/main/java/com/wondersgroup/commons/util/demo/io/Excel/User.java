package com.wondersgroup.commons.util.demo.io.Excel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 以下实体类中根据注解可知，age 字段不需要导出到 Excel。
 *
 * @author tangjunlin
 * @date 2022/3/1 20:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ExcelHeader(value = "账号")
    private String username;

    @ExcelHeader(value = "密码")
    private String password;

    @ExcelHeader(value = "生日")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    // 该字段没有添加注解, Excel不导出
    private Integer age;

    public User(String username, String password, LocalDateTime birthday) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }
}