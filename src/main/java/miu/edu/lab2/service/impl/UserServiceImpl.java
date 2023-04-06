package miu.edu.lab2.service.impl;

import miu.edu.lab2.repo.UserRepo;
import miu.edu.lab2.service.UserService;
import net.eunjae.android.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

//    @Autowired
//    ListMapper listMapper;
}
