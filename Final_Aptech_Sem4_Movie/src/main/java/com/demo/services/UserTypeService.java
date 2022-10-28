package com.demo.services;

import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Service;

import com.demo.models.Account;
import com.demo.models.Usertype;




public interface UserTypeService {
	public Usertype find(int id);

}
