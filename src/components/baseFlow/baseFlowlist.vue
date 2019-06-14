<!-- html部分 -->
<template>
	<div>
		<h1 style="text-align: center">流程信息</h1>
		<div style="text-align: left;margin:0 0 20px 50px;">
			<el-input style='width: 180px;' placeholder='流程名称' v-model='search_cname'></el-input>
			<el-button @click="suc">查询</el-button>
			<el-button @click="aa">新增</el-button>
		</div>
		<div>
				<center>
					<el-table :data="tableData"  border style="width: 100%">
					<el-table-column  v-for="{prop,label} in arr" :key="prop" :prop="prop" :label="label"></el-table-column>
					<el-table-column fixed="right" label="操作" width="200">
					<template slot-scope="scope">
					<el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
					<el-button type="text" size="small" @click="del(scope.row.flowid)">删除</el-button>
				  </template>
				</el-table-column>
			  </el-table>
			</center>
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
					{ prop: 'flowid', label: 'ID' },
					{ prop: 'flowname', label: '流程名称' },
					{ prop: 'dljname', label: '斗轮机' },
					{ prop: 'zcjname', label: '装船机' },
					{ prop: 'pdjname', label: '皮带机' },
					{ prop: 'compname', label: '所属公司' },
					]
			};
		},
		methods:{
			aa(){
					this.$router.push({path:'/baseFlowadd'})
			},
			suc(){
				// 后端网址
				var url = this.baseUrl+"/baseFlow/search"
				// 传递给后端的数据
				var data = {flowname:this.search_cname};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.tableData=res.data;
				})
			},del(flowid){
				// 后端网址
				var url = this.baseUrl+"/baseFlow/delete"
				// 传递给后端的数据
				var data = {flowid:flowid};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.suc();
				})
			},handleClick(row){
					this.$router.push({name:'baseFlowEdit',params:{row:row.flowid}})
			}
		},
		mounted:function(){
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
