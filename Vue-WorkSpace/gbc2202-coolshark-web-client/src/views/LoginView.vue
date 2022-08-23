<template>
  <div class="">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>

      <el-form-item label="密码" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">登陆</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        username:"",
        password:""
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 4 到 15 个字符', trigger: 'blur' }
        ],
        password:[ { required: true, message: '请输入密码', trigger: 'blur' },
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let url = "http://localhost:8080/login";
          let formData = {
            username:this.ruleForm.username,
            password:this.ruleForm.password
          }
          this.axios.post(url,formData).then((response)=>{
            console.log(response.data);
            if (response.data == 1){
              this.$message({
                message:"登陆成功",
                type:"success"
              })
            }else if (response.data == 2){
              this.$message({
                message:"登陆失败，用户名不存在",
                type:"error"
              })
            }
            else{
              this.$message({
                message:"登陆失败，密码错误",
                type:"error"
              })
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>
