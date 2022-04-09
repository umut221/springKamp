package com.kalamarge.SpringKamp.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kalamarge.SpringKamp.business.abstracts.UserService;
import com.kalamarge.SpringKamp.core.entities.User;
import com.kalamarge.SpringKamp.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	@GetMapping("/findByEmail")
	public void asdfasdf() {
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return  new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
	}
}
