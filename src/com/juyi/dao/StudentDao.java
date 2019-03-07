package com.juyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.juyi.model.Student;

/**
 * student接口
 * @author Admin
 *
 */
public interface StudentDao {
	 /**
	  * 保存一个学员信息
	  * @param student 学员类
	  * @return
	  */
	Integer saveStudent(Student student);
	
	/**
	 * 查询所有的学员
	 * @return
	 */
	List<Student> findAllStudent(@Param("m")int m,@Param("n")int n,@Param("StudentName")String StudentName);
	
	/**
	 * 查询一共多少学员
	 */
	Integer findConuntStudent(@Param("StudentName")String StudentName);

	/**
	 * 根据id删除一个学员信息
	 * @param tid
	 * @return
	 */
	Integer deleteStudent(Integer[] tid);
	/**
	 * 查询一个学员
	 */
	Student findSname(@Param("student")Student student);
	
	/**
	 * 根据id查询一个学员
	 */
	Student findId(@Param("student")Student student);

	/**
	 * 修改一个信息
	 * @param student
	 * @return
	 */
	Integer updateStudent(@Param("student")Student student);
	
	
}
