<template>
    <div>
        <div class="modalBackground">
        <div class="modalBox">
            <div>
            <div>
                <h1>Add</h1>
                <div v-show="hasError" id="error">
                    모든 문항을 입력해주세요!
                </div>
            </div>
            <div>
                <div>
                    소비 내용 <br>
                    <hr>
                    <input type="text" v-model="content" id="content">
                    <br><br>
                </div>
                <div>
                    소비 용도 <br>
                    <hr>
                    <label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="식비">
                        <span>식비</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="뷰티">
                        <span>뷰티</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="의류비">
                        <span>의류비</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="교육비">
                        <span>교육비</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="교통비">
                        <span>교통비</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="생활비">
                        <span>생활비</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="문화활동">
                        <span>문화활동</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="병원비">
                        <span>병원비</span>
                    </label>
                    <!--<label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="용돈" >
                        <span>용돈</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="월급">
                        <span>월급</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="장학금">
                        <span>장학금</span>
                    </label> -->
                    <label class="inputTag">
                        <input type="radio" v-model="useType" name="useType" value="기타" key="ETC">
                        <span>기타</span>
                    </label>
                    <br><br>
                </div>
                <div>
                    사용 수단 <br>
                    <hr>
                    <label class="inputTag">
                        <input type="radio" v-model="payType" name="payType" value="카드">
                        <span>카드</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="payType" name="payType" value="현금">
                        <span>현금</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="payType" name="payType" value="계좌이체">
                        <span>계좌이체</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="payType" name="payType" value="기프트카드">
                        <span>기프트카드</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="payType" name="payType" value="기타">
                        <span>기타</span>
                    </label>
                    <br><br>
                </div>
                <div>
                    수입/지출 <br>
                    <hr>
                    <label class="inputTag">
                        <input type="radio" v-model="dwType" name="dwType" value="수입">
                        <span>수입</span>
                    </label>
                    <label class="inputTag">
                        <input type="radio" v-model="dwType" name="dwType" value="지출">
                        <span>지출</span>
                    </label>
                    <br><br>
                </div>
                <div>
                    금액 <br>
                    <hr>
                    <input type="number" v-model="cost" id="money"> 원
                    <br><br>
                </div>
                <div>
                    날짜 <br>
                    <hr>
                    <input type="date" v-model="consumptionDatetime" id="consumptionDatetime">
                    <br><br>
                </div>
                <div class="end">
                    <div class="footer">
                        <button type="button" @click="onSubmit">input</button>
                        <button type="button" @click="$emit('close')">close</button>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
export default {
    methods: {
        onSubmit() {
            if(this.content === undefined || 
            this.useType === undefined || 
            this.payType === undefined ||
            this.dwType === undefined ||
            this.cost === undefined ||
            this.consumptionDatetime === undefined) 
            { 
                this.hasError = true;
            }
            else{
                this.$emit('insert', {
                    consumptionDatetime: this.consumptionDatetime,
                    content: this.content,
                    useType: this.useType,
                    payType: this.payType,
                    dwType: this.dwType,
                    cost: this.cost,
                })
                this.hasError = false;
            }
        }
    },
    data() {
        return {
            hasError: false,
            content: "",
            useType: "",
            payType: "",
            dwType: "",
            cost: "",
            consumptionDatetime: "",
        }
    }
}
</script>

<style scoped>
    #error {
        color: red;
        font-size: 12px;
        text-align: center;
    }
    input[type="number"]::-webkit-outer-spin-button,
    input[type="number"]::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
    .inputMoneyDate {
        margin: 50px 50px 30px;
        text-align: left;
    }
    #money {
        width: 130px;
        height: 18px;
        border: solid 1px gray;
        margin: 5px;
    }
    #content {
        width: 200px;
        height: 18px;
        border: solid 1px gray;
        margin: 5px;
    }
    #consumptionDatetime {
        width: 180px;
        height: 18px;
        border: solid 1px gray;
        margin: 5px;
        padding: 3px 10px 2px;
        font-size: 15px;
    }
    .end {
        width: 380px;
        height: auto;
    }
    .footer {
        position: absolute;
        right: 15px;
        bottom: 15px;
    }
    h1 {
        text-align: center;
    }
    .modalBackground {
        width: 100%;
        height: 100%;
        position: fixed;
        top: 0;
        left: 0;
        background-color: rgba(0, 0, 0, 0.5);
    }
    .modalBox {
        width: 380px;
        height: 700px;
        padding: 20px;
        border-radius: 10px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: white;
    }
    button {
        width: 70px;
        padding: 4px;
        margin: 5px;
        border-radius: 35px;
        border: none;
        color: black;
    }
    button:hover {
        color: white;
        background-color: #5a5a5a;
    }

    .inputTag input[type="radio"] {
        display: none;
    }
 
    .inputTag input[type="radio"] + span {
        display: inline-block;
        padding: 4px 10px 2px;
        margin: 5px;
        border: 1px solid #dfdfdf;
        border-radius: 35px;
        background-color: #ffffff;
        text-align: center;
        font-size: 15px
    }
 
    .inputTag input[type="radio"]:checked + span {
        background-color: #113a6b;
        border: 1px solid #113a6b;
        color: #ffffff;
    }
    .inputTag input[type="radio"]:hover + span {
        background-color: #113a6b;
        border: 1px solid #113a6b;
        color: #ffffff;
    }
</style>