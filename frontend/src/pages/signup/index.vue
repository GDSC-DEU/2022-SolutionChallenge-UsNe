<template>
   <div>
    <div class="signupBar">
      <div class="signup">
        <div class="item1"> [ 회원가입 ] </div>
        <div class="items"> 회원 ID : </div>
        <div class="inputitems"><input type="text"></div>
        <div class="items"> 비밀번호 : </div>
        <div class="inputitems"><input type="text"></div>
        <div class="items"> 비밀번호 확인 : </div>
        <div class="inputitems"><input type="text"></div>
        <div class="items"> 이름 : </div>
        <div class="inputitems"><input type="text"></div>
        <div class="items"> 성별 : </div>
        <div class="inputitems"><input type="text"></div>
        <div class="items"> 휴대전화 : </div>
        <div class="inputitems"><input type="text"></div>
        <div class="items"> 이메일 : </div>
        <div class="inputitems"><input type="text"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style scoped>
  .item1 {
    grid-column-start: 1;
    grid-column-end: 3;
    text-align: center;
    padding-top: 10px;
    font-size: 18px;
  }
  input[type="text"] {
    width: 60%;
    padding: 2px 5px;
  }
  .inputitems {
    text-align: center;
  }
  .items {
    padding: 15px;
    padding-left: 28px;
    font-size: 14px;
  }
  .signup {
    display: grid;
    grid-template-columns: 40% 60%;
    grid-template-rows: 60px;
    margin: 10px;
  }
  .signupBar {
    width: 40%;
    height: 420px;
    padding: 10px;
    border-radius: 43px;
    background-color: rgb(232, 232, 232);
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    box-shadow: 5px 5px 5px gray;
  }
</style>