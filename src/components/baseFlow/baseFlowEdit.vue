<!-- html部分 -->
<template>
	<div>
		<div>
		<h1>流程修改</h1>
		<el-input style='width: 180px;' v-model='flowname' placeholder="请输入流程名称"></el-input>
		<el-select v-model="dljid" placeholder="请选择斗轮机">
			<el-option  v-for="item in options"  :label="item.devname"  :value="item.devid"></el-option>
		</el-select>
		<el-select v-model="zcjid" placeholder="请选择装船机">
		 	<el-option  v-for="item in options1"  :label="item.devname"  :value="item.devid"></el-option>
		</el-select>
		<el-select v-model="pdjid" placeholder="请选择皮带机">
		 	<el-option  v-for="item in options2"  :label="item.devname"  :value="item.devid"></el-option>
		</el-select>
		</div>
		<el-button @click='over' >添加</el-button> 
		<el-button @click='back' >返回</el-button>   
	</div>
</template>
<!-- js部分 -->
<script>
	export default {
		name:'',
		data() {
			return {
				options:[],
				options1:[],
				options2:[],
				flowid:'',
				flowname:'',
				dljid:'',
				zcjid:'',
				pdjid:'',
				
			};
		},
		methods:{
			over(){
				// 后端网址
				var url = this.baseUrl+"/baseFlow/updateSelective"
				// 传递给后端的数据
				var data = {flowid:this.flowid,dljid:this.dljid,zcjid:this.zcjid,pdjid:this.pdjid,flowname:this.flowname};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.$message("更新成功");
					this.$router.push({path:'/baseFlowlist'});
				})
			},back(){
				this.$router.push({path:'/baseFlowlist'})
			}
			
		},
		mounted:function(){
			// 接收路由传递的数据
				var flowid = this.$route.params.row;
				// 回显传递过来的数据
				// 后端网址
				var url = this.baseUrl+"/baseFlow/load"
				// 传递给后端的数据
				var data = {flowid:flowid};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					var obj = res.data
					// 回显
					this.flowid=obj.flowid;
					this.flowname=obj.flowname;
					this.dljid=obj.dljid;
					this.zcjid=obj.zcjid;
					this.pdjid=obj.pdjid;
				})
			
			
			// 后端网址
			var url = this.baseUrl+"/baseDevice/findDljByCompid"
			// 传递给后端的数据
			this.$axios.post(url,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				// res是后端的响应
				this.options=res.data
				})
				
			// 后端网址
			var url = this.baseUrl+"/baseDevice/findCzjByCompid"
			// 传递给后端的数据
			this.$axios.post(url,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				// res是后端的响应
				this.options1=res.data
				})
				
			// 后端网址
			var url = this.baseUrl+"/baseDevice/findPdjByCompid"
			// 传递给后端的数据
			this.$axios.post(url,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				// res是后端的响应
				this.options2=res.data
				})
			
		}
	}
</script>
<!-- css部分 -->
<style>

</style>
