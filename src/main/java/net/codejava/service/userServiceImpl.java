package net.codejava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.user;
import net.codejava.repository.userRepository;

@Service
public class userServiceImpl implements userService {
	
    @Autowired
    private userRepository userRepository;
    
	@Override
	public List<user> getAlluser() {
		
		return userRepository.findAll();
	}

	@Override
	public void saveuser(user user) {
		this.userRepository.save(user);
	}
		
		@Override
		public user getuserById(long id) {
			Optional < user > optional = userRepository.findById(id);
			
			user user = null;
		    if (optional.isPresent()) {
		        user = optional.get();
		    } else {
		        throw new RuntimeException(" user not found for id :: " + id);
		    }
		    return user;
		}

		@Override
		public void deleteuserById(long id) {
			this.userRepository.deleteById(id);
			
		}
		
	}


