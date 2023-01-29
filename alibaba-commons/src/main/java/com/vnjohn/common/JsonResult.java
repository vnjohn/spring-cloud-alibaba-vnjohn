package com.vnjohn.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vnjohn
 * @since 2022/12/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {
    private Integer code;
    private T data;

    public static JsonResult<String> success() {
        return new JsonResult<>(200, "成功");
    }

    public static JsonResult<String> fail() {
        return new JsonResult<>(500, "失败");
    }

}
