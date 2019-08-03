package io.choerodon.todo.infra.dto;

import io.choerodon.mybatis.entity.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    @Table(name = "todo_user")
    public class UserDTO extends BaseDTO {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //对于自增张、序列（SEQUENCE）类型的主键，需要添加该注解
        private Long id;
        private String employeeName;
        private String employeeNumber;
        private String email;

        // 省略get和set方法


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeNumber() {
            return employeeNumber;
        }

        public void setEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
