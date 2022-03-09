package com.gdsc.backend.service;

import com.gdsc.backend.domain.ConsumptionGoal;
import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.ConsumptionGoalRequest;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.exception.ConsumptionGetFailException;
import com.gdsc.backend.exception.ConsumptionGoalCreateFailException;
import com.gdsc.backend.exception.ConsumptionGoalGetFailException;
import com.gdsc.backend.repository.ConsumptionGoalRepository;
import com.gdsc.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ConsumptionGoalService {

    public static final String CONSUMPTIONGOAL_NOT_FOUND = "이번달에 등록된 소비가 없습니다.";
    public static final String CONSUMPTIONGOAL_FOUND = "이번달에 등록된 소비가 있습니다.";

    private final ConsumptionGoalRepository consumptionGoalRepository;
    private final UserRepository userRepository;

    public ConsumptionGoalService(final ConsumptionGoalRepository consumptionGoalRepository, final UserRepository userRepository){
        this.consumptionGoalRepository=consumptionGoalRepository;
        this.userRepository=userRepository;
    }

    @Transactional
    public ConsumptionGoal saveConsumptionGoal(final ConsumptionGoalRequest consumptionGoalRequest, final String userId){
        try{
            User user= userRepository.findByUserId(userId);
            List<ConsumptionGoal> consumptionGoals= consumptionGoalRepository.findConsumptionGoalByUser(user);
            int index= findByThisMonthConsumptionGoal(consumptionGoals);
            if(index==-1)    {
                return consumptionGoalRepository.save(ConsumptionGoal.builder()
                        .education(consumptionGoalRequest.getEducation())
                        .traffic(consumptionGoalRequest.getTraffic())
                        .beauty(consumptionGoalRequest.getBeauty())
                        .culture(consumptionGoalRequest.getCulture())
                        .food(consumptionGoalRequest.getFood())
                        .life(consumptionGoalRequest.getLife())
                        .medicaltreatment(consumptionGoalRequest.getMedicaltreatment())
                        .clothes(consumptionGoalRequest.getClothes())
                        .ect(consumptionGoalRequest.getEct())
                        .user(userRepository.findByUserId(userId))
                        .build());
            }
            else throw new ConsumptionGoalCreateFailException(CONSUMPTIONGOAL_FOUND);
        }catch (Exception e){
            throw new ConsumptionGoalCreateFailException(e.getMessage());
        }

    }

    @Transactional
    public ConsumptionGoal showConsumptionGoal(final String userId){
        try{
            User user= userRepository.findByUserId(userId);
            List<ConsumptionGoal> consumptionGoals= consumptionGoalRepository.findConsumptionGoalByUser(user);
            int index= findByThisMonthConsumptionGoal(consumptionGoals);

            if(index!=-1)
                return consumptionGoals.get(index);

            throw new ConsumptionGoalGetFailException(CONSUMPTIONGOAL_NOT_FOUND);

        }catch (Exception e){
            throw new ConsumptionGoalGetFailException(e.getMessage());
        }

    }

    @Transactional
    public ConsumptionGoal updateConsumptionGoal(final ConsumptionGoalRequest consumptionGoalRequest, final String userId){
        try{
            User user= userRepository.findByUserId(userId);
            List<ConsumptionGoal> consumptionGoals= consumptionGoalRepository.findConsumptionGoalByUser(user);
            int index= findByThisMonthConsumptionGoal(consumptionGoals);
            ConsumptionGoal consumptionGoal;
            if(index!=-1)
                 consumptionGoal = consumptionGoals.get(index);

            else throw new ConsumptionGoalGetFailException(CONSUMPTIONGOAL_NOT_FOUND);

            consumptionGoal.update(consumptionGoalRequest);
            consumptionGoalRepository.save(consumptionGoal);

            return consumptionGoal;

        }catch (Exception e){
            throw new ConsumptionGoalGetFailException(e.getMessage());
        }
    }



    public int findByThisMonthConsumptionGoal(List<ConsumptionGoal> consumptionGoals){
        final int NULL = -1;

        LocalDateTime localDateTime=LocalDateTime.now();
        for (int index = 0; index < consumptionGoals.size(); index++) {
            //System.out.println(consumptionGoals.get(i).getConsumptionGoalDatetime().getMonthValue()+" "+localDateTime.getMonthValue());
            if (consumptionGoals.get(index).getConsumptionGoalDatetime().getMonthValue() - localDateTime.getMonthValue() == 0) {
                return index;
            }
        }
        return NULL;
    }

}
