<template>
  <div>
    <AccountTable />
    <body>
      <div class="goalSetting">
        <h1>My Goal</h1> 
      </div>
      <div class="settingBtn">
      <button type="button" @click="onGoalSet">Goal setting</button>
      </div>
      <div class="goalGraph">
        <div class="graph stack">
          <span style="width:100%;">100%</span>
        </div>
        <div class="graph stack2">
          <span style="width:90%;">90%</span> 
        </div>
        <div class="graph stack3">
          <span style="width:80%;">80%</span>
        </div>
         <div class="graph stack4">
          <span style="width:70%;">70%</span>
        </div>
        <div class="graph stack5">
          <span style="width:60%;">60%</span>
        </div>
        <div class="graph stack6">
          <span style="width:50%;">50%</span>
        </div>
        <div class="graph stack7">
          <span style="width:40%;">40%</span>
        </div>
        <div class="graph stack8">
          <span style="width:30%;">30%</span>
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
import { postGoals } from "@/api/index";
import AccountTable from "@/components/AccountTable.vue";
import Goal from "@/components/accountModal.vue"
export default {
  components: {
    AccountTable,
    Goal
  },
  methods: {
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
    }
  },
}
</script>

<style scoped>
  .goalGraph {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 20px 50px;
  }
  .settingBtn {
    text-align: center;
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