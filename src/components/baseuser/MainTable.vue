<!-- html部分 -->
<template>
	<div>
		<h1>表格综合</h1>
		<hr/>
		<div style="text-align: center;">
			<el-input style='width: 180px;' placeholder='员工姓名' v-model='search_cname'></el-input>
			<el-button @click="suc">查询</el-button>
			<el-button @click="aa">新增</el-button>
		</div>	
		<div>
				<el-table :data="tableData"  border style="width: 100%">
				<el-table-column  v-for="{prop,label} in arr" :key="prop" :prop="prop" :label="label"></el-table-column>
				<el-table-column fixed="right" label="操作" width="200">
       <template slot-scope="scope">
      			<el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
      			<el-button type="text" size="small" @click="del(scope.row.userid)">删除</el-button>
      		  </template>
      		</el-table-column>
      	  </el-table>
      </div>
	</div>
</template>
<!-- js部分 -->
<script>
	export default {
		name:'',
		data() {
			return {
				search_cname:'',
				tableData:[],
				arr:[
					{ prop: 'userid', label: 'ID' },
					{ prop: 'cname', label: '姓名' },
					{ prop: 'username', label: '用户名' },
					{ prop: 'password', label: '密码' },
					{ prop: 'telno', label: '手机号' },
					{ prop: 'email', label: '邮箱' },
					{ prop: 'sex', label: '性别' },
					{ prop: 'baseCompany.compname', label: '所属企业'}]
			};
		},
		methods:{
			aa(){
					this.$router.push({path:'/baseUseradd'})
			},suc(){
				// 后端网址
				var url = this.baseUrl+"/baseUser/search"
				// 传递给后端的数据
				var data = {cname:this.search_cname};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.tableData=res.data;
				})
			},del(userid){
				// 后端网址
				var url = this.baseUrl+"/baseUser/delete"
				// 传递给后端的数据
				var data = {userid:userid};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.suc();
				})
			}
		},
		mounted:function(){
// 					var url = this.baseUrl+"/baseUser/list"
// 					// 传递给后端的数据
// 					this.$axios.post(url,{
// 						headers: {
// 							'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
// 						}
// 					}).then(res=>{
// 						// res是后端的响应
// 						this.tableData=res.data
// 				})
			this.suc()
			}
	}
</script>
<!-- css部分 -->
<style>
	#hh{
		color:#52bab5;margin: 10px 0;
	}
</style>
