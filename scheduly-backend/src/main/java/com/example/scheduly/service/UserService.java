package com.example.scheduly.service;
import com.example.scheduly.dbo.UserDTO;
import com.example.scheduly.entity.UserEntity;
import com.example.scheduly.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> listAllUsers() {
        List<UserEntity> users = userRepository.findAll();

        return users.stream().map(UserDTO::new).toList();
    }

    public void insert(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userRepository.save(userEntity);
    }

    public UserDTO change(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);

        return new UserDTO(userRepository.save(userEntity));
    }

    public void delete(UUID _id) {
        UserEntity userEntity = userRepository.findById(_id).get();

        userRepository.delete(userEntity);
    }

    public UserDTO findById(UUID _id) {
        return new UserDTO(userRepository.findById(_id).get());
    }
}
