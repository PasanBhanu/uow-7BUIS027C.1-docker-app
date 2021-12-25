package com.uowcca.groupt.rest.response;

import com.uowcca.groupt.dao.Book;
import com.uowcca.groupt.rest.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetAllBooksResponse extends BaseResponse {
    private List<Book> data;
}
