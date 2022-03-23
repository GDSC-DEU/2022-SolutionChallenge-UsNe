<template>
  <div>
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
    <Goal 
      v-if="showAccountModal"
      @close="onClosebutton"
      @submitGoal="insertGoal"
      @putGoal="retouchGoals"
    />
  </div>
</template>

<script>
import { postGoals, getGoals, getGoalCalc, putGoals } from "@/api/index";
import Goal from "@/components/accountModal.vue";
export default {
  components: {
    Goal
  },
  mounted() {
    this.getGoalSettingData();
  },
    methods: {
    async retouchGoals(goalData) {
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
      const { data } = await putGoals(userData);
      console.log(data);
      this.onClosebutton()
      this.getGoalSettingData();
    },
    async getTotalConsumption() {
      const response = await getGoalCalc();
      this.totalCons = response.data;
      this.calculateGoal()
    },
    calculateGoal() {
      this.foodWidth = this.totalCons.food*100/this.goals.food + "%";
      this.cultureWidth = this.totalCons.culture*100/this.goals.culture + "%";
      this.lifeWidth = this.totalCons.life*100/this.goals.life + "%";
      this.clothesWidth = this.totalCons.clothes*100/this.goals.clothes + "%";
      this.educationWidth = this.totalCons.education*100/this.goals.education + "%";
      this.medicaltreatmentWidth = this.totalCons.medicaltreatment*100/this.goals.medicaltreatment + "%";
      this.trafficWidth = this.totalCons.traffic*100/this.goals.traffic + "%";
      this.beautyWidth = this.totalCons.beauty*100/this.goals.beauty + "%";
      console.log(this.foodWidth);
    },
    async getGoalSettingData() {
      const response = await getGoals();
      this.goals = response.data;
      console.log(this.goals);
      this.getTotalConsumption();
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
      this.onClosebutton()
    }
  },
  data() {
    return {
      showAccountModal:false,
      goals: [],
      totalCons: [],
      foodWidth: '0%',
      cultureWidth: "0%",
      lifeWidth: "0%",
      clothesWidth: "0%",
      educationWidth: "0%",
      medicaltreatmentWidth: "0%",
      trafficWidth: "0%",
      beautyWidth: "0%",
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
    max-width: 100%;
  }
  #cultureGraph {
    width: v-bind(cultureWidth);
    max-width: 100%;
  }
  #lifeGraph {
    width: v-bind(lifeWidth);
    max-width: 100%;
  }
  #clothesGraph {
    width: v-bind(clothesWidth);
    max-width: 100%;
  }
  #educationGraph {
    width: v-bind(educationWidth);
    max-width: 100%;
  }
  #medicaltreatmentGraph {
    width: v-bind(medicaltreatmentWidth);
    max-width: 100%;
  }
  #trafficGraph {
    width: v-bind(trafficWidth);
    max-width: 100%;
  }
  #beautyGraph {
    width: v-bind(beautyWidth);
    max-width: 100%;
  }

  .goalGraph {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 20px 50px;
  }
  #goalSetButton {
    border-radius: 35px;
    padding: 3px 10px;
    text-align: center;
    background-color: white;
    border: solid 1px red;
    border-color: red;
    color: red;
  }
  #goalSetButton:hover {
    color: white;
    background-color: red;
  }
  .goalSetting {
    text-align: center;
    
  }
  body { 
    padding: 20px 150px;
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