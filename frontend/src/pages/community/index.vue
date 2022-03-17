<template>
  <div>
    Community
    <h2>My Community</h2>
    <div class="groupBar">
      <button>그룹 추가</button>
      <button>그룹 참가</button>
    </div>
    <div>
      그룹 ...
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style scoped>
  .groupBar {
    text-align: center;
  }
  h2 {
    text-align: center;
  }
  button {
    width: 75px;
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