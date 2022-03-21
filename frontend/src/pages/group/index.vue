<template>
  <div>
    <div class="groupButton">
      <button>
        <img class="linkicon" src=''>
        초대링크
      </button>
      <button>
        <img class="deleteicon" src=''>
        그룹탈퇴
      </button>    
    </div>
    <div>
      <GoalTable />
      <AccountTable v-show="lock"/>
    </div>
    <div class="friends">
      <div class="gofriend1">
        친구이름
      </div> 
       <div class="gofriend2">
        친구이름
      </div> 
       <div class="gofriend3">
        친구이름
      </div> 
       <div class="gofriend4">
        친구이름
      </div> 
    </div>  
  
  </div>
  
</template>

<script>
import AccountTable from "@/components/AccountTable.vue";
import GoalTable from "@/components/GoalTable.vue";
export default {
  components: {
    AccountTable,
    GoalTable
  },
  data() {
    return {
      lock: false
    }
  },
}
</script>

<style coped>
.groupButton {
  text-align: center;
}
.linkicon {
  width: 12px;
  display: flex;
  justify-content:center;
  float: left;
  padding-left: 4px;
}
.deleteicon {
  width: 12px;
  padding-top: 0px;
}
.friends {
  text-align: center;
}
.gofriend1 {
  border: 1px solid;
  width: 100px;
  height: 100px;
  padding: 50px;
}
.gofriend2 {
  border: 1px solid;
  width: 100px;
  height: 100px;
  padding: 50;
}
.gofriend3 {
  border: 1px solid;
  width: 100px;
  height: 100px;
  padding: 50;
}
.gofriend4 {
  border: 1px solid;
  width: 100px;
  height: 100px;
  padding: 50;
}


</style>

