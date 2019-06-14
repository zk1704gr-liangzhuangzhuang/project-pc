<!-- html部分 -->
<template>
		<div>
		<div>
		<h1>修改设备信息</h1>
		<el-input style='width: 180px;' v-model='devname' placeholder="请输入斗轮机名称"></el-input>
		<el-select v-model="typeid" placeholder="请选择">
			<el-option  v-for="item in options"  :label="item.typename"  :value="item.typeid"></el-option>
		</el-select>
		<el-select v-model="compid" placeholder="请选择">
		 	<el-option  v-for="item in options1"  :label="item.compname"  :value="item.compid"></el-option>
		</el-select>
		 <el-date-picker  v-model="devdate"  type="datetime" value-format="yyyy-MM-dd"  placeholder="选择日期时间"></el-date-picker>
		<el-input style='width: 180px;' v-model='devuser'  placeholder="请输入负责人"></el-input>
		</div>
		<el-button @click="aa" >修改</el-button> 
		<el-button @click="bb" >返回</el-button>   
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
				typeid:'',
				compid:'',
				
				devid:'',
				devname:'',
				devdate:'',
				devuser:''
			};
		},
		methods:{
			aa(){
				var url = this.baseUrl+"/baseDevice/update"
				// 传递给后端的数据
				var data = {devid:this.devid,compid:this.compid,typeid:this.typeid,devid:this.devid,devname:this.devname,devdate:this.devdate,devuser:this.devuser};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.$message("更新成功");
					this.$router.push({path:'/Devicelist'});
				})
			},
			bb(){
				this.$router.go(-1);
			}
		},
		mounted:function(){
					// 接收路由传递的数据
						var devid = this.$route.params.row;
						// 回显传递过来的数据	
						// 后端网址
						var url = this.baseUrl+"/baseDevice/load"
						// 传递给后端的数据
						var data = {devid:devid};
						this.$axios.post(url,this.$qs.stringify(data),{
							headers: {
								'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
							}
						}).then(res=>{
							// res是后端的响应
							var obj = res.data
							// 回显
							this.devid=obj.devid;
							this.typeid=obj.typeid;
							this.devdate=obj.devdate;
							this.devname=obj.devname;
							this.devuser=obj.devuser;
							this.compid=obj.compid;
						})
						// 后端网址
						var url = this.baseUrl+"/baseCompany/list"
						this.$axios.post(url,{
							headers: {
								'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
							}
						}).then(res=>{
								this.options1=res.data;
						})
						
						// 后端网址
						var url = this.baseUrl+"/baseDevtype/list"
						this.$axios.post(url,{
							headers: {
								'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
							}
						}).then(res=>{
								this.options=res.data;
						})
				}		
				
	}
</script>
<!-- css部分 -->
<style>

</style>
