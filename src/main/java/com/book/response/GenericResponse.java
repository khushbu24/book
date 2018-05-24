package com.book.response;

public class GenericResponse<T,U> {

    public T data;
    public U error;

    public GenericResponse(T data, U error) {
        this.data = data;
        this.error = error;
    }
}


//class Name {
//
//    String name;
//    Integer age;
//
//}
//
//{
//    "name":"a",
//        "age":20
//        }

