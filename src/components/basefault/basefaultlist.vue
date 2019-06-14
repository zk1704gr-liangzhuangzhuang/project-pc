<!-- html部分 -->
<template>
	<div>
		<h1>故障维修</h1>
		<hr/>
		<div style="text-align: center;">
			<el-input style='width: 180px;' placeholder='故障名称' v-model='search_cname'></el-input>
			<el-button @click="suc">查询</el-button>
			<el-button @click="aa">新增</el-button>
		</div>	
		<div>
				<el-table :data="tableData"  border style="width: 100%">
				<el-table-column  v-for="{prop,label} in arr" :key="prop" :prop="prop" :label="label"></el-table-column>
				<el-table-column fixed="right" label="操作" width="200">
       <template slot-scope="scope">
      			<el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
      			<el-button type="text" size="small" @click="del(scope.row.faultId)">删除</el-button>
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
					{ prop: 'faultId', label: 'ID' },
					{ prop: 'devname', label: '设备名称' },
					{ prop: 'cause', label: '故障原因' },
					{ prop: 'faultuser', label: '报告人' },
					{ prop: 'faulttime', label: '故障时间(分钟)' },
					],
			};
		},
		methods:{
			aa(){
					this.$router.push({path:'/basefaultadd'})
			},suc(){
				// 后端网址
				var url = this.baseUrl+"/produceFault/search"
				
				// 传递给后端的数据
				var data = {faultuser:this.search_cname};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.tableData=res.data;
				})
			},del(faultId){
				// 后端网址
				var url = this.baseUrl+"/produceFault/delete"
				// 传递给后端的数据
				var data = {faultId:faultId};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.suc();
				})
			},handleClick(row){
					this.$router.push({name:'basefaultEdit',params:{row:row.faultId}})
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
