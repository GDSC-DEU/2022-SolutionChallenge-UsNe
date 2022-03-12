<template>
   <div>
     <div class="search">
      <h4>search</h4>
      <label class="searchitem">
        <input type="checkbox" value="All">
        <span>All</span>
      </label> <br>
      <label class="searchitem">
        <input type="checkbox" name="useType" value="식비">
        <span>식비</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="useType" value="교통비">
        <span>교통비</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="useType" value="의류비">
        <span>교통비</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="useType" value="교육비">
        <span>교통비</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="useType" value="뷰티">
        <span>교통비</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="useType" value="생활비">
        <span>교통비</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="useType" value="문화활동">
        <span>교통비</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="useType" value="병원비">
        <span>교통비</span>
      </label> <br>
      <label class="searchitem">
        <input type="checkbox" name="payType" value="카드">
        <span>카드</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="payType" value="현금">
        <span>현금</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="payType" value="계좌이체">
        <span>계좌이체</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="payType" value="기프트카드">
        <span>기프트카드</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="payType" value="기타">
        <span>기타</span>
      </label> <br>
      <label class="searchitem">
        <input type="checkbox" name="dwType" value="수입">
        <span>수입</span>
      </label>
      <label class="searchitem">
        <input type="checkbox" name="dwType" value="지출">
        <span>지출</span>
      </label>
      <button type="button" @click="searching">검색하기</button>
     </div>
    </div>
</template>

<script>
export default {

}
</script>
<style scoped>
  .search {
    text-align: center;
  }
  .searchitem input[type="checkbox"] {
      display: none;
  }
  
  .searchitem input[type="checkbox"] + span {
    display: inline-block;
    padding: 4px 10px 2px;
    margin: 5px;
    border: 1px solid #dfdfdf;
    border-radius: 35px;
    background-color: #ffffff;
    text-align: center;
    font-size: 15px
  }
 
  .searchitem input[type="checkbox"]:checked + span {
    background-color: #113a6b;
    border: 1px solid #113a6b;
    color: #ffffff;
  }
  .searchitem input[type="checkbox"]:hover + span {
    background-color: #113a6b;
    border: 1px solid #113a6b;
    color: #ffffff;
  }
</style>