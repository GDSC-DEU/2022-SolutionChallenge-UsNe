<template>
  <div>
    <h2>My Community</h2>
    <!-- <DeleteCheck 
      v-if="deleteModalShow"
      @onNo="DeleteGroupbutton"
      @onYes="outGroup(index)"
    /> -->
    <div class="groupBar">
      <div class="inputGroup" v-show="inputGroupname">
        <input type="text" v-model="groupName">
        <button @click="newGroup">생성하기</button>
      </div>
      <button @click="addGroup">
        <img class="groupIcon" src='@/images/user-group-solid.png'>
        그룹추가
      </button>
      <button>
        <img id="joinIcon" src="@/images/right-to-bracket-solid.png">
         그룹참가
      </button>
      <button @click="deletebutton">
        <img id="joinIcon" src="@/images/right-to-bracket-solid.png">
         그룹탈퇴
      </button>
    </div>
    <div class="groupbody">
      <div class="myGrouplist">
        <ul class="groupGrid">
          <li v-for="(myGroup, index) in myGroups" :key="index">
            <div class="group1">
              <a href="/group"><img src="@/images/usnelogo.jpg" border="0" width="200" height="200"></a>
            </div>
            <p>{{ myGroup.name }}</p>
            <p><button type="button" v-show="showDeleteGroupBtn" @click="outGroup(index)">Delete</button></p>
          </li>
        </ul>
        <div style="clear:both;"></div>
      </div>
    </div>
  </div>
</template>

<script>
import { postNewGroup, getMyGroup, deleteGroup } from "@/api/index.js";
// import DeleteCheck from "@/components/deleteCheck.vue";
export default {
  components : {
    // DeleteCheck
  },
  mounted() {
    this.loadingGroup()
  },
  methods: {
    deletebutton() {
      if(this.showDeleteGroupBtn== true) {
        this.showDeleteGroupBtn= false;
      } else {
        this.showDeleteGroupBtn= true;
      }
    },
    DeleteGroupbutton() {
      if(this.deleteModalShow== true) {
        this.deleteModalShow= false;
      } else {
        this.deleteModalShow= true;
      }
    },
    async outGroup(index) {
      const id = this.myGroups[index].groupListIndex
      console.log(id);
      await deleteGroup(id);
      this.myGroups.splice(index,1);
    },
    addGroup() {
      if(this.inputGroupname==true) {
        this.inputGroupname=false;
      } else {
        this.inputGroupname=true;
      }
    },
    async newGroup() {
      if(this.groupName == "") {
        alert("그룹이름을 입력하세요")
      } else {
        const userData = {
          name: this.groupName
        }
        const {data} = await postNewGroup(userData);
        console.log(data);
        this.groupName = ""
        this.inputGroupname= false;
        this.loadingGroup();
      }
    },
    async loadingGroup() {
      const response = await getMyGroup();
      this.myGroups = response.data;
      console.log(this.myGroups);
    }
  },
  data() {
    return {
      groupName: "",
      inputGroupname: false,
      myGroups: [],
      deleteModalShow: false,
      showDeleteGroupBtn: false,
    }
  },
}
</script>

<style scoped>
  .myGrouplist {
    display: flex;
    justify-content:center;
  }
  .groupGrid {
    display: flex;
    flex-flow: row wrap;
    justify-content: space-evenly;
  }
  ul {
    max-width: 997px;
  }
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
    margin-top: 50px; 
  }
  .group1 {
    text-align: center;
    border: 1px solid gray;
    width: 200px;
    height: 200px;
    margin: 10px;
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