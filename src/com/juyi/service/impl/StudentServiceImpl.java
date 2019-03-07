package com.juyi.service.impl;
/**
 * 聚一毕业学员
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juyi.dao.StudentDao;
import com.juyi.model.Page;
import com.juyi.model.Student;
import com.juyi.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	
	/**
	  * 保存一个学员信息
	  * @param student 学员类
	  * @return
	  */
	@Override
	public Integer saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}
	/**
	 * 查询所有的学员
	 * @return
	 */
	@Override
	public Page findAllStudent(String pageNum,String StudentName) {
		Integer pagenum = 0;
		try {
			pagenum = Integer.valueOf(pageNum);
		}
		catch (Exception e){
			pagenum = 1;
		}
		int countPhone = studentDao.findConuntStudent(StudentName);
		Page page = new Page(pagenum,countPhone);
		int m = page.getStartIndex();
		int n = page.getPagesize();
		List<Student> list = studentDao.findAllStudent(m,n,StudentName);
		page.setRecords(list);
		return page;
	}

	/**
	 * 根据id删除一个学员信息
	 * @param tid
	 * @return
	 */
	@Override
	public Integer deleteStudent(Integer[] tid) {
		return studentDao.deleteStudent(tid);
	}
	/**
	 * 查询一个学员
	 */
	@Override
	public Student findSname(Student student) {
		return studentDao.findSname(student);
	}
	
	/**
	 * 根据id查询一个学员
	 */
	@Override
	public Student findId(Student student) {
		return studentDao.findId(student);
	}

	
	/**
	 * 修改一个信息
	 * @param student
	 * @return
	 */
	@Override
	public Integer updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}
}
