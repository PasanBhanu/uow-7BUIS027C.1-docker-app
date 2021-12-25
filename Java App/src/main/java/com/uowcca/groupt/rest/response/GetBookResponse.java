package com.uowcca.groupt.rest.response;

import com.uowcca.groupt.dao.Book;
import com.uowcca.groupt.rest.BaseResponse;
import lombok.Data;

@Data
public class GetBookResponse extends BaseResponse {
    private Book data;
}
