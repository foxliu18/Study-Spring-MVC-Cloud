package com.summer.mapper;

import com.summer.pojo.Course;

import java.util.List;

public interface CourseMapper {
    List<Course> selectUser();

    void addUser(Course user);

    void deleteUser(int id);
}
