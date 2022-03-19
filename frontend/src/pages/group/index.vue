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
    <h2>My Goal</h2>
    <GoalTable />
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
import GoalTable from "@/components/GoalTable.vue";
export default {
  component: {
    GoalTable,
  }
}
</script>

<style>
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
  padding: 50;
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

