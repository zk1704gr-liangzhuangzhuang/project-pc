<!-- html部分 -->
<template>
	<div>
		<h1>修改企业类别信息</h1>
		<el-row>
		  <el-col :span="42"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入企业名称' v-model='typename'></el-input> </el-col>
		</el-row>
		<el-row style='margin-top: 20px;text-align: center;'>
		  <el-col :span="24" ><el-button type='primary' @click='saveEdit'>确定</el-button> <el-button @click='cancel'>取消</el-button> </el-col>
		</el-row>
	</div>
</template>
<!-- js部分 -->
<script>
	export default {
		name:'',
		data() {
			return {
				typename:''
			};
		},
		methods:{
			saveEdit(){
				// 后端网址
				var url = this.baseUrl+"/baseDevtype/update"
				// 传递给后端的数据
				var data = {typename:this.typename,typeid:this.typeid};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.$message("更新成功");
					this.$router.push({path:'/DevtypeList'});
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
			this.typename = row.typename;
			this.typeid = row.typeid;
		
		}
	}
</script>
<!-- css部分 -->
<style>

</style>
