<template>
	<div style='text-align: center;'>
		<h1>修改公司信息</h1>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入公司名称' v-model='compname'></el-input> </el-col>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入联系人' v-model='contacts'></el-input> </el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入联系电话' v-model='comptel'></el-input> </el-col>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入行业' v-model='industry'></el-input> </el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入地址' v-model='address'></el-input> </el-col>
		  <el-col :span="12"> <span></span> </el-col>
		</el-row>
		<el-row style='margin-top: 20px;text-align: center;'>
		  <el-col :span="24" > <el-button type='primary' @click='saveEdit'>确定</el-button> <el-button @click='cancel'>取消</el-button> </el-col>
		</el-row>
	</div>
</template>

<script>
	export default {
		name:'',
		data() {
			return {
				compname:'',
				contacts:'',
				comptel:'',
				industry:'',
				address:'',
				compid:''
			};
		},
		methods:{
			saveEdit(){
				// 后端网址
				var url = this.baseUrl+"/baseCompany/update"
				// 传递给后端的数据
				var data = {compid:this.compid,compname:this.compname,contacts:this.contacts,comptel:this.comptel,industry:this.industry,address:this.address};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.$message("更新成功");
					this.$router.push({path:'/CompList'});
				})
			},
			cancel(){
				this.$router.go(-1);
			}
		},
		mounted:function(){
			// 接收路由传递的数据
			var row = this.$route.params.row;
			// 回显
			this.compname = row.compname;
			this.contacts = row.contacts;
			this.comptel = row.comptel;
			this.industry = row.industry;
			this.address = row.address;
			this.compid = row.compid;
		
		}
		
	}
</script>

<style>

</style>
