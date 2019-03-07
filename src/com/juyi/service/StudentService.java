package com.juyi.service;



import org.apache.ibatis.annotations.Param;

import com.juyi.model.Page;
import com.juyi.model.Student;
/**
 * 毕业学员信息
 * @author Admin
 *
 */
public interface StudentService {
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
	Page findAllStudent(String pageNum,String StudentName);

	/**
	 * 根据id删除一个学员信息
	 * @param tid
	 * @return
	 */
	Integer deleteStudent(Integer[] tid);
	
	/**
	 * 查询一个学员
	 */
	Student findSname(Student student);
	
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
