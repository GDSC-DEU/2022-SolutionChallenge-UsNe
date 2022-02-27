<template>
  <div>
    <form @submit.prevent="submitSignup" class="signupform">
      <div class="signupgrid">
        <h2 id="signuphead">회원가입</h2>
        <label for="username"> 회원 ID : </label>
        <div>
          <input type="text" id="username" v-model="username"/>
        </div>
        <label for="password"> 비밀번호 : </label>
        <div>
          <input type="text" id="password" v-model="password"/>
        </div>
        <!-- <label for="checkPassword"> 비밀번호 확인 : </label>
        <div>
          <input type="text" id="checkPassword" v-model="checkPassword"/>
        </div> -->
        <label for="nickname"> 닉네임 : </label>
        <div>
          <input type="text" id="nickname" v-model="nickname"/>
        </div>
        <label for="phonenumber"> 전화번호 : </label>
        <div>
          <input type="text" id="phonenumber" v-model="phonenumber"/>
        </div>
        <label for="birth"> 생년월일 : </label>
        <div>
          <input type="text" id="birth" v-model="birth"/>
        </div>
      </div>
      <input type="submit" value="Sign Up" id="signupbutton">
    </form>
  </div>
</template>

<script>
import { registerUser } from "@/api/index.js";
export default {
  methods: {
    async submitSignup() {
      console.log("submitSignup가 실행됨")
      const userData = {
        username: this.username,
        password: this.password,
        checkPassword: this.checkPassword,
        nickname: this.nickname,
        phonenumber: this.phonenumber,
        birth: this.birth,
      };
      const { data } = await registerUser(userData);
      console.log(data)
      this.initForm();
    },
    initForm() {
      this.username = "";
      this.password = "";
      this.checkPassword = "";
      this.nickname = "";
      this.phonenumber = "";
      this.birth = "";
    }
  },
  data() {
    return {
      username: "",
      password: "",
      checkPassword: "",
      nickname: "",
      phonenumber: "",
      birth: "",
    };
  },
}
</script>

<style scoped>
  #signupbutton {
    width: 114px;
    height: 45px;
    border: none;
    background-color: #6b6b6b;
    color: white;
    border-radius: 64px;
    font-size: 15px;
    box-shadow:0 2px 5px rgba(0, 0, 0, 0.5)
  }
  #signupbutton:hover {
    box-shadow:0 2px 5px rgba(0, 0, 0, 0.5) inset;
  }
  .signupgrid {
    display: grid;
    grid-template-columns: 50% 50%;
    grid-template-rows: 50px;
    text-align: center;
  }
  .signupgrid > div,  .signupgrid > label {
    line-height: 50px;
  }
  #signuphead {
    grid-column-start: 1;
    grid-column-end: 3;
    text-align: center;
  }
  .signupform {
    width: 350px;
    height: auto;
    padding: 15px;
    border-radius: 43px;
    background-color: rgb(232, 232, 232);
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    box-shadow:0 5px 10px rgba(0, 0, 0, 0.5)
  }
</style>