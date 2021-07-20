package com.summer.mapper;

import com.summer.pojo.Course;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class CourseMapperImpl extends SqlSessionDaoSupport implements CourseMapper {

    //我们所有操作都使用sqlSessionTemplate来执行
    /*private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }*/

    @Override
    public List<Course> selectUser() {
        Course user = new Course(5, "2003", "Chinese");
        CourseMapper mapper = getSqlSession().getMapper(CourseMapper.class);

        mapper.addUser(user);
        List<Course> courseList = mapper.selectUser();
        mapper.deleteUser(5);
        return courseList;
    }

    @Override
    public void addUser(Course user) {
        CourseMapper mapper = getSqlSession().getMapper(CourseMapper.class);

        mapper.addUser(user);

    }

    @Override
    public void deleteUser(int id) {
        CourseMapper mapper = getSqlSession().getMapper(CourseMapper.class);

        mapper.deleteUser(id);
    }
}
