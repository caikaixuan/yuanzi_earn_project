package com.ygbc.brain.business.common.processor.user;

import com.ygbc.brain.business.common.dal.dao.UserDao;
import com.ygbc.brain.business.common.dal.data.UserData;
import com.ygbc.brain.business.common.entity.User;
import com.ygbc.brain.business.common.enums.UserProcessorEvent;
import com.ygbc.brain.business.common.listener.Listener;
import com.ygbc.brain.business.common.listener.Listeners;
import com.ygbc.brain.business.common.listener.Observable;
import com.ygbc.brain.business.common.listener.user.*;

import java.util.HashMap;
import java.util.Map;

public class UserProcessor implements Observable<User,UserProcessorEvent> {

    private static UserProcessor instance = new UserProcessor();

    private final Listeners<User,UserProcessorEvent> userListeners = new Listeners<>();

    private final Map<Long,User> userMap = new HashMap<>();

    private  UserDao dao;

    private UserProcessor(){
        init_listeners();
    }

    private void init_listeners(){
        userListeners.addListener(new UserChallengeStart(),UserProcessorEvent.USER_CHALLENGE_START);
        userListeners.addListener(new UserChallengeDone(),UserProcessorEvent.USER_CHALLENGE_DONE);
        userListeners.addListener(new UserChallengeWin(),UserProcessorEvent.USER_CHALLENGE_WIN);
        userListeners.addListener(new UserChallengeFailed(),UserProcessorEvent.USER_CHALLENGE_FAILED);
        userListeners.addListener(new UserNewCharge(),UserProcessorEvent.USER_NEW_CHARGE);
        userListeners.addListener(new UserNewWithdraw(),UserProcessorEvent.USER_NEW_WITHDRAW);
    }

    public void nofity(Long userId,UserProcessorEvent eventType)throws Exception{
        if(userId != null){
            User user = getUser(userId);
            userListeners.notify(user,eventType);
        }
    }

    public User getUser(Long userId){
        if(userMap.containsKey(userId)){
            return userMap.get(userId);
        }
        return null;
    }

    public User createFromDB(Long userId){
        UserData userData = dao.selectById(userId);
        User user = new User();
        user.setData(userData);
        return user;
    }

    public void update(User user){

    }

    public User addOrUpdateUser(User user){
        Long userId = user.getUserId();
        return userMap.put(userId,user);
    }

    public User addOrUpdateUser(Long userId){
        User user = createFromDB(userId);
        return addOrUpdateUser(user);
    }

    public User remove(User user){
        Long userId = user.getUserId();
        return remove(userId);
    }

    public User remove(Long userId){
        return userMap.remove(userId);
    }

    @Override
    public boolean addListener(Listener<User> listener, UserProcessorEvent eventType) {
        return userListeners.addListener(listener,eventType);
    }

    @Override
    public boolean removeListener(Listener<User> listener, UserProcessorEvent eventType) {
        return userListeners.removeListener(listener,eventType);
    }

    public static UserProcessor getInstance() {
        return instance;
    }
}
