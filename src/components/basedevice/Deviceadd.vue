<!-- html部分 -->
<template>
	<div>
		<div>
		<h1>设备类别添加</h1>
		<el-input style='width: 180px;' v-model='devname' placeholder="请输入斗轮机名称"></el-input>
		<el-select v-model="typeid" placeholder="请选择">
			<el-option  v-for="item in options"  :label="item.typename"  :value="item.typeid"></el-option>
		</el-select>
		<el-select v-model="compid" placeholder="请选择">
		 	<el-option  v-for="item in options1"  :label="item.compname"  :value="item.compid"></el-option>
		</el-select>
		<el-date-picker  v-model="value1"  type="datetime" value-format="yyyy-MM-dd"  placeholder="选择日期时间"></el-date-picker>
		<el-input style='width: 180px;' v-model='devuser'  placeholder="请输入负责人"></el-input>
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
				typeid:'',
				compid:'',
				devname:'',
				devdate:'',
				devuser:''
			};
		},
		methods:{
			over(){
				// 后端网址
				var url = this.baseUrl+"/baseDevice/insert"
				// 传递给后端的数据
				var data ={compid:this.compid,typeid:this.typeid,devname:this.devname,devdate:this.devdate,devuser:this.devuser};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.$message("添加成功");
					this.$router.push({path:'/Devicelist'});
				})
			},
			back(){
					this.$router.push({path:'/Devicelist'})
			}
		},
		mounted:function(){
			// 后端网址
			var url = this.baseUrl+"/baseCompany/list"
			this.$axios.post(url,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				// res是后端的响应
				this.options1=res.data
			})
			
			var url = this.baseUrl+"/baseDevtype/list"
			this.$axios.post(url,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				// res是后端的响应
				this.options=res.data
			})
		}
	}
</script>
<!-- css部分 -->
<style>

</style>
