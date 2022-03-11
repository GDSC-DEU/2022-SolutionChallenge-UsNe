<template>
  <div>
    <AccountTable />
    <body>
      <div class="goalSetting">
        <h1>My Goal</h1> 
      </div>
      <p> <button type="button" @click="onGoalSet" id="goalSetButton">Goal setting</button></p>
      <div class="goalGraph">
        <div class="graph stack">
          <span id="foodGraph">{{ foodWidth }}</span>
        </div>
        <div class="graph stack2">
          <span id="cultureGraph">{{ cultureWidth }}</span> 
        </div>
        <div class="graph stack3">
          <span id="lifeGraph">{{ lifeWidth }}</span>
        </div>
         <div class="graph stack4">
          <span id="clothesGraph">{{ clothesWidth }}</span>
        </div>
        <div class="graph stack5">
          <span id="educationGraph">{{ educationWidth }}</span>
        </div>
        <div class="graph stack6">
          <span id="medicaltreatmentGraph">{{ medicaltreatmentWidth }}</span>
        </div>
        <div class="graph stack7">
          <span id="trafficGraph">{{ trafficWidth }}</span>
        </div>
        <div class="graph stack8">
          <span id="beautyGraph">{{ beautyWidth }}</span>
        </div>
      </div>
    </body>
    <div>
      {{goals}}

    </div>
    <Goal 
      v-if="showAccountModal"
      @close="onClosebutton"
      @submitGoal="insertGoal"
    />
  </div>
</template>

<script>
import { postGoals, getGoals } from "@/api/index";
import AccountTable from "@/components/AccountTable.vue";
import Goal from "@/components/accountModal.vue"
export default {
  components: {
    AccountTable,
    Goal
  },
  methods: {
    async getGoalSettingData() {
      
    },
    onGoalSet() {
      this.showAccountModal = true;
    },
    onClosebutton() {
      this.showAccountModal = false;
    },
    async insertGoal(goalData) {
      const userData = {
        food: goalData.food,
        culture: goalData.culture,
        life: goalData.life,
        clothes: goalData.clothes,
        education: goalData.education,
        medicaltreatment: goalData.medicaltreatment,
        traffic: goalData.traffic,
        beauty: goalData.beauty,
        ect: goalData.ect
      };
      console.log(userData);
      const { data } = await postGoals(userData);
      console.log(data);
      // 목표 출력
      this.goals.push({
        food: goalData.food,
        culture: goalData.culture,
        life: goalData.life,
        clothes: goalData.clothes,
        education: goalData.education,
        medicaltreatment: goalData.medicaltreatment,
        traffic: goalData.traffic,
        beauty: goalData.beauty,
        ect: goalData.ect
      })
      console.log(this.goals);
      this.onClosebutton()
    }
  },
  data() {
    return {
      showAccountModal: false,
      goals: [],
      foodWidth: '100%',
      cultureWidth: "90%",
      lifeWidth: "90%",
      clothesWidth: "90%",
      educationWidth: "90%",
      medicaltreatmentWidth: "90%",
      trafficWidth: "90%",
      beautyWidth: "90%",
    }
  },
}
</script>

<style scoped>
  p {
    text-align: center;
  }
  #foodGraph {
    width: v-bind(foodWidth);
  }
  #cultureGraph {
    width: v-bind(cultureWidth);
  }
  #lifeGraph {
    width: v-bind(lifeWidth);
  }
  #clothesGraph {
    width: v-bind(clothesWidth);
  }
  #educationGraph {
    width: v-bind(educationWidth);
  }
  #medicaltreatmentGraph {
    width: v-bind(medicaltreatmentWidth);
  }
  #trafficGraph {
    width: v-bind(trafficWidth);
  }
  #beautyGraph {
    width: v-bind(beautyWidth);
  }

  .goalGraph {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 20px 50px;
  }
  #goalSetButton {
    
    border-radius: 35px;
    text-align: center;
    background: white;
    border: none;
    border-color: red;
    color: red;
  }
  .goalSetting {
    text-align: center;
    
  }
  body { 
    padding: 250px;
  }
  .graph {
    height:30px; 
    margin: 0 0 30px; 
    background:#ccc; 
    border-radius:40px;
  }
 .graph span {
   background:pink;
    display:block; 
    padding: 0 10px; 
    width: 75px; 
    height: 30px;
    line-height:40px; 
    text-align:right; 
    border-radius:40px;
    box-sizing:border-box; 
    animation:stack 2s 1;
 }
 @keyframes stack {
  0% {width:0; opacity: 0; 
    color: rgba(255,255,25,0);
  }
  40% {
    color: rgba(255,255,255,1);
  }
  100% {
    width: 100%; opacity: 1;
  }
}
@keyframes stack2 {
  0% {width:0; opacity: 0; 
    color: rgba(255,255,25,0);
  }
  40% {
    color: rgba(255,255,255,1);
  }
  100% {
    width: 100%; opacity: 1;
  }
}
@keyframes stack3 {
  0% {
    width:0; 
    color: rgba(255,255,25,0);
  }
  40% {
    color: rgba(255,255,255,1);
  }
  100% {
    width: 90%;
  }
}

@keyframes stack4 {
  0% {
    width:0; 
    color: rgba(255,255,25,0);
  }
  40% {
    color: rgba(255,255,255,1);
  }
  100% {
    width: 80;
  }
}
@keyframes stack5 {
  0% {
    width:0; 
    color: rgba(255,255,25,0);
  }
  40% {
    color: rgba(255,255,255,1);
  }
  100% {
    width: 70%;
  }
}
@keyframes stack6 {
  0% {
    width:0; 
    color: rgba(255,255,25,0);
  }
  40% {
    color: rgba(255,255,255,1);
  }
  100% {
    width: 60%;
  } 
}
@keyframes stack7 {
  0% {
    width:0; 
    color: rgba(255,255,25,0);
  }
  40% {
    color: rgba(255,255,255,1);
  }
  100% {
    width: 50%;
  } 
}
@keyframes stack8 {
  0% {
    width:0; 
    color: rgba(255,255,25,0);
  }
  40% {
    color: rgba(255,255,255,1);
  }
  100% {
    width: 40%;
  }
}
</style>