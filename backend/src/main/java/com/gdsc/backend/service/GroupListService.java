package com.gdsc.backend.service;

import com.gdsc.backend.domain.GroupList;
import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.GroupRequest;
import com.gdsc.backend.repository.GroupRepository;
import com.gdsc.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GroupListService {
    public static final String NOT_FOUND_MESSAGE = "그룹을 찾을수 없습니다.";
    public static final String NOT_POWER_USER_MESSAGE = "권한을 가진 유저가 아닙니다.";

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    public GroupListService(final GroupRepository groupRepository, final UserRepository userRepository){
        this.groupRepository=groupRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public GroupList saveGroup(final GroupRequest groupRequest,final String userId){
        try{
            User user=userRepository.findByUserId(userId);
            return groupRepository.save(GroupList.builder()
                                                .name(groupRequest.getName())
                                                .user(user)
                                                .build());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Transactional
    public List<GroupList> findAllGroup(){
        return groupRepository.findAll();
    }

    @Transactional
    public GroupList updateGroup(final GroupRequest groupRequest, final Long index, final String userId){

        try{
            User user = userRepository.findByUserId(userId);
            GroupList groupList = findByIndex(index);
            if (groupList == null) throw new RuntimeException(NOT_FOUND_MESSAGE);

            if (groupList.getUser().equals(user)) {
                groupList.update(groupRequest);
                groupRepository.save(groupList);
                return groupList;
            }
            else throw new RuntimeException(NOT_POWER_USER_MESSAGE);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public GroupList findByIndex(final Long index){
        return groupRepository.findGroupListByGroupListIndex(index);
    }

    public void deleteGroup(final Long index,final String userId){
        try{
            User user = userRepository.findByUserId(userId);
            GroupList groupList = findByIndex(index);
            if(groupList.getUser().equals(user)){
                groupRepository.deleteById(index);
            }
            else throw new RuntimeException(NOT_POWER_USER_MESSAGE);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

}
