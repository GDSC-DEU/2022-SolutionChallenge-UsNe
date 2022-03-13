<template>
  <div class="modalBody">
    <h1>Goal</h1>
    <div v-show="errorMessage" style="color: red;">예산이 부족합니다.</div>
    <p>한달예산</p>
    <div>{{ budget }}</div>
    <button type="button" @click="showBudget" v-show="showSetButton">설정</button>
    <input type="number" v-show="showBudgetBox" v-model="budget">
    <button type="button" v-show="showBudgetBox" @click="budgetSet">저장</button>
    <p>총 지출</p>
    <div>{{ totalConsumption }}</div>
    <div class="goalInput"></div>
    <p>
      #식비<input type="number" v-model="food">  
      #문화<input type="number" v-model="culture">
    </p>
    <p>
      #생활<input type="number" v-model="life">  
      #의류<input type="number" v-model="clothes">
    </p>
    <p>
      #교육<input type="number" v-model="education">  
      #의료<input type="number" v-model="medicaltreatment">
    </p>
    <p>
      #교통<input type="number" v-model="traffic">  
      #뷰티<input type="number" v-model="beauty">
    </p>
    <p>  
      #기타<input type="number" v-model="ect">
    </p>

    <button type="button" @click="addbudget">input</button>
    <button type="button" @click="$emit('close')">close</button>
  </div> 
</template> 

<script>


export default {
  methods: {
    showBudget() {
      this.showBudgetBox = true;
      this.showSetButton = false;
    },
    budgetSet() {
      this.showBudgetBox = false;
      this.showSetButton = true;
    },
    addbudget() {
      console.log("실행됨");
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
        this.$emit('submitGoal', {
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
    }
  },
  data() {
    return {
      budget: 0,
      showBudgetBox: false,
      showSetButton: true,
      totalConsumption: 0,
      errorMessage: false,
      food: "",
      culture: "",
      life: "",
      clothes: "",
      education: "",
      medicaltreatment: "",
      traffic: "",
      beauty: "",
      ect: ""
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
    width: 600px;
    height: 500px;
    padding: 40px;
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
      top: 51%;
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