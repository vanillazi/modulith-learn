package cn.vanillazi.learn.system.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import cn.vanillazi.common.error.ErrorCode;
import cn.vanillazi.common.result.Result;
import cn.vanillazi.common.result.Results;
import cn.vanillazi.learn.system.entity.User;
import cn.vanillazi.learn.system.event.UserUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepository {

	private final ApplicationEventPublisher eventPublisher;
	private List<User> users=new CopyOnWriteArrayList<>();

	public Result<List<User>> users(){
		return Results.success(new ArrayList<>(users));
	}

	public Result<Void> add(User user){
		if(getUser(user.getName()).isSuccess()){
			return Results.fail(ErrorCode.NAME_EXIST,"user name exists");
		}else {
			users.add(user);
			return Results.success();
		}
	}

	public Result<Void> update(User user){
		var target=getUser(user.getName());
		if(!target.isSuccess()){
			return Results.fail(ErrorCode.TARGET_NOT_FOUND,"user not found");
		}else {
			var targetUser=target.getData();
			targetUser.setAge(user.getAge());
			var uu=new UserUpdate();
			uu.setUser(user);
			eventPublisher.publishEvent(uu);
			return Results.success();
		}
	}

	public Result<Void> delete(String name){
		var user=getUser(name);
		if(user.isSuccess()){
			users.remove(user.getData());
			return Results.success();
		}
		return Results.fail(ErrorCode.TARGET_NOT_FOUND,"user not found");
	}

	public Result<User> getUser(String name){
		var target= users.stream()
				.filter(user->user.getName().equals(name))
				.findFirst();
		if(target.isPresent()){
			return Results.success(target.get());
		}else {
			return Results.fail(ErrorCode.TARGET_NOT_FOUND,"user is not found");
		}

	}
}
