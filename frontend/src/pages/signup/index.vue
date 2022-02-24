<template>
   <div>
    <div class="signupBar">
      <div class="signup">
        <div class="item1"> [ 회원가입 ] </div>
        <div class="items"> 회원 ID : </div>
        <div class="inputitems"><input type="text"></div>
        <div class="items"> 비밀번호 : </div>
        <div class="inputitems"><input type="password"></div>
        <div class="items"> 비밀번호 확인 : </div>
        <div class="inputitems"><input type="password"></div>
        <div class="items"> 이름 : </div>
        <div class="inputitems"><input type="text"></div>
        <div class="items"> 성별 : </div>
        <div class="inputgender">
          <label class="gender">
            <input type="radio" name="gender" value="man">
            <span style="font-size: 13px">남자</span>
          </label>
          <label class="gender">
            <input type="radio" name="gender" value="woman">
            <span style="font-size: 13px">여자</span>
          </label>
        </div>
        <div class="items"> 휴대전화 : </div>
        <div class="inputitems"><input type="tel"></div>
        <div class="items"> 이메일 : </div>
        <div class="inputitems"><input type="email"></div>
        <div class="item1">
        <input type="button" value="Sign Up" id="onsignup">
      </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style scoped>
  #onsignup {
    width: 114px;
    height: 45px;
    border: none;
    background-color: #6b6b6b;
    color: white;
    border-radius: 64px;
    font-size: 15px;
    box-shadow:0 2px 5px rgba(0, 0, 0, 0.5)
  }
  #onsignup:hover, #onsignup:checked {
    box-shadow:0 2px 5px rgba(0, 0, 0, 0.5) inset;
  }
  .inputgender {
    padding: 5px 15px 10px 28px;
  }
  .item1 {
    grid-column-start: 1;
    grid-column-end: 3;
    text-align: center;
    padding-top: 10px;
    font-size: 18px;
  }
  .inputitems {
    text-align: center;
    width: 60%;
    padding: 2px 5px;
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
    width: 380px;
    height: auto;
    padding: 10px;
    border-radius: 43px;
    background-color: rgb(232, 232, 232);
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    box-shadow:0 5px 10px rgba(0, 0, 0, 0.5)
  }
</style>