package com.junmo.junmowebsite.global.util;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseDto<T> {

    private final String message;
    private final T data;

    @Builder
    private ResponseDto(String message, T data) {
        this.message = message;
        this.data = data;
    }

    // 예외 처리할 경우, 응답으로 메시지만 보내면 되니 보통 이것을 사용
    public static ResponseDto<Object> response(final String message) {
        return ResponseDto.<Object>builder()
                .message(message)
                .build();
    }

    // 일반적인 응답의 경우 자세한 내용과 데이터를 보내기 때문에, 보통 이 생성자를 사용
    public static <T> ResponseDto<T> response(final String message, final T data) {
        return ResponseDto.<T>builder()
                .message(message)
                .data(data)
                .build();
    }

    // 요청에서 valid에 위배되는 속성값들에 대한 내용들을 list로 응답보내기 위한 생성자
    public static <T> ResponseDto<List<T>> responseList(final String message, final List<T> data) {
        return ResponseDto.<List<T>>builder()
            .message(message)
            .data(data)
            .build();
    }


}
