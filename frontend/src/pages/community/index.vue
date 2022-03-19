<template>
  <div>
    <h2>My Community</h2>
    <div class="groupBar">
      <button>
        <img class="groupIcon" src='@/images/user-group-solid.png'>
        그룹추가
      </button>
      <button>
        <img id="joinIcon" src="@/images/right-to-bracket-solid.png">
         그룹참가
      </button>
    </div>
    <div class="groupbody">
      <div class="group1">
       <a href="url"><img src="@/images/group-img.jpeg" border="0" width="100" height="100"></a>
       <p>그룹1</p>
      </div>
      <div class="group2">
       <a href="url"><img src="@/images/img.jpg" border="0" width="100" height="100"></a>
       <p>그룹2</p>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  
}
</script>

<style scoped>
  #joinIcon {
    width: 12px;
    display: flex;
    justify-content:center;
    float: left;
    padding-left: 4px;
  }
  .groupIcon {
    width: 12px;
    padding-top: 0px;
  }
  .groupbody {
    text-align: center;
  }
  .group1 {
    text-align: center;
    border: 1px solid;
    width: 100px;
    height: 100px;
    padding: 50;
    margin-right: 20px;
    margin-left: 850px;
    float: left;
  }
  .group2 {
    text-align: center;
    border: 1px solid;
    width: 100px;
    height: 100px;
    padding: 50;
    float: left;
  }
  
  .groupBar {
    text-align: center;
  }
  h2 {
    text-align: center;
  }
  button {
    width: 87px;
    height: 25px;
    margin: 5px;
    border-radius: 45px;
    border: solid 0.5px black;
    background-color: white;
    text-align: center;
    font-size: 12px;
  }
  button:hover {
    color: white;
    background-color: #113a6b;
  }
</style>