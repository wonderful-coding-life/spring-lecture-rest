package com.example.rest.repository;

import com.example.rest.model.Company;
import com.example.rest.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class DataRepository {
    public static List<Employee> employees = new ArrayList<>(List.of(
            new Employee(1, "홍길동", "010-1111-1111", 1),
            new Employee(2, "홍길철", "010-1111-1112", 1),
            new Employee(3, "홍길순", "010-1111-1113", 2),
            new Employee(4, "홍길자", "010-1111-1114", 2)
    ));

    public static List<Company> companies = new ArrayList<>(List.of(
            new Company(1, "삼성전자", "경기도 수원시 영통구 삼성로 129"),
            new Company(2, "LG전자", "서울시 영등포구 여의대로 128 LG트윈타워")
    ));
}
