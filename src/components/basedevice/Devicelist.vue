<!-- html部分 -->
<template>
	<div>
		<h1>表格综合</h1>
		<hr/>
		<div style="text-align: center;">
			<el-input style='width: 180px;' placeholder='设备名称' v-model='search_cname'></el-input>
			<el-button @click="suc">查询</el-button>
			<el-button @click="aa">新增</el-button>
		</div>	
		<div>
				<el-table :data="tableData"  border style="width: 100%">
				<el-table-column  v-for="{prop,label} in arr" :key="prop" :prop="prop" :label="label"></el-table-column>
				<el-table-column fixed="right" label="操作" width="200">
       <template slot-scope="scope">
      			<el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
      			<el-button type="text" size="small" @click="del(scope.row.devid)">删除</el-button>
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
					{ prop: 'devid', label: 'ID' },
					{ prop: 'devname', label: '设备名称' },
					{ prop: 'baseDevtype.typename', label: '设备类别' },
					{ prop: 'baseCompany.compname', label: '所属企业' },
					{ prop: 'devdate', label: '投入时间' },
					{ prop: 'devuser', label: '责任人' },
					]
			};
		},
		methods:{
			aa(){
					this.$router.push({path:'/Deviceadd'})
			},suc(){
				// 后端网址
				var url = this.baseUrl+"/baseDevice/search"
				// 传递给后端的数据
				var data = {devname:this.search_cname};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.tableData=res.data;
				})
			},del(devid){
				// 后端网址
				var url = this.baseUrl+"/baseDevice/delete"
				// 传递给后端的数据
				var data = {devid:devid};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.suc();
				})
			},handleClick(row){
					this.$router.push({name:'DeviceEdit',params:{row:row.devid}})
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
