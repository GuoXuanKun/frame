package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private  Integer uid;
    private String username;
    private String password;
    private String[] hobbys;
    private List<String> phoneList;
    private Dog  dog;
    private List<Address> addressList;

}
