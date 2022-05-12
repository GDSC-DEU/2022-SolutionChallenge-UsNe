<template> 
  <div class="modalBody"> <!--목표 수정 모달창-->
    <h1>Goal</h1>
    <div v-show="errorMessage" style="color: red;">예산이 부족합니다.</div>
    <p>한달예산</p>
    <div>{{ budget }}</div>
    <button type="button" @click="showBudget" v-show="showSetButton">설정</button>
    <input type="number" v-show="showBudgetBox" v-model="budget">
    <button type="button" v-show="showBudgetBox" @click="budgetSet">저장</button>
    <p>총 예상지출</p>
    <div>{{ totalConsumption }}</div>
    <div class="goalInput"></div>
    <p>
      <span v-show="inputBtn">#식비</span>
      <input type="number" v-model="food" v-show="inputBtn"> 
      <span v-show="inputBtn">#문화</span>
      <input type="number" v-model="culture" v-show="inputBtn">
    </p>
    <p>
      #식비{{ this.goals.food }}
      #문화{{ this.goals.culture }}
    </p>
    <p>
      <span v-show="inputBtn">#생활</span>
      <input type="number" v-model="life" v-show="inputBtn">  
      <span v-show="inputBtn">#의류</span>
      <input type="number" v-model="clothes" v-show="inputBtn">
    </p>
    <p>
      #생활{{ this.goals.life }}
      #의류{{ this.goals.clothes }}
    </p>
    <p>
      <span v-show="inputBtn">#교육</span>
      <input type="number" v-model="education" v-show="inputBtn">  
      <span v-show="inputBtn">#의료</span>
      <input type="number" v-model="medicaltreatment" v-show="inputBtn">
    </p>
    <p>
      #교육{{ this.goals.education }}
      #의료{{ this.goals.medicaltreatment }}
    </p>
    <p>
      <span v-show="inputBtn">#교통</span>
      <input type="number" v-model="traffic" v-show="inputBtn">  
      <span v-show="inputBtn">#뷰티</span>
      <input type="number" v-model="beauty" v-show="inputBtn">
    </p>
    <p>
      #교통{{ this.goals.traffic }}
      #뷰티{{ this.goals.beauty }}
    </p>
    <button type="button" @click="showInputBtn" v-show="modifyBtn">수정</button>
    <button type="button" @click="putbudget" v-show="putbudgetBtn">설정</button>
    <button type="button" @click="$emit('close')">닫기</button>
  </div>
</template>

<script>
import { getGoals } from "@/api/index";
export default {
  mounted() {
    // 한달 예산, 총 예상지출, 설정한 목표 불러오기 
    this.getGoalSettingData();
  },
  methods: {
    showInputBtn() {
      this.inputBtn=true;
      this.putbudgetBtn=true;
      this.modifyBtn=false;
    },
    async getGoalSettingData() {
      const response = await getGoals();
      this.goals = response.data;
      console.log(this.goals);
    },
    putbudget() {
      this.totalConsumption = 
        this.food + 
        this.culture + 
        this.life + 
        this.clothes + 
        this.education + 
        this.medicaltreatment + 
        this.traffic + 
        this.beauty + 
        this.ect;
      if(this.totalConsumption > this.budget) {
        this.errorMessage = true;
      } else {
        this.errorMessage = false;
        this.$emit('putGoal', {
          food: this.food,
          culture: this.culture,
          life: this.life,
          clothes: this.clothes,
          education: this.education,
          medicaltreatment: this.medicaltreatment,
          traffic: this.traffic,
          beauty: this.beauty,
          ect: this.ect
        })
      }
    },
    showBudget() {
      this.showBudgetBox = true;
      this.showSetButton = false;
    },
    budgetSet() {
      this.showBudgetBox = false;
      this.showSetButton = true;
    },
  },
  data() {
    return {
      goals: [],
      inputBtn: false,
      budget: 0,
      totalConsumption: 0,
      showBudgetBox: false,
      showSetButton: true,
      errorMessage: false,
      food: "",
      culture: "",
      life: "",
      clothes: "",
      education: "",
      medicaltreatment: "",
      traffic: "",
      beauty: "",
      ect: 0,
      putbudgetBtn: false,
      modifyBtn: true,
    }
  },
}
</script>

<style scoped>
.modalBody {
    position: absolute;
    text-align: center; 
    top: 50%;
    left: 50%;
    width: 500px;
    height: 400px;
    padding: 80px;
    background-color: rgb(255, 255, 255);
    border-radius: 10px;
    box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);
    transform: translateX(-50%) translateY(-50%);
}
 
.myGoal {
       text-align: center;
}
      
.modal {
       position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      display: none;
      background-color: rgba(0, 0, 0, 0.4);
}

.modal.show {
      display: block;
}

.modal_body {
      position: absolute;
      text-align: center; 
      top: 50%;
      left: 50%;
      width: 600px;
      height: 500px;
      padding: 40px;
      background-color: rgb(255, 255, 255);
      border-radius: 10px;
      box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);
      transform: translateX(-50%) translateY(-50%);
}
.goalInput {
  text-align: center;
  font-family: 'pinokio';
  font-size: 20px;
}
</style>